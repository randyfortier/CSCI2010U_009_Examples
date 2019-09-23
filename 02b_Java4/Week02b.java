import animals.*;
import hardware.*;

public class Week02b {
    public static void main(String[] args) {
        // animals
        Animal coco = new Gorilla("Coco", 180.0, 1.0);
        coco.eat("five bananas");

        if (coco instanceof Gorilla) {
            //Gorilla gorillaCoco = (Gorilla)coco;
            ((Gorilla)coco).doSignLanguage();
        }


        // hardware
        OnePlus7Pro phone = new OnePlus7Pro();
        System.out.println(phone.snapPhoto());
        System.out.println(phone.getLocation());
    }
}