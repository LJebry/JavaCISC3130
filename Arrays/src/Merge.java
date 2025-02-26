public class Merge {
    public static void main(String[] args) {

        int [] arr1 = {1, 5 ,7}; // length 3
        int [] arr2 = {-1,0,1,2,3,6}; // length 6

    }

    public static int [] merge(int [] arr1, int [] arr2){
        int s1 = arr1.length;
        int s2 = arr2.length;

        int [] result = new int[s1 + s2];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < s1 && j < s2){
            if (arr1[i] < arr2[j]){
                result[k] = arr1[i];
                k++;
                i++;
            } else {
                result[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < s1){
            result[k++] = arr1[i++];
        }
        while (j < s2){
            result[k++] = arr2[j++];
        }
        return result;

    }

}