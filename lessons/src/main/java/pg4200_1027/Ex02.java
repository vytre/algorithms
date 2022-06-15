package pg4200_1027;

import org.pg4200.les09.Graph;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Ex02 {
    public static class tramAndMetro<V> implements Graph<V>{

        @Override
        public void addVertex(V vertex) {
            
        }

        @Override
        public void addEdge(V from, V to) {

        }

        @Override
        public int getNumberOfVertices() {
            return 0;
        }

        @Override
        public int getNumberOfEdges() {
            return 0;
        }

        @Override
        public void removeEdge(V from, V to) {

        }

        @Override
        public void removeVertex(V vertex) {

        }

        @Override
        public Collection<V> getAdjacents(V vertex) {
            return null;
        }

        @Override
        public List<V> findPathDFS(V start, V end) {
            return null;
        }

        @Override
        public List<V> findPathBFS(V start, V end) {
            return null;
        }

        @Override
        public Set<V> findConnected(V vertex) {
            return null;
        }

        @Override
        public Set<V> findConnected(Iterable<V> vertices) {
            return null;
        }
    }
}
