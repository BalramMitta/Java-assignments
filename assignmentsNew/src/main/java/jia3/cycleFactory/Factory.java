package jia3.cycleFactory;

interface Cycle{
    void ride();
}

interface CycleFactory{
    Cycle getCycle();
}

class Unicycle implements Cycle{

    @Override
    public void ride() {
        System.out.println("Riding Unicycle");
    }
}

class Bicycle implements Cycle{

    @Override
    public void ride() {
        System.out.println("Riding bicycle");
    }
}

class Tricycle implements Cycle{

    @Override
    public void ride() {
        System.out.println("Riding tricycle");
    }

}

class UnicycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}
class TricycleFactory implements CycleFactory{

    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class Factory {

    Cycle getCycle(String cycleName){

        CycleFactory cycleFactory;
        if("Uni".equalsIgnoreCase(cycleName)){
            cycleFactory = new UnicycleFactory();
        }
        else if("Bi".equalsIgnoreCase(cycleName)){
            cycleFactory = new BicycleFactory();
        }
        else if("Tri".equalsIgnoreCase(cycleName)){
            cycleFactory = new TricycleFactory();
        }
        else {
            System.out.println("No mentioned Cycle");
            return null;
        }

        return cycleFactory.getCycle();
    }

    public static void main(String[] args){

        Factory factory = new Factory();

        Cycle cycle1 = factory.getCycle("uni");

        Cycle cycle2 = factory.getCycle("bi");

        Cycle cycle3 = factory.getCycle("tri");

        cycle1.ride();
        cycle2.ride();
        cycle3.ride();

    }

}
