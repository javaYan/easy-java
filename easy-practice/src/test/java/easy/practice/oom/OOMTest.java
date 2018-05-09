package easy.practice.oom;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OOMTest {

    /**
     * 测试OutOfMemory异常并且生成dump文件
     * 需要配置jvm参数
     *
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=D:\workspace\gitRepo\easy-java\easy-practice\target\java_heapdump.hprof
     *
     * 说明Xms Xmx 分别设置最小内存和最大内存为20m 方便OOM
     * HeapDumpOnOutOfMemoryError 发生OOM时进行dump导出
     * HeapDumpPath 配置dump输出路径
     */
    @Test
    public void testOOMwithDump() {
        Map<Long, String> map = new HashMap<>();
        long id = 1;
        while(true){
            map.put(id++, String.valueOf(id));
        }
    }
}
