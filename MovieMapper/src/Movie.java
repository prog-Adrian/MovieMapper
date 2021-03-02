// --== CS400 File Header Information ==--
// Name: Kaushal Chandrasekar
// Email: kchandrasek4@wisc.edu
// Team: EB Blue (Purple Role)
// Role: Data Wrangler (Purple Role)
// TA: Yelun
// Lecturer: Purple Teammate, not sure
// Notes to Grader: Purple Teammate


import java.util.List;

public class Movie implements MovieInterface {

  String title;
  Integer year;
  List<String> genres;
  String director;
  String description;
  Float avgvote;

  // Instantiates a Movie Object with given parameters
  public Movie(String title, Integer year, List<String> genres, String director, String description,
      Float avgvote) {

    this.title = title;
    this.year = year;
    this.genres = genres;
    this.director = director;
    this.description = description;
    this.avgvote = avgvote;
  }

  public String getTitle() {

    return title;

  }


  public Integer getYear() {

    return year;

  }

  public List<String> getGenres() {

    return genres;

  }

  public String getDirector() {

    return director;


  }

  public String getDescription() {

    return description;

  }

  public Float getAvgVote() {

    return avgvote;

  }

  // compares this movie object to othermovie and returns the rounded integer of the difference of
  // their Average rating
  public int compareTo(MovieInterface othermovie) {

    return (Math.round(-(this.avgvote - othermovie.getAvgVote())));

  }

  // prints the movie as a string; takes care to remove extra quotation marks if present, but will
  // print the list of genres with a [] enclosing them
  public String toString() {
    String s = (title + ", " + year + ", " + genres + ", " + director + ", " + description + ", "
        + avgvote);
    return s;
  }



}

