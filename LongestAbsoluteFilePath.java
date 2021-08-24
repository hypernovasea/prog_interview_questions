
import java.util.Stack;

/**
 *  Longest Absolute File Path
 *  https://leetcode.com/problems/longest-absolute-file-path/
 * 
 *  level: medium
 *  ans: 
 */
public class LongestAbsoluteFilePath {

	public static void main(String[] args) {

        String path1 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(path1));

		String path2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(lengthLongestPath(path2));
	}

	
	public static int lengthLongestPath(String input) {
		Stack<Integer> stack = new Stack<Integer>();
        stack.push(0); // "dummy" length
        int maxLen = 0;

        // break string by new line since that indicates a new file
        for (String file: input.split("\n")) {
        	
        	System.out.println(file);
            int level = file.lastIndexOf("\t")+1; // level == number of "\t"
            
            while (level+1 < stack.size()) 
            	stack.pop(); // find parent
            
            int len = stack.peek() + (file.length() - level + 1); // remove "/t", add"/"
            stack.push(len);
            
            // check if it is a file
            if (file.contains(".")) 
                maxLen = Math.max(maxLen, len-1); 
        }
        return maxLen;
	} 
}
