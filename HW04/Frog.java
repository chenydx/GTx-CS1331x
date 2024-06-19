public class Frog {
    
    //variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species;

    //constructors
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = (this.age >= 1 && this.age <= 7) ? true : false;
        species = "Rare Pepe";
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this.name = name;
        this.age = (int) (ageInYears*12);
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = (this.age >= 1 && this.age <= 7) ? true : false;

    }

    public Frog(String name) {
        this.name = name;
        this.age = 5;
        this.tongueSpeed = 5;
        this.isFroglet = true;

    }

    //methods
    public void grow(int month) {
        if (this.age + month<=12)
        this.tongueSpeed = this.tongueSpeed + month;
        else if (this.age>= 30)
            this.tongueSpeed = this.tongueSpeed - month;
        else if (this.age<=12 && this.age+month<=30)
            this.tongueSpeed = this.tongueSpeed +(12-this.age);
        else if (this.age>=12 && this.age+month>=30)
            this.tongueSpeed = this.tongueSpeed -(this.age+month-30);
        if (this.tongueSpeed<5)
        this.tongueSpeed = 5;
        this.age = this.age + month;
        this.isFroglet = (this.age >= 1 && this.age <= 7) ? true : false;
    }

    public void eat(Fly afly) {
        if (afly.isDead())
            return;
        if (this.tongueSpeed > afly.getSpeed()) {
            if (afly.getMass()>=0.5*this.age)
                this.grow(1);
            afly.setMass(0);
        }
        else
            afly.grow(1);  
    }
    
    @Override
    public String toString() {
        if (this.isFroglet)
            return "My name is "+this.name+" and I\'m a rare froglet! I\'m "+this.age+" months old and my tongue has a speed of "+this.tongueSpeed+".";
        else
            return "My name is "+this.name+" and I\'m a rare frog. I\'m "+this.age+" months old and my tongue has a speed of "+this.tongueSpeed+".";
    }
    
    public void setSpecies(String species) {
        Frog.species = species;
    }

    public static String getSpecies() {
        return species;
    }

    
}