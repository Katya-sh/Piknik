
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import java.util.HashMap;
import java.util.Map;

public class OperationFile {
    private String filename;

    public OperationFile(String filename) {
        this.filename = filename;
    }
    private String readFile()  {
        StringBuilder result = new StringBuilder();
        try(FileReader reader = new FileReader(this.filename))
        {
            int c;
            while((c=reader.read())!=-1){

                result.append((char) c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return result.toString();
    }
    public Collection<String> getWords()  {
        String text = readFile();
        text = text.trim();
        Collection<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));
        words.removeIf(String::isEmpty);
        return words;
    }
    public void Longest(Collection<String> words){
        String longest;
        if (!words.isEmpty()) {
            longest = words.iterator().next();
            for (String word : words) {
                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
            System.out.println("Наиболее длинное слово: " + longest);
        } 

    }
    public void Count(Collection<String> words){
        System.out.println("Количество слов в тексте " + words.size());

    }
    public void Freq(Collection<String> words){
         Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (String word : words) {
            dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

    }


}
