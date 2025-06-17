package distance;
import Tanker.*;
import Tanks.Item;

import javax.crypto.Cipher;
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

    public void addItems(String name, double liquid_density, double risk_factor, ArrayList<Item> items) {
        Item newItem = new Item(name, liquid_density, risk_factor);
        items.add(newItem);
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

    public ArrayList<Item> getItems(ArrayList<Item> items) {
        return items;
    }

    public Item getItemByIndex(ArrayList<Item> arrayList, int index) {
        if (index >= 0 && index < arrayList.size()) {
            return arrayList.get(index);
        } else return null;
    }

    public void printItems(ArrayList<Item> arrayList) {
        if (arrayList.isEmpty()) {
            System.out.println("No items available.");
        }
         else{
            System.out.println("Available Items:");
            int index = 0;
            for (Item item : arrayList) {
                System.out.println(index + ": " + item.getName());
                index++;
            }
            System.out.println( index+1 + ":Other ");
        }
    }

    public void printCities(ArrayList<DistanceToCity> arrayList) {
        if (arrayList.isEmpty()) {
            System.out.println("\nNo cities available.");
        } else {
            System.out.println("\nAvailable Cities:");
            int index = 0;
            for (DistanceToCity item : arrayList) {
                System.out.println(index + ": " + item.getCityName());
                index++;
            }
            System.out.println( index+1 + ":Other ");
        }
    }
    //public void setItem(int item) {}
}

