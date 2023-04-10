import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 입력값의 최대 크기(10000) 만큼의 배열을 선언
        int[] count = new int[10001];

        // 입력값들의 빈도수를 계산
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        // 빈도수를 누적합으로 변경 (거꾸로)
        for (int i = 10000 - 1; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // 출력
        for (int i = 0; i < 10000; i++) {
            while (count[i] > count[i + 1]) {
                bw.write(Integer.toString(i) + "\n");
                count[i]--;
            }
        }

        int last = count[10000];
        while (last -- > 0) {
        	bw.write(Integer.toString(10000) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}