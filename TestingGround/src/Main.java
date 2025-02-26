class Main {
    public static void main(String[] args) {
        Integer [] numbers = {1,2,3,4,5,6,7};

        System.out.println(binarySearch(numbers, 4));

    }
    public static <T extends Comparable<T>> int binarySearch(T [] arr, T target){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middlePosition = (low + high) / 2;
            T middleElement = arr[middlePosition];

            if (target.equals(middleElement)) {
                return middlePosition;
            }
            if (target.compareTo(middleElement) > 0) {
                low = middlePosition + 1;
            } else {
                high = middlePosition - 1;
            }
        }
        return -1;
    }
}
