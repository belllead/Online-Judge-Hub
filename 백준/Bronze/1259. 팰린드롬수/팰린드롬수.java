import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String s = sc.next();
			String[] sArr = new String[s.length()];
			for (int i=0; i<s.length(); i++) {
				sArr[i] = s.substring(i, i+1);
			}
			
			boolean isPalin = true;
			for (int i=0; i<=s.length()/2; i++) {
				if (!(sArr[i].equals(sArr[s.length()-i-1]))) isPalin = false;  
			}
			
			if (s.equals("0")) break;
			
			if (isPalin) {
				System.out.println("yes");
			} else 
				System.out.println("no");
			
			
		}
	}
}