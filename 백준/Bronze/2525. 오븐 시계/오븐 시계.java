import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int cook = sc.nextInt();
		
		int t = m + cook;
		while (t >= 60) {
			t -= 60;
			h = (h+1) % 24;
		} 
		
		m = t;
		
		System.out.println(h + " " + m);
		sc.close();
	}
}