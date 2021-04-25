import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int i = 0;
        ArrayList<Person> persons= new ArrayList<Person>();
        int scanTimes = 0;
        while (scanTimes < n){
            int n_k = scanner.nextInt();
            Person newPerson = new Person(i++, n_k);
            persons.add(newPerson);
            scanTimes++;
        }
        int i1 = 0;
        while (i1 < k){
            System.out.println(persons.get(0).index+1);
            int nowTime = persons.get(0).nextTime;
            persons.get(0).nextTime += persons.get(0).k;
            persons.sort(Comparator.comparing(Person::getNextTime).thenComparing(Person::getIndex));
            i1++;
        }
    }
}

class Person{
    int index;
    int k;
    int nextTime;

    int getIndex(){
        return index;
    }

    int getK(){
        return k;
    }

    int getNextTime(){
        return nextTime;
    }

    public Person(int index, int k){
        this.index = index;
        this.k = k;
        this.nextTime = k;
    }

}
