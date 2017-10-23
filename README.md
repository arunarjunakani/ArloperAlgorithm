# Arloper's Algorithm
This is the implementation of a simple heuristic algorithm for the [Travelling Salesman Problem (TSP)](https://en.wikipedia.org/wiki/Travelling_salesman_problem). The TSP involves a a salesman who starts at city and wants to visit n different cities before returning to his home town. He wants to find the optimal path through so that he spends the least amount of time travelling. We can represent this abstractly as an undirected weighted cycle. The only true solution to this problem, however, is to to use exhaustive search and identify every single possible cycle, which has a running time of O(n!) which isn't exactly ideal. The TSP is a NP-complete problem. This project is the implementation of Arloper's Algorithm, a heuristic that runs in on average O(nlog(n)) with worst case O(n^2) running time.

## Built With

* [Java](https://www.java.com/en/) - The language used
* [JavaFX](http://docs.oracle.com/javase/8/javase-clienttechnologies.htm) - GUI

## Author

* **Arun Arjunakani** - [arunarjunakani](https://github.com/arunarjunakani)

## Acknowledgments

* [Ben Cooper](https://github.com/bencooper222) and Tony Lu for helping me design this algorithm.
* Dr. Noah Prince for assigning the project that influenced me to create this algorithm.
