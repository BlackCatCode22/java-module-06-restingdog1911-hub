public class Bear extends Animal{


// Unique variable for the sub class
    private String favoriteFood;

//constructor for hyena subclass
    public Bear(String sex, int age, int weight, String animalName, String animalId, String animalBirthDate,
                String animalColor, String animalOrigin, String animalArrivalDate){
// refers to the constructor of the super class
        super(sex, age, weight, animalName,animalId, animalBirthDate, animalColor, animalOrigin,animalArrivalDate);}



        //default constructor
    public Bear(){
        this.favoriteFood = "Steak";
    }

//Ussr-defined Constructor
    public Bear (String favoriteFood){
        this.favoriteFood = favoriteFood;
    }

    }
