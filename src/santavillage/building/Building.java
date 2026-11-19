package santavillage.building;

import santavillage.exception.CapacityExceededException;
import santavillage.building.Proprete;
import santavillage.characters.Character;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Building {
    private final double area;
    private final int capacity;
    private Proprete cleanliness;
    private List<Character> presentCharacters;

    public Building(double area, int capacity) {
        this.area = area;
        this.capacity = capacity;
        this.cleanliness = Proprete.GOOD;
        this.presentCharacters = new ArrayList<>();
    }

    public double getArea(){
        return area;
    }

    public int getCapacity(){
        return capacity;
    }

    public void welcomed(Character character) {
        if (presentCharacters.size() >= capacity) {
            throw new CapacityExceededException("Le bâtiment est complet.");
        }
        presentCharacters.add(character);
        System.out.println(character.getName() + " est entré dans le bâtiment.");
    }

    public boolean withdraw(Character character){
        return presentCharacters.remove(character);
    }

    public void maintain(){
        if (cleanliness == Proprete.BAD && presentCharacters.isEmpty()) {
            cleanliness = Proprete.GOOD;
            System.out.println("Le bâtiment a été nettoyé.");
        } else {
            System.out.println("Le bâtiment ne peut pas être entretenu : il doit être sale et vide.");
        }
    }

    public void viewSpec(){
        System.out.println("Superficie : " + area + " m² | Capacité : " + capacity + " | Propreté : " + cleanliness + " | Occupants : " + presentCharacters.size());
        for (Character character : presentCharacters) {
            System.out.println(" - " + character.getName() + " (" + character.getClass().getSimpleName() + ")");
        }
    }

    public int getPresenCharactersNumber() {
        return presentCharacters.size();
    }

    public List<Character> getPresenCharacters() {
        return Collections.unmodifiableList(presentCharacters);
    }

    public Proprete getProprete(){
        return cleanliness;
    }

    public void setProprete(Proprete cleanliness){
        this.cleanliness = cleanliness;
    }

}