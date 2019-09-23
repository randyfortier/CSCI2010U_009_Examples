package animals;

// final - cannot subclass
public class Gorilla extends Animal {
    private int strength;

    public Gorilla(String name, 
                   double weight,
                   double strengthRatio) {
        super(name, "bananas", weight);

        this.strength = (int)(strengthRatio * this.weight);
    }

    public void eat(String food) {
        System.out.println(this.name + " eats " + food);
    }

    public void doSignLanguage() {
        System.out.println(name + " signs");
    }
}