import java.util.NoSuchElementException;
// --== CS400 File Header Information ==--
// Name: Eric Chang
// Email: echang39@wisc.edu
// Team: EB Red
// Role: Integration Manager
// TA: Yelun
// Lecturer: Gary Dahl
// Notes to Grader: N/A

public interface MapADT<KeyType, ValueType> {
  public boolean put(KeyType key, ValueType value);

  public ValueType get(KeyType key) throws NoSuchElementException;

  public int size();

  public boolean containsKey(KeyType key);

  public ValueType remove(KeyType key);

  public void clear();

}
