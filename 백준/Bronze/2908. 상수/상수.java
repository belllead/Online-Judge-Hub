import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		
		StringBuilder sbA = new StringBuilder();
		StringBuilder sbB = new StringBuilder();
		
		for (int i=2; i>=0; i--) {
			sbA.append(A.substring(i, i+1));
			sbB.append(B.substring(i, i+1));
		}
		
		int a = Integer.parseInt(sbA.toString());
		int b = Integer.parseInt(sbB.toString());
		if (a > b) {
			System.out.println(a);
		} else
			System.out.println(b);
		
		
		sc.close();
		
		
	}
}