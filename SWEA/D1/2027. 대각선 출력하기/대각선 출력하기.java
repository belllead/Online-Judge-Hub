public class Solution {

	public static void main(String[] args) {
		
		String[][] arr = new String[5][5];
		
		for (int r=0; r<5; r++) {
			for (int c=0; c<5; c++) {
				if (r == c) arr[r][c] = "#";
				else arr[r][c] = "+";
			}
		}
		
		for (int r=0; r<5; r++) {
			for (int c=0; c<5; c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		
	}
	
}