import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] score = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		double max = 0;
		
		for (int i=0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, score[i]);
		}
		
		for (int i=0; i<N; i++) {
			score[i] = score[i] / max * 100;
		}
		
		double sum = 0;
		for (int i=0; i<N; i++) {
			sum += score[i];
		}
		
		double avg = sum / N;
		System.out.println(avg);
		
	}
	
}