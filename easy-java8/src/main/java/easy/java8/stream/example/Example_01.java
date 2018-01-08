package easy.java8.stream.example;

import easy.java8.entity.Student;
import easy.java8.enums.SexEnum;
import org.junit.*;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Mr_yyy on 2017/11/11.
 */
public class Example_01 {

    List<Student> studentList = new ArrayList<Student>();

    @Before
    public void before() {
        Student student;
        for (int i = 0; i < 5; i ++) {
            student = new Student();
            student.setBirthday(LocalDate.now());
            student.setName("学生_"+i);
            student.setNumber(String.valueOf(i));
            student.setSex(i%2 == 0 ? SexEnum.FEMALE : SexEnum.MALE);
            student.setHeight(170+i);
            student.setWeight(60-i);
            studentList.add(student);
        }
    }

    /**
     * 取出第一个学生
     */
    @Test
    public void test_findFirst() {
        Optional<Student> firstStudent = studentList.stream().findFirst();
        System.out.println(firstStudent.get());
    }

    /**
     * 找到所有男生 并输出
     */
    @Test
    public void test_01() {
        studentList.stream().filter(student -> student.getSex() == SexEnum.MALE)
                .forEach( stu -> System.out.println(stu));
    }

    /**
     * 找到学号是2的女生
     */
    @Test
    public void test_02() {
        Optional<Student> stuOptional = studentList.stream().filter(student ->
                student.getSex() == SexEnum.FEMALE && student.getNumber().equals("2")
        ).findFirst();
        if (stuOptional.isPresent()) {
            System.out.println(stuOptional.get());
        } else {
            System.out.println("不存在此学生");
        }
    }

    /**
     * 随机获取一个学生
     */
    @Test
    public void test_03() {
        Optional<Student> anyStu = studentList.stream().findAny();
        System.out.println(anyStu.get());
    }

    /**
     * 找出170cm以上的学生 按身高排序
     */
    @Test
    public void test_04() {
        studentList.stream().filter(student -> student.getHeight() > 170)
                .sorted( (stu1, stu2) ->  stu1.getHeight().compareTo(stu2.getHeight()))
                .forEach(sort -> System.out.println(sort) );
    }

    @Test
    public void test_05() {
        studentList.stream().sorted(Comparator.comparing(Student::getHeight).thenComparing(Student::getWeight))
                .forEach( System.out::println );
    }

    /**
     * 取出名字 组装成set  无序
     */
    @Test
    public void test_06() {
        Set<String> nameSet = studentList.stream().map(Student::getName).collect(Collectors.toSet());
        System.out.println(nameSet);
    }

    /**
     * 取出名字 组装成list  有序
     */
    @Test
    public void test_07() {
        List<String> nameList = studentList.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(nameList);
    }

    /**
     * (k,v) -> (name,Student) 组装成map  有序
     */
    @Test
    public void test_08() {
        Map<String, Student> studentMap = studentList.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
        System.out.println(studentMap);
    }






    @After
    public void after() {

    }
}
