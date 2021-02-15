package movieMapper;
import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String filePath = "";
    System.out.println("Please enter the path to the file which contains your movie database: ");
    filePath = scanner.nextLine();
    
    run(filePath);
  }
  
  public static void run(String csvFilePath) {
    Scanner scanner = new Scanner(System.in);
    char inputChar;
    Mode currentMode = Mode.BASE;
    
    while(true) {
      if(currentMode == Mode.BASE) {
        System.out.println("Welcome to Movie Mapper! Check the bottom of this screen for the available commands.");
        System.out.println("\nHere is a list of the top three movies in the dataset sorted in order of decreasing rating: ");
        
        System.out.println("TODO: PRINT LIST OF TOP THREE MOVIES");
        
        System.out.println("\n[g] Enter genre select mode       [r] Enter rating select mode        [x] Exit the program");
        
        inputChar = scanner.next().charAt(0);
        
        switch(inputChar) {
          case 'g': currentMode = Mode.GENRE_SELECT; break;
          case 'r': currentMode = Mode.RATING_SELECT; break;
          case 'x': currentMode = Mode.EXIT; break;
        }
        
      }
      
      if(currentMode == Mode.GENRE_SELECT) {
        System.out.println("You have chosen the Genre Select mode. Here are the available genres for you to search by: \n");
        System.out.println("TODO: LIST AVAILABLE GENRES");
        System.out.println("Type in the number next to the genre to select it. Type 'x' to go back to the main menu.");
        
        inputChar = scanner.next().charAt(0);
        
        if(inputChar == 'x') currentMode = Mode.BASE;
      }
      
      if(currentMode == Mode.RATING_SELECT) {
        System.out.println("You have chosen the Rating Select mode. Here are the available ratings for you to search by: \n");
        System.out.println("[0-10]");
        System.out.println("Type in the rating you would like to search by. Type 'x' to go back to the main menu.");
        
        inputChar = scanner.next().charAt(0);
        
        if(inputChar == 'x') currentMode = Mode.BASE;
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
