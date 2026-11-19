package santavillage.building;

import santavillage.characters.CanWork;
import santavillage.characters.Character;
import santavillage.characters.Humanoid;

/**
 * les ateliers de fabrication : lieu de travail des lutins et fées de Noël, interdit aux créatures ;
 */
public class Workshop extends Building {
    public Workshop(int area, int capacity) {
        super(area, capacity);
    }

    @Override
    protected boolean acceptsType(Character p) {
        return p instanceof Humanoid;
    }

    @Override
    protected void activity(Character p) {
        if (p instanceof Elf || p instanceof ChristmasFairy) {
            ((CanWork) p).work();
        }
    }
}
