import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			String caseText = in.readLine();
			int ans = 0;
			
			for (int i=1; i<=10; i++) {
				String madi1 = caseText.substring(0, i);
				boolean repeat = true;
				for (int j=0; j<30/i; j++) {
					String madi2 = caseText.substring(i*j, i*(j+1)); 
					if (!(madi1.equals(madi2))) {
						repeat = false;
						ans = i+1;
						break;
					}
				}
				if (repeat) break;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");	
		}
		
		System.out.println(sb.toString());
		
	}
	
}