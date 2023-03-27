import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Stack<Character> s1 = new Stack<>();
	static Stack<Integer> s2 = new Stack<>();
	static char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		for (int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			String s = sc.next();
			
			char[] inArr = s.toCharArray();
			
			char[] sufArr = toSufOp(inArr);
			
			System.out.println("#" + tc + " " + calculate(sufArr));
		}
	}
	
	static int calculate(char[] sufArr) {
		s2.clear();
		
		for (char c : sufArr) {
			if (c != '\u0000') {
				if (checkInt(c))
					s2.push(c - '0');
				else {
					if (c == '*') {
						s2.push(s2.pop() * s2.pop());
					} else {
						s2.push(s2.pop() + s2.pop());
					}
				}
//				System.out.println(s2.toString());
			}
		}
		return s2.pop();
	}
	
	static char[] toSufOp(char[] inArr) {
		s1.clear();
		
		char[] sufArr = new char[inArr.length];
		
		int sufIdx = 0;
		
		for (char c : inArr) {
			if (checkInt(c))
				sufArr[sufIdx++] = c;	
			else {
				if (s1.isEmpty()) {
					s1.push(c);
				} else if (c == '+') {
					while (!s1.isEmpty() && s1.peek() != '(') {
						if (s1.peek() == '*' || s1.peek() == '+') {
							sufArr[sufIdx++] = s1.pop();
						}
					}
					s1.push(c);
					
					
				} else if (c == '*') {
					if (s1.peek() == '+' || s1.peek() == '(')
						s1.push(c);
					else {
						sufArr[sufIdx++] = s1.pop();
						s1.push(c);
					}
					
				} else if (c == '(') {
					s1.push(c);
					
				} else if (c == ')') {
					while (!s1.isEmpty() && s1.peek() != '(') {
						sufArr[sufIdx++] = s1.pop();
					}
					s1.pop();
				}
			}
//			System.out.println(inArr);
//			System.out.println(sufArr);
//			System.out.println(s1.toString());
		}
		if (!s1.isEmpty())
			sufArr[sufIdx] = s1.pop();		
		
		return sufArr;
	}
	
	static boolean checkInt(char c) {
		for (char n : num) {
			if (c == n)
				return true;
		}
		return false;
	}
}