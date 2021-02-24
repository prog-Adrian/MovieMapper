import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

public class MovieReaderTester {
  
  public static void main(String[] args) {
    MovieDataReader reader = new MovieDataReader();
    
    try {
      List<DummyMovie> movies = reader.readDataSet(new FileReader("C:\\Users\\ozapa\\Downloads\\movies.csv"));
      for(DummyMovie m : movies) {
        System.out.println(m);
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
