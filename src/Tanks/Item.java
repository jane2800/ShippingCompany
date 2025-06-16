package Tanks;

public class Item {
    private String name;
    private double liquid_density;
    private double risk_factor;

    public Item(String name, double liquid_density, double risk_factor) {

        this.name = name;
        this.liquid_density = liquid_density;
        this.risk_factor = risk_factor;
    }

    public String getName() {return name;}
    public double getLiquidDensity() {return liquid_density;}
    public double getRiskFactor() {return risk_factor;}

    public void setName(String name) {this.name = name;}
    public void setLiquidDensity(double liquid_density) {this.liquid_density = liquid_density;}
    public void setRiskFactor(double risk_factor) {this.risk_factor = risk_factor;}

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Liquid: " + liquid_density);
        System.out.println("Risk: " + risk_factor);
    }
}