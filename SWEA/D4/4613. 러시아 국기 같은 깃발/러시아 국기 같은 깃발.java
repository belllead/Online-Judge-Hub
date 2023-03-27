import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[][] flag;
	static int N, M, startIdx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			flag = new char[N][M];
			for (int i=0; i<N; i++) {
				flag[i] = br.readLine().toCharArray();
			}
			
//			for (int i=0; i<N; i++) {
//				for (int j=0; j<M; j++) {
//					System.out.print(flag[i][j]);
//				}
//				System.out.println();
//			}
			
			// 각 줄 별 최소 칠한 횟수
			
			int temp = 0;
			int firstLine = 0;
			int lastLine = 0;
			
			// 첫 줄 W 처리
			for (int i=0; i<M; i++) {
				if (flag[0][i] == 'W')
					temp++;
			}
			firstLine = M - temp;
			temp = 0;

			// 마지막 줄 R 처리
			for (int i=0; i<M; i++) {
				if (flag[N-1][i] == 'R')
					temp++;
			}
			lastLine = M - temp;
			temp = 0;
			
			// 중간 줄 처리
			int middleLine = M*N;
			
			for (int i=1; i<N-1; i++) {
				startIdx = i;
				middleLine = Math.min(middleLine, colorLine(i, 'B'));
			}
			
			int totalPaint = firstLine + lastLine + middleLine;
			
			sb.append("#" + tc + " " + totalPaint + "\n");
		}
		System.out.println(sb);
	}
	
	
	
	static int colorLine(int lineIdx, char currentColor) {
		int rst = 0;
		
		// 기저조건
		if (lineIdx == 0 || lineIdx == N-1)
			return 0;
		
		// 유도 파트
		// 첫번째 반드시 실행
		// 시작한 줄을 파란색으로 칠하기
		else if (lineIdx == startIdx) {
			int temp = 0;
			for (int m=0; m<M; m++) {
				if (flag[lineIdx][m] == 'B')
					temp++;
			}
			temp = M - temp;
			
			// 이전 줄을 하얀색 또는 파란색으로 칠하기
			temp += colorLine(lineIdx-1, 'B');
			
			// 다음 줄을 파란색 또는 빨간색으로 칠하기
			temp += colorLine(lineIdx+1, 'B');
			
			rst = temp;
		}
		
		// 앞선 실행보다 위로 왔을 때
		else if (lineIdx < startIdx) {
			// 앞선 색이 B일 때
			if (currentColor == 'B') {
				// B를 칠하고 위로 보내보기
				int temp1 = 0;
				for (int m=0; m<M; m++) {
					if (flag[lineIdx][m] == 'B')
						temp1++;
				}
				temp1 = M - temp1;
				temp1 += colorLine(lineIdx-1, 'B');
				
				// W를 칠하고 위로 보내보기
				int temp2 = 0;
				for (int m=0; m<M; m++) {
					if (flag[lineIdx][m] == 'W')
						temp2++;
				}
				temp2 = M - temp2;
				temp2 += colorLine(lineIdx-1, 'W');
				
				rst = (temp1 < temp2)? temp1 : temp2;
			}
			
			// 앞선 색이 W일 때
			else if (currentColor == 'W') {
				// W를 칠하고 위로 보내기
				int temp = 0;
				for (int m=0; m<M; m++) {
					if (flag[lineIdx][m] == 'W')
						temp++;
				}
				temp = M - temp;
				temp += colorLine(lineIdx-1, 'W');
				
			rst = temp;
			}			
		}
		
		// 앞선 실행보다 아래로 왔을 때
		else if (lineIdx > startIdx) {
			// 앞선 색이 B일 때
			if (currentColor == 'B') {
				// B를 칠하고 아래로 보내보기
				int temp1 = 0;
				for (int m=0; m<M; m++) {
					if (flag[lineIdx][m] == 'B')
						temp1++;
				}
				temp1 = M - temp1;
				temp1 += colorLine(lineIdx+1, 'B');
				
				// R을 칠하고 아래로 보내보기
				int temp2 = 0;
				for (int m=0; m<M; m++) {
					if (flag[lineIdx][m] == 'R')
						temp2++;
				}
				temp2 = M - temp2;
				temp2 += colorLine(lineIdx+1, 'R');
				
				rst = (temp1 < temp2)? temp1 : temp2;
			}
			
			// 앞선 색이 R일 때
			else if (currentColor == 'R') {
				// W를 칠하고 위로 보내기
				int temp = 0;
				for (int m=0; m<M; m++) {
					if (flag[lineIdx][m] == 'R')
						temp++;
				}
				temp = M - temp;
				temp += colorLine(lineIdx+1, 'R');
				
				rst = temp;
			}			
		}
		return rst;
	}
	
}