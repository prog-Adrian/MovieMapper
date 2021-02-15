
import java.util.*;
import java.io.*;


public class backEnd {
    // Instantiating all the variables for the backend
    List<String> genreList;
    List<String> avgRatingList;
    List<String> outputList;
    Hashtable<String, String> movieTable;
    
    // Added a main function for testing the class
    // Reminder: Remove before final presentation/submission
    public static void main(String[] args){
        backEnd tester1 = new backEnd();
        tester1.addGenre("Pokemon");
        tester1.addAvgRating("10");
    }

    public backEnd(){
        // Creating the Hash table to hold the movie genre ratings 
        this.movieTable = new Hashtable<String, String>();
        // Init for the data structures
        this.genreList = new ArrayList<String>();
        this.avgRatingList = new ArrayList<String>();
        this.outputList = new ArrayList<String>();

    }

    // Backend constructor when taking an file/dataset for the input
    public backEnd(FileReader inputFile){
        // Instantiate the Data Wrangler object
        // MovieReaderInterface
        // Using input file
        
        // Creating the Hash table to hold the movie genre ratings 
        this.movieTable = new Hashtable<String, String>();
        // Init for the data structures
        this.genreList = new ArrayList<String>();
        this.avgRatingList = new ArrayList<String>();
        this.outputList = new ArrayList<String>();

    }

    public void addGenre(String genre){
        // Description:
        // The methods addGenre and addAvgRating in the interface above will be used by the front end to add another 
        // genre or rating to select movies by. The movies returned by the back end will be all movies in the selected 
        // rating ranges that have all of the selected genres. If there is no genre selected, 
        // the list of movies returned by the backend is empty
        if (!this.genreList.contains(genre) || this.genreList.size() <= 0){
            genreList.add(genre);
            System.out.println("The genre has been added");
        } else {
            System.out.println("The genre has not been added");
        }
    }
    
    // Add rating function, uses the genre priority queue and pops the genre while adding it along with the rating
    // to the movieTable Hashtable
    public void addAvgRating(String rating){
        // Checks if the Genre Queue is empty
        if(avgRatingList.size() <= 0 || !avgRatingList.contains(rating)){
            avgRatingList.add(rating);
            System.out.println("The rating has been added");
        } else {
            System.out.println("The rating has not been added");
        }
    }
   
    // Removing the genre added in the selection criteria 
    public void removeGenre(String genre){
        this.genreList.remove(genre);
    }

    // Removing the rating added in the selection criteria
    public void removeAvgRating(String rating){
        this.avgRatingList.remove(rating);
    }

    // Returns the currnet criteria for genres
    public List<String> getGenres(){
        return this.genreList;
    }

    // Returns the currnet criteria for avg_Ratings
    public List<String> getAvgRatings(){
        return this.avgRatingList;
    }

    // Returns the number of movies currnetly in the selection / outputList
    public int getNumberOfMovies(){
        return this.outputList.size();
    }

    /*
    public List<MovieInterface> getThreeMovies(int startingIndex){
    }
    
    Cannot make this function yet due to not having the MovieInterface
    */

    /*
    public List<String> getAllGenres(){
    }
    
    Cannot make this function yet due not having the data set code

    Function is suppose to give all the Genres in the data set
    */

}



/*

Note:
    This is only here for refrence
    Delete before final submission

public interface BackendInterface{

    public void addGenre(String genre);
    public void addAvgRating(String rating);
    public void rmeoveGenre(String genre);
    public void removeAvgRating(String rating);
    public List<String> getGenre();
    public List<String> getAvgRatings();
    public int getNumberofMovies();
    public List<MovieInterface> getThreeMovies(int startingIndex);
    public List<String> getAllGenres();
}
*/
