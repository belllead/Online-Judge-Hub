import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			String[][] arr = new String[5][15];
			for (int i=0; i<5; i++) {
				String str = br.readLine();
				int idx = 0;
				for (String s : str.split("")) {
					arr[i][idx++] = s; 
				}
				
			}
            
			sb.append("#" + tc + " ");
			
			for (int c=0; c<15; c++) {
				for (int r=0; r<5; r++) {
					if (arr[r][c] == null)
						sb.append("");
					else
						sb.append(arr[r][c]);
				}
			}
			
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}