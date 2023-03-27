import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ingri = new int[N];
		for (int i=0; i<N; i++) {
			ingri[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ingri);
		
		int startIdx = 0;
		int endIdx = N-1;
		int sum = 0;
		int cnt = 0;
		
		while (startIdx != endIdx) {
			sum = ingri[startIdx] + ingri[endIdx];
			
			if (sum == M) {
				cnt++;
				startIdx++;
			}
			
			if (sum < M) {
				startIdx++;
			}

			if (sum > M) {
				endIdx--;
			}
		}
		
		System.out.println(cnt);
	}
}