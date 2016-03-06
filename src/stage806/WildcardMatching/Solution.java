package stage806.WildcardMatching;

public class Solution {
	public static void main(String args[]) {
		String s1 = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
		String s2 = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
		System.out.println(isMatch2(s1, s2));
	}

	public static boolean isMatch2(String str, String pattern) {
		int s = 0;
		int p = 0;
		int match = 0;
		int starIdx = -1;

		while (s < str.length()) {
			// ���ƥ����s++ p++
			if (p < pattern.length() && (pattern.charAt(p) == str.charAt(s))) {
				s++;
				p++;
			}
			// �����ǰƥ�䴮���ַ�Ϊ*�����¼id��������ƥ�䣨��*��0���ַ�����ƥ�俪ʼ��
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}

			// ���startIdx!=-1 ˵��ǰ�����Ǻ�,�ٶ�*��n+1���ַ�����ƥ��
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}

			// ���򣬲�ƥ��
			else
				return false;
		}

		while (p < pattern.length() && pattern.charAt(p) == '*') {
			p++;
		}
		return p == pattern.length();
	}

	public static boolean isMatch3(String str, String pattern) {
		int s = 0;
		int p = 0;
		int match = 0;
		int starIdx = -1;

		while (s < str.length()) {
			// advancing both pointers
			if (p < pattern.length()
					&& (pattern.charAt(p) == '?' || str.charAt(s) == pattern
							.charAt(p))) {
				s++;
				p++;
			}
			// * found, only advancing pattern pointer
			else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starIdx = p;
				match = s;
				p++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (starIdx != -1) {
				p = starIdx + 1;
				match++;
				s = match;
			}
			// current pattern pointer is not star, last patter pointer was not
			// *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

	/**
	 * @param s
	 *            : A string
	 * @param p
	 *            : A string includes "?" and "*"
	 * @return: A boolean
	 */
	public static boolean isMatch(String s, String p) {
		// write your code here
		// System.out.println(s+"|"+p);
		if (s.length() == 0 && p.length() == 0)
			return true;
		if (s.length() == 0 || p.length() == 0)
			return false;
		if (p.charAt(0) != '*') {
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
				return isMatch(s.substring(1), p.substring(1));
			} else
				return false;
		} else {

			for (int i = 0; i <= s.length(); i++) {
				if (isMatch(s.substring(i), p.substring(1)) == true) {
					return true;
				}
			}
			return false;
		}

	}

}
