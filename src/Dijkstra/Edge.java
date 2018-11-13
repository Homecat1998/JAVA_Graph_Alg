package Dijkstra;

public class Edge {

    // start
    private Vertex origin;

    // end
    private Vertex dest;

    // weight
    private int weight;

    // constructor empty edge
    public Edge(){}

    // no weight = infinity
    public Edge(Vertex origin, Vertex dest){
        this.origin = origin;
        this.dest = dest;
        this.weight = Integer.MAX_VALUE;
    }

    // constructor for a connected edge
    public Edge(Vertex origin, Vertex dest, int weight){
        this.origin = origin;
        this.dest = dest;
        this.weight = weight;
    }

    // get methods
    public int getWeight() {
        return weight;
    }

    public Vertex getDest() {
        return dest;
    }

    public Vertex getOrigin() {
        return origin;
    }
}
