package map;
import java.util.*;

public class WordFreqCounter {
    static void main() {
        // 12
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String input = sc.nextLine();
        input = input.toLowerCase();
        String[] words = input.split(" ");
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
