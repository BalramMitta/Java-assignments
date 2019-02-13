package jia3.q5;


class A {

    class InnerA {

        InnerA(String s) {
            System.out.println("Inside Inner A \n " + s);
        }

    }
}

class B {

    class InnerB extends A.InnerA {

        InnerB(A a, String s) {
            a.super(s);
        }

    }

}

public class InnerClass {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        B.InnerB innerB = b.new InnerB(a, "Hello Balram");

    }

}
