// https://www.codingninjas.com/studio/problems/occurrence-of-x-in-a-sorted-array_630456
public static int count(int arr[], int n, int x) {
        // Your code goes here
        int firstIndex = firstOccurrence(arr, n, x);
        int lastIndex = lastOccurrence(arr, n, x);

        if (firstIndex == -1 || lastIndex == -1)
            return 0;

        return lastIndex - firstIndex + 1;
}
