import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] ans = new String[T];
		
		for (int i=0; i<T; i++) {
			String date = sc.next();
			String year = date.substring(0, 4);
			String month = date.substring(4, 6);
			String day = date.substring(6, 8);
			int yearInt = Integer.parseInt(year);
			int monthInt = Integer.parseInt(month);
			int dayInt = Integer.parseInt(day);
			
			if (monthInt>0 && monthInt<13) {
				switch (monthInt) {
				case 1:
					if (dayInt>0 && dayInt<32) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 2:
					if (dayInt>0 && dayInt<29) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 3:
					if (dayInt>0 && dayInt<32) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 4:
					if (dayInt>0 && dayInt<31) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 5:
					if (dayInt>0 && dayInt<32) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 6:
					if (dayInt>0 && dayInt<31) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 7:
					if (dayInt>0 && dayInt<32) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 8:
					if (dayInt>0 && dayInt<32) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 9:
					if (dayInt>0 && dayInt<31) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 10:
					if (dayInt>0 && dayInt<32) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 11:
					if (dayInt>0 && dayInt<31) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				case 12:
					if (dayInt>0 && dayInt<32) 
						date = year + "/" + month + "/" + day;
					else date = "-1";
					break;
				} 
			} else date = "-1";
			
			ans[i] = date;
		}
		
		for (int i=0; i<T; i++)
			if (ans[i] == "-1")
				System.out.println("#" + (i+1) + " " + Integer.parseInt(ans[i]));
			else 
				System.out.println("#" + (i+1) + " " + ans[i]);
			
		
		
	}
	
}