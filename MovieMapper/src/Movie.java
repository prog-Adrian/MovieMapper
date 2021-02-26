import java.util.List;

public class Movie implements MovieInterface {
  private String title;
  private int year;
  private List<String> genres;
  private String director;
  private String description;
  private Float avgVote;
  
  
  
  public Movie(String title, int year, List<String> genres, String director,
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
        if ((float)this.avgVote > (float)otherMovie.getAvgVote())
          return 1;
        else if ((float)this.avgVote < (float)otherMovie.getAvgVote())
          return -1;
        return 0;
  }
  
  @Override
  public String toString() {
    String genres = "";
    for(String s : this.genres) {
      genres += (s + " ");
    }
    return(this.title + ", " + this.year + " | " + genres + "| " + this.director + " | " + this.description + " (" + this.avgVote + ")");
  }
  
  @Override
  public int hashCode() {
     return Math.abs(Integer.parseInt(this.genres.get(0)));
  }
  
  @Override
  public boolean equals(Object obj) {
      if(obj == this) {
          Movie dt = (Movie) obj;
          if(this.title.equals(dt.getTitle()) && this.toString().equals(dt.toString())) {
              return true;
          }
      }
      
     
      return false;
  }
}