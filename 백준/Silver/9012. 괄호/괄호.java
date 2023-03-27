import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] sArr = st.nextToken().split("");
			
			List<String> sList = new ArrayList<>();
			for (int s=0; s<sArr.length; s++) {
				sList.add(sArr[s]);
			}
			
			vps(sList);
			String ans = (sList.size() == 0) ? "YES" : "NO";
			System.out.println(ans);	
		}		
	}
	
	public static void vps(List<String> sList) {
		if (sList.get(0).equals("(")) {
			if (sList.contains(")")) {
				sList.remove(")");
				sList.remove(0);
				if (sList.size() != 0) {
					vps(sList);
				} else return;
			} else return;
		} else return;
	}
	
}