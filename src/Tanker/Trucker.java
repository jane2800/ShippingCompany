package Tanker;

public class Trucker {
    private String name;
    private int height;
    private int radius;
    private int volume;

    public Trucker(String name, int height, int radius) {
        int power = (int) Math.pow(radius,2);

        this.name = name;
        this.height = height;
        this.radius = radius;
        this.volume = (int) (3.14 * power * height);
    }

    public String getName() {return name;}
    public int getHeight() {return height;}
    public int getRadius() {return radius;}
    public int getVolume(){return volume;}

    public void setName(String name) {this.name = name;}
    public void setHeight(int height) {this.height = height;}
    public void setRadius(int radius) {this.radius = radius;}
    public void setVolume(int volume) {this.volume = volume;}

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Height: " + height);
        System.out.println("Radius: " + radius);
        System.out.println("Volume: " + volume);
    }
}
