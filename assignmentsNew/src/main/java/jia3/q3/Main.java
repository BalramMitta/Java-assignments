package jia3.q3;

// Interface 1

interface A{

    abstract void a1();

    abstract void a2();
}

// Interface 2

interface B{

    void b1();

    void b2();
}

// Interface 3

interface C{

    void c1();

    void c2();
}

// New interface joining above 3 interfaces

interface D extends A,B,C{

    abstract void d1();
}

// Concrete class

class Concrete {

    void printConcrete(){
        System.out.println("Concrete");
    }

}


// class extending concrete class implementing the interface D

public class Main extends Concrete implements D{


    //Implementation of methods from A,B,C,D interfaces

    @Override
    public void a1() {
        System.out.println("a1");
    }

    @Override
    public void a2() {
        System.out.println("a2");
    }

    @Override
    public void b1() {
        System.out.println("b1");
    }

    @Override
    public void b2() {
        System.out.println("b2");
    }

    @Override
    public void c1() {
        System.out.println("c1");
    }

    @Override
    public void c2() {
        System.out.println("c2");
    }

    @Override
    public void d1() {
        System.out.println("d1");
    }


    // Four methods taking one of the above interfaces as argument and calling its method

    void methodA(A a){
        a.a1();
        a.a2();
    }

    void methodB(B b){
        b.b1();
        b.b2();
    }

    void methodC(C c){
        c.c1();
        c.c2();
    }

    void methodD(D d){
        d.d1();   // can call any of the methods from A,B,C

    }


    public static void main(String[] arggs){

        Main m=new Main();

        m.methodA(m);
        m.methodB(m);
        m.methodC(m);
        m.methodD(m);
    }
}
