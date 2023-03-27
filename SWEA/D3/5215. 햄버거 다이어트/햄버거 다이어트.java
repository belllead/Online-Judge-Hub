import java.util.Scanner;

public class Solution {
	
	static int N, L, maxScore;
	static int[] score, calorie;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			score = new int[N];
			calorie = new int[N];
			
			for (int i=0; i<N; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}
			
//			System.out.println(Arrays.toString(score));
//			System.out.println(Arrays.toString(calorie));
			
			maxScore = 0;
			
			makeBurger(0, 0, 0);
			
			sb.append("#" + tc + " ");
			sb.append(maxScore);
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	static void makeBurger(int idx, int accCalorie, int accScore) {
		if (accCalorie > L)
			return;
		
		maxScore = Math.max(maxScore, accScore);
//		System.out.println("idx: " + idx);
//		System.out.println("accScore: " + accScore);
//		System.out.println("accCalorie: " + accCalorie);
//		System.out.println();

		if (idx >= N)
			return;
		
		makeBurger(idx+1, accCalorie + calorie[idx], accScore + score[idx]);
		makeBurger(idx+1, accCalorie, accScore);
	}
}