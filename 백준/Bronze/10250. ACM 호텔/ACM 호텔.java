import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
		
			String[][] hotel = new String[H][W];
			int cnt = 0;
			for (int c=0; c<W; c++) {
				for (int r=0; r<H; r++) {
					if (c<9)
						hotel[r][c] = Integer.toString(r+1) + "0" + Integer.toString(c+1);
					else 
						hotel[r][c] = Integer.toString(r+1) + Integer.toString(c+1);
					if (++cnt == N) 
						System.out.println(hotel[r][c]);
				}
			}
            
		}
		
		
	}
}