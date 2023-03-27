import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	static Set<Integer> primeNum = new TreeSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
				
		primeNum.add(2);
		for (int i=3; i<=1000; i++) {
			primeListMaker(i);
		}
		
		int cnt = 0;
		
		for (int i=0; i<N; i++) {
			num[i] = sc.nextInt();
			if (primeNum.contains(num[i])) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		sc.close();
		
	}
	
	public static void primeListMaker(int a) {
		for (int i : primeNum) {
			if (a % i == 0) return;
		}
		primeNum.add(a);
	}
}