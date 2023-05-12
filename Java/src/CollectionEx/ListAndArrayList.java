package CollectionEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAndArrayList {
    public static void main(String[] args) {

        List<String> words = List.of("Apple", "Cat", "Bat");
        List<String> wordsAl = new ArrayList<>(words);

        // 데이터들중 at 가 들어가는 데이터를 출력
        for (String word : words) {
            if (word.endsWith("at")) {
                System.out.println(word);
            }
        }

        // data 중 at 가 들어가는 데이터 삭제
        for (String word : wordsAl) {
            if (word.endsWith("at")) {
                wordsAl.remove(word);
            }
        }

        System.out.println(wordsAl);

        //Iterator
        //Iterator 는 무언가를 제거할 때 최고의 방법이다.
        Iterator<String> iterator = wordsAl.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().endsWith("at")) { 
                 iterator.remove();
            }
        }
        System.out.println(wordsAl ); 

    }
}
