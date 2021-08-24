import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {

	public static void main(String[] args) {
		String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println( lengthLongestPath(s) );
	}

	
	
	public static int lengthLongestPath(String input){
		Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
        	
        	System.out.println(s);
        	
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            
            while( lev+1 < stack.size() ) 
            	stack.pop(); // find parent
            
            int len = stack.peek() + s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1); 
        }
        return maxLen;
	} 
}
