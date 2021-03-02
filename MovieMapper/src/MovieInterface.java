// --== CS400 File Header Information ==--
// Name: Kaushal Chandrasekar
// Email: kchandrasek4@wisc.edu
// Team: EB Blue (Purple Role)
// Role: Data Wrangler (Purple Role)
// TA: Yelun
// Lecturer: Purple Teammate, not sure
// Notes to Grader: Purple Teammate

import java.util.List;

public interface MovieInterface extends Comparable<MovieInterface> {

  public String getTitle();

  public Integer getYear();

  public List<String> getGenres();

  public String getDirector();

  public String getDescription();

  public Float getAvgVote();

  // from super interface Comparable
  public int compareTo(MovieInterface otherMovie);

}
