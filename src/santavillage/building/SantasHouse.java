package santavillage.building;

/**
 * la maison du Père Noël : bâtiment unique ne pouvant accueillir de personnage ;
 */
public class SantasHouse extends NoCharacterBuilding {
    public SantasHouse(int area) {
        super("Santa's house", area);
    }

    @Override
    public boolean isUnique() {
        return true;
    }
}
