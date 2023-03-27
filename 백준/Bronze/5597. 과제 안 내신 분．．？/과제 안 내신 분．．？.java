import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> stu = new ArrayList<>();
		
		for (int i=0; i<28; i++) {
			stu.add(sc.nextInt());
		}

		for (int i=1; i<=30; i++) {
			if (!stu.contains(i))
				System.out.println(i);
		}
		sc.close();
	}
}