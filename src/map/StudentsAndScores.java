package map;
import java.util.*;

public class StudentsAndScores {
    static void main() {

        // 1. Create & Put
        HashMap<String,Integer> score = new HashMap<>();
        score.put("Aida", 85);
        score.put("Azat", 92);
        score.put("Dana", 77);
        System.out.println(score);
        System.out.println(score.size());

        // 2. Get & ContainsKey
        score.get("Aida");
        score.get("Mira");
        if (score.containsKey("Mira"))
            System.out.println("Key is found");
        else
            System.out.println("Key is not found");

        // 3. Update Existing Value
        score.put("Dana", 80);
        System.out.println(score.get("Dana"));
        System.out.println(score);

        // 4. Remove by Key
        score.remove("Azat");
        System.out.println(score.remove("NonExisting"));

        // 5. isEmpty & Clear
        System.out.println(score.isEmpty());
        score.clear();
        System.out.println(score.isEmpty());
        score.put("Aida", 85);
        score.put("Azat", 92);
        score.put("Dana", 77);

        // 6. getOrDefault
        if (score.getOrDefault("Mira", -1)==-1)
            System.out.println("Not found");
        if (score.getOrDefault("Aida", -1)==-1)
            System.out.println("Not found");
        if (score.getOrDefault("Ms. Azhar", -1)==-1)
            System.out.println("Not found");

        // 7. putIfAbsent
        score.putIfAbsent("Aida", 90);
        score.putIfAbsent("Mira", 88);
        System.out.println(score);
        // Explanation:
        // putIfAbsent method puts a new entry only if an entry with the same key doesn't already exist, and it's value is not null

        // 8. replace
        System.out.println(score.replace("Aida", 85, 86));
        System.out.println(score.replace("Aida", 91));
        System.out.println(score.replace("Ms. Azhar", 65, 100));
        System.out.println(score.replace("Ms. Azhar", 100));
        System.out.println(score);

        // 9. Iterate over keys, values, entries
        for (String key : score.keySet()) {
            System.out.println(key);
        }
        for (Integer value : score.values()) {
            System.out.println(value);
        }
        for (Map.Entry<String,Integer> entry : score.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }

        // 10. Count how many have score >= 80
        int count = 0;
        for (Integer value : score.values()) {
            if (value >= 80)
                count++;
        }
        System.out.println(count);

        // 11. Find max score and who has it
        int maxValue = Integer.MIN_VALUE;
        String maxKey = "";
        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("max score is " + maxValue + " and " + maxKey + " has it");

    }
}
