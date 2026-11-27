package santavillage.building;
/**
 * les confiseries : permets à tous les personnages de se restaurer ;
 */
public class CandyShop extends Building {
    private static final int HUNGER_THRESHOLD = 25;

    public CandyShop(String name, int area, int capacity) {
        super(name, area, capacity);
    }

    @Override
    protected boolean acceptsType(Character p) {
        return true;
    }

    @Override
    protected void activity(Character p, Village village) {
        if (p.getHunger() < HUNGER_THRESHOLD) {
            return;
        }
        Food food = village.takeFood();
        if (food == null) {
            System.out.println("  ⚠ " + getName() + " : nothing left to eat for " + p.getName() + "!");
        } else {
            p.eat(food);
        }
    }
}
