package com.henry.interview;

import java.util.*;

public class JobSchedule {

	private static int inf = 10000000;

	public static void main(String[] args) {
		JobSchedule soln  = new JobSchedule();
		System.out.println(soln.minDifficulty(new int[] {11,111,22,222,33,333,44,444}, 6));
	}

	public int minDifficulty(int[] jobDifficulty, int d) {
		if (d > jobDifficulty.length) {
			return -1;
		}
		int dp[][] = new int[jobDifficulty.length][d + 1];
		for (int row[] : dp) {
			Arrays.fill(row, -1);
		}
		return helper(jobDifficulty, d, 0, dp);
	}

	private int helper(int job[], int d, int i, int dp[][]) {
		if (i == job.length && d == 0) {
			return 0;
		}
		if (i == job.length || d == 0) {
			return inf;
		}
		if (dp[i][d] != -1) {
			return dp[i][d];
		}
		int curr_max = job[i];
		int res = inf;
		for (int j = i; j < job.length; j++) {
			curr_max = Math.max(curr_max, job[j]);
			int smallAns = helper(job, d - 1, j + 1, dp);
			res = Math.min(res, curr_max + smallAns);
		}
		return dp[i][d] = res;
	}
}
