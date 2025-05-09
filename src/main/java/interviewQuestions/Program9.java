package interviewQuestions;

interface InterfaceA {
    default void display() {
        System.out.println("Display from InterfaceA");
    }
}

interface InterfaceB {
    default void display() {
        System.out.println("Display from InterfaceB");
    }
}

public class Program9 implements InterfaceA, InterfaceB {

    @Override
    public void display() {
        InterfaceA.super.display();
        InterfaceB.super.display();
    }

    public static void main(String[] args) {
        Program9 t = new Program9();
        t.display();
    }
}

