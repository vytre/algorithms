package pg4200_1027;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {

    @Test
    public void myTest(){

        Ex02.TramAndMetro<String> transport = new Ex02.TramAndMetro<>();
        transport.addEdge("1","5");
        transport.addEdge("2","5");
        transport.addEdge("4","5");
        transport.addEdge("5","8");
        transport.addEdge("5","6");
        transport.addEdge("5","10");
        transport.addEdge("2","6");
        transport.addEdge("3","6");
        transport.addEdge("7","6");
        transport.addEdge("6","10");
        transport.addEdge("2","1");
        transport.addEdge("2","3");
        transport.addEdge("3","7");
        transport.addEdge("7","9");
        transport.addEdge("9","10");
        transport.addEdge("1","4");
        transport.addEdge("4","8");
        transport.addEdge("8","10");



        List<String> path = transport.findPath("5","9");
        System.out.println(path.toString());

    }


    @Test
    public void voidTestRandom(){
        Ex02.TramAndMetro<String> transport = new Ex02.TramAndMetro<>();

        transport.addEdge("1","5");
        transport.addEdge("2","5");
        transport.addEdge("4","5");
        transport.addEdge("5","8");
        transport.addEdge("5","6");
        transport.addEdge("5","10");
        transport.addEdge("2","6");
        transport.addEdge("3","6");
        transport.addEdge("7","6");
        transport.addEdge("6","10");
        transport.addEdge("2","1");
        transport.addEdge("2","3");
        transport.addEdge("3","7");
        transport.addEdge("7","9");
        transport.addEdge("9","10");
        transport.addEdge("1","4");
        transport.addEdge("4","8");
        transport.addEdge("8","10");

        String nodeA = transport.selectNodeRandomly();
        String nodeB = transport.selectNodeRandomly();


        List<String> myPath = transport.findPath(nodeA,nodeB);


        System.out.println(myPath.toString());
    }

    @Test
    public void test3(){
        Ex02.TramAndMetro<String> transport = new Ex02.TramAndMetro<>();

        transport.addEdge("1","5");
        transport.addEdge("2","5");
        transport.addEdge("4","5");
        transport.addEdge("5","8");
        transport.addEdge("5","6");
        transport.addEdge("5","10");
        transport.addEdge("2","6");
        transport.addEdge("3","6");
        transport.addEdge("7","6");
        transport.addEdge("6","10");
        transport.addEdge("2","1");
        transport.addEdge("2","3");
        transport.addEdge("3","7");
        transport.addEdge("7","9");
        transport.addEdge("9","10");
        transport.addEdge("1","4");
        transport.addEdge("4","8");
        transport.addEdge("8","10");

        List<String> myPath = transport.findPath("6","9");
        System.out.println(myPath.toString());
    }

}