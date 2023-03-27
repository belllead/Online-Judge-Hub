import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			String s = br.readLine();

			char[] arr = new char[s.length()];
			
			int cnt = 0;
			int sum = 0;
			int idx = 0;
			for (int i=0; i<s.length(); i++) {
				char temp = s.charAt(i);
				if (temp == '(') {
					arr[idx++] = temp;
					cnt++;
					sum++;
				} else {
					if (arr[idx-1] == '(') {
						cnt--;
						sum--;
						sum += cnt;
						arr[idx++] = temp;
					} else {
						cnt--;
					}
				}
				
			}
			System.out.println("#" + tc + " " + sum);
		}
		br.close();
	}
}