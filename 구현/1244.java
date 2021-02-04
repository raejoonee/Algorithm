import java.io.*;

public class Main {
	static int switchCount;
	static String[] switchStatus;
	
	public static void switchClick(int index) {
		switchStatus[index] = switchStatus[index].equals("1") ? "0" : "1";
	}
	
	public static void maleStudent(int startIndex, int curIndex) {
		if (startIndex * curIndex > switchCount) return ;
		switchClick(startIndex * curIndex - 1);
		maleStudent(startIndex, curIndex + 1);
	}
	
	public static void femaleStudent(int startIndex, int curIndex) {
		int minus = startIndex - curIndex - 1;
		int plus = startIndex + curIndex - 1;
		if (minus < 0 || plus >= switchCount) return ;
		if (!switchStatus[minus].equals(switchStatus[plus])) return ;
		switchClick(minus);
		switchClick(plus);
		femaleStudent(startIndex, curIndex + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switchCount = Integer.parseInt(br.readLine());
		switchStatus = br.readLine().split(" ");
		int studentCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentCount; i++) {
			String[] studentInfo = br.readLine().split(" ");
			switch (studentInfo[0]) {
			case "1": // 남학생
				maleStudent(Integer.parseInt(studentInfo[1]), 1);
				break;
			case "2": // 여학생
				switchClick(Integer.parseInt(studentInfo[1]) - 1);
				femaleStudent(Integer.parseInt(studentInfo[1]), 1);
				break;
			}
		}
		for (int i = 0; i < switchCount; i++) {
			System.out.print(switchStatus[i] + " ");
			if ((i+1) % 20 == 0) System.out.println();
		}
	}
	
}
