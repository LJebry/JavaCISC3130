public class Main {
    public static void main(String[] args) {

        int [] arr = {6, 10 ,2, 5, 0};
        int size = 5;

        System.out.println(average(arr, size));
    }

    public static double average(int [] arr, int size){

        double result = 0;
        int add = 0;

        for(int i = 0; i < size; i++) {
            add = add + arr[i];
            result = (double) add / size;
        }
        return result;
    }
}