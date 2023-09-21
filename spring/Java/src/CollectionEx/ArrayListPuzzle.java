package CollectionEx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayListPuzzle {
    public static void main(String[] args) {
        List value = List.of("A", 'A', 1, 1.0);

        System.out.println(value.get(2));

        System.out.println(value.get(2)instanceof Integer);

        System.out.println(value.get(3) instanceof Double);

        List<Integer> number = List.of(101, 102, 103, 104, 105);
        System.out.println(number.indexOf(101));

        List<Integer> numbersAl = new ArrayList<>(number);

        System.out.println(numbersAl.indexOf(101));

        System.out.println(numbersAl.remove(Integer.valueOf(101)));

        System.out.println(numbersAl);

        //ArrayList 정렬
        List<Integer> numbers = List.of(123, 12, 3, 45);
        List<Integer> numbersAl2 = new ArrayList<>(numbers);
//        System.out.println(numbersAl2.sort());
        //What is Comparator? 비교자

        Collections.sort(numbersAl2);
        //Collections.sort() is static method.
        System.out.println(numbersAl2);

        
    }
}
