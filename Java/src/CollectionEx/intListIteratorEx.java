package CollectionEx;

import java.util.Iterator;
import java.util.List;

public class intListIteratorEx {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        Iterator iIter = intList.iterator();

        //1.
        for (int i = 0; i < intList.size(); i++) {
            System.out.print(intList.get(i) + "\t");
        }
        System.out.println();

        //2.
        for (int num : intList) {
            System.out.print(num+ "\t");
        }
        System.out.println();

        //3. Iterator
        while (iIter.hasNext()) {
            System.out.print(iIter.next()+ "\t");
        }
    }
}
