import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K, N;
	static long max = 0;
	static long[] LAN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		LAN = new long[K];
		
		long end = 0;

		for (int i=0; i<K; i++) {
			LAN[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, LAN[i]);
		}
		
		findLength(0, end);
		System.out.println(max);
		
		
	}
	
	static void findLength(long start, long end) {
		while (start <= end) {
			long cnt = 0;
			long mid = (start + end) / 2;

			for (int i=0; i<K; i++) {
				long t = LAN[i];

				if (t >= mid) {
					try {
						cnt += t/mid;
					} catch (Exception e) {
						cnt += t;
					}
				}
			}
			
			if (cnt >= N) {
				max = Math.max(max, mid);
				start = mid + 1;
			}
			else
				end = mid - 1;
		
		}
	}
}