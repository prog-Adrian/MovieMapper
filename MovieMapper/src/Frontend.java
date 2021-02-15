import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Frontend {
  
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String filePath = "";
      System.out.println("Please enter the path to the file which contains your movie database: ");
      filePath = scanner.nextLine();
      
      Backend be = null;
      try {
        be = new Backend(new FileReader(filePath));
      } catch (FileNotFoundException e) {
        System.out.println("File not found.");
        System.exit(0);
      }
      
      // TEST CODE - DELETE BEFORE SUBMISSION
      be.addGenre("Test");
      be.addGenre("Test2");
      // TEST CODE - DELETE BEFORE SUBMISSION
      
      run(be);
    }
    
    public static void run(Backend backend) {
      Scanner scanner = new Scanner(System.in);
      String input;
      Mode currentMode = Mode.BASE;
      
      while(true) {
        if(currentMode == Mode.BASE) {
          System.out.println("Welcome to Movie Mapper! Check the bottom of this screen for the available commands.");
          System.out.println("\nHere is a list of the top three movies in the dataset sorted in order of decreasing rating: ");
          
          System.out.println("TODO: PRINT LIST OF TOP THREE MOVIES");
          
          System.out.println("\n[g] Enter genre select mode       [r] Enter rating select mode        [x] Exit the program");
          
          input = scanner.next();
          
          switch(input) {
            case "g": currentMode = Mode.GENRE_SELECT; break;
            case "r": currentMode = Mode.RATING_SELECT; break;
            case "x": currentMode = Mode.EXIT; break;
          }
          
        }
        
        if(currentMode == Mode.GENRE_SELECT) {
          System.out.println("You have chosen the Genre Select mode. Here are the available genres for you to search by: \n");
          
          int counter = 0;
          String print = "";
          for(String s : backend.getGenres()) {
            print += "[" + counter + "] " + s + "\n";
            counter++;
          }
          System.out.println(print);
          System.out.println("Type in the number next to the genre to select it. Type 'x' to go back to the main menu.");
          
          input = scanner.next();
          
          if(input.equalsIgnoreCase("x")) currentMode = Mode.BASE;
        }
        
        if(currentMode == Mode.RATING_SELECT) {
          System.out.println("You have chosen the Rating Select mode. Here are the available ratings for you to search by: \n");
          System.out.println("[0-10]");
          System.out.println("Type in the rating you would like to search by. Type 'x' to go back to the main menu.");
          
          input = scanner.next();
          
          if(input.equalsIgnoreCase("x"))
            currentMode = Mode.BASE;
          
          else {
            try {
              int ratingSelected = Integer.parseInt(input);
              System.out.println(ratingSelected);
              backend.addAvgRating(input);
            } catch(NumberFormatException e) {
              System.out.println("That is not a valid option.");
            }
          }
        }
        
        
        if(currentMode == Mode.EXIT) {
          System.out.println("Thank you for using our Movie Mapper!");
          System.exit(0);
        }
      }
    }
// End of class Main
 }

    enum Mode {
        BASE,
        GENRE_SELECT,
        RATING_SELECT,
        EXIT
    }