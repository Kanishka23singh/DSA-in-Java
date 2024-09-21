
class Solution {
    public int maxMeetings(int n, int[] start, int[] end) {
        // Create a 2D array to store start and end times
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Sort meetings based on their end times
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));

        int cnt = 0; // Count of maximum meetings
        int lastEndTime = 0; // End time of the last selected meeting

        for (int i = 0; i < n; i++) {
            // If the current meeting starts after the last selected meeting ends
            if (meetings[i][0] > lastEndTime) {
                cnt++; // Attend this meeting
                lastEndTime = meetings[i][1]; // Update the last end time
            }
        }

        return cnt; // Return the count of maximum meetings
    }
}
