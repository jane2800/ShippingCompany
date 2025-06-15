package distance;

import java.util.ArrayList;

public class CreateCity {
    private final ArrayList<DistanceToCity> cityDistance = new ArrayList<>();

    public CreateCity() {
        cityDistance.add(new DistanceToCity( "Berlin", 255.46));
        cityDistance.add(new DistanceToCity("Munich", 608.29));
        cityDistance.add(new DistanceToCity("Leipzig", 291.4));
    }

    public DistanceToCity getDistanceToCityByIndex(int index) {
        if (index >= 0 && index < cityDistance.size()) {
            return cityDistance.get(index);
        } else return null;
    }

    public ArrayList<DistanceToCity> getDistanceToCity() {
        return cityDistance;
    }
}