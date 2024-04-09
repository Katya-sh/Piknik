
import java.util.Collection;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Collection<String> words;
        OperationFile repository = new OperationFile("input.txt");
            words = repository.getWords();
            repository.Count(words);
            repository.Freq(words);
            repository.Longest(words);
  
    }
}

