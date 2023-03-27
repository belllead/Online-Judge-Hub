import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] score = new int[N];
			
			double sum = 0;
			
			for (int i=0; i<N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}
			
			double avg = sum / N;
			
			int cnt = 0;
			
			for (int i=0; i<N; i++) {
				if (score[i] > avg)
					cnt++;
			}
			
			double ans = (double) cnt / N * 100;
			String s = String.format("%.3f", ans);
			sb.append(s + "%\n");
		}
		
		System.out.println(sb);
	}
}