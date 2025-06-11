import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tk = null;
	
	static class Meeting implements Comparable<Meeting> {
		int start, end, people;
		public Meeting(int start, int end, int people) {
			super();
			this.start = start;
			this.end = end;
			this.people = people;
		}
		@Override
		public int compareTo(Meeting o) {
			return Integer.compare(this.end, o.end);
		}
	}
	
	static int N;
	static Meeting[] meetings;
	
	// [종료시간 순 현재까지 고려한 회의의 index] => 종료시간 순 0~i번 중 진행한 회의들의 인원수 합
	static int[] memo;	
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(rd.readLine());
		meetings = new Meeting[N+1];
		memo = new int[N+1];
		
		meetings[0] = new Meeting(0, 0, 0);
		for (int i=1; i<=N; i++) {
			tk = new StringTokenizer(rd.readLine());
			int start = Integer.parseInt(tk.nextToken());
			int end = Integer.parseInt(tk.nextToken());
			int people = Integer.parseInt(tk.nextToken());
			meetings[i] = new Meeting(start, end, people);
		}

		// meetings들은 종료 시간 순으로 정렬 (이분탐색을 위해)
		Arrays.sort(meetings);

		memo[0] = 0;
		for (int i=1; i<=N; i++) {
			// 회의를 진행 시, 최적해는 회의가 시작되기 전까지 고를 수 있는 최적해에 회의의 인원수를 더한 값이다.
			// 회의를 진행하지 않을 시, 최적해는 이전 회의의 최적해와 같다.
			
			// 회의 시작 시간 전까지 진행할 수 있는 회의 중 가장 마지막 회의의 번호 idx를 찾자.
			// 인덱스 0을 가상의 (0, 0, 0) 회의로 하였으므로 idx >= 0임이 보장된다.
			// 예를 들어 종료 시간이 [50, 60, 100, 120, 140]이고 회의 i의 시작시간이 90이라 하면
			// 구하는 idx는 1이다. (meetings[1].end == 60)
			// 이분탐색 직접 구현
			int lo = 0;
			int hi = N;	// 정확히 회의 i 시작과 일치한 회의의 유무에 관계 없이, hi가 idx다.
			int mid;
			while (lo <= hi) {
				mid = (lo + hi) / 2;
				// 회의 i 시작 전까지 회의 마치기 불가능
				if (meetings[mid].end > meetings[i].start)
					hi = mid - 1;	// 범위를 낮은 쪽으로 좁힘
				else 
					lo = mid + 1;	// 범위를 높은 쪽으로 좁힘
			}
			memo[i] = Math.max(memo[hi] + meetings[i].people, memo[i-1]);
		}
		
		System.out.println(memo[N]);
	}
}