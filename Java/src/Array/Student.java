package Array;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Student {


    private  String name;
    private ArrayList<Integer> marks = new ArrayList<>();



    public Student(String name, int... marks){  //가변 인수는 항상 메소드의 마지막에 와야 한다.
        this.name = name;
        for (int mark : marks) {
            this.marks.add(mark);
        }
    }

    public int getNumberOfMarks() {
        return marks.size();
    }

    public int getTotalSumOfMarks() {
        int sum = 0;
        for (int arr:this.marks){
            sum += arr;
        }
        return sum;
    }

    public int getMaximumNumberOfMarks() {
//        int maximum = Integer.MIN_VALUE;    //97,98,99,100 MIN_VALUE 상수 사용
//        for (int mark:marks){
//            if (mark>maximum){
//                maximum = mark;
//            }
//        }
//        return maximum;
        return Collections.max(marks);  //ArrayList 는 Collections 이기 때문에 바로 최대값 
    }
    public  int getMinimumNumberOfMarks() {
//        int minimum = Integer.MAX_VALUE; //97,98,99,100
//        for (int mark:marks){
//            if (mark<minimum){
//                minimum = mark;
//            }
//        }
//        return minimum;
        return Collections.min(marks);
    }

    public BigDecimal getAverageNumberOfMarks() {
        int sum =  getTotalSumOfMarks();
        int number = getNumberOfMarks();
       return new BigDecimal(sum).divide(new BigDecimal(number),3, RoundingMode.UP);
       //Non-terminating deciaml expansion : 정확히 정의 할 수 없다는 오류(Exception) 이 발생한다.
        // 이를 해결 할 수 있는 방법은 Precision : 정확도 모드 를 사용하거나 Rounding : 반올림 모드를 사용하는 것이다.
        
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void addNewMark(int mark) {
        marks.add(mark);
    }
    public String toString() {    //지금 예제에서는 하나의 연결고리만 있기 때문에 String 을 사용했지만
        return name + marks;      //만약, 하나가 아니라 10개정도의 연결고리가 있다면 StringBuffer 를 사용해야한다.
    }

    public void removeMarkAtIndex(int i) {
        marks.remove(i);
    }
}
