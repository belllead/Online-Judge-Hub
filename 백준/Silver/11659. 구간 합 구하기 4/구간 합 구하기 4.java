import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] acc = new int[N];
		
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			int t = Integer.parseInt(st.nextToken());
			sum += t;
			acc[i] = sum;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1; 
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			int a = acc[end];
			int b = start == 0 ? 0 : acc[start-1];
					
			sb.append(a - b);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}