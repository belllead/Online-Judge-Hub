import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int dist = 0;
			int speed = 0;
			
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int gear = 0;
				
				gear = Integer.parseInt(st.nextToken());					
				
				if (gear == 1) {
					speed += Integer.parseInt(st.nextToken());
					dist += speed;
				} else if (gear == 0) {
					dist += speed;
				} else {
					speed -= Integer.parseInt(st.nextToken());
					if (speed < 0) speed = 0;
					dist += speed;
				}
				
			}
			
			System.out.println("#" + tc + " " + dist);
			
			
			
		}
		
		
	}
}

//입력 a b	시간	속력	거리
//1 2			1		2		2
//2 1			2		1		3
//
//1 1			1		1		1
//0			2		1		2	
//1 1			3		2		4
//
//if a == 1 속력+b 	거리 += 속력
//	a == 0 	속력 = 속력
//	a == 2 속력-b