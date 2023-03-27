import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static long[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		long tallest = 0;
		for (int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			tallest = Math.max(tallest, trees[i]);
		}
		System.out.println(binarySearch(0, tallest));
	}
	
	static long binarySearch(long start, long end) {
		long maxHeight = 0;
		
		while (start <= end) {
			long mid = (start + end) / 2;
			
			long lumber = 0;
			
			for (int i=0; i<N; i++) {
				lumber += trees[i] - mid > 0 ? trees[i] - mid : 0;
			}
			
			if (lumber >= M) {
				maxHeight = Math.max(maxHeight, mid);
				start = mid + 1;				
			} else {
				end = mid - 1;
			}
			
		}
		
		return maxHeight;
		
	}
}