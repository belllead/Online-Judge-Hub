import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		String B = sc.next();
		int[] BArr = new int[3];
		
		for (int i=2; i>=0; i--) {
			BArr[i] = Integer.parseInt(B.substring(i, i+1));
			System.out.println(A * BArr[i]);
		}
		System.out.println(A*BArr[2] + A*BArr[1]*10 + A*BArr[0]*100);
		
	}
}