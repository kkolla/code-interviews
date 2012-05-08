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
		int pos = 1;
		while (pos < path.length()) {
			char c = path.charAt(pos);
			// c could be letter, ., /
			if (c == '/') {
				while (pos < path.length() && path.charAt(pos) == c)
					pos++;
			} else if (c == '.') {
				if (pos + 1 < path.length() && path.charAt(pos + 1) == '.') {
					// ..
					if (!s.isEmpty())
						s.pop();
					pos += 2;
				} else {
					// .
					pos++;
				}
			} else {
				// letter
				int i = pos;
				while (i < path.length() && path.charAt(i) != '.'
						&& path.charAt(i) != '/')
					i++;
				String name = path.substring(pos, i);
				s.push(name);
				pos = i;
			}
		}
		if (s.size() == 0)
			return "/";
		String simplified = "";
		while (!s.isEmpty()) {
			String name = s.pop();
			simplified = "/" + name + simplified;
		}
		return simplified;
	}

	public static void main(String[] args) {
		String[] paths = { "/home/", "/home//", "/home///", "/a/./b/../../c/",
				"/a/./b/..//c/", "/../" };
		for (String path : paths)
			System.out.println(simplifyPath(path));
	}

}
