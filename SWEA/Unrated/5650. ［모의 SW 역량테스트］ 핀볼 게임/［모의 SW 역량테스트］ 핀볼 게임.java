import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int score, currentR, currentC, N;
	static int[] currentDirection;
	static int[][] ballDirection = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] board, wormHole;
	static List<int[]> possibleStartPosition;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			board = new int[N+2][N+2];
			possibleStartPosition = new ArrayList<>();
			wormHole = new int[10][2];
			
			int ans = 0;
						
			for (int r=1; r<N+1; r++) {
				for (int c=1; c<N+1; c++) {
					board[r][c] = sc.nextInt();
					
					switch (board[r][c]) {
					case 0:
						// 가능한 시작 위치 체크
						int[] temp = {r, c};
						possibleStartPosition.add(temp);
						break;
					case 6: // 웜홀 입력
						if (wormHole[0][0] == 0)
							wormHole[0] = new int[] {r, c};
						else 
							wormHole[1] = new int[] {r, c};
						break;
					case 7:
						if (wormHole[2][0] == 0)
							wormHole[2] = new int[] {r, c};
						else 
							wormHole[3] = new int[] {r, c};
						break;
					case 8:
						if (wormHole[4][0] == 0)
							wormHole[4] = new int[] {r, c};
						else 
							wormHole[5] = new int[] {r, c};
						break;
					case 9:
						if (wormHole[6][0] == 0)
							wormHole[6] = new int[] {r, c};
						else 
							wormHole[7] = new int[] {r, c};
						break;
					case 10:
						if (wormHole[8][0] == 0)
							wormHole[8] = new int[] {r, c};
						else 
							wormHole[9] = new int[] {r, c};
					}	
				}	
			}
			
			
			
			for (int i=0; i<possibleStartPosition.size(); i++) {
				int tempMax = playPinBall(possibleStartPosition.get(i)[0], possibleStartPosition.get(i)[1]);
				ans = Math.max(ans, tempMax);
			}
			
			sb.append("#" + tc + " " + ans + "\n");
			
		}
		System.out.println(sb.toString());
		sc.close();
	}

	private static int playPinBall(int startR, int startC) {
		int max = 0;
				
		for (int startDirection=0; startDirection<4; startDirection++) {
			currentR = startR;
			currentC = startC;
			
			score = 0;
			
			currentDirection = ballDirection[startDirection];
			
			while (board[currentR][currentC] != -1) {
				currentR += currentDirection[0];
				currentC += currentDirection[1];
				switch (board[currentR][currentC]) {
				case 1:
					block(1);
					break;
				case 2:
					block(2);
					break;
				case 3:
					block(3);
					break;
				case 4:
					block(4);
					break;
				case 5:
					block(5);
					break;
				case 6:
					wormhole(6);
					break;
				case 7:
					wormhole(7);
					break;
				case 8:
					wormhole(8);
					break;
				case 9:
					wormhole(9);
					break;
				case 10:
					wormhole(10);
					break;
				}
				
				if (currentC == 0)
					wall("left wall");
				else if (currentC == N+1)
					wall("right wall");
				else if (currentR == 0)
					wall("top wall");
				else if (currentR == N+1)
					wall("bottom wall");
				
				if (currentR == startR && currentC == startC)
					 break;
			}
			
			// 각 방향으로 시작한 핀볼 경우의 수 중 가장 큰 점수를 저장한다.
			max = Math.max(max, score);
		}
		
		return max;
	}

	private static void block(int i) {
		switch (i) {
		case 1:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[1];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[0];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[2];
			score++;
			break;
		case 2:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[0];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[1];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[2];
			score++;
			break;
		case 3:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[2];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[0];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[1];
			score++;
			break;
		case 4:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[1];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[2];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[0];
			score++;
			break;
		case 5:
			if (currentDirection == ballDirection[0]) 
				currentDirection = ballDirection[1];
			else if (currentDirection == ballDirection[1]) 
				currentDirection = ballDirection[0];
			else if (currentDirection == ballDirection[2]) 
				currentDirection = ballDirection[3];
			else if (currentDirection == ballDirection[3]) 
				currentDirection = ballDirection[2];
			score++;
			break;
		}
	}
	
	private static void wall(String s) {
		switch (s) {
		case "left wall":
			currentDirection = ballDirection[3];
			score++;
			break;
		case "right wall":
			currentDirection = ballDirection[2];
			score++;
			break;
		case "top wall":
			currentDirection = ballDirection[1];
			score++;
			break;
		case "bottom wall":
			currentDirection = ballDirection[0];
			score++;
			break;
		}
		
	}
	
	private static void wormhole(int i) {
		switch (i) {
		case 6:
			 if (currentR == wormHole[0][0] && currentC == wormHole[0][1]) {
				 currentR = wormHole[1][0];
				 currentC = wormHole[1][1];
			 } else if (currentR == wormHole[1][0] && currentC == wormHole[1][1]) {
				 currentR = wormHole[0][0];
				 currentC = wormHole[0][1];
			 }
			 break;
		case 7:
			 if (currentR == wormHole[2][0] && currentC == wormHole[2][1]) {
				 currentR = wormHole[3][0];
				 currentC = wormHole[3][1];
			 } else if (currentR == wormHole[3][0] && currentC == wormHole[3][1]) {
				 currentR = wormHole[2][0];
				 currentC = wormHole[2][1];
			 }
			 break;
		case 8:
			 if (currentR == wormHole[4][0] && currentC == wormHole[4][1]) {
				 currentR = wormHole[5][0];
				 currentC = wormHole[5][1];
			 } else if (currentR == wormHole[5][0] && currentC == wormHole[5][1]) {
				 currentR = wormHole[4][0];
				 currentC = wormHole[4][1];
			 }
			 break;
		case 9:
			 if (currentR == wormHole[6][0] && currentC == wormHole[6][1]) {
				 currentR = wormHole[7][0];
				 currentC = wormHole[7][1];
			 } else if (currentR == wormHole[7][0] && currentC == wormHole[7][1]) {
				 currentR = wormHole[6][0];
				 currentC = wormHole[6][1];
			 }
			 break;
		case 10:
			 if (currentR == wormHole[8][0] && currentC == wormHole[8][1]) {
				 currentR = wormHole[9][0];
				 currentC = wormHole[9][1];
			 } else if (currentR == wormHole[9][0] && currentC == wormHole[9][1]) {
				 currentR = wormHole[8][0];
				 currentC = wormHole[8][1];
			 }
			 break;
		}		
	}
	
	
}