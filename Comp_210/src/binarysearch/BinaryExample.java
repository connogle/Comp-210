package binarysearch;

public class BinaryExample {

    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(intArr,0,intArr.length-1,13));
    }
    static boolean binarySearch(int[] arr, int low, int high, int x) {
        int mid = (low+ high) / 2;

        if (arr[mid] == x) {return true;}

        if (high >= low) {
            if (arr[mid] > x) {
                return binarySearch(arr, low, mid-1, x);
            } else {
                return binarySearch(arr, mid+1, high, x);
            }
        }
        return false;
    }
}
