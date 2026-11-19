package santavillage.building;

import santavillage.characters.Character;
import santavillage.characters.Creature;

public class ToyStore extends Building{

    public ToyStore(double area, int capacity) {
        super(area, capacity);
    }

    @Override
    protected boolean canWelcome(Character character) {
        return !(character instanceof Creature);
    }
}
