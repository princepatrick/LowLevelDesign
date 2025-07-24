package trafficsystemown;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrafficSystem {
    
    public static TrafficSystem trafficSystem;

    private int numOfDirs;
    
    List<TrafficConfig> trafficDirectionConfigList;
    
    public TrafficSystem(){
        numOfDirs = 0;
        trafficDirectionConfigList = new ArrayList<>();
    }
    
    public static TrafficSystem getInstance(){
        if( trafficSystem == null ){
            trafficSystem = new TrafficSystem();                                
        }

        return trafficSystem;       
    }

    public int getNumOfDirs() {
        return numOfDirs;
    }

    public void setNumOfDirs(int numOfDirs) {
        this.numOfDirs = numOfDirs;
    }
    
    public void addTrafficConfiguration( TrafficConfig trafficConfig ){
        trafficDirectionConfigList.add(trafficConfig);
    }
    
    public void runSignal( Map<Integer, Integer> m ){
        
        int ind = m.keySet().iterator().next();        
        TrafficConfig config = trafficDirectionConfigList.get(ind-1);
        ArrayList<Boolean> directions = config.directionConfig;
        int durationOfSignal = config.duration;
        int offsetDuration = durationOfSignal / 10;
        
        String listOfSignal = "";
        
        for( Map.Entry<Integer, Integer> keyVal : m.entrySet() ){
            int key = keyVal.getKey();
            listOfSignal += key + " ";
        }
        if( directions.get(2)  || directions.get(3) ){
            int rightSideDuration = (durationOfSignal / 10) * 3;
            System.out.println("The traffic signal is green lit for right side and/or U-turn signals " 
                    + listOfSignal + " for " + rightSideDuration  + " seconds " );
            int straightDuration = durationOfSignal - rightSideDuration;
            System.out.println("The traffic signal is green lit for straight and/or left signals "
                    + listOfSignal + " for " + straightDuration + " seconds " );
        } else {
            int straightDuration = durationOfSignal;
            System.out.println("The traffic signal is green lit for straight and/or left signals "
                    + listOfSignal + " for " + straightDuration + " seconds " );
        }

        System.out.println("The orange light is green lit for " + offsetDuration + " seconds ");
        
    }
    
    public void runEmergency( EmergencySituation emergencySituation ){
        int directionOfEmergency = emergencySituation.directionOfSignal;
        String emergency = emergencySituation.situationName;
        int durationOfEmergency = emergencySituation.durationOfEmergency + 5;

        System.out.println("The Emergency situation of " + emergency
                + " needs the signal " + directionOfEmergency
                + " to be green lit for " + durationOfEmergency + " seconds while other signals are blocked " );
    }
    
    
    
}
