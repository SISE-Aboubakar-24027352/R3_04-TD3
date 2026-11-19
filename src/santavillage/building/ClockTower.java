/**
 * la tour de l’horloge : bâtiment unique ne pouvant accueillir de personnage, comptabilise le
 * niveau total de magie de Noël du village du Père Noël et, accessoirement, donne l’heure ;
 */

package santavillage.building;

public class ClockTower extends NoCharacterBuilding {
    private int hour;
    private int totalMagic;

    public ClockTower(int area) {
        super("Clock tower", area);
    }

    @Override
    public boolean isUnique() {
        return true;
    }

    /** Updated by the village at each time interval. */
    public void update(int hour, int totalMagic) {
        this.hour = hour % 24;
        this.totalMagic = totalMagic;
    }

    public int getTotalMagic() {
        return totalMagic;
    }

    public String getTime() {
        return String.format("%02dh00", hour);
    }

    @Override
    public String toString() {
        return super.toString() + " | time is " + getTime() + " | village total Christmas magic: " + totalMagic;
    }
}
