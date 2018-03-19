package com.mahesh.abstraction;

import java.util.HashMap;
import java.util.Map;

public class ElectoralVotingBallot {
	public static void findWinner(String votes[])
    {
        // Insert all votes in a hashmap
        Map<String,Integer> map =
                    new HashMap<String, Integer>();
        for (String str : votes)
        {
            if (map.keySet().contains(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
 
        // Traverse through map to find the candidate
        // with maximum votes.
        int maxValueInMap = 0;
        String winner = "";
        for (Map.Entry<String,Integer> entry : map.entrySet())
        {
            String key  = entry.getKey();
            Integer val = entry.getValue();
            if (val > maxValueInMap)
            {
                maxValueInMap = val;
                winner = key;
            }
 
            // If there is a tie, pick lexicographically
            // smaller. 
            else if (val == maxValueInMap &&
                winner.compareTo(key) < 0)
                winner = key;
        }
        System.out.println("Winning Candidate is :" +
                                              winner);
    }
 
    // Driver code
    public static void main(String[] args)
    {
       String[] votes = { "john", "jzzzcy", "jackie",
                         "jzzzcy", "john", "jackie",
                         "jamie", "jamie", "john",
                         "jzzzcy", "jamie", "jzzzcy",
                         "john" };
 
       findWinner(votes);
    }
}
