
import java.io.StringReader;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 * This class contains a set of tests for the MovieInterface and MovieDataReaderInterface
 * implementation of the Movie Mapper project.
 */
public class TestMovieandMovieDataReader {

        MovieDataReaderInterface readerToTest = new MovieDataReader();

        public static void main(String[] args) {
                (new TestMovieandMovieDataReader()).runTests();
        }

        /**
         * This method calls all of the test methods in the class and ouputs pass / fail
         * for each test.
         */

        public void runTests() {
                // instantiate reader to test once it is implemented
              //  readerToTest = null; //new MovieDataReader();

                // add all tests to this method
                if (this.testReaderNumberOfMovies()) {
                        System.out.println("Test number of movies: PASSED");
                } else {
                        System.out.println("Test number of movies: FAILED");
                }
                if (this.testReaderMovieTitles()) {
                        System.out.println("Test movie titles: PASSED");
                } else {
                        System.out.println("Test movie titles: FAILED");
                }
                if (this.testMovieOrder()) {
                        System.out.println("Test movie order: PASSED");
                } else {
                        System.out.println("Test movie order: FAILED");
                }
                if (this.testReaderMovieYears())
                {
                        System.out.println("Test movie year: PASSED");
                } else {
                        System.out.println("Test movie year: FAILED");
                }
                if (this.testReaderMovieDirectors())
                {
                        System.out.println("Test movie Director: PASSED");
                } else {
                        System.out.println("Test movie Director: FAILED");
                }
                if (this.testReaderGenreList())
                {
                        System.out.println("Test movie genres: PASSED");
                } else {
                        System.out.println("Test movie genres: FAILED");
                }

        }

        /**
         * This test reads in 3 movies and tests whether the list of movies
         * returned is of size 3. It fails if the size is not 3 or if an
         * exception occurs while reading in the movies.
 * @return true if the test passed, false if it failed
         */
        public boolean testReaderNumberOfMovies() {
                List<MovieInterface> movieList;
                try {
                	
                
                movieList = readerToTest.readDataSet(new StringReader(
                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
                + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
                + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
                + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                        ));
                } catch (Exception e) {
                        e.printStackTrace();
                        // test failed
                        return false;
                }
                if (movieList.size() == 3) {
                        // test passed
                        return true;
                } else {
                        // test failed
                        return false;
                }
        }

    /**
         * This test reads in 3 movies and tests whether the list of movies
         * contains all 3 titles of the source data in any order. It fails
         * if the list returned is missing one or more titles or if an
         * exception occurs while reading in the data.
         * @return true if the test passed, false if it failed
         */
        public boolean testReaderMovieTitles() {
                List<MovieInterface> movieList;
                try {
                	movieList = readerToTest.readDataSet(new StringReader(
                            "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
                    + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
                    + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
                    + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                            ));
                } catch (Exception e) {
                        e.printStackTrace();
                        // test failed
                        return false;
                }
                String title1 = "The Source of Shadows";
                String title2 = "The Insurrection";
                String title3 = "Valley Girl";
                boolean equalOne = true;
                // check if first movie is has of the above titles
                equalOne = equalOne && (title1.equals(movieList.get(0).getTitle()) ||
                                                                title2.equals(movieList.get(0).getTitle()) ||
                                                                title3.equals(movieList.get(0).getTitle()));
                // check if second movie is has of the above titles
                equalOne = equalOne && (title1.equals(movieList.get(1).getTitle()) ||
                                                                title2.equals(movieList.get(1).getTitle()) ||
                                                                title3.equals(movieList.get(1).getTitle()));
                // check if third movie is has of the above titles
                equalOne = equalOne && (title1.equals(movieList.get(2).getTitle()) ||
                        title2.equals(movieList.get(2).getTitle()) ||
                        title3.equals(movieList.get(2).getTitle()));
                // true if the three movies have the right titles
                return equalOne;
        }

