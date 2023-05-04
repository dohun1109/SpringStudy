package Array;

import java.util.ArrayList;

public class ArrayListEx {
    

    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add("Apple");
        arr.add("Bat");
        arr.add("Cat");

        System.out.println(arr);

        arr.remove("Cat");
        System.out.println(arr);

        arr.add(1);
        System.out.println(arr);

    }


}
