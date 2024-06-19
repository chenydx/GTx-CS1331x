public class Fly {
    
    //variables
    private double mass;
    private double speed;

    //constructors
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass) {
        this.mass = mass;
        this.speed = 10;
    }
    public Fly() {
        this.mass = 5;
        this.speed = 10;
    }

    //methods
    @Override
    public String toString() {
        if (this.mass <=0)
            return "I\'m dead, but I used to be a fly with a speed of "+this.speed+".";
        else
            return "I\'m a speedy fly with "+this.speed+" speed and "+this.mass+" mass.";
    }

    public void grow(double dmass) {
        if (mass<20)
            if (mass+dmass<=20)
                this.speed = this.speed+dmass;
            else
                this.speed = this.speed+30-1.5*mass-0.5*dmass;
        else
            if (mass+dmass>20)
                this.speed = this.speed - 0.5*dmass;
            else
                this.speed = this.speed -0.5*mass - 30 - dmass;
        this.mass = this.mass + dmass;
    }

    public boolean isDead() {
        if (this.mass<=0)
            return true;
        else
            return false;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMass() {
        return this.mass;
    }

    public double getSpeed() {
        return this.speed;
    }
}
