package distance;

public class DistanceToCity {
    private String cityName;
    private double distance;

    public DistanceToCity(String cityName, double distance) {
        this.cityName = cityName;
        this.distance = distance;
    }

    public String getCityName() {return cityName;}
    public double getDistance() {return distance;}

    public void setDistance(double distance) {this.distance = distance;}
    public void setCityName(String cityName) {this.cityName = cityName;}

    public void display() {
        System.out.println("Name: " + cityName);
        System.out.println("Distance: " + distance);
    }
}

