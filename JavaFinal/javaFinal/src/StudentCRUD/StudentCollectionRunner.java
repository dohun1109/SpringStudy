 package StudentCRUD;

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.Comparator;
 import java.util.List;

 class
 DescendingStudentComparator implements Comparator<Student> {

     @Override
     public int compare(Student stu1, Student stu2) {
         return Integer.compare(stu1.getId(),stu2.getId());
     }
 }

 class StudentNameComparator implements Comparator<Student> {
     @Override
     public int compare(Student stu1, Student stu2) {
         return stu1.getName().compareTo(stu2.getName());
     }
 }

 
 public class StudentCollectionRunner {
    public static void main(String[] args) {
        List<Student> Students = List.of(
                new Student(1, "Ranga"),
                new Student(100,"Adom"),
                new Student(3,"Eve"));
        List<Student> StudentAl = new ArrayList<>(Students);

        System.out.println(Students);
        Collections.sort(StudentAl);

        //내림차순 정렬
        System.out.println("DESC : "+StudentAl);
        //현재 상황에서 sort 를 사용하려면 compareTo() method를 구현해야한다.
        //왜냐하면, Student Class 는 사용자가 직접 만든 클래스이고 비교대상이 어떤건지
        // 판단을 할수 없기 때문 그래서 판단의 기준이 되는 method를 구현해주어야 한다.

        //오름차순  (참고, 클래스명 잘못함)
        Collections.sort(StudentAl, new DescendingStudentComparator());
        System.out.println("ASC : "+ StudentAl);

        Collections.sort(StudentAl,new StudentNameComparator());
        System.out.println("이름순 정렬:" + StudentAl);

        
         
    }
}
