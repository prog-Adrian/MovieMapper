import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
// --== CS400 File Header Information ==--
// Name: Param Oza
// Email: phoza@wisc.edu
// Team: EB Red
// Role: Frontend Developer
// TA: Yelun
// Lecturer: Florian Heimerl
// Notes to Grader: N/A


/**
 * This class serves as the Frontend driver class for CS400's Movie Mapper project. It provides a
 * clear and understandable user interface, and ensures that all inputs are handled properly.
 * 
 * @author Param Oza
 * @since 3/2/2021
 * @version 1.0
 *
 */
public class Frontend {

  public static void main(String[] args) {

    // make new backend object
    Backend be = new Backend(args);
    // run the code with the newly created backend
    run(be);
  }

  /**
   * This method serves as the main driver method for the Frontend for Movie Mapper. This correctly
   * handles all user inputs and ensures that all commands are easy to understand and use.
   * 
   * @param backend The backend object that will be used by the Frontend to interact with the data.
   */
  public static void run(Backend backend) {
    // make a new scanner object to read user input
    Scanner scanner = new Scanner(System.in);
    String input;

    // this represents the current mode that Movie Mapper is in
    Mode currentMode = Mode.BASE;
    // this represents the index from which to start listing the top 3 movies in the selection set
    int currentIndex = 0;
    System.out.println(
        "Welcome to Movie Mapper! Check the bottom of this screen for the available commands.");

    // core program loop, only exits when Movie Mapper receives exit command from base mode
    while (true) {

      // handles the base mode operations for the program
      if (currentMode == Mode.BASE) {

        System.out.println(
            "\nHere is a list of the top three movies in your selected dataset starting at number "
                + (currentIndex + 1) + ".\n");

        // prints the top 3 movies based on rating from the selection set
        // prints custom message if no movies exist in selection set
        int counter = currentIndex + 1;
        if (backend.getThreeMovies(currentIndex).isEmpty()) {
          System.out.println("There are no movies available with your current search criteria!");
        }

        for (MovieInterface m : backend.getThreeMovies(currentIndex)) {
          System.out.println(counter + ". " + m.toString());
          counter++;
        }

        // display available commands
        System.out.println(
            "\n[g] Enter genre select mode       [r] Enter rating select mode        [x] Exit the program");
        System.out.println(
            "You can also type in the number next to a movie to display the next three movies after it.");
        System.out.print("Command: ");

        input = scanner.next();

        // handle all different types of input that the user could possibly enter
        if (input.equals("g")) {
          System.out.println("\nYou have chosen the Genre Select mode.");
          currentMode = Mode.GENRE_SELECT;
        } else if (input.equals("r")) {
          System.out.println("\nYou have chosen the Rating Select mode.");
          currentMode = Mode.RATING_SELECT;
        } else if (input.equals("x")) {
          currentMode = Mode.EXIT;

          // otherwise, the input is either a number or invalid.
          // if a number, set currentIndex to that number.
        } else {
          try {
            int index = Integer.parseInt(input);
            // check to ensure that chosen index is within proper range
            if (index - 1 >= backend.getNumberOfMovies()) {
              System.out.println("\nThere aren't that many movies in the list!");
            } else {
              currentIndex = index - 1;
            }
            // otherwise, the input type is not valid
          } catch (NumberFormatException e) {
            System.out.println("That isn't a valid input type!");
          }
        }


      }

      // handles the genre selection operations for the program
      if (currentMode == Mode.GENRE_SELECT) {
        // print list of all genres and indicate which ones are selected or not
        System.out.println("\nList of Genres: \n");
        for (String s : backend.getAllGenres()) {
          if (backend.getGenres().contains(s)) {
            System.out.println(s + " | Selected");
          } else {
            System.out.println(s + " | Not Selected");
          }

        }

        // provide user with instruction on how to use this mode
        System.out.println(
            "\nType in the name of the genre exactly as it is shown to toggle it. Type 'x' to go back to the main menu.");
        System.out.print("Command: ");

        input = scanner.next();

        // parse user input to either a character denoting the next mode Movie Mapper should go to,
        // or if it is a String, handle Genre selection or deselection.
        if (input.equalsIgnoreCase("x")) {
          currentMode = Mode.BASE;
          currentIndex = 0;
        } else if (backend.getGenres().contains(input)) {
          backend.removeGenre(input);
        } else if (!backend.getGenres().contains(input) && backend.getAllGenres().contains(input)) {
          backend.addGenre(input);
        } else {
          System.out.println("Invalid input.");
        }
      }

      // handles all rating selection operations for the program
      if (currentMode == Mode.RATING_SELECT) {

        // create a master list of all possible ratings (0-10) to compare getAvgRatings() with
        List<String> availableRatings = new ArrayList<String>();
        for (int i = 0; i <= 10; i++) {
          availableRatings.add(String.valueOf(i));
        }

        // list out all ratings and indicate which ones are selected or not
        System.out.println("\nList of ratings: \n");
        for (String s : availableRatings) {
          if (backend.getAvgRatings().contains(s)) {
            System.out.println(s + " | Selected");
          } else {
            System.out.println(s + " | Not Selected");
          }
        }

        // provide the user the available commands in this mode
        System.out.println(
            "\nType in the rating you would like to toggle. Type 'x' to go back to the main menu.");
        System.out.print("Command: ");

        input = scanner.next();

        // parse user input and handle accordingly
        if (input.equalsIgnoreCase("x")) {
          currentMode = Mode.BASE;
          currentIndex = 0;
        }

        // otherwise, the input must be a number that represents the rating to be toggled
        // if not, invalid input.
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

      // handles the command to exit Movie Mapper from the base mode
      if (currentMode == Mode.EXIT) {
        System.out.println("Thank you for using our Movie Mapper!");
        break;
      }
    }
  }
}


/**
 * This enum contains all of the different modes that the user can select in this program.
 * 
 * @author Param Oza
 * @since 3/2/2021
 * @version 1.0
 */
enum Mode {
  BASE, GENRE_SELECT, RATING_SELECT, EXIT
}
