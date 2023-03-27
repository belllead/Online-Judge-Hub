import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, W, H, initialBrickCnt, maxBreak;
	static int[][] brickMap, brickMapTest;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			brickMap = new int[H][W];
			brickMapTest = new int[H][W];
			initialBrickCnt = 0;
			
			for (int r=0; r<H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<W; c++) {
					brickMap[r][c] = Integer.parseInt(st.nextToken());
					if (brickMap[r][c] != 0) 
						initialBrickCnt++;
				}
			}
			
			maxBreak = 0;
			
			sb.append("#" + tc + " ");
			
			maxBreak = breakBrickRoutine(brickMap, 1);
			
			sb.append(initialBrickCnt - maxBreak);
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int breakBrickRoutine(int[][] brickMap, int shotNum) {
		int[][][] columnTest = copyBrickMap(brickMap);
		int[] testResult = new int[W];
		int max = 0;
		
		for (int i=0; i<W; i++) {
			testResult[i] = breakTest(columnTest[i], i);
			organizeMap(columnTest[i]);
			max = Math.max(max, testResult[i]);
		}
		
		
		if (shotNum == N) {
			return max;
		} else {
			for (int i=0; i<W; i++) {
				testResult[i] += breakBrickRoutine(columnTest[i], shotNum+1);
				max = Math.max(max, testResult[i]);
			}
			return max;
		}
	}
	
	static int[][][] copyBrickMap(int[][] brickMap) {
		int[][][] copiedBrickMap = new int[W][H][W];
		
		for (int i=0; i<W; i++) {
			for (int j=0; j<H; j++) {
				copiedBrickMap[i][j] = Arrays.copyOf(brickMap[j], W);;
			}
		}
		
		return copiedBrickMap;
	}
	
	static int breakTest(int[][] brickMap, int col) {
		int brokenBrickCnt = 0;
		
		for (int r=0; r<H; r++) {
			if (brickMap[r][col] == 0) continue;
			else {
				brokenBrickCnt = breakBrick(brickMap, r, col, brickMap[r][col]);
				break;
			}					
		}
		
		return brokenBrickCnt;
	}
	
	static int breakBrick(int[][] brickMap, int row, int col, int brickInfluence) {
		// 깨뜨린 벽돌
		brickMap[row][col] = 0;
		int brokenBrickCnt = 1;
		
		int delta = brickInfluence-1;
		
		// 세로로 벽돌 영향만큼 벽돌깨기를 진행한다.
		for (int r=row-delta; r<=row+delta; r++) {
			if (r >= 0 && r < H && r != row) {
				if (brickMap[r][col] != 0) { 
					brokenBrickCnt += breakBrick(brickMap, r, col, brickMap[r][col]);
				}				
			}		
		}
		
		// 가로로 벽돌 영향만큼 벽돌깨기를 진행한다.
		for (int c=col-delta; c<=col+delta; c++) {
			if (c >= 0 && c < W && c != col) {
				if (brickMap[row][c] != 0) { 
					brokenBrickCnt += breakBrick(brickMap, row, c, brickMap[row][c]);
				}
			}
		}
		
		return brokenBrickCnt;
	}
	
	public static void organizeMap(int[][] brickMap) {
		// 각 열에 대해 제일 아래 행부터 올라오면서 0을 만날때마다 
		// 그 위의 0이 아닌 값과 자리를 바꾼다.
		for (int c=0; c<W; c++) {
			for (int r=H-1; r>=1; r--) {
				if (brickMap[r][c] == 0) {
					for (int rr=r-1; rr>=0; rr--) {
						if (brickMap[rr][c] != 0) {
							int temp = brickMap[r][c];
							brickMap[r][c] = brickMap[rr][c];
							brickMap[rr][c] = temp;
							break;
						}
					}
				}
			}
		}
	}
	
	
}