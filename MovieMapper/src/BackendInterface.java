import java.util.List;
// --== CS400 File Header Information ==--
// Name: Adrian Ayag
// Email: aayag@wisc.edu
// Team: EB Red
// Role: Backend Developer
// TA: Yelun
// Lecturer: Gary Dahl
// Notes to Grader: N/A

public interface BackendInterface {
  public void addGenre(String genre);

  public void addAvgRating(String rating);

  public void removeGenre(String genre);

  public void removeAvgRating(String genre);

  public List<String> getGenres();

  public List<String> getAvgRatings();

  public int getNumberOfMovies();

  public List<MovieInterface> getThreeMovies(int startingIndex);

  public List<String> getAllGenres();
}
