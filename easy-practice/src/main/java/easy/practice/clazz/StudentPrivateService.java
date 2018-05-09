package easy.practice.clazz;

/**
 * Created by Mr_yyy on 2018/1/21.
 */
public class StudentPrivateService {
    /**
     * 私有构造器
     */
    private StudentPrivateService() {}
    private String name;

    public void say() {
        System.out.println("say...");
    }

    public void doSay() {
        System.out.println("do say...");
    }

    public void introduce() {
        System.out.println("my name is " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
