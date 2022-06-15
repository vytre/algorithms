In my solution for Task 2 I made the following assumptions

Since the task text said that we can use UndirectedGraph I made the assumption that if there is a edge between A-->B there is a connection A<--B

In the task it says we are going to write a method that computes the path between two nodes.
Since the task says "Path" and not "Paths" I made the assumption that the task asks us to fin the shortest rout from A to B.

That is why in my findPath method I used the findPathBFS from UndirectedGraph class from the  course GitHub repository.

The findPath method takes in Vertex A and B then computes all possible routes, then returns the shortest one.