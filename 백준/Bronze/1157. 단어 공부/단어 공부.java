import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sArr = new String[s.length()];
		String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int[] cnt = new int[26];

		for (int i=0; i<s.length(); i++) {
			sArr[i] = s.substring(i, i+1).toLowerCase();
			for (int j=0; j<26; j++) {
				if (sArr[i].equals(alphabets[j])) {
					cnt[j]++;
				}
			}
		}
		
		
		int max = -1;
		int maxIndex = -1;;
		
		for (int i=0; i<26; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
				maxIndex = i;
			}			
		}
		
		int overlap = 0;
		
		for (int i=0; i<26; i++) {
			if (cnt[maxIndex] == cnt[i]) overlap++;
			if (overlap == 2) {
				System.out.println("?");
				return;
			}
		}
		
		System.out.println(alphabets[maxIndex].toUpperCase());
		
		
	}
	
}