package map;
import java.util.*;

public class CharFreqCounter {
    static void main() {
        // 13
        String word = "Mississippi";
        char[] chars = word.toCharArray();
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for (char c : chars) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(freqMap);



    }
}
