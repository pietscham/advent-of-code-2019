import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Day4 {

    public static void main(String[] args) {
        // brute force, you can compute all possible passwords
        // determine if it's a viable solution
        List<String> res = new LinkedList<>();
        List<Integer> resI = new LinkedList<>();
        //permute(new StringBuilder(), "171309643603", res, new HashSet<String>());
        rangePermute(171309, 643603, resI, new HashSet<>());
        System.out.println(resI.size());
    }

    public static void permute(StringBuilder sb, String valid, List<String> results, Set<String> found) {
        if(sb.length() > 6) {
            return;
        }
        else if(sb.length() == 6) {
            if(isValid(sb.toString()) && !found.contains(sb.toString())) {
                results.add(sb.toString());
                found.add(sb.toString());
            }
        }
        else {
            for(int i = 0; i < valid.length(); i++) {
                sb.append(valid.charAt(i));
                permute(sb, (valid.substring(0, i) + valid.substring(i + 1, valid.length())), results, found);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return;
    }

    public static void rangePermute(int min, int max, List<Integer> res, Set<Integer> found) {

        for(int i = min; i <= max; i++) {
            if(isValidInt(i) && !found.contains(i)) {
                res.add(i);
                found.add(i);
            }
        }
    }

    public static boolean isValidInt(int i) {
        boolean foundDouble = false, largerRepeat = false;
        StringBuilder run = new StringBuilder();
        int prev = 10;
        while(i != 0) {
            int digit = i%10;
            if(run.toString().length() > 0) {
                if(run.charAt(0) - '0' == digit) {
                    run.append(digit);
                } else {
                    if(run.length() == 2) foundDouble = true;
                    run.setLength(0);
                    run.append(digit);
                }
            } else {
                run.append(digit);
            }
            if(digit > prev) return false;
            prev = digit;
            i/=10;
        }
        return foundDouble || run.length() == 2;
    }

    public static boolean isValid(String s) {
        boolean foundDouble = false;
        int prev = -1;
        for(int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            if(curr < prev) return false;
            else if(curr == prev) foundDouble = true;
            prev = curr;
        }
        return foundDouble;
    }
}
