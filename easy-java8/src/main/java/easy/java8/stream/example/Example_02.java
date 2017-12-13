package easy.java8.stream.example;

import easy.java8.entity.Numbers;
import easy.java8.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mr_yyy on 2017/11/11.
 */
public class Example_02 {

    /**
     * distinct 根据hashcode和equals去重
     */
    @Test
    public void test_distinct() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,1,6,4);
        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctNumbers);
    }

    /**
     * 会分别判断hashcode和equals
     * 可以打断点进行观察
     */
    @Test
    public void test_distinct02() {
        Numbers n1 = new Numbers();
        n1.setIndex(1);
        n1.setDesc("1desc");
        Numbers n2 = new Numbers();
        n2.setIndex(1);
        n2.setDesc("1desc");
        List<Numbers> numberses = Arrays.asList(n1,n2);
        numberses.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void test_limit() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,1,6,4);
        numbers.stream().limit(4).forEach(System.out::println);
    }

    @Test
    public void test_skip() {
        List<Integer> numbers = Arrays.asList(1,2,2,3,1,6,4);
        numbers.stream().skip(1).limit(4).forEach(System.out::println);
    }


    /**
     * reduce 求最大值
     */
    @Test
    public void test_reduce_max() {
        System.out.println(Arrays.asList(1,2,2,3,1,6,4).stream().reduce(0,Integer::max));
    }

    /**
     * reduce 求和
     */
    @Test
    public void test_reduce() {
        System.out.println(Arrays.asList(1,2,2,3,1,6,4).stream().reduce(0,(a, b) -> Integer.sum(a,b)));
    }

    /**
     * reduce 求和
     */
    @Test
    public void test_sum() {
        System.out.println(Arrays.asList(1,2,2,3,1,6,4).stream().mapToInt(a->a.intValue()).sum());
    }

    /**
     * reduce 拼接字符串
     */
    @Test
    public void test_reduce_string() {
        List<String> strings = Arrays.asList("xiaowang", "zhanglaoshi", "liming", "wahaha");
        String strAppend = strings.stream().sorted().reduce("", (str1, str2) -> str1 +" "+ str2);
        System.out.println(strAppend);
    }

    /**
     * joining 拼接字符串
     */
    @Test
    public void test_joining() {
        List<String> strings = Arrays.asList("xiaowang", "zhanglaoshi", "liming", "wahaha");
        String strAppend = strings.stream().sorted().collect(Collectors.joining(" "));
        System.out.println(strAppend);
    }
}
