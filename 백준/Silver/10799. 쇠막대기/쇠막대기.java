import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		char[] arr = new char[s.length()];
		
		int cnt = 0;
		int sum = 0;
		int idx = 0;
		for (int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			if (temp == '(') {
				arr[idx++] = temp;
				cnt++;
				sum++;
			} else {
				if (arr[idx-1] == '(') {
					cnt--;
					sum--;
					sum += cnt;
					arr[idx++] = temp;
				} else {
					cnt--;
				}
			}
		}
		System.out.println(sum);
	}
}