package jia3.rodents_assignment;

class Rodent {

    Rodent() {
        System.out.println("Rodent");
    }

    void eat() {
        System.out.println("Rodent is eating");
    }

    void sleep() {
        System.out.println("Rodent is sleeping");
    }

}

class Mouse extends Rodent {

    Mouse() {
        System.out.println("Mouse");
    }

    @Override
    void eat() {
        System.out.println("Mouse is eating");
    }

    @Override
    void sleep() {
        System.out.println("Mouse is sleeping");
    }
}

class Gerbil extends Rodent {

    Gerbil() {
        System.out.println("Gerbil");
    }

    @Override
    void eat() {
        System.out.println("Gerbil is eating");
    }

    @Override
    void sleep() {
        System.out.println("Gerbil is sleeping");
    }
}

class Hamster extends Rodent {

    Hamster() {
        System.out.println("Hamster");
    }

    @Override
    void eat() {
        System.out.println("Hamster is eating");
    }

    @Override
    void sleep() {
        System.out.println("Hamster is sleeping");
    }
}

public class Main {

    public static void main(String[] args) {

        Rodent rodent[] = new Rodent[3];
        rodent[0] = new Mouse();
        rodent[1] = new Gerbil();
        rodent[2] = new Hamster();

        rodent[0].eat();
        rodent[0].sleep();

        rodent[1].eat();
        rodent[1].sleep();

        rodent[2].eat();
        rodent[2].sleep();

    }

}
