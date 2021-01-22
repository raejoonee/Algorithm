import java.util.TreeMap;
import java.util.Scanner;

public class Main {
	static String answer = "";
	static int sellCount = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> tm = new TreeMap<>();
		int repeatTime = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < repeatTime; i++) {
			String bookTitle = sc.nextLine();
			if (tm.containsKey(bookTitle)) tm.put(bookTitle, tm.get(bookTitle) + 1);
			else tm.put(bookTitle, 1);
		}
    
		tm.forEach((key, value) -> {
			if (value > sellCount) {
				answer = key;
				sellCount = value;
			}
		});
		
		System.out.println(answer);
		
		sc.close();
	}
}
