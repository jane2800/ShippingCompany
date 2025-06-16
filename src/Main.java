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
            CreateItems loader = new CreateItems(calc);

            calc.printItems();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter what type of item you want to ship: ");
            int type = scanner.nextInt();
            Item name = calc.getItemByIndex(type);
            System.out.print(name.getName());

            //
            System.out.print("\nEnter how much gallons you want to ship: ");
            int amount = scanner.nextInt();
            System.out.print(type);

            //
            CreateCity createCity = new CreateCity();
            ArrayList<DistanceToCity> distance = createCity.getDistanceToCity();

            for (int i = 0; i < distance.size(); i++) {
                System.out.println(i + ": " + distance.get(i).getCityName());
            }

            System.out.print("\nWhere do you want to ship? ");
            int choice = scanner.nextInt();
            String cityName = distance.get(choice).getCityName();
            double cityDist = distance.get(choice).getDistance();

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