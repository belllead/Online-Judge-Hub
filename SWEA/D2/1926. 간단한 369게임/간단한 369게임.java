import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		
		for (int i=1; i<=N; i++) {
			String str = Integer.toString(i); 
			if (str.contains("3") || str.contains("6") || str.contains("9")) {
				for (int strLeng=0; strLeng<str.length(); strLeng++) {
					String a = str.substring(strLeng, strLeng+1);
					if (a.contains("3")) cnt++;
					if (a.contains("6")) cnt++;
					if (a.contains("9")) cnt++;
				}
				for (int dash=0; dash<cnt; dash++) {
					sb.append("-");
				}
				sb.append(" ");
				cnt = 0;
			} else {
				sb.append(str + " ");
			}
				
		}
		
		System.out.println(sb.toString());
		
	}
	
}