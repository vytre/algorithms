package pg4200_1027;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class Ex02 {
    public static class TramAndMetro<V> extends UndirectedGraph<V> {

        // Code used in this task are the addEdge and findPathBFS methods from \les09\UndirectedGraph.java


        public V selectNodeRandomly(){
            List<V> keys;
            Random rand = new Random();
            keys = List.copyOf(graph.keySet());
            int sel = rand.nextInt(keys.size());
            return keys.get(sel);
        }

        public void addEdge(V from, V to) {
            Objects.requireNonNull(from);
            Objects.requireNonNull(to);

            addVertex(from);
            addVertex(to);

            graph.get(from).add(to);

            if(! from.equals(to)) {
                graph.get(to).add(from);
            }
        }



        public List<V> findPath(V start, V end){
            if(! graph.containsKey(start) || ! graph.containsKey(end)){
                return null;
            }
            if(start.equals(end)){
                throw new IllegalArgumentException();
            }

            Queue<V> queue = new ArrayDeque<>();
            Map<V,V> bestParent = new HashMap<>();

            queue.add(start);

            mainLoop: while(! queue.isEmpty()){

                V parent = queue.poll();

                for(V child : graph.get(parent)){

                    if( child.equals(start) || bestParent.get(child) != null){
                        continue;
                    }
                    bestParent.put(child, parent);

                    if(child.equals(end)){
                        break mainLoop;
                    }
                    queue.add(child);
                }
            }

            if(! bestParent.containsKey(end)){
                return null;
            }

            List<V> path = new ArrayList<>();
            V current = end;
            while (current != null){
                path.add(0, current);
                current = bestParent.get(current);
            }
            return path;
        }
    }
}
