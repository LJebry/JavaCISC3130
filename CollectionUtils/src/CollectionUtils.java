import javax.print.attribute.standard.PrintQuality;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CollectionUtils {



    public static double average(Collection<Integer> col){
        int add = 0;
        int result = 0;

        for(Integer num : col){
            add = add + num; //access each element at num
        }
        result = add / col.size();
        return result;
    }

    public static int maxLength(Collection<String> col){
        int maxLength = 0;

        for(String words : col){
            if (words.length() > maxLength){
                maxLength = words.length();
            }
        }
        return maxLength;
    }

    public static boolean containsDuplicate(Collection<Integer> col){
        Set<Integer> seen = new HashSet<>();

        for(Integer nums : col){
           if (!seen.add(nums)){
               return true;
           }
        }
        return false;
    }
}
