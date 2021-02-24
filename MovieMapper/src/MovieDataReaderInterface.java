import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

public interface MovieDataReaderInterface {
  
  public List<DummyMovie> readDataSet(FileReader inputFileReader)
    throws FileNotFoundException, IOException, DataFormatException;

}
