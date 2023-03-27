import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] pile = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<100; i++) {
				pile[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(pile);
//			System.out.println(Arrays.toString(pile));
					
			for (int i=0; i<N; i++) {
				pile[99]--;
				pile[0]++;
				Arrays.sort(pile);
			}
			
//			System.out.println(Arrays.toString(pile));
			System.out.println("#" + tc + " " + (pile[99]-pile[0]));
		}
	}

}