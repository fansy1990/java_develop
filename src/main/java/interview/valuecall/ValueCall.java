package interview.valuecall;

/**
 * @Author: fansy
 * @Time: 2019/1/8 12:00
 * @Email: fansy1990@foxmail.com
 */
class Student{
    public String name;
    public Student(String t1){
        this.name = t1;
    }

    @Override
    public String toString() {
        return name;
    }
}
public class ValueCall {
    public static void main(String[] args) {
        Student t1 = new Student("t1");
        Student t2 = new Student("t2");

        swap(t1,t2);
        System.out.println(t1);
    }

    /**
     * 改变
     * @param t1 t1是引用的复制，只改变引用，不会影响原来的引用；但是改变引用地址对应的内容，那么看到的内容才会改变；
     * @param t2
     */
    public  static void swap(Student t1 , Student t2){
        Student t = t1;
        t1 = t2;
        t2 = t ;

    }
}
