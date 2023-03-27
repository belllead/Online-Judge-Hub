import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;
		
		minx = Math.min(minx, x);
		minx = Math.min(minx, w-x);
		miny = Math.min(miny, y);
		miny = Math.min(miny, h-y);
		int min = (minx < miny) ? minx : miny;
		
		System.out.println(min);
	}
}