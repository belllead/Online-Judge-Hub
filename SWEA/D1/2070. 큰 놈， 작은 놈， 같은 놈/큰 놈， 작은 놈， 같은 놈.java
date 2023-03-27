import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] ans = new String[T];
		
		for (int i=0; i<T; i++) {
			String op = "";
					
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if (num1 > num2)
				op = ">";
			else if (num1 < num2)
				op = "<";
			else op = "=";
						
			ans[i] = op;
		}
		
		for (int i=0; i<T; i++)
			System.out.println("#" + (i+1) + " " + ans[i]);
		
	}
	
}