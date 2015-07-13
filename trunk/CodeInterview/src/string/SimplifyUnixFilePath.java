package string;

import java.util.Stack;

/*
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class SimplifyUnixFilePath {

	public static String simplifyPath(String path) {
		assert (path.charAt(0) == '/');
		Stack<String> s = new Stack<String>();
        
        int i = 0;
        while (i < path.length()) {
            // find start of the word
            while (i < path.length() && path.charAt(i) == '/') i++;
            if (i == path.length()) break;

            // find end of the word
            int start = i;
            while (i < path.length() && path.charAt(i) != '/') i++;
            
            String name = path.substring(start, i);
            if (name.equals("..")) {
                if (!s.isEmpty()) s.pop();
            } else if (!name.equals(".")) {
                s.push(name);    
            }
        }
        
        if (s.isEmpty()) return "/";
        else {
            StringBuilder sb = new StringBuilder("");
            while (!s.isEmpty()) {
                String name = s.pop();
                sb.insert(0, "/" + name);
            }
            return sb.toString();
        }
	}

	public static void main(String[] args) {
		String[] paths = { "/home/", "/home//", "/home///", "/a/./b/../../c/",
				"/a/./b/..//c/", "/../" };
		for (String path : paths)
			System.out.println(simplifyPath(path));
	}

}
