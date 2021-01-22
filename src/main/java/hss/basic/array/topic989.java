package hss.basic.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param
 * @author YCKJ3552
 * @return
 * @date 16:51 2021/1/22
 */
public class topic989 {
    public static void main(String[] args) {

        List<Integer> res = addToArrayForm(new int[]{1, 2, 6, 3, 0, 7, 1, 7, 1, 9, 7, 5, 6, 6, 4, 4, 0, 0, 6, 3}, 516);

        System.out.println(res);
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
//        List<Integer> res = new ArrayList<>();
//        long sum1 = 0;
//        for(int i= A.length-1; i>=0; i--){
//            sum1+=A[A.length-1-i]*Math.pow(10,i);
//            System.out.println(Math.pow(10,i));
//        }
//        long sum=sum1+K;
//        System.out.println(sum);
//        String num=Long.toString(sum);
//        System.out.println(num);
//        for(int i =0;i<num.length();i++){
//            char c= num.charAt(i);
//            System.out.println(c);
//            res.add(Integer.parseInt(String.valueOf(c)));
//        }
//        return res;
//上述long、int类型都有上界限，无法解决所有情况，下面为正解
        List<Integer> res = new ArrayList<>();
        int length = A.length;

        for (int i = length - 1; i >= 0; i--) {
            K = A[i] + K;
            int target = K%10;
            res.add(target);
            K=K/10;
        }
        while(K>9){
            int target = K%10;
            res.add(target);
            K=K/10;
        }
        if(K>0&K<=9){
            res.add(K);
        }
        List<Integer> mirrorRes= new ArrayList<>();
        for(int i=res.size()-1;i>=0;i--){
            mirrorRes.add(res.get(i));
        }
        return mirrorRes;
    }
}
