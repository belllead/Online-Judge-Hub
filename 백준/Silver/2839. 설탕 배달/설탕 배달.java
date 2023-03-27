import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		List<Integer> sugarBag = new ArrayList<>();
		
		if(N<=7) {
			switch(N) {
			case 1:
				ans = -1;
				break;
			case 2:
				ans = -1;
				break;
			case 3:
				ans = 1;
				break;
			case 4: 
				ans = -1;
				break;
			case 5:
				ans = 1;
				break;
			case 6:
				ans = 2;
				break;
			case 7:
				ans = -1;
			}
		} else {
			outer: for (int b=0; b<=N/3+1; b++) {
				for (int a=0; a<=N/5+1; a++) {
					if ((5*a + 3*b) == N) {
						ans = a+b;
						break outer;
					}
				}
			}
		}
		
	
		System.out.println(ans);
		sc.close();
	}
}