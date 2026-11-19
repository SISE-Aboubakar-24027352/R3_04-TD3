package santavillage.characters;

public abstract class Character {
	private String name;
	private String sex;
	private int age;
	private double hungerIndicator;			//Création de type Pourcentage pour la gestion des bornes ?
	private boolean state;
	private double christmasMagicIndicator;	//Création de type Pourcentage pour la gestion des bornes ?
	
	public abstract void MakeSound();
	
	public abstract void travel();
	
	public void eat(String food, double nutritionalValue) {
		hungerIndicator = hungerIndicator - nutritionalValue;
	}
	
	public void restOrWork() {
		state = !state;
	}
	
	public void manipulateChristmasMagic(double change) {
		christmasMagicIndicator = christmasMagicIndicator - change;
	}

	public String getName(){
		return name;
	}
}