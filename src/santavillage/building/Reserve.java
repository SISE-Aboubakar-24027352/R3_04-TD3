package santavillage.building;

import santavillage.characters.Character;
import java.util.EnumMap;
import java.util.Map;

public class Reserve extends Building{

    public Reserve(double area) {
        super(area, 0);
    }

    public Reserve(double area, int capacity) {
        super(area, 0);
    }

    @Override
    protected boolean canWelcome(Character character) {
        return false;
    }

    @Override
    public void maintain() {
        System.out.println("La réserve ne nécessite pas d'entretien.");
    }
}
