import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		int[] side = new int[6];
		int[] direction = new int[6];
		int idx = 0;
		
		int addSide1 = 0;
		int addSide2 = 0;
		int sub = 1;
		
		boolean[] bend = new boolean[6];
		
		for (int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			if (d == 1 || d == 2)
				addSide1 = Math.max(addSide1, l);
			else
				addSide2 = Math.max(addSide2, l);
			
			direction[idx] = d;
			side[idx] = l;
			idx++;
		}
		
		for (int i=0; i<6; i++) {
			if (direction[i % 6] == direction[(i+2) % 6]) {
				bend[(i+1) % 6] = true;				
			}
		}
		
		for (int i=0; i<6; i++) {
			if (bend[i]) {
				sub *= side[i];				
			}
		}
//		
//		System.out.println(Arrays.toString(bend));
//		System.out.println(Arrays.toString(side));
//		System.out.println(Arrays.toString(direction));
//		System.out.println(addSide1);
//		System.out.println(addSide2);
//		System.out.println(sub);
		
		int ans = K * (addSide1 * addSide2 - sub);
		System.out.println(ans);
	}
	
	
}