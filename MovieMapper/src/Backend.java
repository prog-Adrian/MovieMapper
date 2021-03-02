import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.io.*;
import java.util.Collections;


public class Backend implements BackendInterface{
    // Instantiating all the variables for the backend
    
    List<String> genre;
    List<String> rating;
    List<MovieInterface> outputList;
    HashTableMap<String, List<Movie>> genreTable;
    List<Movie> genreList;
    List<MovieInterface> validMovies;
    List<MovieInterface> possibleMovies;
    List<MovieInterface> possibleRatings;
    List<MovieInterface> possibleGenres;
    List<Movie> dataSet;
    
    // Added a main function for testing the class
    // Reminder: Remove before final presentation/submission
    public static void main(String[] args){
    	//String[] cmdArgs = new String[] {"C:\\\\Users\\\\zxcvt\\\\Documents\\\\CS400\\\\MovieMapper\\\\movies.csv", "Horror", "2", "0"};
    	//Backend tester1 = new Backend(cmdArgs);
        try {	
			Backend tester2 = new Backend(new FileReader("C:\\Users\\zxcvt\\Documents\\CS400\\MovieMapper\\movies.csv"));
	        System.out.println(tester2.getNumberOfMovies());
	        tester2.addGenre("Horror");
	        tester2.addGenre("Action");
	        tester2.addAvgRating("2");
	        tester2.addAvgRating("5");
	        System.out.println(tester2.getNumberOfMovies());
	        System.out.println(tester2.getNumberOfMovies());
	        for(MovieInterface mv :tester2.getThreeMovies(0)) {
	        	System.out.println(mv.toString());
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public Backend(String args[]) {
    	MovieDataReader mvReader = new MovieDataReader();
		try {
			FileReader inputFile = new FileReader(args[0]);
			this.dataSet = mvReader.readDataSet(inputFile);
			// Creating the Hash table to hold the movie genre ratings 
	        this.genreTable = new HashTableMap<String, List<Movie>>();
	        this.genreList = new ArrayList<Movie>();
	        this.possibleRatings = new ArrayList<MovieInterface>();
	        this.possibleGenres = new ArrayList<MovieInterface>();
	        this.validMovies = new ArrayList<MovieInterface>();
	        Collections.sort(this.dataSet);
	        List<String> allGenres = getAllGenres();
	        for(String aG : allGenres) {
	        	this.genreList = new ArrayList<Movie>();
	        	for(Movie dw: this.dataSet) {
	        		for(String g : dw.getGenres()) {
	        			if(aG.equals(g)) {
	        				this.genreList.add(dw);
	        			}
	        		}
	        	}
	        	this.genreTable.put(aG, this.genreList);
	        }
	        // Init for the data structures
	        this.possibleMovies = new ArrayList<MovieInterface>();
	        this.genre = new ArrayList<String>();
	        this.rating = new ArrayList<String>();
	        this.outputList = new ArrayList<MovieInterface>();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DataFormatException e) {
			e.printStackTrace();
		}
    }

    // Backend constructor when taking an file/dataset for the input
    public Backend(FileReader inputFile){
        // Instantiate the Data Wrangler object
        // MovieReaderInterface
        // Using input file
        MovieDataReader mvReader = new MovieDataReader();
			try {
				this.dataSet = mvReader.readDataSet(inputFile);
				// Creating the Hash table to hold the movie genre ratings 
		        this.genreTable = new HashTableMap<String, List<Movie>>();
		        this.genreList = new ArrayList<Movie>();
		        this.possibleRatings = new ArrayList<MovieInterface>();
		        this.possibleGenres = new ArrayList<MovieInterface>();
		        this.validMovies = new ArrayList<MovieInterface>();
		        Collections.sort(this.dataSet);
		        List<String> allGenres = getAllGenres();
		        for(String aG : allGenres) {
		        	this.genreList = new ArrayList<Movie>();
		        	for(Movie dw: this.dataSet) {
		        		for(String g : dw.getGenres()) {
		        			if(aG.equals(g)) {
		        				this.genreList.add(dw);
		        			}
		        		}
		        	}
		        	this.genreTable.put(aG, this.genreList);
		        }
		        // Init for the data structures
		        this.possibleMovies = new ArrayList<MovieInterface>();
		        this.genre = new ArrayList<String>();
		        this.rating = new ArrayList<String>();
		        this.outputList = new ArrayList<MovieInterface>();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (DataFormatException e) {
				e.printStackTrace();
			}
    }

    public void addGenre(String genre){
        // Description:
        // The methods addGenre and addAvgRating in the interface above will be used by the front end to add another 
        // genre or rating to select movies by. The movies returned by the back end will be all movies in the selected 
        // rating ranges that have all of the selected genres. If there is no genre selected, 
        // the list of movies returned by the backend is empty
    	this.possibleMovies.clear();
    	if(this.genre.contains(genre) == false) {
    		this.genre.add(genre);
    		PairNodeList<String, List<Movie>>[] pairs = this.genreTable.getPairs();
    		for(int i = 0; i < pairs.length;i++) {
    			if(pairs[i]!= null) {
    				PairNodeList<String, List<Movie>> currList = pairs[i];
    				while(currList != null) {
    					List<Movie> tempList = pairs[i].getValue();
    					for(int j = 0; j < tempList.size(); j++) {
    						Movie currNode = tempList.get(j);
    						if(currNode.getGenres().containsAll(this.genre) == true && this.possibleGenres.contains(currNode) == false) {
    							this.possibleGenres.add(currNode);
    						}
    					}
    					currList = currList.getNext();
    				}
    			}
    		}
    		/*
    		if(this.rating.size() == 0) {
    			for(int i = 0; i < pairs.length;i++) {
        			if(pairs[i]!= null) {
        				PairNodeList<String, List<Movie>> currList = pairs[i];
        				while(currList != null) {
        					List<Movie> tempList = pairs[i].getValue();
        					for(int j = 0; j < tempList.size(); j++) {
        						Movie currNode = tempList.get(j);
        						if(currNode.getGenres().containsAll(this.genre) == true && this.possibleGenres.contains(currNode) == false) {
        							this.possibleGenres.add(currNode);
        						}
        					}
        					currList = currList.getNext();
        				}
        			}
        		}
    		} else {
    			for(int i = 0; i < pairs.length;i++) {
        			if(pairs[i]!= null) {
        				PairNodeList<String, List<Movie>> currList = pairs[i];
        				while(currList != null) {
        					List<Movie> tempList = pairs[i].getValue();
        					for(int j = 0; j < tempList.size(); j++) {
        						Movie currNode = tempList.get(j);
        						if(currNode.getGenres().containsAll(this.genre) && this.possibleGenres.contains(currNode) == false && checkRange(currNode) == true) {
        							this.possibleGenres.add(currNode);
        						}
        					}
        					currList = currList.getNext();
        				}
        			}
        		}
    		}
    		*/
			addMovies(this.possibleGenres);
			this.possibleGenres.clear();
			List<MovieInterface> toCull = new ArrayList<>();
			for(MovieInterface mv : this.possibleMovies) {
				if(!(checkGenre(mv) == true && checkRange(mv) == true) && this.rating.size() > 0) {
					toCull.add(mv);
				}
			}
			if(toCull.size() > 0) {
				removeAll(toCull);
			}
    		System.out.println("The genre has been added");
    	} else {
            System.out.println("The genre has not been added");
        }
        
    }
    
    // Primary method for adding movies to the possibleRatings (ArrayList)
    // This sorts through all the possible genres set and finds the ratings that are within the range of rating + 1
    // also inclusive for the value of rating
    public void addAvgRating(String rating){
        if(this.rating.contains(rating) == false){
            this.rating.add(rating);
            if(this.possibleMovies.size() > 0) {
            	for(String rat : this.rating) {
            		for(MovieInterface dw : this.possibleMovies) {
                		float upperLim = Float.parseFloat(rat) + (float) 1;
                		if((dw.getAvgVote() >= Float.parseFloat(rat)) && (dw.getAvgVote() < upperLim) && this.validMovies.contains(dw) == false) {
                			this.validMovies.add(dw);
                		}
                	}
            	}
            }
            List<MovieInterface> toCull = new ArrayList<>();
			for(MovieInterface mv : this.validMovies) {
				if(!(checkGenre(mv) == true && checkRange(mv) == true) && this.rating.size() > 0) {
					toCull.add(mv);
				}
			}
			if(toCull.size() > 0) {
				removeAll(toCull);
			}
            if(this.validMovies.size() == 0) {
            	this.possibleMovies.clear();
            }
            System.out.println("The rating has been added");
        } else {
            System.out.println("The rating has not been added");
        }
    }
 
    // Removing the rating added in the selection criteria, all the movies that meet the criteria for removal
    // are added into toRemove and then removed with removeAll
    public void removeAvgRating(String rating){
    	List<MovieInterface> toRemove = new ArrayList<MovieInterface>();
		for(int i = 0; i < this.possibleMovies.size();i++) {
			float tempRating = Float.parseFloat(rating);
			float upperLimit = tempRating + (float)1;
			if(this.possibleMovies.get(i).getAvgVote() >= tempRating && this.possibleMovies.get(i).getAvgVote() < upperLimit) {
				toRemove.add(this.possibleMovies.get(i));
			}
		}
		removeAll(toRemove);
    	this.rating.remove(rating);
    	System.out.println("The rating has been removed");
     }
    // Method that calls removeAll by comparing the genre passed in to those in possibleGenres (ArrayList) and
    // adding them to the toRemove list which is passed to removeAll
	@Override
	public void removeGenre(String genre) {
		// TODO Auto-generated method stub
		List<MovieInterface> toRemove = new ArrayList<MovieInterface>();
		for(int i = 0; i < this.possibleMovies.size();i++) {
			if(this.possibleMovies.get(i).getGenres().contains(genre) == true) {
				toRemove.add(this.possibleMovies.get(i));
			}
		}
		removeAll(toRemove);
		this.genre.remove(genre);
		System.out.println("The genre has been removed");
	}
	
	// Returns the genres set currently in a list of strings
	@Override
	public List<String> getGenres() {
		return this.genre;
	}
	
	// Returns the avg ratings set in the program in a list of strings

	@Override
	public List<String> getAvgRatings() {
		// TODO Auto-generated method stub
		return this.rating;
	}
	
	// Helper Function to remove all the desired Movie objects from each of the lists
	
	public void removeAll(List<MovieInterface> res) {
		for(MovieInterface dw : res) {
			if(this.possibleGenres.contains(dw)) {
				this.possibleGenres.remove(dw);
			}
			if(this.possibleRatings.contains(dw)) {
				this.possibleRatings.remove(dw);
			}
			if(this.possibleMovies.contains(dw)) {
				this.possibleMovies.remove(dw);
			} 
			if(this.validMovies.contains(dw)) {
				this.validMovies.remove(dw);
			}
		}
	}
	
	
	// Method to return the 3 movies starting from the index of 'Starting Index'
	// Will return the startingIndex and the following 2 movies after
	
	@Override
	public List<MovieInterface> getThreeMovies(int startingIndex) {
		this.outputList.clear();
		if(this.validMovies.size() > 0) {
			if((startingIndex  + 3) < this.validMovies.size()) {
				for(int i = startingIndex; i < startingIndex + 3;i++) {
					if(!((startingIndex + 3) > this.validMovies.size()) && checkGenre(this.validMovies.get(i)) == true) {
						this.outputList.add(this.validMovies.get(i));
					}
				}
			} else {
				for(int j = startingIndex; j < this.validMovies.size();j++) {
					if(checkGenre(this.possibleMovies.get(j)) == true) {
						this.outputList.add(this.validMovies.get(j));
					}
				}
			}
		} else if (this.rating.size() == 0 && this.genre.size() > 0){
			if((startingIndex  + 3) < this.possibleMovies.size()) {
				for(int i = startingIndex; i < startingIndex + 3;i++) {
					if(!((startingIndex + 3) > this.possibleMovies.size()) && checkGenre(this.possibleMovies.get(i)) == true) {
						this.outputList.add(this.possibleMovies.get(i));
					}
				}
			} else {
				for(int j = startingIndex; j  < this.possibleMovies.size();j++) {
					if(checkGenre(this.possibleMovies.get(j)) == true) {
						this.outputList.add(this.possibleMovies.get(j));
					}
				}
			}
		} else if(this.rating.size() > 0 && this.genre.size() > 0) {
			if((startingIndex  + 3) < this.possibleMovies.size()) {
				for(int i = startingIndex; i < startingIndex + 3;i++) {
					if(!((startingIndex + 3) > this.possibleMovies.size()) && checkGenre(this.possibleMovies.get(i)) == true 
							&& checkRange(this.possibleMovies.get(i)) == true) {
						this.outputList.add(this.possibleMovies.get(i));
					}
				}
			} else {
				for(int j = startingIndex; j < this.possibleMovies.size();j++) {
					if(checkGenre(this.possibleMovies.get(j)) == true && checkRange(this.possibleMovies.get(j)) == true) {
						this.outputList.add(this.possibleMovies.get(j));
					}
				}
			}
		}
		return this.outputList;
	}
	
	
	// Method to return all the Genres created by the set of Genres added in the system when importing
	// All the data from the data set
	
	@Override
	public List<String> getAllGenres() {
		List<String> ans = new ArrayList<String>();
    	for(Movie dw : this.dataSet) {
    		for(String g : dw.getGenres()) {
    			if(ans.contains(g) == false) {
    				ans.add(g);
    			}
    		}
    		
    	}
    	return ans;
	}
	
	public boolean checkRange(MovieInterface mv) {
		if(this.rating.size() > 0) {
			for(String rat : this.rating) {
				float tempRating = Float.parseFloat(rat);
				float upperLim = tempRating + (float) 1;
				if(mv.getAvgVote() >= tempRating && mv.getAvgVote() < upperLim) {
					return true;
				}
			}
		} 
		return false;
	}
	
	public boolean checkGenre(MovieInterface mv2Compare) {
		List<String> list2Compare = mv2Compare.getGenres();
		List<String> tempGenres = this.genre;
		Collections.sort(tempGenres);
		Collections.sort(list2Compare);
		if(list2Compare.containsAll(this.genre)) {
			return true;
		}
		return false;
	}
	
	// Method that returns the size of the movies that meet the criteria of genre and rating set
	@Override
	public int getNumberOfMovies() {
		// TODO Auto-generated method stub
		if(this.validMovies.size() > 0) {
			return this.validMovies.size();
		}
		return this.possibleMovies.size();
	}
    
	// Method called by the primary selectors (addGenre and addAvgRating)
	// Main use is for adding to the possibleMovie list, which is the ArrayList that contains all the movies
	// that meet the Rating and genere criteria
	public void addMovies(List<MovieInterface> validMV) {
		if(this.genre.size() > 0) {
			for(MovieInterface mv : validMV) {
				if(this.possibleMovies.contains(mv) == false) {
					this.possibleMovies.add(mv);
				}
			}
		} else{
			this.possibleMovies.clear();
		}
		
		Collections.sort(this.possibleMovies);
	}
}