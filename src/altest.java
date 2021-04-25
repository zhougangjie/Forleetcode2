import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class altest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<ArrayList<Integer>> result = prepareAB(n);
        for (ArrayList<Integer> result_1:
             result) {
            for (Integer result_unit:result_1
                 ) {
                System.out.print(result_unit+" ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> prepareAB(int n){
        if (n > 1){
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

            ArrayList<ArrayList<Integer>> resultn_1 = prepareAB(n-1);

            for (int i=0; i<Math.pow(2, n-1);i++){
                ArrayList<Integer> newArray = new ArrayList<>();
                for (int j = 0; j<Math.pow(2, n-1); j++){
                    newArray.add(0);
                }
                newArray.addAll(resultn_1.get(i));
                result.add(newArray);
            }
            for (int i=0; i<Math.pow(2, n-1);i++){
                ArrayList<Integer> newArray = new ArrayList<>();
                newArray.addAll(resultn_1.get(i));
                newArray.addAll(resultn_1.get(i));
                result.add(newArray);
            }
            return result;
        }else {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> result1 = new ArrayList<>(Arrays.asList(0,1));
            ArrayList<Integer> result2 = new ArrayList<>(Arrays.asList(1,1));
            result.add(result1);
            result.add(result2);
            return result;
        }
    }
}
