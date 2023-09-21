package CollectionEx;

import java.util.Comparator;

 

public class Student implements Comparable<Student>{
    private int id;
    private String name;


    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + "\t";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public int compareTo(Student that) {
//        return Integer.compare(this.id,that.id);
//    }
    //만약 역순으로 정렬 하고 싶다면

    @Override
    public int compareTo(Student that) {
        return Integer.compare(that.id,this.id);
    }
}
