package trafficsystemown;

public class EmergencySituation {

    String situationName;
    int durationOfEmergency;
    int directionOfSignal;

    public EmergencySituation( String situation, int duration, int direction ){
        situationName = situation;
        durationOfEmergency = duration;
        directionOfSignal = direction;
    }
}
