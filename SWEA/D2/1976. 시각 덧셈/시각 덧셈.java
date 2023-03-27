import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			
			int finalH = h1 + h2;
			int finalM = m1 + m2;
			if (finalM >= 60) {
				finalM -= 60;
				finalH++;
			}
			if (finalH > 12) finalH -= 12;
		
			System.out.println("#" + tc + " " + finalH + " " + finalM);
		}
		
	}
}