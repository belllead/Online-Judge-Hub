import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sArr = new String[s.length()];
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int[] cnt = new int[26];
		
		
		for (int i=0; i<s.length(); i++) {
			sArr[i] = s.substring(i, i+1);
		}
		
		for (int j=0; j<26; j++) {
			for (int i=0; i<s.length(); i++) {				
				if (alphabet[j].equals(sArr[i])) {
					cnt[j] = i;
					break;
				} else cnt[j] = -1;
			}
		}
		
		for (int j=0; j<26; j++) {
			System.out.print(cnt[j] + " ");
		}
		
		
		
		
		
		
	}
}