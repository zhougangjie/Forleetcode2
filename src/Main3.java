import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Double> lineLengths =  new ArrayList<Double>();
        int scanTimes = 0;
        while (scanTimes < n){
            Double n_k = scanner.nextDouble();
            lineLengths.add(n_k);
            scanTimes++;
        }

        for (int i=0; i<lineLengths.size();i++){
            System.out.println(analyseDays(lineLengths.get(i)));
        }
    }

    public static int analyseDays(double lineLength){
        if (lineLength > 1){
            return 1+analyseDays(Math.ceil(lineLength / 2.0 ));
        }else {
            return 1;
        }
    }
}

