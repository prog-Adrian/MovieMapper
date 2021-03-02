import java.io.*;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.Arrays;
import java.util.ArrayList;
// --== CS400 File Header Information ==--
// Name: Kaushal Chandrasekar
// Email: kchandrasek4@wisc.edu
// Team: EB Blue (Purple Role)
// Role: Data Wrangler (Purple Role)
// TA: Yelun
// Lecturer: Purple Teammate, not sure
// Notes to Grader: Purple Teammate



public class MovieDataReader implements MovieDataReaderInterface {

  public List<MovieInterface> readDataSet(Reader inputFileReader)
      throws IOException, DataFormatException {
    // variable list: movielist - to be returned, line - used when splitting input to parameters for
    // Movie, genrelist - list of all genres of movie, values[] - each element contains a vertain
    // section of a given line (separated by commas)
    // continued: firstlineignore - to ensure the column headings aren't stored as a movie object,
    // [g1,desc,d] are temporary arrays that have the sole purpose of separating unneeded extra
    // punctuation like " or , from parameters before their input
    ArrayList<MovieInterface> movielist = new ArrayList<MovieInterface>();
    String line;
    BufferedReader br = new BufferedReader(inputFileReader);
    List<String> genrelist;
    int firstlineignore = 0;
    while ((line = br.readLine()) != null) {
      if (firstlineignore == 0) {
      } else {
        Object[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        String[] g1 = ((String) values[3]).split(", ");
        String[] desc = ((String) values[11]).split("\"");
        if (g1.length > 1) {
          g1[0] = charRemoveAt(g1[0], 0);
          g1[g1.length - 1] = charRemoveAt(g1[g1.length - 1], g1[g1.length - 1].length() - 1);
        }
        if (desc.length > 1) {
          values[11] = desc[1];

        }
        String[] d = ((String) values[7]).split("\"");
        if (d.length > 1) {
          values[7] = d[1];

        }
        genrelist = Arrays.asList(g1);

        Movie a = new Movie((String) values[0], Integer.valueOf((String) values[2]), genrelist,
            (String) values[7], (String) values[11], Float.parseFloat((String) values[12]));
        movielist.add(a);
      }
      firstlineignore = 1;

    }


    return movielist;
  }

  // lil subhelper method to help remove extra quotation marks for genres with multiple items in the
  // list
  public static String charRemoveAt(String str, int p) {
    return str.substring(0, p) + str.substring(p + 1);
  }
}

