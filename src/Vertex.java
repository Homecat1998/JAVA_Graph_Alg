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


}
