import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static String isValid(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int freq : frequencyMap.values()) {
            frequencyCount.put(freq, frequencyCount.getOrDefault(freq, 0) + 1);
        }
        
        if (frequencyCount.size() == 1) {
            return "YES";
        } else if (frequencyCount.size() == 2) {
            Iterator<Integer> iterator = frequencyCount.keySet().iterator();
            int firstFreq = iterator.next();
            int secondFreq = iterator.next();
            
            if ((firstFreq == 1 && frequencyCount.get(firstFreq) == 1) || 
                (secondFreq == 1 && frequencyCount.get(secondFreq) == 1)) {
                return "YES";
            } else if ((Math.abs(firstFreq - secondFreq) == 1) && 
                      (frequencyCount.get(Math.max(firstFreq, secondFreq)) == 1)) {
                return "YES";
            }
        }
        
        return "NO";
    }
}

public class Solution16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}