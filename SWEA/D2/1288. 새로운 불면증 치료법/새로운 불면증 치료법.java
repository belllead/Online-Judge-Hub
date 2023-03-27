import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			List<String> nums = new ArrayList<>();
			
			for(int i=0; i<=9; i++) {
				nums.add(Integer.toString(i));
			}
			
			while (nums.size() != 0) {
				ans += N;
				for(int i=nums.size()-1; i>=0; i--) {
					if (Integer.toString(ans).contains(nums.get(i))) {
						nums.remove(i);
					}
				}
			
			}	
			System.out.println("#" + tc + " " + ans);
		}
		
		
		
	}
}