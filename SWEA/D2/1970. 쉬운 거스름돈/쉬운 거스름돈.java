import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] change = new int[8];
			
			while (N>=50000) {
				N -= 50000;
				change[0]++;
			}
	
			while (N>=10000) {
				N -= 10000;
				change[1]++;
			}
			
			while (N>=5000) {
				N -= 5000;
				change[2]++;
			}
			
			while (N>=1000) {
				N -= 1000;
				change[3]++;
			}
			
			while (N>=500) {
				N -= 500;
				change[4]++;
			}
			
			while (N>=100) {
				N -= 100;
				change[5]++;
			}
			
			while (N>=50) {
				N -= 50;
				change[6]++;
			}
			
			while (N>=10) {
				N -= 10;
				change[7]++;
			}
			
			System.out.print("#" + tc + "\n");
			for (int i=0; i<8; i++) {
				System.out.print(change[i] + " ");
			}
			System.out.println();
		}
	}
}