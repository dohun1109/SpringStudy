package StudentCRUD;

import java.io.*;
import java.util.*;

public class StudentDAO {

    private ArrayList<Student> al;


    public ArrayList<Student> getAl() {
        return al;
    }

    public void setAl(ArrayList<Student> al) {
        this.al = al;
    }

    public StudentDAO() {
        al = new ArrayList<Student>();
    }

    // 1. 등록
    // 등록시 점수는 0~100 사이 값 등록
    public boolean create(String id, String name, int score) {
        for (int i = 0; i < al.size(); i++) {
            Student s = al.get(i);
            if (id.equals(s.getId()))
                return false;
        }
        Student stu = new Student(id, name, score);
        al.add(stu);
        return true;
    }

    // 2. 조회
    public String read() {
        String str = " ";
        for (int i = 0; i < al.size(); i++) {
            str = str + "ID : " + al.get(i).getId() + " 이름 : " + al.get(i).getName() + " 성적 : "
                    + al.get(i).getScore() + '\n';
        }
        return str;
    }

    // 3. 수정
    public int update(String id) {

        int plus = 0;
        for (int i = 0; i < al.size(); i++) {
            Student stu = al.get(i);

            if (id.equals(stu.getId())) {
                break;
            } else
                plus++;

        }
        return plus;

    }

    //update_dialog 생성시 해당 객체 데이터 넘겨주기 
    public Student Search_i(int id_i){

        Student st1 = new Student(al.get(id_i).getId(), al.get(id_i).getName(),al.get(id_i).getScore());

        return st1;
    }
    
    // 추가. 검색
    public boolean Search(String id){
        boolean result = false;

        for (int i = 0; i < al.size(); i++) {
            Student stu = al.get(i);

            if (id.equals(stu.getId())) {
                result = true;
            } else
                continue;

        }
        return result;
    }

    // 4. 삭제
    public boolean delete(String id) {

        boolean found = false;
        int tempIndex = 0;

        for (int i = 0; i < al.size(); i++) {
            Student stu = al.get(i);
            if (id.equals(stu.getId())) {
                found = true;
                tempIndex = i;
            }
        }

        if (found) {
            al.remove(tempIndex);
            return true;

        } else {
            return false;
            
        }


    }
    // 저장
    public boolean save(String filePath) {
        try {
            String filepath = filePath;
            FileOutputStream fos = new FileOutputStream(filepath);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);


            ArrayList<Student> list = new ArrayList<>();
            for (int i = 0; i < al.size(); i++) {
                list.add(new Student(al.get(i).getId(), al.get(i).getName(), al.get(i).getScore()));
            }


            // 객체직렬화
            bw.write(String.valueOf(list));


            bw.close();
            osw.close();
            fos.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    //불러오기 
    public boolean load(String filePath) {
        try {
            String savefilename = filePath;
            FileInputStream fis = new FileInputStream(savefilename);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String text;
            while((text = br.readLine())!= null){
                String text1 = text.replace("[","");
//                System.out.println(text1);        <테스트 코드>
                String text2 = text1.replace("]","");
//                System.out.println(text2);
                String text3 = text2.replace(" ","");
                String[] values = text3.split(",");
//                System.out.println(Arrays.toString(values));
                al.clear();

                for (int i = 0; i<values.length; i++){
                    String[] info = values[i].split(":");
//                    System.out.println(Arrays.toString(info));
                    Student stu = new Student(info[0],info[1],Integer.parseInt(info[2]));
                    al.add(i,stu);
                }
            }




            br.close();
            isr.close();
            fis.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }


    }
    public boolean strContain(String id){
        boolean check = false;
       for(char c : id.toCharArray()){
           if(!Character.isDigit(c)){
               check = true;
           }
       }
       return check; 
    }
    //id 오름차순 정렬
    public boolean sortAsc_id(){
        Collections.sort(al,new Asc_compare());
        return true;
    }
    //id 내림차순 정렬
    public boolean sortDesc_id(){
        Collections.sort(al,new Desc_compare());
        return true;
    }
    //score 내림차순 정렬
    public boolean sortAsc_score(){
        Collections.sort(al,new Asc_Rank_compare());
        return true;
    }
    public boolean sortDesc_score(){
        Collections.sort(al,new Desc_Rank_compare());
        return true;
    }

    public boolean sortAsc_name(){
        Collections.sort(al,new Asc_name_compare());
        return true;
    }

    public boolean sortDesc_name(){
        Collections.sort(al,new Desc_name_compare());
        return true;
    }

    // 이전에 검사 모두 마친 후 수정(실제 수정되는 코드)
    public void update_2(int id_i, String id,String name,int score) {
          al.set(id_i,new Student(id,name,score));

    }


    //--------정렬 부분------
    //UserId(학번) 오름차순 정렬
    class Asc_compare implements Comparator<Student> {

        @Override
        public int compare(Student stu1, Student stu2) {
            return Integer.compare(Integer.parseInt(stu1.getId()),Integer.parseInt(stu2.getId()));
        }
    }
    //UserId(학번) 내림차순 정렬
    class Desc_compare implements Comparator<Student>{

        @Override
        public int compare(Student stu1, Student stu2) {
            return Integer.compare(Integer.parseInt(stu2.getId()),Integer.parseInt(stu1.getId()));
        }
    }

    class Asc_Rank_compare implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o1.getScore(),o2.getScore());
        }
    }
    class Desc_Rank_compare implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return Integer.compare(o2.getScore(),o1.getScore());
        }
    }
    class Asc_name_compare implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    class Desc_name_compare implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o2.getName().compareTo(o1.getName());
        }
    }



}
