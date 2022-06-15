package pg4200_1027;

import org.pg4200.les09.UndirectedGraph;

import java.util.*;

public class Ex02 {
    public static class TramAndMetro<V> extends UndirectedGraph<V> {

        public V selectNodeRandomly(){
            List<V> keys;
            Random rand = new Random();
            keys = List.copyOf(graph.keySet());
            int sel = rand.nextInt(keys.size());
            return keys.get(sel);
        }

        public List<V> findPath(V start, V end){
            if (!graph.containsKey(start) && !graph.containsKey(end)) {
                return Collections.emptyList();
            }

            if (start.equals(end)) {
                //we do not consider cycles
                throw new IllegalArgumentException();
            }

            Deque<V> stack = new ArrayDeque<>();

            List<V> paths = new ArrayList<>();

            dfs(paths, stack, start, end);

            return paths;
        }

        private void dfs(List<V> paths, Deque<V> stack, V current, V end) {

            stack.push(current);

            if (isPathTo(stack, end)) {
                List<V> path = new ArrayList<>(stack);
                Collections.reverse(path);
                paths.add((V) path);
                return;
            }

            for (V connected : getAdjacents(current)) {
                if (stack.contains(connected)) {
                    continue;
                }

                dfs(paths, stack, connected, end);
                //backtrack
                stack.pop();
            }
        }
    }
}
