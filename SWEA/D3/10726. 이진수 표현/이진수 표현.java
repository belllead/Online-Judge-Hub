import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
//			System.out.println(Integer.toBinaryString(M));
//			System.out.println(Integer.toBinaryString((1 << (N))-1));
//			System.out.println();
			
			int check = (1 << N) - 1;
			if ((M & check) == check) sb.append("ON");
			else sb.append("OFF");
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}