package hardware;

public class OnePlus7Pro implements DigitalCamera,
                                    GPSReceiver {

    public String snapPhoto() {
        return "a touching photo of a puppy";
    }

    public double getLocation() {
        return 37.032;
    }
}