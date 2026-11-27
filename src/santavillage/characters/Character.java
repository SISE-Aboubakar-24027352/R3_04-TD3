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

    public double getChristmasMagicIndicator() {
        return christmasMagicIndicator;
    }

    public void setChristmasMagicIndicator(double christmasMagicIndicator) {
        this.christmasMagicIndicator = christmasMagicIndicator;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public double getHungerIndicator() {
        return hungerIndicator;
    }

    public void setHungerIndicator(double hungerIndicator) {
        this.hungerIndicator = hungerIndicator;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}