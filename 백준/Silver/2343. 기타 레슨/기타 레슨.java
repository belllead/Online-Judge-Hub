import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] lecture;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lecture = new int[N];
		
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			start = Math.max(start, lecture[i]);
			end += lecture[i];
		}
		
		System.out.println(binarySearch(start, end));
	}
	
	static int binarySearch(int start, int end) {
		while (start <= end) {
			int cnt = 0;
			int bluray = (start + end) / 2;
			int sum = 0;
			
			for (int i=0; i<N; i++) {
				sum += lecture[i];
				
				if (sum > bluray) {
					cnt++;
					sum = lecture[i];
				} else if (sum == bluray) {
					cnt++;
					sum = 0;
				}
			}
			
			if (sum > 0)
				cnt++;
			
			if (cnt > M)
				start = bluray + 1;
			else
				end = bluray - 1;
		}
				
		return start;
	}
}