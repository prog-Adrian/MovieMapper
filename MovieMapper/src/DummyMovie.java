import java.util.List;

public class DummyMovie implements MovieInterface {
  private String title;
  private int year;
  private List<String> genres;
  private String director;
  private String description;
  private Float avgVote;
  
  
  
  public DummyMovie(String title, int year, List<String> genres, String director,
      String description, Float avgVote) {
    this.title = title;
    this.year = year;
    this.genres = genres;
    this.director = director;
    this.description = description;
    this.avgVote = avgVote;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  @Override
  public Integer getYear() {
    // TODO Auto-generated method stub
    return this.year;
  }

  @Override
  public List<String> getGenres() {
    // TODO Auto-generated method stub
    return this.genres;
  }

  @Override
  public String getDirector() {
    // TODO Auto-generated method stub
    return this.director;
  }

  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return this.description;
  }

  @Override
  public Float getAvgVote() {
    // TODO Auto-generated method stub
    return this.avgVote;
  }

  @Override
  public int compareTo(MovieInterface otherMovie) {
    // TODO Auto-generated method stub
    return 0;
  }
  
}