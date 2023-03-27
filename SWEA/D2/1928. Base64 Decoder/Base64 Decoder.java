import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			String s = sc.next();
			byte[] b = s.getBytes();
			
			Decoder d = Base64.getDecoder();
			
			byte[] decoded = d.decode(b);
			
			
			System.out.println("#" + tc + " " + new String(decoded));
			
		}
		
		sc.close();
	}
}