import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode.com/problems/all-paths-from-source-to-target/
 *  
 *  level: medium
 *  ans: Use backtracking.
 */
public class AllPathsSourceTarget {

    public static void main(String[] args) {
        int[][] graph1 = {
            {1, 2},
            {3},
            {3},
            {}
        }; // [[1,2],[3],[3],[]];

        List<List<Integer>> paths = allPathsSourceTarget(graph1);
        
        // print paths
        for (int i = 0; i < paths.size(); i++) {
            System.out.printf("index %d: ", i);
            for (int j = 0; j < paths.get(i).size(); j++) {
                System.out.printf("%d  ", paths.get(i).get(j));
            }
            System.out.println("");
        }
    }


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        allPathsSourceTarget(graph, 0, paths, path);
        return paths;
    }


    public static void allPathsSourceTarget(int[][] graph, int currNode, 
                                            List<List<Integer>> paths, List<Integer> currPath) {
        // check if current path is a solution
        // path is a solution if the current node == graph.length - 1
        //      meaning we've gotten to the end
        if (currNode == graph.length - 1) {
            paths.add(new ArrayList<Integer>(currPath));
            return;
        }

        // if no more paths can be explored (end of graph.length)
        //  return list of paths

        // continue to find more paths if currNode
        //  doesnt lead to complete path
        // from the edges for current node
        for (int nextNode : graph[currNode]) {
            // // apply one edge at a time
            // int nextNode = graph[currNode].get(i);

            // add node to current path
            currPath.add(nextNode);

            // recurse on function with next node
            allPathsSourceTarget(graph, nextNode, paths, currPath);

            // remove edge
            currPath.remove(currPath.size() - 1);
        }

    }
}