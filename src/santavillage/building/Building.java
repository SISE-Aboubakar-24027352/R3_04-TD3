package santavillage.building;

import santavillage.exception.CapacityExceededException;
import santavillage.characters.Character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Building {
    private final double area;
    private final int capacity;
    private Cleanliness cleanliness;
    private List<Character> presentCharacters;

    public Building(double area, int capacity) {
        if (area < 0) {
            throw new IllegalArgumentException("La superficie ne peut pas etre negative.");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("La capacite ne peut pas etre negative.");
        }
        this.area = area;
        this.capacity = capacity;
        this.cleanliness = Cleanliness.GOOD;
        this.presentCharacters = new ArrayList<>();
    }

    public double getArea() {
        return area;
    }

    public int getCapacity() {
        return capacity;
    }

    public void welcomed(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Le personnage ne peut pas etre nul.");
        }
        if (!canWelcome(character)) {
            throw new IllegalArgumentException(
                    "Ce personnage ne peut pas entrer dans " + getClass().getSimpleName() + "."
            );
        }
        if (presentCharacters.size() >= capacity) {
            throw new CapacityExceededException("Le bâtiment est complet.");
        }
        presentCharacters.add(character);
        System.out.println(character.getName() + " est entré dans le bâtiment.");
    }

    protected boolean canWelcome(Character character) {
        return true;
    }

    public boolean withdraw(Character character) {
        return presentCharacters.remove(character);
    }

    public void maintain() {
        if (cleanliness == Cleanliness.BAD && presentCharacters.isEmpty()) {
            cleanliness = Cleanliness.GOOD;
            System.out.println("Le bâtiment a été nettoyé.");
        } else {
            System.out.println("Le bâtiment ne peut pas être entretenu : il doit être sale et vide.");
        }
    }

    public void viewSpec() {
        System.out.println("Superficie : " + area + " m² | Capacité : " + capacity + " | Propreté : " + cleanliness + " | Occupants : " + presentCharacters.size());
        for (Character character : presentCharacters) {
            System.out.println(" - " + character.getName() + " (" + character.getClass().getSimpleName() + ")");
        }
    }

    public int getPresentCharactersNumber() {
        return presentCharacters.size();
    }

    public List<Character> getPresentCharacters() {
        return Collections.unmodifiableList(presentCharacters);
    }

    public Cleanliness getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(Cleanliness cleanliness) {
        this.cleanliness = cleanliness;
    }

}