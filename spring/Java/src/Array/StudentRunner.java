package Array;

import java.math.BigDecimal;

public class StudentRunner  {
    public static void main(String[] args) {
        int[] marks =  {97,98,99,100,20,30,40,50,65,75,78,77,56};
        //배열은 한번 생성하면 배열의 index 를 추가하거나 줄일 수 없다.
        Student student = new Student("Ranga",marks);

        int number = student.getNumberOfMarks();
        System.out.println("Get Number of Marks length :" + number);

        int sum = student.getTotalSumOfMarks();
        System.out.println("Get Total Sum Of Marks : " + sum);

        int maximum = student.getMaximumNumberOfMarks();
        System.out.println("Get Maximum Number Of Marks : " + maximum);

        int minimum = student.getMinimumNumberOfMarks();
        System.out.println("Get Minimum Number Of Marks : " + minimum);
        
        BigDecimal average = student.getAverageNumberOfMarks();
        System.out.println("Get Average Number Of Marks : " + average);

        System.out.println(student);
        student.addNewMark(35);

        System.out.println(student);

        student.removeMarkAtIndex(1);
        System.out.println(student);

         


        
    }
}
