import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Frontend {

  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    String filePath = "C:\\Users\\ozapa\\Downloads\\movies.csv";
    System.out.println(filePath);
    // System.out.println("Please enter the path to the file which contains your movie database: ");
    // filePath = scanner.nextLine();

    Backend be = null;
    try {
      be = new Backend(new FileReader(filePath));
      // be = new Backend(new FileReader(args[0]));
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
      System.exit(0);
    }

    // TEST CODE - DELETE BEFORE SUBMISSION

    // TEST CODE - DELETE BEFORE SUBMISSION

    run(be);
  }

  public static void run(Backend backend) {
    Scanner scanner = new Scanner(System.in);
    String input;
    Mode currentMode = Mode.BASE;
    int currentIndex = 0;

    System.out.println(
        "Welcome to Movie Mapper! Check the bottom of this screen for the available commands.");

    while (true) {
      if (currentMode == Mode.BASE) {
        System.out.println(
            "\nHere is a list of the top three movies in your selected dataset starting at number "
                + (currentIndex + 1) + "\n");

        int counter = currentIndex + 1;
        for (MovieInterface m : backend.getThreeMovies(currentIndex)) {
          System.out.println(counter + ". " + m.toString());
          counter++;
        }


        System.out.println(
            "\n[g] Enter genre select mode       [r] Enter rating select mode        [x] Exit the program");
        System.out.println(
            "You can also type in the number next to display the next three movies after it.");
        System.out.print("Command: ");

        input = scanner.next();

        if (input.equals("g")) {
          System.out.println("\nYou have chosen the Genre Select mode.");
          currentMode = Mode.GENRE_SELECT;
        } else if (input.equals("r")) {
          System.out.println("\nYou have chosen the Rating Select mode.");
          currentMode = Mode.RATING_SELECT;
        } else if (input.equals("x")) {
          currentMode = Mode.EXIT;
        } else {
          try {
            int index = Integer.parseInt(input);
            if (index - 1 >= backend.getNumberOfMovies()) {
              System.out.println("\nToo far!");
            } else {
              currentIndex = index - 1;
            }
          } catch (NumberFormatException e) {
            System.out.println("That isn't a valid input type!");
          }
        }


      }

      if (currentMode == Mode.GENRE_SELECT) {
        System.out.println("Genres currently selected: \n");
        if (backend.getGenres().isEmpty()) {
          System.out.println("There are no genres selected.");
        } else {
          for (String s : backend.getGenres()) {
            System.out.println(s);
          }
        }
        System.out.println("\nGenres available to select: \n");
        if (backend.getGenres().containsAll(backend.getAllGenres())) {
          System.out.println("All genres are currently selected.");
        } else {
          for (String s : backend.getAllGenres()) {
            if (backend.getGenres().contains(s))
              continue;
            System.out.println(s);
          }
        }
        System.out.println(
            "\nType in the name of the genre exactly as it is shown to toggle it. Type 'x' to go back to the main menu.");
        System.out.print("Command: ");

        input = scanner.next();

        if (input.equalsIgnoreCase("x")) {
          currentMode = Mode.BASE;
        } else if (backend.getGenres().contains(input)) {
          backend.removeGenre(input);
        } else if (!backend.getGenres().contains(input) && backend.getAllGenres().contains(input)) {
          backend.addGenre(input);
        } else {
          System.out.println("Invalid input.");
        }
      }

      if (currentMode == Mode.RATING_SELECT) {
        List<String> availableRatings = new ArrayList<String>();
        for(int i = 0; i <= 10; i++) {
          availableRatings.add(String.valueOf(i));
        }
        
        
        // System.out.println("You have chosen the Rating Select mode. Here are the available
        // ratings for you to search by: \n");
        System.out.println("Ratings currently selected: \n");
        if (backend.getAvgRatings().isEmpty()) {
          System.out.println("There are no ratings selected.");
        } else {
          for (String s : backend.getAvgRatings()) {
            System.out.println(s);
          }
        }
        
        System.out.println("\nRatings available to select: \n");
        if(backend.getAvgRatings().containsAll(availableRatings)) {
          System.out.println("All ratings are currently selected.");
        } else {
          for(String s : availableRatings) {
            if(backend.getAvgRatings().contains(s))
              continue;
            System.out.println(s);
          }
        }
        
        System.out.println(
            "\nType in the rating you would like to toggle. Type 'x' to go back to the main menu.");
        System.out.print("Command: ");

        input = scanner.next();

        if (input.equalsIgnoreCase("x"))
          currentMode = Mode.BASE;

        else {
          try {
            int ratingSelected = Integer.parseInt(input);
            if (ratingSelected < 0 || ratingSelected > 10) {
              System.out.println("That number isn't between 0 and 10!");
              continue;
            }
            if (backend.getAvgRatings().contains(input)) {
              backend.removeAvgRating(input);
            } else {
              backend.addAvgRating(input);
            }
          } catch (NumberFormatException e) {
            System.out.println("That is not a valid option.");
          }
        }
      }


      if (currentMode == Mode.EXIT) {
        System.out.println("Thank you for using our Movie Mapper!");
        break;
      }
    }
  }
}


enum Mode {
  BASE, GENRE_SELECT, RATING_SELECT, EXIT
}
