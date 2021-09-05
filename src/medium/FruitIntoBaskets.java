package src.medium;

import java.util.HashMap;

/**
 *  Fruit Into Baskets
 *  https://leetcode.com/problems/fruit-into-baskets/
 * 
 *  level: medium
 *  ans: sliding window (see educative for an explanation)
 *  note: this is very smiliar to the Longest Substring with At Most K Distinct 
 *          Characters question only k=2.
 */
public class FruitIntoBaskets {

    public static void main(String[] args) {

        int[] t1 = {1,2,1};
        System.out.printf("max number of fruits: %d\n", totalFruit(t1));
        System.out.printf("max number of fruits: %d\n", maxFruit(t1));

        int[] t2 = {1, 2, 3, 2, 2, 3};
        System.out.printf("max number of fruits: %d\n", totalFruit(t2));
        System.out.printf("max number of fruits: %d\n", maxFruit(t2));

    }


    public static int totalFruit(int[] tree) {
        
        if (tree == null || tree.length == 0)
            return 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int start = 0;

        for (int end=0; end<tree.length; end++) {
            // add fruit to map if it doesn't exist or increase 
            //  frequency if it does
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);

            // check map size
            // decrease window size until map size goes back to 2
            while (map.size() > 2) {
                // decrease the frequency of fruit at tree[start]
                map.put(tree[start], map.get(tree[start])-1);

                // if fruit at tree[start] hit 0, remove it from map
                if (map.get(tree[start]) == 0) {
                    map.remove(tree[start]);
                }
                start++;
            }

            // determine max length
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }


    public static int maxFruit(int[] tree) {
        if (tree == null || tree.length == 0)
            return 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = 1; 
        int i = 0;  // index of first type of fruit seen
        int j = 0;  // tree iterator
        
        // iterate thru 'trees', increasing window size when encountering a 
        //  tree we've already seen
        while (j<tree.length) {
            
            // only have seen 2 types of fruit
            if (map.size() <= 2) { 
                map.put(tree[j], j++);  // fruit type, last index seen
            }
            
            if (map.size() > 2) { // now seeing more than 2 types of fruit
                // find min index 
                // start at last because starting at 0 will quarantee that 
                //  min < whatever index is in the map
                int min = tree.length - 1;
                for (int value : map.values()) { // iterate thru fruit types
                    min = Math.min(min, value); // set min = the smallest index
                }
                i = min + 1;
                map.remove(tree[min]);
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
    
}
