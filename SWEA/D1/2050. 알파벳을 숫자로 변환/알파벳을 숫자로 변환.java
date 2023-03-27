import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		for (int i=0; i<input.length(); i++) {
			String sub = input.substring(i, i+1);
			for (int j=0; j<26; j++) {
				if (alphabets[j].equals(sub)) {
					System.out.print(j+1 + " ");
				}
			}	
		}
		
		
		
	}
	
}