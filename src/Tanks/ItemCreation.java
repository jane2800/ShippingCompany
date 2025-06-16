package Tanks;

import java.util.ArrayList;

public class ItemCreation {

    public ArrayList<Item> ItemCreation() {
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
        return itemArrayList;
    }
}