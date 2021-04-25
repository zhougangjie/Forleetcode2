import java.lang.reflect.Array;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        int u = scanner.nextInt();
        ArrayList<Integer> bollets =  new ArrayList<Integer>();
        int scanTimes = 0;
        while (scanTimes < n){
            int n_k = scanner.nextInt();
            bollets.add(n_k);
            scanTimes++;
        }
        Collections.sort(bollets,(a, b) -> b - a);

        int times = 0;
        ArrayList<Integer> neededBollets = new ArrayList<>();
        for (int i=0; i<bollets.size() && h < u;i++){
            h += bollets.get(i);
            neededBollets.add(bollets.get(i));
        }
        System.out.println(neededBollets.size());
    }
}

