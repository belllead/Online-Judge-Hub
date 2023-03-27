import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 1. 입력 받기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		// 2. (입력받은 숫자의 개수만큼) 출력하기
		for(int i = 0; i < num; i++) {
			System.out.print("#");
		}
	}
}
