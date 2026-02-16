package map;
import java.util.*;

public class FirstChar {
    static void main() {
        String word = "swiss";
        char[] charArray = word.toCharArray();
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (char c : charArray) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        boolean charExists = false;
        char firstChar = ' ';
        for (char c : charArray) {
            if (charFreq.get(c) == 1) {
                charExists = true;
                firstChar = c;
                break;
            }
        }
        if (charExists)
            System.out.println("The first character with count 1: " + firstChar);
        else
            System.out.println("None");

    }
}
