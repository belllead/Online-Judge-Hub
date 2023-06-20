import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
//			System.out.println(N);
			// 0~9까지 체크할 수 있는 이진수 숫자
			// 10,000,000,000
			long check = (1 << 10);
			int add = N;
			
			// 0~9까지 체크되면 break
			while (true) {
				int digits = N;
				
				while (digits >= 1) {
//					System.out.println(digits);
					int digit = digits % 10;
					check = check | (1 << digit);
					digits /= 10;
				}
//				System.out.println("check: " + Long.toBinaryString(check));
				if ((((1 << 11) - 1) & check) == ((1 << 11) - 1)) {
					sb.append("#").append(tc).append(" ").append(N).append("\n");
					break;
				}
				
				N += add;
//				System.out.println(N);
			}
		}
		System.out.println(sb);
	}
	
}