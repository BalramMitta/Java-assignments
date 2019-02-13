package jia3.cycles;

class Cycle {

    Cycle() {
        System.out.println("Cycle");
    }


}

class Unicycle extends Cycle {

    Unicycle() {
        System.out.println("Unicycle");
    }

    void balance() {
        System.out.println("Balancing unicycle");
    }

}

class Bicycle extends Cycle {

    Bicycle() {
        System.out.println("Bicycle");
    }

    void balance() {
        System.out.println("Balancing bicycle");
    }

}

class Tricycle extends Cycle {

    Tricycle() {
        System.out.println("Tricycle");
    }

}


public class Main {

    public static void main(String[] args) {

        Unicycle unicycle = new Unicycle();
        Bicycle bicycle = new Bicycle();
        Tricycle tricycle = new Tricycle();

        Cycle[] cycle = new Cycle[3];


        //  Upcasting

        cycle[0] = (Cycle) unicycle;
        cycle[1] = (Cycle) bicycle;
        cycle[2] = (Cycle) tricycle;

//        cycle[0].balance();           AS cycle doesn't have balance method we cannot call it from upcasted cycle;
//        cycle[1].balance();           It can be possible if there is an abstract method balance in cycle
//        cycle[2].balance();


        // Downcasting

        Unicycle unicycle1 = (Unicycle) cycle[0];

        unicycle1.balance();

        Bicycle bicycle1 = (Bicycle) cycle[1];

        bicycle1.balance();

        Tricycle tricycle1 = (Tricycle) cycle[2];

//        tricycle1.balance();      // Tricycle don't have balance method
    }


}
