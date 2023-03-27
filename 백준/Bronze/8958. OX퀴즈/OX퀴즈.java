import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=0; tc<T; tc++) {
			String s = br.readLine();
			
			String[] sArr = new String[s.length()];
			for (int i=0; i<s.length(); i++) {
				sArr[i] = s.substring(i, i+1);
			}
						
			int serialScore = 0;
			int totalScore = 0;
			for (int i=0; i<s.length(); i++) {
				if (sArr[i].equals("O")) {
					serialScore++;
				} else {
					serialScore = 0;
				}
				totalScore += serialScore;
			}
			
			sb.append(totalScore).append("\n");
		}
		System.out.println(sb.toString());
	}
}