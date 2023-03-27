import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Stack<Character> s1 = new Stack<>();
	static Stack<Integer> s2 = new Stack<>();
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		for (int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			String s = sc.next();
			
			char[] inArr = s.toCharArray();
//			System.out.println(inArr);
			
			char[] sufArr = toSufOp(inArr);
//			System.out.println(sufArr);
			
			System.out.println("#" + tc + " " + calculate(sufArr));
		}
	}
	
	static int calculate(char[] sufArr) {
		for (char c : sufArr) {
			try {
				int t = Integer.parseInt(String.valueOf(c));
				s2.add(t);
			} catch (Exception e) {
				s2.push(s2.pop() + s2.pop());
			}
		}
		return s2.pop();
	}
	
	static char[] toSufOp(char[] inArr) {
		char[] sufArr = new char[inArr.length];
		
		int sufIdx = -1;
		
		for (char c : inArr) {
			try {
				int t = Integer.parseInt(String.valueOf(c));
				sufArr[sufIdx++] = (char) (t + '0');	
			} catch (Exception e) {
				if (s1.isEmpty())
					s1.push(c);
				else {
					sufArr[sufIdx++] = s1.pop();
					s1.push(c);
				}
			}
		}
		sufArr[sufIdx] = s1.pop();		
		
		return sufArr;
	}
}