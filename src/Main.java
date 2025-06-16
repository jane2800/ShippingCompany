import Tanker.*;
import Tanks.*;
import distance.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //
        CreateItems createItems = new CreateItems(); // new createItems object
        ArrayList<Item> items = createItems.getItems(); // get an arraylist of all the items in the
        // arraylist created in CreateItems

        //display a list of all the possible items that can be transported
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ": " + items.get(i).getName());
        }

        Calculation itemIndex = new Calculation();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter what type of item you want to ship: ");
        int type = scanner.nextInt();
        Item name = itemIndex.getItemByIndex(type);
        System.out.print(name.getName());

        //
        System.out.println("\nEnter how much of item you want to ship: ");
        int amount = scanner.nextInt();
        System.out.print(type);

        //
        CreateCity createCity = new CreateCity();
        ArrayList<DistanceToCity> distance = createCity.getDistanceToCity();

        for (int i = 0; i < distance.size(); i++) {
            System.out.println( i + ": " + distance.get(i).getCityName());
        }

        System.out.println("Where do you want to ship? : ");
        int choice = scanner.nextInt();
        String cityName = distance.get(choice).getCityName();
        double cityDist = distance.get(choice).getDistance();

        System.out.print("Do you want to add another item? (y/n): ");
        String choice2 = scanner.next();

        Calculation city = new Calculation();
        city.addItems("Oxygen", 9.52, 0.17);
        city.addItems("Water", 9.52, 0.17);
        city.addItems("Electric", 9.52, 0.17);

        if (choice2.equals("y")) {
            System.out.print("Enter another name: ");
        }
        Calculation calc = new Calculation();
        calc.printItem(name.getName(), name.getLiquidDensity(), name.getRiskFactor());
        calc.printOrder(amount, // gallons being transported
                name.getLiquidDensity(), // liquid density to find weight
                cityDist, // destination distance
                cityName, //  destination city name
                name.getRiskFactor());// risk factor to find total price
    }
}