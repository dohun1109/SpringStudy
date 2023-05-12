package CollectionEx;

import java.util.*;

public class LIstEx {
    public static void main(String[] args) {

        List<String> words = List.of("apple", "Bat", "Cat");
        //리스트를 만드는(초기화하는)가장쉬운 방법 .of() -> List interface 에 존재하는 static method 이다.

        System.out.println(words);
        // length() -> array , size()->ArrayList
        System.out.println(words.size());
        //비어있는지 -> isEmpty
        System.out.println(words.isEmpty());

        //List 의 특정 요소에 접근 할 때.                          
        System.out.println(words.get(1));

        //특정 요소를 포함하고 있는지 여부.
        System.out.println(words.contains("Cat"));

        //특정 요소의 위치를 (index Num)을 알고 싶을 때
        System.out.println(words.indexOf("Bat"));
        System.out.println(words.indexOf("Cup"));   //리스트에 없는 요소를 찾으려하면 -1 return
        //즉, -1 이 return 된다는 것은 List 내부에 요소가 존재 하지 않는 다는 뜻.

//        words.add("dog");
//        그냥 List 는 불변성을 가진다.
//        그럼으로 새로운 객체를 생성하는 것이 아닌 이상 객체의 내부를 수정하거나 추가 할 수 없다.
        // String 도 동일

        System.out.println(words);


        /* 가변성 집합객체 ArrayList, LinkedList, Vector
         *
         * */

        ArrayList<String> wordsArrayList = new ArrayList<>(words);

        LinkedList<String> wordsLinkedList = new LinkedList<>(words);

        Vector<String> wordsVector = new Vector<>(words);


        System.out.println(wordsArrayList);
        System.out.println(wordsArrayList.add("Dog")); //가능; ArrayList 는 가변성 객체 이니까.
        // 지금은 정확하게는 알지못하니까 메모리에 저장되는 구조가 다른거 같다 heap메모리에서 Thread 생성으로
        // 수정 가능한 것이 아닐까 생각이 든다.
        wordsArrayList.add(2, "elephant");
        //ArrayList 에서 index 를 지정하지 않으면 맨 끝에 저장된다. 근데 ArrayList는 중복을 허용함으로
        //데이터가 중복될 수 있다는 것을 인지해야한다.

        //특정 배열을 추가하는 방법 addAll()
        // 배열을 추가하기 위해 새로운 List 를 만들어 보겠다!
        List<String> newList = List.of("Yak", "Zebra");
        wordsArrayList.addAll(newList);
        // 이렇게 추가시 ArrayList의 맨뒤에 배열이 추가된다.

        // 특정 위치의 요소를 변경하는 방법
        wordsArrayList.set(0, "Fish");

        wordsArrayList.remove(1);
        //위와 같이 인덱스 번호로 줄수도 있고 특정 데이터 자체로 넣을 수 도 있다.
        wordsArrayList.remove("Zebra");

        System.out.println(wordsArrayList);


        // List and ArrayList 요소들의 반복
        //1.
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
        //2.
        for (String word : words) {
            System.out.println(word);
        }
        //3. Iterator
        Iterator wordIterator = words.iterator();
        while (wordIterator.hasNext()) {
            System.out.println(wordIterator.next());
        }
        


    }
}
