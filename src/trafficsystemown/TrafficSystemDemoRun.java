package trafficsystemown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrafficSystemDemoRun {

    public static void run(){
        //Get object of the traffic system - we will proceed the implementation with
        // 4 directions and opposite directions operating at the same time
        TrafficSystem trafficSystem = TrafficSystem.getInstance();

        int NUM_DIRS = 4;

        //Setting the number of directions with traditional and simple - 4 way direction
        trafficSystem.setNumOfDirs(NUM_DIRS);

        //Define the Traffic Configuration for direction 1
        // 0 - Left , 1 - Straight, 2 - Right, 3 - U-Turn
        ArrayList<Boolean> directionConfig = new ArrayList<Boolean>(Arrays.asList(true, true, true, true));
        TrafficConfig trafficConfig1 = new TrafficConfig( directionConfig, 50 );
        trafficSystem.addTrafficConfiguration( trafficConfig1 );

        //Define the Traffic Configuration for direction 2
        TrafficConfig trafficConfig2 = new TrafficConfig( directionConfig, 30 );
        trafficSystem.addTrafficConfiguration( trafficConfig2 );

        //Define the Traffic Configuration for direction 3
        TrafficConfig trafficConfig3 = new TrafficConfig( directionConfig, 50 );
        trafficSystem.addTrafficConfiguration( trafficConfig3 );

        //Define the Traffic Configuration for direction 4
        TrafficConfig trafficConfig4 = new TrafficConfig( directionConfig, 50 );
        trafficSystem.addTrafficConfiguration( trafficConfig4 );

        int i = 0;

        //An ambulance passing through the 1st signal in 35 seconds - the signal 1 will be run specifically free
        //for 35 + 5 seconds = 40 seconds, while the other signals is going to be stopped
        EmergencySituation emergencySituation1 = new EmergencySituation( "Ambulance", 35, 1 );

        //An ambulance passing through the 1st signal in 35 seconds - the signal 1 will be run specifically free
        //for 35 + 5 seconds = 40 seconds, while the other signals is going to be stopped
        EmergencySituation emergencySituation2 = new EmergencySituation( "Ambulance", 40, 4 );

        //The 1st and 3rd signals are paired
        Map<Integer, Integer> m1 = new HashMap<>();
        m1.put(1,1);
        m1.put(3,1);

        //The 2nd and 4th signals are paired
        Map<Integer, Integer> m2 = new HashMap<>();
        m2.put(2,1);
        m2.put(4,1);

        //The signals are run for 5 times in a loop
        while( i < 5 ){

            //The 1st cluster are run at the same time
            System.out.println("An emergency has occurred at Iteration number 5");
            if( i == 4 ){
                trafficSystem.runEmergency( emergencySituation2 );
            }

            trafficSystem.runSignal( m1 );


            System.out.println("The first cluster of signals is completed");

            System.out.println("An emergency has occurred at Iteration number 3");
            if( i == 2 ){
                trafficSystem.runEmergency( emergencySituation1 );
            }

            //The 2nd cluster are run at the same time
            trafficSystem.runSignal( m2 );

            if( i < 4 ){
                System.out.println("The second cluster of signals is completed. Moving to next iteration " + (i+2) );
            }

            i++;
        }
    }




}
