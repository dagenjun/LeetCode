package hss.basic;

import java.util.ArrayList;

/**
 * int 123
 *
 */
public class baidu {
    public static void main(String[] args) {
        System.out.println(reverseInt(156));
    }

    private static int reverseInt(int n){
        int target=0;

        ArrayList<Integer> res = new ArrayList<>();
        while(n/10>0){
            int k=n%10;

            n=n/10;

            target=target*10+k;
        }
        target=target*10+n%10;
        return target;
    }
}
