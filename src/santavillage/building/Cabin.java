package santavillage.building;

import santavillage.characters.Character;
import santavillage.characters.Humanoid;

/**
 * les chalets dortoir : non mixte, permet aux humanoïdes de se reposer ;
 */
public class Cabin extends Building {

    public Cabin(double area, int capacity) {
        super(area, capacity);
    }

    @Override
    public void welcomed(Character character) {
        if (!(character instanceof Humanoid)) {
            throw new IllegalArgumentException("A cabin only welcomes humanoids.");
        }
        if (!getPresentCharacters().isEmpty()
                && !getPresentCharacters().get(0).getSex().equals(character.getSex())) {
            throw new IllegalArgumentException("A cabin is not mixed.");
        }
        super.welcomed(character);
        character.restOrWork();
    }
}