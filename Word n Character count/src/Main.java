
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author tmtmt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//   This is a sample string with several words. This is a sample.
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();

        Map<String, Integer> wordCountMap = countWords(inputString);
        Map<Character, Integer> charCountMap = countCharacters(inputString);

        System.out.println(formatWordCounts(wordCountMap));
        System.out.println(formatCharacterCounts(charCountMap));

    }

    public static Map<String, Integer> countWords(String inputString) {
        String[] words = inputString.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            if (wordCountMap.containsKey(word)) {
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;
    }

    public static String formatWordCounts(Map<String, Integer> wordCountMap) {
        StringBuilder result = new StringBuilder("{");

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            result.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
        }

        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }

        result.append("}");

        return result.toString();
    }

    public static Map<Character, Integer> countCharacters(String inputString) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        char[] characters = inputString.toCharArray();

        for (char c : characters) {
            if (Character.isLetter(c)) {
                if (charCountMap.containsKey(c)) {
                    int count = charCountMap.get(c);
                    charCountMap.put(c, count + 1);
                } else {
                    charCountMap.put(c, 1);
                }
            }
        }

        return charCountMap;
    }

    public static String formatCharacterCounts(Map<Character, Integer> charCountMap) {
        StringBuilder result = new StringBuilder("{");

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            result.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
        }

        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }

        result.append("}");

        return result.toString();
    }
}
