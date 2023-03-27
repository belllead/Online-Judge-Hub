import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());			
			List<String> text = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String ci = st.nextToken();
				int ki = Integer.parseInt(st.nextToken());
				for(int j=0; j<ki; j++) {
					text.add(ci);
				}
			}
			
			System.out.println("#" + tc);
			
			int line = 1;
			while(text.size() != 0) {
				System.out.print(text.get(0));
				text.remove(0);
				if(line == 10) {
					System.out.println();
					line = 1;
				} else line++;	
			}
			
			System.out.println();
			
			
		}
	}
}