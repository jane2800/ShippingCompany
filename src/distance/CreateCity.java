package distance;

import java.util.ArrayList;

public class CreateCity {

    public ArrayList<DistanceToCity> getDistanceToCity() {
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
        return cityDistance;
    }
}