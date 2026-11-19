package santavillage.building;

public class Pen extends Building {
    private final boolean open;

    public Pen(String name, int area, int capacity, boolean open) {
        super(name, area, capacity);
        this.open = open;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    protected boolean acceptsType(Character p) {
        return p instanceof Creature;
    }

    @Override
    protected boolean compatibleWithOccupants(Character p) {
        return getCharacters().isEmpty() || getCharacters().get(0).getClass() == p.getClass();
    }

    @Override
    protected boolean isRestPlace() {
        return true;
    }

    @Override
    protected void activity(Character p, Village village) {
        p.rest();
    }

    @Override
    public String toString() {
        return super.toString() + (open ? " | open" : " | closed");
    }
}
