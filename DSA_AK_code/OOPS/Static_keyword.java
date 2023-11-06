package OOPS;

// the static keyword in java is used to share the same variabel or method of  given class 
// like == properties , function , blocks code , nested classes 
public class Static_keyword {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("JMV");
        System.out.println("s1 : " + s1.getaSchooleName());
        Student s2 = new Student();
        System.out.println("s2 : " + s2.getaSchooleName());// here also same name will print becouse we have make
                                                           // SchooleName as
        // (static)
        // and also when you make changes by useing other abject the Schole name will
        // also change for other objects
        System.out.println();
        s2.setName("ganesh");
        System.out.println("s2 : " + s2.getaSchooleName());

        System.out.println("s1 : " + s1.getaSchooleName());

        System.out.println(s1.markes(3, 3, 5));
        System.out.println(s2.markes(4, 55, 6));
    }
}

// when we use "this" keyword for any variavble inthe function it means that the
// original variable
class Student {
    String name;
    int roll;
    static String SchooleName;

    static int markes(int math, int pysh, int sci) {
        return (math + pysh + sci) / 3;
    }

    void setName(String SchooleName) {
        this.SchooleName = SchooleName;
    }

    String getaSchooleName() {
        return this.SchooleName;
    }
}