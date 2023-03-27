import java.util.Scanner;

public class Main {
	static int[][] theatre;
	static int C, R, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		K = sc.nextInt();
		
		theatre = new int[R][C];
		theatreNum(theatre, 0, R, 0, C, 1);
		findSeat();
		
		sc.close();
	}
	
	private static void findSeat() {
		boolean flag = true;
		int cCnt = 0;		
		int rCnt = 0;
		
		outer: for (int c=0; c<C; c++) {
			cCnt++;
			rCnt = 0;
			for (int r=R-1; r>=0; r--) {
				rCnt++;
				if (theatre[r][c] == K) {
					flag = true;
					break outer;
				} else 
					flag = false;
			}
		}
		
		if (flag)
			System.out.println(cCnt + " " + rCnt);
		else
			System.out.println(0);			
	}
	
	private static void theatreNum(int[][] theatre, int startRow, int endRow, int startCol, int endCol, int cnt) {
		for (int r=endRow-1; r>=startRow; r--) {
			theatre[r][startCol] = cnt++;
			if (cnt == K+1) return;
		}
		
		
		for (int c=startCol+1; c<endCol; c++) {
			theatre[startRow][c] = cnt++;
			if (cnt == K+1) return;
		}
		
		for (int r=startRow+1; r<endRow; r++) {
			theatre[r][endCol-1] = cnt++;
			if (cnt == K+1) return;
		}
		
		for (int c=endCol-2; c>startCol; c--) {
			theatre[endRow-1][c] = cnt++;
			if (cnt == K+1) return;
		}
		
		if (cnt <= C * R)
			theatreNum(theatre, startRow+1, endRow-1, startCol+1, endCol-1, cnt);
	}
	
}