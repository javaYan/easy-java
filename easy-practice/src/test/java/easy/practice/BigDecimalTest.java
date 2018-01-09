package easy.practice;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * BigDecimal测试
 * Created by Mr_yyy on 2018/1/9.
 */
public class BigDecimalTest {

    @Test
    public void Test01() {
        Double d1 = 112992.612D;
        BigDecimal decimal = new BigDecimal(d1);
        System.out.println(decimal.divide(new BigDecimal(1000)).longValue());
    }
}
