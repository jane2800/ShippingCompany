package distance;

public class Calculation {

    private int item;

    public Calculation(int item) {
        this.item = item;
    }

    public double totalVolume(int gallons) {
        return gallons * 231;
    }

    //public long totalWeight(){};

    //public String bestShipping(){};

    //public long ShippingPrice(){};

    //public String addItems(){};

    //public String addOrder(){};

    //public void printItem(){};

    public void printOrder(int gallons) {
        System.out.println("\nTotal liquid volume: " + totalVolume(gallons) + " in³");};

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
}
