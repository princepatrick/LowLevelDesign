package trafficsystemown;

import java.util.ArrayList;

public class TrafficConfig {

    ArrayList<Boolean> directionConfig;
    int duration;

    public TrafficConfig(ArrayList<Boolean> theDirConfig, int theDuration){
        directionConfig = theDirConfig;
        duration = theDuration;
    }


}
