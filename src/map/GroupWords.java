package map;
import java.util.*;

public class GroupWords {
    static void main() {
        ArrayList<String> words =
                new ArrayList<>(Arrays.asList("hi","book","java","sun","loop", "map"));
        HashMap<Integer, ArrayList<String>> wordsLengths = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            wordsLengths.putIfAbsent(length, new ArrayList<>());
            wordsLengths.get(length).add(word);
        }
        System.out.println(wordsLengths);
    }
}
