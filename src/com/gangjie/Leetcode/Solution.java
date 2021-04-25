package com.gangjie.Leetcode;

import javax.swing.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
//        System.out.println(solution.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            if (A[i] > A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    public int maximumWealth(int[][] accounts) {
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            int tempsum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                tempsum += accounts[i][j];
            }
            if (tempsum > sum)
                sum = tempsum;
        }
        return sum;
    }

    public String reverseLeftWords(String s, int n) {
        if (n > s.length())
            return s;
        char[] sArray = new char[s.length()];
        char[] resultArray = new char[s.length()];
        sArray = s.toCharArray();
        for (int i = 0; i < s.length() - n; i++) {
            resultArray[i] = sArray[n + i];
        }
        for (int i = s.length() - n, j = 0; j < n; i++, j++) {
            resultArray[i] = sArray[j];
        }
        return  resultArray.toString();
    }

    /**
     * 给你一个整数数组 nums 。
     *
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     *
     * 返回好数对的数目。
     *
     * @param nums 整数数组
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        for (int i = 0; i<nums.length -1; i++){
            for (int j = i+1 ; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    result ++;
                }
            }
        }
        return result;
    }

    public int numIdenticalPairs2(int[] nums){
        Arrays.sort(nums);
        int result=0, i=0,j=0;
        for (i=0; i<nums.length-1; i++){
            for (j = i+1; j<nums.length && nums[j]==nums[i]; j++){
            }
            if(j > i+1){
                result += (j - i - 1) * (1 + j -i -1)/2;
                i = j - 1;
            }
        }
        System.out.println(result);
        return result;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int length = candies.length;
        int max = candies[0];
        for(int i = 1; i<length; i++){
            if (candies[i] > max){
                max = candies[i];
            }
        }

        for (int i = 0; i < length; i++){
            if (candies[i] + extraCandies >= max){
                result.add(true);
            }
            else result.add(false);
        }
        return result;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result_half1 = new  int[nums.length/2];
        int[] result_half2 = new  int[nums.length/2];
        int[] result = new int[n*2];
        for (int i=0; i<n; i++){
            result_half1[i] = nums[i];
            result_half2[i] = nums[i+n];
        }
        int i = 0, j =0;
        while (i < n *2){
            result[i] = result_half1[j];
            result[i+1] = result_half2[j];
            i+=2;
            j++;
        }
        return result;
    }

    /**
     *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     *
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *
     */

    public int numJewelsInStones(String J, String S) {
        int result = 0;
//        for (int i=0; i<J.length(); i++){
//            String j = "";
//            j = J.substring(i,i+1);
//            System.out.println(j);
//            for (int i1 = 0; i1 < S.length(); i1++){
//                String s = S.substring(i1, i1+1);
//                if (j.equals(s))
//                    result++;
//            }
//        }
        Set<Character> jewelsSet = new HashSet<Character>();
        for (int i=0; i<J.length(); i++){
            Character j = J.charAt(i);
            jewelsSet.add(j);
        }
        for (int i=0; i <S.length(); i++){
            Character s= S.charAt(i);
            if (jewelsSet.contains(s))
                result++;
        }
        return result;
    }

    /**
     * 给你两个整数，n 和 start 。
     *
     * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
     *
     * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
     */

    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++){
            ans ^= start + i * 2;
        }
        return ans;
    }

    /**
     * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
     */
    public int subtractProductAndSum(int n) {
        String n_str = String.valueOf(n);
        int ji = 1;
        int he = 0;
        for (int i = 0; i < n_str.length(); i++){
            int n_i = Integer.parseInt(n_str.substring(i, i+1));
            ji *= n_i;
            he += n_i;
        }
        return ji-he;
    }

    /**
     *
     * 给你一个以行程长度编码压缩的整数列表 nums 。
     *
     * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
     *
     * 请你返回解压后的列表。
     * @param nums
     * @return
     */
    public int[] decompressRLElist(int[] nums) {
        int numbers = 0;
        int[] result = null;
        for (int i = 0; i < nums.length; i+=2){
            numbers += nums[i];
        }
        result = new int[numbers];
        int index = 0 ;
        for (int i = 0; i < nums.length; i += 2){
            for (int j = 0; j < nums[i] ; j++){
                result[index] = nums[i+1];
                index ++;
            }
        }
        return result;
    }

    /**
     * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
     *
     * 目标数组 target 最初为空。
     * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
     * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
     * 请你返回目标数组。
     *
     * 题目保证数字插入位置总是存在。
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result_array = new int[nums.length];
        List<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++){
            result.add(index[i],nums[i]);
        }
        for (int i = 0; i < result.size(); i++){
            result_array[i] = result.get(i);
        }
        return result_array;
    }

    /**
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     *
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
     *
     * 以数组形式返回答案。
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0 ; i < nums.length; i++){
            int now = nums[i];
            for (int j = 0; j < nums.length; j++){
                if (nums[j] < nums[i])
                    result[i] +=1;
            }
        }
        return result;
    }

    /**
     * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
     */
    public int largestAltitude(int[] gain) {
        int result=0;
        int temp = 0;
        for (int i=0; i < gain.length; i++ ){
            temp = temp + gain[i];
            if (result < temp){
                result = temp;
            }
        }
        return  result;
    }

    /**
     * 未知 整数数组 arr 由 n 个非负整数组成。
     *
     * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
     *
     * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
     *
     * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
     */

    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++){
            result[i] = result[i-1] ^ encoded[i - 1];
        }
        return result;
    }


    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length-1; i++){
            int[] a = points[i];
            int[] b = points[i+1];
            int x_a_b = Math.abs(a[0]-b[0]);
            int y_a_b = Math.abs(a[1]-b[1]);

            result += x_a_b > y_a_b ? x_a_b :  y_a_b;
        }
        return result;
    }

    /**
     * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
     * @param num
     * @return
     */

    public int numberOfSteps (int num) {
        int result = 0;
//        long num1 = 1;
//        while (num != 0){
//            if (num & num1 == 1)
//                num -= 1;
//            else
//                num /= 2 ;
//            result ++;
//        }
//        return result;

        while (num != 0){
            int odd_or_not = num & 1;
            if (odd_or_not == 1)
                num -= 1;
            else
                num = num >> 2 ;
            result ++;
        }
        return result;
    }

    public int findNumbers(int[] nums) {
        int result = 0;
        for(int i=0; i < nums.length; i++){
            String temp = Integer.toString(nums[i]);
            if (temp.length() % 2 ==0){
                result ++;
            }
        }
        return result;
    }

    public String interpret(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        char[] all = allowed.toCharArray();
        for (String word : words){
            for (int i=0; i<all.length; i++){
                if (word.indexOf(all[i]) != -1){
                    word.replace(all[i],'0');
                }else
                    word.replace(all[i], '1');
            }
            if (Integer.valueOf(word) != 0){
                result++;
            }
        }
        return result;
    }

    /**
     *
     * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
     *
     * 请你返回 nums 中唯一元素的 和 。
     */
    public int sumOfUnique(int[] nums) {
        int result=0;
        HashMap<Integer, Integer> num_count = new HashMap<Integer, Integer>();
        for (int num : nums){
            if (num_count.containsKey(num)){
                num_count.put(num,num_count.get(num) + 1);
            }else {
                num_count.put(num,1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : num_count.entrySet()){
            if (entry.getValue() == 1){
                result += entry.getKey();
            }
        }
        return result;
    }

    public int getDecimalValue(ListNode head) {
        int result = 0;
        ListNode current = head;
        while (current != null){
            result = result * 2 + current.val;
            current = current.next;
        }
        return result;
    }

    public int diagonalSum(int[][] mat) {
        int len = mat[0].length;
        int result = 0;
        for (int i=0; i<len; i++){
            result += mat[i][i] + mat[i][len-1-i];
        }

//        return result - mat[len/2][len/2] * (n & 1);
        if (len % 2 == 1){
            result -= mat[len/2][len/2];
        }
        return result;
    }

    public int numberOfMatches(int n) {
        int temp = n;
        int result = 0;
        while (temp > 1){
            result += temp >> 1;
            if ((temp & 1) == 1){
                temp = temp >> 1 + 1;
            }else {
                temp = temp >> 1;
            }
        }
        return result;
    }

    public int maxDepth(String s) {
        int result = 0;
        int temp = 0;
        char[] s_array = s.toCharArray();
        for (char c : s_array){
            if (c == '(' ){
                temp ++;
                result = result < temp ?  temp : result;
            }
            if (c == ')'){
                temp --;
            }
        }
        return result;
    }

    public int calculate(String s) {
        int x = 1, y=0;
        char[] s_array = s.toCharArray();
        for (char c : s_array){
            switch (c){
                case 'A': x = 2 * x + y;
                break;
                case 'B': y = 2 * y + x;
                break;
                default:
                    break;
            }
        }
        return x + y;
    }
}


 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

