import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, startR, startC, startD, cnt = 0, curR, curC, curD;
	static int[][] room;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		startD = Integer.parseInt(st.nextToken());
		
		curR = startR;
		curC = startC;
		curD = startD;
		
		room = new int[N][M];
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				room[r][c] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		clean(curR, curC);
		
//		for (int[] i : room)
//			System.out.println(Arrays.toString(i));
		
		System.out.println(cnt);
		
	}
	
	
	static void clean(int r, int c) {
//		System.out.println("R: " +curR);
//		System.out.println("C: " +curC);
//		System.out.println("D: " +curD);
//		System.out.println();
		if (room[r][c] == 0) {
			// 청소한 곳은 2로 표시
			room[r][c] = 2;
			cnt++;
		}
		
		// 주변에 청소할 곳이 없으면 후진 실행
		if (checkDust(r, c)) {
			// 후진한다면
			if (moveBackward(curD)) {
				// 다시 청소 시작
				clean(curR, curC);
			} else return; // 후진 못 하면 종료
		} 
		
		// 주변에 청소할 곳이 있으면
		else {
			while (true) {
				// 반시계 회전
				curD = (curD - 1) >= 0 ? curD - 1 : curD + 3;
				// 전진 시도
				if (moveForward(curD)) {
					clean(curR, curC);
					break;
				} 
			}
			
				
		}
	}


	// 주변에 청소할 곳이 없으면 true 반환
	static boolean checkDust(int r, int c) {
		boolean flag = true;
		
		for (int i=0; i<4; i++) {
			int tr = r + dr[i];
			int tc = c + dc[i];
			
			if (tr >= 0 && tr < N && tc >= 0 && tc <M && room[tr][tc] == 0)
				flag = false;
		}
		
		return flag;
	}
	
	// 후진하면 true 반환
	static boolean moveBackward(int d) {
		boolean flag = true;
		
		switch (d) {
		case 0:
			if (room[curR + 1][curC] != 1)
				curR++;
			else
				flag = false;
			break;
		case 1:
			if (room[curR][curC - 1] != 1)
				curC--;
			else
				flag = false;
			break;
		case 2:
			if (room[curR - 1][curC] != 1)
				curR--;
			else
				flag = false;
			break;
		case 3:
			if (room[curR][curC + 1] != 1)
				curC++;
			else
				flag = false;
			break;
		}
		
		return flag;
	}
	
	// 전진하면 true 반환
	static boolean moveForward(int d) {
		boolean flag = true;
		
		switch (d) {
		case 0:
			if (room[curR - 1][curC] == 0)
				curR--;
			else
				flag = false;
			break;
		case 1:
			if (room[curR][curC + 1] == 0)
				curC++;
			else
				flag = false;
			break;
		case 2:
			if (room[curR + 1][curC] == 0)
				curR++;
			else
				flag = false;
			break;
		case 3:
			if (room[curR][curC - 1] == 0)
				curC--;
			else
				flag = false;
			break;
		}
		
		return flag;
	}
	
	
}