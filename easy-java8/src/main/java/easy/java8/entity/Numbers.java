package easy.java8.entity;

/**
 * Created by Mr_yyy on 2017/12/12.
 */
public class Numbers {
    private int index;
    private String desc;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Numbers numbers = (Numbers) o;

        if (index != numbers.index) return false;
        return desc != null ? desc.equals(numbers.desc) : numbers.desc == null;

    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "index=" + index +
                ", desc='" + desc + '\'' +
                '}';
    }
}
