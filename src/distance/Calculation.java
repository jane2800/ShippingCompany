package distance;
import Tanker.*;
import Tanks.Item;

import java.util.ArrayList;

public class Calculation {

    public double totalVolume(double gallons) {
        double CubicInchToGallon = 231;

        Truck small = new SmallTruck();
        Truck medium = new MediumTruck();
        Truck large = new LargeTruck();

        int[] trucks = bestShipping(gallons);

        return (double) (trucks[2] * small.getVolume()
                + trucks[1] * medium.getVolume()
                + trucks[0] * large.getVolume()) /CubicInchToGallon;
    }

    public double totalWeight(double gallons, double density) {
        return gallons * density;
    };

    public int[] bestShipping(double gallons) {

        Truck small = new SmallTruck();
        Truck medium = new MediumTruck();
        Truck large = new LargeTruck();

        double remainingVolume = gallons;
        int largeCount = 0, mediumCount = 0, smallCount = 0;

        while (remainingVolume >= large.getVolume()) {
            remainingVolume -= large.getVolume();
            largeCount++;
        }

        while (remainingVolume >= medium.getVolume()) {
            remainingVolume -= medium.getVolume();
            mediumCount++;
        }

        while (remainingVolume > 0) {
            remainingVolume -= small.getVolume();
            smallCount++;
        }

        return new int[] {largeCount, mediumCount, smallCount};
    }

    public double shippingPrice(double volume, double distance, double risk_factor) {

        double shippingCostTo = 0.01;
        double shippingCostFrom = 0.6;

        double base = volume * distance * shippingCostTo;
        double riskAdded = base * risk_factor;
        double returnCost = distance * shippingCostFrom;

        return base + riskAdded + returnCost;
    }

    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> addItems(String name, double liquid_density, double risk_factor) {
        Item newItem = new Item(name, liquid_density, risk_factor);
        items.add(newItem);
        return items;
    }

    //public String addOrder(){};

    public void printItem(String name, double liquidDensity, double riskFactor) {
        System.out.println("\nItem: " + name);
        System.out.println("LiquidDensity: " + liquidDensity);
        System.out.println("RiskFactor: " + riskFactor);
     };

    public void printOrder(double gallons,double density, double distance, String city, double risk_factor) {

        System.out.print("\nTotal liquid volume ordered: " + Math.ceil(gallons * 100.0) / 100.0 + " gallons");
        System.out.print("\nTotal volume still available: " + Math.ceil(totalVolume(gallons) * 100.0) / 100.0 + " gallons");

        System.out.print("\nTotal liquid weight: " + Math.ceil(totalWeight(gallons, density))*100.0/100.0 + "kg");

        System.out.print("\nTotal distance from Hamburg to " + city + ": " + distance + "km");

        int[] trucks = bestShipping(gallons);
        System.out.print("\nLarge Truck: " + trucks[0]);
        System.out.print("\nMedium Truck: " + trucks[1]);
        System.out.print("\nSmall Truck: " + trucks[2]);

        double cost = shippingPrice(totalVolume(gallons), distance, risk_factor);
        System.out.println("\nTotal shipping cost: €" + Math.round(cost));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItemByIndex(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else return null;
    }

    //public void setItem(int item) {}
}

