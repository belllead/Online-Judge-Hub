import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] quo = new int[T];
		int[] rem = new int[T];
		
		for (int i=0; i<T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			quo[i] = a / b;
			rem[i] = a % b;
		}
		
		
		for (int i=0; i<T; i++) {
			System.out.println("#" + (i+1) + " " + quo[i] + " " + rem[i]);
		}
		
		
		
		
	}
	
}