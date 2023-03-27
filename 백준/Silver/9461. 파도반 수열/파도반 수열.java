import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	static Map<Integer, Long> memo = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(findPadovan(N) + "\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}
	
	static long findPadovan(int N) {
		if (memo.get(N) != null)
			return memo.get(N);
		
		if (N <= 3) {
			memo.put(N, 1L);
			return memo.get(N);
		}
	
		if (N <= 5) {
			memo.put(N, 2L);
			return memo.get(N);
		}
		
		if (N == 6) {
			memo.put(N, 3L);
			return memo.get(N);
		}
		
		if (N == 7) {
			memo.put(N, 4L);
			return memo.get(N);
		}
				
		memo.put(N, findPadovan(N-1) + findPadovan(N-5));
		return memo.get(N);
	}
}