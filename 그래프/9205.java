import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n;
	static Point[] pointList;
	static boolean[] visited;
	static boolean bfs() {
		visited[0] = true;
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(pointList[0]);
		while (!queue.isEmpty()) {
			Point start = queue.poll();
			for (int i = 1; i <= n+1; i++) {
				Point end = pointList[i];
				if (!visited[i] && (Math.abs(start.x - end.x) + Math.abs(start.y - end.y) <= 1000)) {
					queue.add(end);
					visited[i] = true;
				}
			}
		}
		return visited[n+1];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			pointList = new Point[n+2];
			visited = new boolean[n+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			pointList[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int j = 1; j <= n; j++) {
				st = new StringTokenizer(br.readLine());
				pointList[j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			pointList[n+1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if (bfs()) sb.append("happy");
			else sb.append("sad");
			if (i != t-1) sb.append('\n');
		}
		System.out.print(sb.toString());
	}

}
