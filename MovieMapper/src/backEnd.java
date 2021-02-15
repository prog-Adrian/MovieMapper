package movieMapper;


public class backEnd implements BackendInterface{
    public backEnd(){

        

    }
    public void addGenre(String genre);
    public void addAvgRating(String rating);
    public void rmeoveGenre(String genre);
    public void removeAvgRating(String rating);
    public List<String> getGenre();
    public List<String> getAvgRatings();
    public int getNumberofMovies();


}


public interface BackendInterface{

    public void addGenre(String genre);
    public void addAvgRating(String rating);
    public void rmeoveGenre(String genre);
    public void removeAvgRating(String rating);
    public List<String> getGenre();
    public List<String> getAvgRatings();
    public int getNumberofMovies();
    //public List<MovieInterface> getThreeMovies(int startingIndex);
    //public List<String> getAllGenres();
}

