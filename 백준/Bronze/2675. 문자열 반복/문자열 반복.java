import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			String[] sArr = new String[s.length()];
			for (int i=0; i<s.length(); i++) {
				sArr[i] = s.substring(i, i+1);
			}
			String[] resArr = new String[s.length()*R];
			for (int i=0; i<s.length(); i++) {
				for (int j=0; j<R; j++) {
					resArr[j+i*R] = sArr[i];
				}
			}
			
			StringBuilder sb2 = new StringBuilder();
			for (int i=0; i<resArr.length; i++) {
				sb2.append(resArr[i]);
			}
			sb.append(sb2).append("\n");
		
		}
		
		System.out.println(sb.toString());
	}
	
}