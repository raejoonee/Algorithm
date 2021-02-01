import java.util.*;

class Pair implements Comparable<Pair> {
	int num;
	
	public Pair(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
	@Override
	public int compareTo(Pair o) {
		if (Math.abs(getNum()) == Math.abs(o.getNum())) return getNum() - o.getNum();
		return Math.abs(getNum()) - Math.abs(o.getNum());
	}

}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Vector<Integer> vector = new Vector<>();
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x == 0) {
				Pair pair = pq.poll();
				vector.add(pair == null ? 0 : pair.num);
			} else pq.add(new Pair(x));
		}
		
		while (!vector.isEmpty()) {
			System.out.println(vector.get(0));
			vector.remove(0);
		}
		
		sc.close();
		
	}
	
}