        /**
         * This test reads in 3 movies, then sorts them. It then checks whether
         * the default sorting order is Descending based on the average ratings.
         * @return true if the test passed, false if it failed
         */
        public boolean testMovieOrder() {
        	List<MovieInterface> movieList;
        	try {
        		movieList = readerToTest.readDataSet(new StringReader(
                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
                + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
                + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
                + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                        ));
        	} catch (Exception e) {
        		e.printStackTrace();
        		// test failed
        		return false;
        	}
        	
        	double lastRating = 11f;
        	Collections.sort(movieList);
        	for (MovieInterface movie : movieList) {
        		if (movie.getAvgVote() > lastRating) {
        			// test fails
        			System.out.println(movie.getAvgVote());
        			return false;
        		}
        		lastRating = movie.getAvgVote();
        	}
        	// test passes
        	return true;
        }

        // TODO: Data Wrangler, add at least 2 more tests
        /**
         * This test reads in 3 movies and tests whether the list of movies
         * contains all 3 years of the movies of the source data in any order. It fails
         * if the list returned is missing one or more years or if an
         * exception occurs while reading in the data.
         * @return true if the test passed, false if it failed
         */
        public boolean testReaderMovieYears() {
        	List<MovieInterface> movieList;
        	try {
        		movieList = readerToTest.readDataSet(new StringReader(
                        "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
                + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
                + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
                + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                        ));
        	} catch (Exception e) {
        		e.printStackTrace();
        		  // test failed
                return false;
        }
        Integer year1 = 2020;
        Integer year2 = 2019;
        Integer year3 = 2021;
        boolean equalOne = true;
        // check if first movie is has of the above years
        equalOne = equalOne && (year1.equals(movieList.get(0).getYear()) ||
                                                        year2.equals(movieList.get(0).getYear()) ||
                                                        year3.equals(movieList.get(0).getYear()));
        // check if second movie has the above years
        equalOne = equalOne && (year1.equals(movieList.get(1).getYear()) ||
                                                        year2.equals(movieList.get(1).getYear()) ||
                                                        year3.equals(movieList.get(1).getYear()));
        // check if third movie has the above years
        equalOne = equalOne && (year1.equals(movieList.get(2).getYear()) ||
                                                        year2.equals(movieList.get(2).getYear()) ||
                                                        year3.equals(movieList.get(2).getYear()));
        // true if the three movies have the right years
        return equalOne;
}

/**
 * This test reads in 3 movies and tests whether the list of movies
 * contains all 3 directors of the source data in any order. It fails
 * if the list returned is missing one or more directors or if an
 * exception occurs while reading in the data.
 * @return true if the test passed, false if it failed
 */

        
public boolean testReaderMovieDirectors() {
        List<MovieInterface> movieList;
        try {
        	movieList = readerToTest.readDataSet(new StringReader(
                    "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
            + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
            + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
            + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                    ));
        } catch (Exception e) {
                e.printStackTrace();
                // test failed
                return false;
        }
        
    	
        String d1 = "Ryan Bury, Jennifer Bonior";
        String d2 = "Rene Perez";
        String d3 = "Rachel Lee Goldenberg";
        boolean equalOne = true;
        // check if first movie has the above Directors
        equalOne = equalOne && (d1.equals(movieList.get(0).getDirector()) ||
                                                        d2.equals(movieList.get(0).getDirector()) ||
                                                        d3.equals(movieList.get(0).getDirector()));
        // check if second movie has the above Directors
        equalOne = equalOne && (d1.equals(movieList.get(1).getDirector()) ||
                                                        d2.equals(movieList.get(1).getDirector()) ||
                                                        d3.equals(movieList.get(1).getDirector()));
        // check if third movie has the above Directors
        equalOne = equalOne && (d1.equals(movieList.get(2).getDirector()) ||
                                                        d2.equals(movieList.get(2).getDirector()) ||
                                                        d3.equals(movieList.get(2).getDirector()));
        // true if the three movies have the right Directors
        return equalOne;
		}

/**
 * This test reads in 3 movies and tests whether the list of movies
 * contains all the same genres of the source data in any order. It fails
 * if the list returned is missing one or more genres or if an
 * exception occurs while reading in the data.
 * @return true if the test passed, false if it failed
 */
public boolean testReaderGenreList() {
        List<MovieInterface> movieList;
        try {
        	movieList = readerToTest.readDataSet(new StringReader(
                    "title,original_title,year,genre,duration,country,language,director,writer,production_company,actors,description,avg_vote\n"
            + "The Source of Shadows,The Source of Shadows,2020,Horror,83,USA,English,\"Ryan Bury, Jennifer Bonior\",\"Jennifer Bonior, Trevor Botkin\",Four Thieves Productions,\"Ashleigh Allard, Tom Bonington, Eliane Gagnon, Marissa Kaye Grinestaff, Jenna Heffernan, Joshua Hummel, Janice Kingsley, Chris Labasbas, Jared Laufree, Dominic Lee, Vic May, Sienna Mazzone, Lizzie Mounter, Grace Mumm, Ashley Otis\",\"A series of stories woven together by one of our most primal fears, the fear of the unknown.\",3.5\n"
            + "The Insurrection,The Insurrection,2020,Action,90,USA,English,Rene Perez,Rene Perez,,\"Michael Paré, Wilma Elles, Joseph Camilleri, Rebecca Tarabocchia, Jeanine Harrington, Malorie Glavan, Danner Boyd, Michael Cendejas, Woody Clendenen, Keely Dervin, Aaron Harvey, Tony Jackson, Michael Jarrod, Angelina Karo, Bernie Kelly\",The director of the largest media company wants to expose how left-wing powers use film to control populations.,2.9\n"
            + "Valley Girl,Valley Girl,2020,\"Comedy, Musical, Romance\",102,USA,English,Rachel Lee Goldenberg,\"Amy Talkington, Andrew Lane\",Sneak Preview Productions,\"Jessica Rothe, Josh Whitehouse, Jessie Ennis, Ashleigh Murray, Chloe Bennet, Logan Paul, Mae Whitman, Mario Revolori, Rob Huebel, Judy Greer, Alex Lewis, Alex MacNicoll, Danny Ramirez, Andrew Kai, Allyn Rachel\",\"Set to a new wave '80s soundtrack, a pair of young lovers from different backgrounds defy their parents and friends to stay together. A musical adaptation of the 1983 film.\",5.4\n"
                    ));
        } catch (Exception e) {
                e.printStackTrace();
                // test failed
                return false;
        }
        
    	String[] d1 = {"Horror"};
    	String[] d2 = {"Action"};
    	String[] d3 = {"Comedy", "Musical", "Romance"};
        List<String> g1 = Arrays.asList(d1);
        List<String> g2 = Arrays.asList(d2);
        List<String> g3 = Arrays.asList(d3);
    
        boolean equalOne = true;
     // check if first movie has of the above genres
        equalOne = equalOne && (g1.equals(movieList.get(0).getGenres()) ||
                                                        g2.equals(movieList.get(0).getGenres()) ||
                                                        g3.equals(movieList.get(0).getGenres()));
        
        // check if second movie has of the above genres
        equalOne = equalOne && (g1.equals(movieList.get(1).getGenres()) ||
                                                        g2.equals(movieList.get(1).getGenres()) ||
                                                        g3.equals(movieList.get(1).getGenres()));
        
        // check if third movie has of the above genres
        equalOne = equalOne && (g1.equals(movieList.get(2).getGenres()) ||
                                                        g2.equals(movieList.get(2).getGenres()) ||
                                                        g3.equals(movieList.get(2).getGenres()));
        
        // true if the three movies have the right genres
        return equalOne;
		}


}   
