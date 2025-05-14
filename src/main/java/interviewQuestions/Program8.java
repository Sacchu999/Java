package interviewQuestions;

class Parent {
    public Parent() {
        System.out.println("in parent Constructor");
    }

    public void ml() {
        System.out.println("in parent method m1");
    }

    public static void m2() {
        System.out.println("in parent method m2");
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("in child Constructor");
    }

    public void ml() {
        System.out.println("in child method m1");
    }

    public static void m2() {
        System.out.println("in child method m2");
    }
}

public class Program8 {

    public static void main(String[] args) {
        String str1 = "Sachin"; // String constant pool
        String str2 = new String("Sachin"); //Heap
        Parent p = new Parent(); //Heap
        p.ml();
        p.m2();
        Child c = new Child();
        c.ml();
        c.m2();
//      Child ch = new Parent(); // Child reference cannot hold parent object
//      ch.ml();
//      ch.m2();
        Parent pl = new Child();
        pl.ml();
        pl.m2();
    }
}

