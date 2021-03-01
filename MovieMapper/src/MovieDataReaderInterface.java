import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.zip.DataFormatException;

public interface MovieDataReaderInterface {
  
  public List<Movie> readDataSet(Reader inputFileReader)
    throws IOException, DataFormatException;

}
