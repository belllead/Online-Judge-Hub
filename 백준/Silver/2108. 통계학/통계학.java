import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];

		double sum = 0;
		int mean = 0;
		int median = 0;
		int mode = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] cnt = new int[8002];
		
		for (int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
			
			if (num[i] < 0) {
				cnt[Math.abs(num[i])+4000]++;
			} else
				cnt[num[i]]++;
		}
		
		mean = (int) Math.round(sum / N);
		
		Arrays.sort(num);
		median = num[N/2];
		
		int modeNum = 0;
		for (int i=0; i<8002; i++) {
			modeNum = Math.max(modeNum, cnt[i]);
		}
		
		List<Integer> modeCandidate = new ArrayList<>();
		
		for (int i=0; i<8002; i++) {
			if (cnt[i] == modeNum) {
				if (i > 4000)
					modeCandidate.add(-(i-4000));
				else 
					modeCandidate.add(i);
			}
		}
		
		Collections.sort(modeCandidate);
		
		if (modeCandidate.size() > 1)
			mode = modeCandidate.get(1);
		else
			mode = modeCandidate.get(0);
	
		System.out.println(mean);
		System.out.println(median);
		System.out.println(mode);
		System.out.println(max - min);
	}
}