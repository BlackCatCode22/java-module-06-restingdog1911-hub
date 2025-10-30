public class Hyena extends Animal {

// Unique variable for the sub class
    private String favoriteFood;

//constructor for hyena subclass
    public Hyena(String sex, int age, int weight, String animalName, String animalId, String animalBirthDate,
                  String animalColor, String animalOrigin, String animalArrivalDate){
// refers to the constructor of the super class
        super(sex, age, weight, animalName,animalId, animalBirthDate, animalColor, animalOrigin,animalArrivalDate);
    }

//default constructor
    public Hyena() {
        this.favoriteFood = "Steak";
    }

//Ussr-defined Constructor
    public Hyena(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
}
