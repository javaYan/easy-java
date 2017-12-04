package easy.presuretest.cycle;

import easy.presuretest.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 测试stream.filter与普通的for循环
 */
public class Test1 {

    private List<Student> students;

    @Before
    public void before() {
        students = new ArrayList<Student>();
        Student student;
        for (int i = 0; i < 5000000; i ++) {
            student = new Student();
            student.setBirthday(LocalDate.now());
            student.setName("学生_"+i);
            student.setNumber(String.valueOf(i));
            student.setHeight(i);
            student.setWeight(i);

            students.add(student);
        }
    }

    @Test
    public void testStreamCost() {
        long start = System.nanoTime();
        List<Student> collect = students.stream().filter(s -> s.getHeight() > 100000).collect(Collectors.toList());
        long end = System.nanoTime();
        System.out.println("stream cost :" + (end-start) + " ns");
        //stream cost :298623237 ns
        //stream cost :300234656 ns
        //stream cost :304940071 ns
    }

    @Test
    public void testParallelStreamCost() {
        long start = System.nanoTime();
        List<Student> collect = students.parallelStream().filter(s -> s.getHeight() > 100000).collect(Collectors.toList());
        long end = System.nanoTime();
        System.out.println("stream cost :" + (end-start) + " ns");
        //parallelStream cost :112502988 ns
        //parallelStream cost :196600003 ns
        //parallelStream cost :290826621 ns
    }

    @Test
    public void testForCost() {
        long start = System.nanoTime();
        List<Student> collect = new ArrayList<Student>();
        for(Student student : students) {
            if(student.getHeight()>100000) {
                collect.add(student);
            }
        }
        long end = System.nanoTime();
        System.out.println("for cost :" + (end-start) + " ns");

        //for cost :100165650 ns
        //for cost :100690239 ns
        //for cost :104078290 ns
    }

}
