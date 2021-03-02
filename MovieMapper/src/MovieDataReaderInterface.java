import java.util.List;
import java.util.zip.DataFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
// --== CS400 File Header Information ==--
// Name: Kaushal Chandrasekar
// Email: kchandrasek4@wisc.edu
// Team: EB Blue (Purple Role)
// Role: Data Wrangler (Purple Role)
// TA: Yelun
// Lecturer: Purple Teammate, not sure
// Notes to Grader: Purple Teammate


public interface MovieDataReaderInterface {

  public List<MovieInterface> readDataSet(Reader inputFileReader)
      throws IOException, DataFormatException;

}
