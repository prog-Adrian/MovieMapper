import java.util.List;

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
