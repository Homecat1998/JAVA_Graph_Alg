import java.util.ArrayList;

public class Vertex {

    // vertex's name
    private int name;

    // shortest distance
    private int distance;

    // if flooded
    private boolean flooded;

    // its neighbours
    private ArrayList<Edge> linkedEdges;

    // constructors
    public Vertex(int name){
        this.distance = Integer.MAX_VALUE;
        this.flooded = false;
        this.name = name;
    }

    public Vertex (int name, int distance){
        this.distance = distance;
        this.flooded = false;
        this.name = name;
    }

    // get methods


    public ArrayList<Edge> getLinkedEdges() {
        return linkedEdges;
    }

    public int getDistance() {
        return distance;
    }

    public int getName() {
        return name;
    }


    // add neighbour
    public void addEdge (Vertex dest, int weight){
        linkedEdges.add(new Edge(this, dest, weight));
    }
}
