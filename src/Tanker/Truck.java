package Tanker;

public abstract class Truck {
    private int height;
    private int radius;
    private int volume;

    public Truck(int height, int radius) {
        int power = (int) Math.pow(radius,2);

        this.height = height;
        this.radius = radius;
        this.volume = (int) (Math.PI * power * height);
    }

    public int getHeight() {return height;}
    public int getRadius() {return radius;}
    public int getVolume(){return volume;}

    public void setHeight(int height) {this.height = height;}
    public void setRadius(int radius) {this.radius = radius;}
    public void setVolume(int volume) {this.volume = volume;}

    public void display() {
        System.out.println("Height: " + height);
        System.out.println("Radius: " + radius);
        System.out.println("Volume: " + volume);
    }
}


