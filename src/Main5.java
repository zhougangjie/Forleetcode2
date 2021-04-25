import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int ori_n1 = n1;
        int n2 = scanner.nextInt();
        int ori_n2 = n2;
        int q = scanner.nextInt();

        int scantimes = 0;
        ArrayList<Integer> movesPeople = new ArrayList<>();
        while (scantimes < q){
            movesPeople.add(scanner.nextInt());
            scantimes++;
        }

        LinkedHashSet<Integer> list1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> list2 = new LinkedHashSet<>();
        ArrayList<Integer> statuList = new ArrayList<>();
        for (int i = 0; i < ori_n1; i++) {
            list1.add(i+1);
            statuList.add(1);
        }
        for (int i = 0; i < ori_n2; i++) {
            list2.add(ori_n1 + i + 1);
            statuList.add(2);
        }
        for (Integer movePeople :
                movesPeople) {
            if (statuList.get(movePeople-1) == 2){
                list2.remove(movePeople);
                list1.add(movePeople);
                statuList.set(movePeople-1,1) ;
            }else {
                list1.remove(movePeople);
                list2.add(movePeople);
                statuList.set(movePeople-1,2);
            }
        }
        for (Integer people :
                list1) {
            System.out.print(people + " ");
        }
        System.out.println();
        for (Integer people :
                list2) {
            System.out.print(people + " ");
        }
    }
}


