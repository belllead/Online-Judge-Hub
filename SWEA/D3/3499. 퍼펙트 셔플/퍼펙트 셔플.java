import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] deck = br.readLine().split(" ");
			
			Queue<String> d1 = new LinkedList<>();
			Queue<String> d2 = new LinkedList<>();
			
			
			if (N % 2 == 0) {
				for (int i=0; i<N/2; i++)
					d1.offer(deck[i]);

				for (int i=N/2; i<N; i++)
					d2.offer(deck[i]);				
			} else {
				for (int i=0; i<N/2+1; i++)
					d1.offer(deck[i]);

				for (int i=N/2+1; i<N; i++)
					d2.offer(deck[i]);	
			}
			
//			System.out.println(d1.toString());
//			System.out.println(d2.toString());
			
			String[] suffledDeck = new String[N];
			for (int i=0; i<N; i+=2) {
//				0 2 4 
//				0 2 
//				0 2 4
				if (!d1.isEmpty())
					suffledDeck[i] = d1.poll();
				if (!d2.isEmpty())
					suffledDeck[i+1] = d2.poll();
			}
			
//			String s = Arrays.toString(suffledDeck).replace('[', '\u0000').replace(']', '\u0000').replace(',', '\u0000');
			
			sb.append("#" + tc + " ");
			
			for (int i=0; i<N; i++) {
				sb.append(suffledDeck[i] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}