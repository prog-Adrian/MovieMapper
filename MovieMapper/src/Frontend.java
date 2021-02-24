import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Frontend {
  
    public static void main(String[] args) {
      //Scanner scanner = new Scanner(System.in);
      String filePath = "C:\\Users\\ozapa\\Downloads\\hwi_642.exe";
      //System.out.println("Please enter the path to the file which contains your movie database: ");
      //filePath = scanner.nextLine();
      
      DummyBackend be = null;
      try {
        be = new DummyBackend(new FileReader(filePath));
        // be = new Backend(new FileReader(args[0]));
      } catch (FileNotFoundException e) {
        System.out.println("File not found.");
        System.exit(0);
      }
      
      // TEST CODE - DELETE BEFORE SUBMISSION
      be.movieTable.put("Romance", "5");
      be.movieTable.put("Tragedy", "3");
      be.movieTable.put("Horror", "4");
      be.movieTable.put("Comedy", "6");
      be.movieTable.put("Musical", "34");
      // TEST CODE - DELETE BEFORE SUBMISSION
      
      run(be);
    }
    
    public static void run(DummyBackend backend) {
      Scanner scanner = new Scanner(System.in);
      String input;
      Mode currentMode = Mode.BASE;
      int currentIndex = 0;
      
      System.out.println("Welcome to Movie Mapper! Check the bottom of this screen for the available commands.");
      
      while(true) {
        if(currentMode == Mode.BASE) {
          System.out.println("\nHere is a list of the top three movies in your selected dataset starting at number " + currentIndex);
          System.out.println("TODO: PRINT LIST OF TOP THREE MOVIES");
          for(DummyMovie m : backend.getThreeMovies(currentIndex)) {
            System.out.println(m.getTitle());
          }
          
          
          System.out.println("\n[g] Enter genre select mode       [r] Enter rating select mode        [x] Exit the program");
          System.out.println("");
          
          input = scanner.next();
          
          switch(input) {
            case "g": currentMode = Mode.GENRE_SELECT; break;
            case "r": currentMode = Mode.RATING_SELECT; break;
            case "x": currentMode = Mode.EXIT; break;
          }
          
          if(input.equals("g")) {
            System.out.println("\nYou have chosen the Genre Select mode.");
            currentMode = Mode.GENRE_SELECT;
          } else if(input.equals("r")) {
            System.out.println("You have chosen the Rating Select mode.");
            currentMode = Mode.RATING_SELECT;
          } else if(input.equals("x")) {
            currentMode = Mode.EXIT;
          } else {
            try {
              currentIndex = Integer.parseInt(input);
            } catch(NumberFormatException e) {
              System.out.println("That isn't a valid input type!");
            }
          }
          
          
        }
        
        if(currentMode == Mode.GENRE_SELECT) {
          System.out.println("Genres currently selected: \n");
          if(backend.getGenres().isEmpty()) {
            System.out.println("There are no genres selected.");
          } else {
            for(String s : backend.getGenres()) {
              System.out.println(s);
            }
          }
          System.out.println("\nGenres available to select: \n");
          if(backend.getGenres().containsAll(backend.getAllGenres())) {
            System.out.println("All genres are currently selected.");
          } else {
            for(String s : backend.getAllGenres()) {
              if(backend.getGenres().contains(s)) continue;
              System.out.println(s);
            }
          }
          System.out.println("\nType in the name of the genre exactly as it is shown to select it. Type 'x' to go back to the main menu.");
          
          input = scanner.next();
          
          if(input.equalsIgnoreCase("x")) {
            currentMode = Mode.BASE;
          } else if(backend.getGenres().contains(input)) {
            backend.removeGenre(input);
          } else if(!backend.getGenres().contains(input) && backend.getAllGenres().contains(input)){
            backend.addGenre(input);
          } else {
            System.out.println("Invalid input.");
          }
        }
        
        if(currentMode == Mode.RATING_SELECT) {
          //System.out.println("You have chosen the Rating Select mode. Here are the available ratings for you to search by: \n");
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
 }

    enum Mode {
        BASE,
        GENRE_SELECT,
        RATING_SELECT,
        EXIT
    }
