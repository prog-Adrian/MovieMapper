import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class DummyBackend {
    // Instantiating all the variables for the backend
    List<String> genreList;
    List<String> avgRatingList;
    List<String> outputList;
    Hashtable<String, String> movieTable;
    
    List<DummyMovie> allMovies = new ArrayList<DummyMovie>();


    public DummyBackend(){
        // Creating the Hash table to hold the movie genre ratings 
        this.movieTable = new Hashtable<String, String>();
        // Init for the data structures
        this.genreList = new ArrayList<String>();
        this.avgRatingList = new ArrayList<String>();
        this.outputList = new ArrayList<String>();
        
        DummyMovie movie1 = new DummyMovie("Titanic", 1997, Arrays.asList("Romance", "Drama"), "James Cameron", "Good", 7.8F);
        DummyMovie movie2 = new DummyMovie("Up", 2009, Arrays.asList("Adventure", "Family"), "Pete Docter", "Good", 8.2F);
        DummyMovie movie3 = new DummyMovie("Soul", 2020, Arrays.asList("Drama", "Family"), "Pete Docter", "Very Good", 8.1F);
        this.allMovies.add(movie1);
        this.allMovies.add(movie2);
        this.allMovies.add(movie3);

    }

    // Backend constructor when taking an file/dataset for the input
    public DummyBackend(FileReader inputFile){
        // Instantiate the Data Wrangler object
        // MovieReaderInterface
        // Using input file
        
        // Creating the Hash table to hold the movie genre ratings 
        this.movieTable = new Hashtable<String, String>();
        // Init for the data structures
        this.genreList = new ArrayList<String>();
        this.avgRatingList = new ArrayList<String>();
        this.outputList = new ArrayList<String>();
        
        DummyMovie movie1 = new DummyMovie("Titanic", 1997, Arrays.asList("Romance", "Drama"), "James Cameron", "Good", 7.8F);
        DummyMovie movie2 = new DummyMovie("Up", 2009, Arrays.asList("Adventure", "Family"), "Pete Docter", "Good", 8.2F);
        DummyMovie movie3 = new DummyMovie("Soul", 2020, Arrays.asList("Drama", "Family"), "Pete Docter", "Very Good", 8.1F);
        this.allMovies.add(movie1);
        this.allMovies.add(movie2);
        this.allMovies.add(movie3);

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

    public List<DummyMovie> getThreeMovies(int startingIndex) {
      List<DummyMovie> toReturn = new ArrayList<DummyMovie>();
      for(int i = startingIndex; i < this.allMovies.size(); i++) {
        toReturn.add(this.allMovies.get(i));
      }
      return toReturn;
      
    }

    public List<String> getAllGenres(){
        List<String> ans = new ArrayList<String>(this.movieTable.size());
        for(String k: this.movieTable.keySet()) {
            ans.add(k);
        }
        return ans;
    
    }
    /*
    Cannot make this function yet due not having the data set code

    Function is suppose to give all the Genres in the data set
    */
    

}