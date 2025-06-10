import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class solution {
    static int argMinFirst(ArrayList<Integer> maximums){
        int best = maximums.get(0);
        int bestIndex = 0;
        for(int i = 0; i != maximums.size(); ++i){
            if(maximums.get(i) < best){
                best = maximums.get(i);
                bestIndex = i;
            }
        }
        return maximums.get(bestIndex);
    }


    static ArrayList<Integer> calculateMaximums(int sequence[], int k)
    {
        Deque<Integer>  dequeWindow = new LinkedList<>();
        ArrayList<Integer> maximums = new ArrayList<>();


        for(int i = 0; i < (k-1); ++i){
            maximums.add(Integer.MAX_VALUE);
        }
        for (int i = 0; i < k; ++i)
        {
            while ( (!dequeWindow.isEmpty()) &&                      
                    (sequence[i] >= sequence[dequeWindow.getLast()])  
                    ){
                dequeWindow.pollLast();
            }
            dequeWindow.addLast(i);
        }

        for (int i = k; i < sequence.length; ++i)
        {
            maximums.add(sequence[dequeWindow.peekFirst()]);

            while ( (!dequeWindow.isEmpty()) &&
                    (dequeWindow.peekFirst() <= i - k)){
                dequeWindow.pollFirst(); 
            }

            while ( (!dequeWindow.isEmpty()) && sequence[i] >= sequence[dequeWindow.getLast()])
                dequeWindow.pollLast();

            dequeWindow.addLast(i);
        }

        maximums.add(sequence[dequeWindow.peekFirst()]);
        return maximums;
    }

    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); int Q= in.nextInt(); in.nextLine();

        int[] sequence = new int[N];
        for(int i = 0; i != N; ++i){
            sequence[i] = in.nextInt();
        }
        in.nextLine();

        int[] queries = new int[Q];
        for(int i = 0; i != Q; ++i){
            queries[i] = in.nextInt();
        }

        for(int i = 0; i != queries.length; ++i){
            ArrayList<Integer> maximums = calculateMaximums(sequence, queries[i]);


            System.out.println((argMinFirst(maximums)));
        }

    }
}
