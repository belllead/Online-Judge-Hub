import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			char[] pwPool = br.readLine().toCharArray();

			int pwLength = N / 4;
			String[] possiblePW = new String[N];

			int idx = 0;

			for (int k = 0; k < pwLength; k++) {
				for (int i = 0; i < N; i += pwLength) {
					String t = "";
					for (int j = i-k; j < i-k + pwLength; j++) {
						int temp = j;
						j = j < 0 ? j+N : j;
						t += pwPool[j % N];
						j = temp;
					}
					
					possiblePW[idx++] = t;
				}

			}
			
			List<Integer> tenArr = new ArrayList<>();
			for (int i=0; i<N; i++) {
				int t = sixteenToTen(possiblePW[i]);
				if (!tenArr.contains(t))
					tenArr.add(t);
			}
			
			Collections.sort(tenArr);
			
			sb.append("#" + tc + " ");
			sb.append(tenArr.get(tenArr.size()-K));
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int sixteenToTen(String s) {
		String[] sArr = s.split("");
		
		int sum = 0;
		
		for (int i=sArr.length-1, pow=0; i>=0; i--, pow++) {
			int t = 0;
			try {
				t = Integer.parseInt(sArr[i]);
			} catch (Exception e) {
				switch (sArr[i]) {
				case "A":
					t = 10;
					break;
				case "B":
					t = 11;
					break;
				case "C":
					t = 12;
					break;
				case "D":
					t = 13;
					break;
				case "E":
					t = 14;
					break;
				case "F":
					t = 15;
					break;
				}
			}
			
			sum += t * Math.pow(16, pow);
		}
		
		return sum;
	}
}