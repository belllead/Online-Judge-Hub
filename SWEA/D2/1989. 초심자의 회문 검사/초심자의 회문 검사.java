import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder ans = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			String word = in.readLine();
			int rst = 0;
			
			for (int i=0; i<word.length()/2; i++) {
				if (word.substring(i, i+1).equals(word.substring(word.length()-i-1, word.length()-i))) {
					rst = 1;
				} else rst = 0;
			}
			
			ans.append("#" + tc + " ").append(rst).append("\n");
		}
		
		System.out.println(ans.toString());
		
	}
	
}