package pg4200_1027;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Ex02Test {

    @Test
    public void myTest(){

        Ex02.TramAndMetro<String> graph = new Ex02.TramAndMetro<>();
        graph.addEdge("0","X");
        graph.addEdge("X","1");
        graph.addEdge("X","Y");
        graph.addEdge("1","2");
        graph.addEdge("2","Y");
        graph.addEdge("1","3");
        graph.addEdge("3","4");
        graph.addEdge("3","5");
        graph.addEdge("4","5");


        List<String> paths = graph.findPath("X","5");
        assertEquals(4, paths.size());
    }

}