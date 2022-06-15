package pg4200_1027;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {

    @Test
    public void myTest(){

        Ex02.TramAndMetro<String> metro = new Ex02.TramAndMetro<>();
        metro.addEdge("2","1");
        metro.addEdge("2","3");
        metro.addEdge("3","7");
        metro.addEdge("7","9");
        metro.addEdge("9","10");
        metro.addEdge("1","4");
        metro.addEdge("4","8");
        metro.addEdge("8","10");


        Ex02.TramAndMetro<String> tram = new Ex02.TramAndMetro<>();
        tram.addEdge("1","5");
        tram.addEdge("2","5");
        tram.addEdge("4","5");
        tram.addEdge("5","8");
        tram.addEdge("5","6");
        tram.addEdge("5","10");
        tram.addEdge("2","6");
        tram.addEdge("3","6");
        tram.addEdge("7","6");
        tram.addEdge("6","10");

        Ex02.TramAndMetro<String> both = new Ex02.TramAndMetro<>();
        both.addEdge("1","5");
        both.addEdge("2","5");
        both.addEdge("4","5");
        both.addEdge("5","8");
        both.addEdge("5","6");
        both.addEdge("5","10");
        both.addEdge("2","6");
        both.addEdge("3","6");
        both.addEdge("7","6");
        both.addEdge("6","10");
        both.addEdge("2","1");
        both.addEdge("2","3");
        both.addEdge("3","7");
        both.addEdge("7","9");
        both.addEdge("9","10");
        both.addEdge("1","4");
        both.addEdge("4","8");
        both.addEdge("8","10");



        List<String> path = both.findPath("5","9");
        System.out.println(path.toString());

    }


    @Test
    public void voidTestRandom(){
        Ex02.TramAndMetro<String> both = new Ex02.TramAndMetro<>();

        both.addEdge("1","5");
        both.addEdge("2","5");
        both.addEdge("4","5");
        both.addEdge("5","8");
        both.addEdge("5","6");
        both.addEdge("5","10");
        both.addEdge("2","6");
        both.addEdge("3","6");
        both.addEdge("7","6");
        both.addEdge("6","10");
        both.addEdge("2","1");
        both.addEdge("2","3");
        both.addEdge("3","7");
        both.addEdge("7","9");
        both.addEdge("9","10");
        both.addEdge("1","4");
        both.addEdge("4","8");
        both.addEdge("8","10");

        String nodeA = both.selectNodeRandomly();
        String nodeB = both.selectNodeRandomly();
        System.out.println(nodeA);
        System.out.println(nodeB);

        List<String> myPath = both.findPath(nodeA,nodeB);


        System.out.println(myPath.toString());
    }

    @Test
    public void test3(){
        Ex02.TramAndMetro<String> both = new Ex02.TramAndMetro<>();

        both.addEdge("1","5");
        both.addEdge("2","5");
        both.addEdge("4","5");
        both.addEdge("5","8");
        both.addEdge("5","6");
        both.addEdge("5","10");
        both.addEdge("2","6");
        both.addEdge("3","6");
        both.addEdge("7","6");
        both.addEdge("6","10");
        both.addEdge("2","1");
        both.addEdge("2","3");
        both.addEdge("3","7");
        both.addEdge("7","9");
        both.addEdge("9","10");
        both.addEdge("1","4");
        both.addEdge("4","8");
        both.addEdge("8","10");

        List<String> myPath = both.findPath("6","9");
        System.out.println(myPath.toString());


    }

}