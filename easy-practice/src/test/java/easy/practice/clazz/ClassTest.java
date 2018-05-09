package easy.practice.clazz;

import easy.practice.clazz.StudentPrivateService;
import easy.practice.clazz.StudentService;
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
        Class studentServiceCls = StudentService.class;
        Method sayMethod = studentServiceCls.getMethod("say");
        Method doSayMethod = studentServiceCls.getMethod("doSay");
        Object obj = studentServiceCls.newInstance();
        sayMethod.invoke(obj);
        doSayMethod.invoke(obj);
    }

    /**
     * field
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws NoSuchFieldException
     * @throws InstantiationException
     */
    @Test
    public void testField () throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException, InstantiationException {
        Class studentServiceCls = StudentService.class;
        Object obj = studentServiceCls.newInstance();
        Field nameField = studentServiceCls.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj, "Mr_yyy");
        Method introduceMethod = studentServiceCls.getMethod("introduce");
        introduceMethod.invoke(obj);
    }

    /**
     * Private的构造方法对应的类在newInstance时会抛出异常
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void testPrivateClass () throws IllegalAccessException, InstantiationException {
        Class studentPrivateServiceCls = StudentPrivateService.class;
        Object obj = studentPrivateServiceCls.newInstance();
        //IllegalAccessException
    }
}
