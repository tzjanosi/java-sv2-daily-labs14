package day04;

import java.util.Set;
import java.util.TreeSet;

public class PairFinder {
    public int findPairs(int[] arr){
        Set<Integer> tempSet=new TreeSet<>();
        int countOfPairs=0;
        for(int i:arr){
            if(!tempSet.contains(i)){
                tempSet.add(i);
            }
            else{
                tempSet.remove(i);
                countOfPairs++;
            }
        }
        return countOfPairs;
    }
}
