package easy.java8.enums;

/**
 * 性别枚举
 * Created by Mr_yyy on 2017/11/11.
 */
public enum SexEnum {

    UNKNOWN(0, "未知"),
    MALE(1,"男"),
    FEMALE(2,"女");

    SexEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    private String desc;

    public String desc() {
        return this.desc;
    }
}
