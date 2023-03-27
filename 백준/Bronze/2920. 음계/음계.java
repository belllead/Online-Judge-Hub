import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		for (int i=0; i<8; i++) {
			arr[i] = sc.nextInt();
		}
		
		int asCnt =0;
		int desCnt = 0;

		for (int i=0; i<7; i++) {
			if (arr[i] < arr[i+1]) {
				asCnt++;
			} else desCnt++;
		}
		
		if (asCnt == 7) {
			System.out.println("ascending");
		} else if (desCnt == 7) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	
		
		
	}
}