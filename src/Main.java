import Tanker.*;
import Tanks.*;
import distance.*;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean keepAddingItems = true;
        while (keepAddingItems) {

            Calculation calc = new Calculation();
            ArrayList<Item> itemArrayList= new ArrayList<>();
            itemArrayList.add(new Item("Oxygen", 9.52, 0.17));
            itemArrayList.add(new Item("Hydrogen", 0.59, 0.18));
            itemArrayList.add(new Item("Nitrogen", 6.74, 0.02));
            itemArrayList.add(new Item("Propane", 4.22, 0.2));
            itemArrayList.add(new Item("Carbon Dioxide", 8.47, 0.1));
            itemArrayList.add(new Item("Methane", 3.50, 0.18));
            itemArrayList.add(new Item("Benzene Supper E95", 6.73, 0.2));
            itemArrayList.add(new Item("Benzene Supper", 6.84, 0.2));
            itemArrayList.add(new Item("Water", 8.34, 0));
            itemArrayList.add(new Item("Milk", 8.6, 0));

            calc.printItems(itemArrayList);
            calc.getItems(itemArrayList);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter what type of item you want to ship: ");
            int type = scanner.nextInt();
            Item name = calc.getItemByIndex(itemArrayList, type);
            System.out.print(name.getName());

            //
            System.out.print("\nEnter how many gallons you want to ship: ");
            int amount = scanner.nextInt();

            //
            ArrayList<DistanceToCity> cityDistance = new ArrayList<>();
            cityDistance.add(new DistanceToCity("Berlin", 255.46));
            cityDistance.add(new DistanceToCity("Munich", 608.29));
            cityDistance.add(new DistanceToCity("Leipzig", 291.4));
            cityDistance.add(new DistanceToCity("Dresden", 375.28));
            cityDistance.add(new DistanceToCity("Köln", 352.06));
            cityDistance.add(new DistanceToCity("Rome", 1304.41));
            cityDistance.add(new DistanceToCity("Paris", 741.66));
            cityDistance.add(new DistanceToCity("Wien", 741.53));
            cityDistance.add(new DistanceToCity("Madrid", 1782.66));

            calc.printCities(cityDistance);

            System.out.print("\nWhere do you want to ship? ");
            int choice = scanner.nextInt();
            String cityName = cityDistance.get(choice).getCityName();
            double cityDist = cityDistance.get(choice).getDistance();

            System.out.print("\nDo you want to add another item? (y/n): ");
            String choice2 = scanner.next();
            keepAddingItems = choice2.equals("y");

            Calculation calc1 = new Calculation();
            calc1.printItem(name.getName(), name.getLiquidDensity(), name.getRiskFactor());
            calc1.printOrder(amount, // gallons being transported
                    name.getLiquidDensity(), // liquid density to find weight
                    cityDist, // destination distance
                    cityName, //  destination city name
                    name.getRiskFactor());// risk factor to find total price
        }
    }
}