import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Year;
import java.util.ArrayList;

// main is upper case because it represents the class name
public class Main {
 // main is lower case here because it a function
    public static void main(String[] args) {

 //create a new arraylist of animals named zoo
        ArrayList<Animal> zoo=new ArrayList<Animal>();


// store the file path in a variable

        String filepath="C:\\Users\\Resti\\Desktop\\CIT-63\\mod4\\src\\arrivingAnimals.txt";


//crate an ArrayList list to store the line of arriving animal files
        ArrayList<String>animalData = new ArrayList<String>();


//create an arrayList to store the animal names
        ArrayList<String>animalNames = new ArrayList<String>();

//create a try.. catch block to handle any errors as see between lines 24 through 29

       try {

//create a buffered reader that read the lines of a file
//the buffered reader needs a file reader, which needs a file path

           BufferedReader reader=new BufferedReader(new FileReader(filepath));

// create a string to temporarily hold the line of the file


           String line="";


// create a loop to read through all the lines of the file. In one set of parentheses we use (line=reader.readline())
//to store the line of the file in "line", and in the outer parentheses we check if that whole expression is a value
// that isn't null (no value) so that we stop the loop when there are no more lines to read in the file
//"!=" stands for not equals in java
        while ( (line=reader.readLine()) !=null){
            System.out.println(line);

//add the line of the file to the arraylist
           animalData.add(line);

        }
//close the file to stop file corruption
        reader.close();
        filepath="C:\\Users\\Resti\\Desktop\\CIT-63\\mod4\\src\\animalNames.txt";

//create new file path
        reader= new BufferedReader(new FileReader(filepath));

           while ( (line=reader.readLine()) !=null) {
               System.out.println(line);

//add the line of the file to the arraylist
               animalNames.add(line);
           }
            System.out.println("\n");
//use catch to handel error and exceptions
       } catch (Exception e){
           System.out.println(e.getMessage());

       }
// create a buffered writer to write a new file
       try {
           BufferedWriter writer = new BufferedWriter(new FileWriter("mod 6/src/report.txt"));

// extract the names from the animal names array list
// using .get() to get the line, and .split() to divide up the names

       String[] hyenaNames = animalNames.get(2).split(", ");
       String[] lionNames= animalNames.get(6).split(", ");
       String[] bearNames= animalNames.get(10).split(", ");
       String[] tigerNames= animalNames.get(14).split(", ");

//create variables to hold species count
           int countOfBear=0;
           int countOfHyena=0;
           int countOfLion=0;
           int countOfTiger=0;


//create a for loop to go through the data and write it to a file
          for (int i = 0; i < animalData.size(); i++) {
//Extract the species using get() and Split() remember the[ ] represent the index
//split works off of the indexing of your data remember java always starts at 0 and always takes in the information in the parentheses/quotes  such as spaces comas ext.(", ")
              String species = animalData.get(i).split(", ")[0].split(" ")[4];

// extract the age
//integer.parseInt converts the split up string into an integer
              int age = Integer.parseInt(animalData.get(i).split(" ")[0]);

//create a veritable for the name
              String name = "";

// create a string id variable
              String id = "";

// create a variable for the sex and parse it from the text

              String sex = (animalData.get(i).split(" ")[3]);
              System.out.println(sex);
// create a variable for the color and parse it from the text
              String color = (animalData.get(i).split(", ")[2]);
              System.out.println(color);
// create a variable  for the weight and parse it from the text
              int weight = Integer.parseInt(animalData.get(i).split(", ")[3].split(" ")[0]);
              System.out.println(weight);
// create a variable  for the origin and parse it from the text
              String origin = animalData.get(i).split("from ")[1];
              System.out.println(origin);
// create a variable for birthdate
              String birthdate = "";
              String season = animalData.get(i).split(", ")[1].split(" ")[2];
              //.out.println(birthdate);
              System.out.println(season + "\n");

//switch statement to decide birthday base on season

              String year = Integer.toString(Year.now().getValue() - age);

              switch (season) {
                  case "spring":
                      birthdate = year + "-03-21";
                  case "summer":
                      birthdate = year + "-06-21";
                  case "fall":
                      birthdate = year + "-10-21";
                  case "winter":
                      birthdate = year + "-01-21";
                  default:
                      birthdate = year + "-02-29";
              }
//switch statement to determine name and count species
              switch (species) {
                  case "hyena":
                      name = hyenaNames[i % 4];
                      countOfHyena++;
                      id = "hy0" + countOfHyena;
                      zoo.add(new Hyena(sex, age, weight, name, id, birthdate, color, origin, "2025-10-28"));
                      break;
                  case "tiger":
                      name = tigerNames[i % 4];
                      countOfTiger++;
                      id = "ti0" + countOfTiger;
                      zoo.add(new Tiger(sex, age, weight, name, id, birthdate, color, origin, "2025-10-28"));
                      break;
                  case "bear":
                      name = bearNames[i % 4];
                      countOfBear++;
                      id = "be0" + countOfBear;
                      zoo.add(new Bear(sex, age, weight, name, id, birthdate, color, origin, "2025-10-28"));
                      break;
                  case "lion":
                      name = lionNames[i % 4];
                      countOfLion++;
                      id = "li0" + countOfLion;
                      zoo.add(new LION(sex, age, weight, name, id, birthdate, color, origin, "2025-10-28"));
                      break;
              }

          }



          for (Animal animal: zoo){
              // writ the information to the report
              writer.write( "Name: "+ animal.getAnimalName() + "\n"
                      +"ID: "+ animal.getAnimalID() + "\n"
                      +"Age: "+ animal.getAge() + "\n"
                      +"SeX: "+ animal.getSex() + "\n"
                      +"Weight: "+ animal.getWeight() + "\n"
                      +"color: "+ animal.getAnimalColor() + "\n"
                      +"Origin: "+ animal.getAnimalOrigin() + "\n"
                      +"Birth Date: "+ animal.getAnimalBirthDate() + "\n"
                      +"Arrival Date: "+  animal.getAnimalArrivalDate()+"\n\n");
          }

           writer.write("Number of hyenas: "+countOfHyena + "\n");
           writer.write("Number of tiger: "+countOfTiger + "\n");
           writer.write("Number of bear: "+countOfBear + "\n");
           writer.write("Number of lion: "+countOfLion + "\n");
           writer.close();
       }catch (Exception e){
           System.out.println(e.getMessage());

       }


    }


}
