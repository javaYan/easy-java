package easy.practice;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Mr_yyy on 2018/1/21.
 */
public class ClassTest {
    /**
     * invoke
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    @Test
    public void testInvoke() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class studentServiceClass = StudentService.class;
        Method sayMethod = studentServiceClass.getMethod("say");
        Method doSayMethod = studentServiceClass.getMethod("doSay");
        Object obj = studentServiceClass.newInstance();
        sayMethod.invoke(obj);
        doSayMethod.invoke(obj);
    }

    @Test
    public void testField () throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException, InstantiationException {
        Class studentServiceClass = StudentService.class;
        Object obj = studentServiceClass.newInstance();
        Field nameField = studentServiceClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj, "Mr_yyy");
        Method introduceMethod = studentServiceClass.getMethod("introduce");
        introduceMethod.invoke(obj);
    }
}
