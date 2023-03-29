import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[][] room, sCoord;
	static List<int[]> pCoord, pCoord1, pCoord2;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			pCoord = new ArrayList<>();
			sCoord = new int[2][3];
			
			int idx = 0;
			
			for (int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int c=0; c<N; c++) {
					room[r][c] = Integer.parseInt(st.nextToken());
					if (room[r][c] == 1) pCoord.add(new int[] {r, c});
					if (room[r][c] > 1) sCoord[idx++] = new int[] {r, c, room[r][c]};
				}
			}
			
//			for (int[] p : pCoord)
//				System.out.println(Arrays.toString(p));
//			for (int[] s : sCoord)
//				System.out.println(Arrays.toString(s));
			// 입력 완료
			
			int min = Integer.MAX_VALUE;
			
			for (int i=0; i<(1<<pCoord.size()); i++) {
				pCoord1 = new ArrayList<>();
				pCoord2 = new ArrayList<>();

				for (int j=0; j<pCoord.size(); j++) {
					if ((i & (1<<j)) != 0) {
						pCoord1.add(pCoord.get(j));
					} else pCoord2.add(pCoord.get(j));
				}
				
//				System.out.println();
//				for (int[] p1: pCoord1)
//					System.out.print(Arrays.toString(p1));
//				System.out.println();
//				for (int[] p2: pCoord2)
//					System.out.print(Arrays.toString(p2));
//				System.out.println();
//				System.out.println(Arrays.toString(sCoord[0]));
//				System.out.println(Arrays.toString(sCoord[1]));
				
				// 사람을 두 그룹으로 나눔
				// 여기서 각각 계단으로 보내주어 계산하면 됨
				// pCoord1 => sCoord[0]
				// pCoord2 => sCoord[1]
				// 두 부분집합은 대칭관계에 있기 때문에 
				// 계단을 바꿔서 배정해주지 않아도 모든 경우를 볼 수 있음
				
				// 계단과의 거리 리스트
				List<Integer> dist1 = new ArrayList<>();
				List<Integer> dist2 = new ArrayList<>();
				
				if (pCoord1.size() != 0) {
					for (int j=0; j<pCoord1.size(); j++) {
						dist1.add(getDist(pCoord1.get(j), sCoord[0]));
					}
				}
				
				if (pCoord2.size() != 0) {
					for (int j=0; j<pCoord2.size(); j++) {
						dist2.add(getDist(pCoord2.get(j), sCoord[1]));
					}
				}
				
//				System.out.println();
//				System.out.println(dist1);
//				System.out.println(dist2);
//				
//				System.out.println();
//				int t1 = getSecond(dist1, sCoord[0]);
//				int t2 = getSecond(dist2, sCoord[1]);
//				System.out.println(t1);
//				System.out.println(t2);
//				System.out.println();
//				int max = Math.max(t1, t2);
//				System.out.println(max);
//				min = Math.min(min, max);
//				System.out.println(Math.max(getSecond(dist1, sCoord[0]), getSecond(dist2, sCoord[1])));
				min = Math.min(min, (Math.max(getSecond(dist1, sCoord[0]), getSecond(dist2, sCoord[1]))));
				
//				System.out.println();System.out.println();
			}
			
			sb.append("#" + tc + " ");
			sb.append(min);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int getDist(int[] pCoord, int[] sCoord) {
		return Math.abs(pCoord[0] - sCoord[0]) + Math.abs(pCoord[1] - sCoord[1]);
	}
	
	static int getSecond(List<Integer> dist, int[] sCoord) {
		List<Integer> stairCnt = new ArrayList<>();
		int second = 0;
		
		while (dist.size() != 0 || stairCnt.size() != 0) {

			second++;
			
			for (int j=dist.size()-1; j>=0; j--) {
				// 계단을 향해 모두 한 칸 전진
				dist.set(j, dist.get(j)-1);
				
				// 계단에 다다르면
				if (dist.get(j) == 0) {
					stairCnt.add(sCoord[2]+1);
					dist.remove(j);
				}
			}
			
			// 계단 위에 있는 3명까지만 내려가고
			// 다 내려가면 치워버림
			for (int j=0; j<3; j++) {
				if (stairCnt.size() > j) {
					stairCnt.set(j, stairCnt.get(j)-1);
					
					if (stairCnt.get(j) == 0) {
						stairCnt.remove(j);
						j--;						
					}
				}
			}
//			System.out.println(stairCnt);
		}
		
		return second + 1;
	}
}