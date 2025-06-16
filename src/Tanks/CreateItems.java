package Tanks;

import java.util.ArrayList;

public class CreateItems {
    private ArrayList<Item> items = new ArrayList<>();

    public CreateItems() {
        items.add(new Item("Oxygen", 9.52, 0.17));
        items.add(new Item("Hydrogen", 0.59, 0.18));
        items.add(new Item("Dry Oxygen", 9.52, 0.17));
    }

    public Item getItemByIndex(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        } else return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}