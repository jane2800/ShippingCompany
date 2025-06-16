package Tanker;

public abstract class Truck {
    private double height;
    private double radius;
    private double volume;

    public Truck(double height, double radius) {
        double power = Math.pow(radius,2);

        this.height = height;
        this.radius = radius;
        this.volume = (int) (Math.PI * power * height);
    }

    public double getHeight() {return height;}
    public double getRadius() {return radius;}
    public double getVolume(){return volume;}

    public void setHeight(double height) {this.height = height;}
    public void setRadius(double radius) {this.radius = radius;}
    public void setVolume(double volume) {this.volume = volume;}

    public void display() {
        System.out.print("\nHeight: " + height);
        System.out.print("\nRadius: " + radius);
        System.out.print("\nVolume: " + volume);
    }
}


