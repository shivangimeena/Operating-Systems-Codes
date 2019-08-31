
public class FCFS {

	public static void findWaitingTime(int[] processes, int n, int wt[], int[] tat, int[] bt) {
//		int[] rem_bt = new int[n];
//		for (int i = 0; i < n; i++) {
//			rem_bt[i] = bt[i];
//		}
//		int time = 0;
//		while (true) {
//			boolean done = true;
//			for (int i = 0; i < n; i++) {
//				if (rem_bt[i] != 0) {
//					done = false;
//					time += rem_bt[i];
//					rem_bt[i] = 0;
//					wt[i] = time - bt[i];
//				}
//			}
//			if (done == false) {
//				break;
//			}
//		}
		wt[0] = 0;
		for(int i=1; i<n; i++) {
			wt[i] = bt[i-1]+wt[i-1];
		}

	}

	public static void findTAT(int[] processes, int n, int[] wt, int[] tat, int[] bt) {
		for (int i = 0; i < n; i++) {
			tat[i] = wt[i] + bt[i];
		}
	}

	public static void findAvgTime(int[] processes, int n, int[] bt) {
		int wt[] = new int[n], tat[] = new int[n];
		int total_wt = 0, total_tat = 0;
		findWaitingTime(processes, n, wt, tat, bt);
		findTAT(processes, n, wt, tat, bt);
		System.out.printf("Processes Burst time Waiting" + " time Turn around time\n");

		// Calculate total waiting time and total turn
		// around time
		for (int i = 0; i < n; i++) {
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.printf(" %d ", (i + 1));
			System.out.printf("     %d ", bt[i]);
			System.out.printf("     %d", wt[i]);
			System.out.printf("     %d\n", tat[i]);
		}
		float s = (float) total_wt / (float) n;
		int t = total_tat / n;
		System.out.printf("Average waiting time = %f", s);
		System.out.printf("\n");
		System.out.printf("Average turn around time = %d ", t);

	}

	public static void main(String[] args) {
		int processes[] = {1, 2, 3}; 
        int n = processes.length; 
  
        //Burst time of all processes  
        int burst_time[] = {10, 5, 8}; 
  
        findAvgTime(processes, n, burst_time); 
	}

}
