import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

public class MovieDataReader implements MovieDataReaderInterface {

  @Override
  public List<DummyMovie> readDataSet(FileReader inputFileReader)
      throws FileNotFoundException, IOException, DataFormatException {
    List<DummyMovie> toReturn = new ArrayList<DummyMovie>();
    
    BufferedReader reader = new BufferedReader(inputFileReader);
    String headerLine = reader.readLine();
    String row;
    while((row = reader.readLine()) != null) {
      String[] data = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
      String genres = data[3].replaceAll("\"", "").replaceAll(" ", "");
      String directors = data[7].replaceAll("\"", "");
      
      //System.out.println("" + data[0] + " | " + data[2] + " | " + genres + " | " + data[7] + " | " + data[11].replaceAll("\"", "") + " | " + data[12]);
      
      toReturn.add(new DummyMovie(data[0], Integer.parseInt(data[2].trim()), Arrays.asList(genres.split(",")), directors, data[11].replaceAll("\"", ""), Float.parseFloat(data[12].trim())));
    }
    
    
    return toReturn;
  }
  
}
