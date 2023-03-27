import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> cards = new HashMap<>();

        for (int i=0; i<N; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (cards.containsKey(t)) {
                cards.replace(t, cards.get(t) + 1);
            }
            else {
                cards.put(t, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int t2 = Integer.parseInt(st.nextToken());
            sb.append(cards.getOrDefault(t2, 0)).append(" ");
        }

        System.out.println(sb);
    }
}