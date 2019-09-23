package animals;

public abstract class Animal {
    protected String name;
    private String diet;
    protected double weight;

    public Animal(String name,
                  String diet,
                  double weight) {
        this.name = name;
        this.diet = diet;
        this.weight = weight;
    }

    public abstract void eat(String food);
}