package easy.presuretest.entity;

import java.time.LocalDate;

/**
 * Created by Mr_yyy on 2017/11/11.
 */
public class Student {
    private String name;
    private String number;
    private LocalDate birthday;
    private Integer height; //cm
    private Integer weight; //kg

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "学生信息 { " +
                "姓名:" + name + '，' +
                "学号:" + number + '，' +
                "生日:" + birthday + '，' +
                "身高:" + height + "cm，" +
                "体重:" + weight + "kg } \n";
    }
}
