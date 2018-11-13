package Dijkstra;

import java.util.*;

public class Dijkstra {

    private int numberOfVertices, road, minDistNotFlooded;


    ArrayList<Vertex> vertexList = new ArrayList();
    ArrayList<Vertex> unvisited = new ArrayList<>();
    Scanner console;

    public Dijkstra(){
        console = new Scanner(System.in);
    }

    public void getInput() {
        System.out.println("How many vertices?");
        numberOfVertices = console.nextInt();
        System.out.println("How many roads?");
        road = console.nextInt();

        // add the source vertex
        Vertex v0 = new Vertex(0,0);
        vertexList.add(v0);

        // else vertices
        for (int i = 1; i < numberOfVertices; i++) {
            Vertex vi = new Vertex(i);
            vertexList.add(vi);
        }

        // input roads

        for (int i = 0; i < road; i++) {
            int[] thisRoad = {0, 0, 0};

            System.out.println("Please enter a road: ");

            for (int j = 0; j < 3; j++) {
                thisRoad[j] = console.nextInt();
            }

            vertexList.get(thisRoad[0]).addEdge(vertexList.get(thisRoad[1]), thisRoad[2]);
        }
    }

    public void searchUsing(Vertex vertex){

        ArrayList<Edge> edges = vertex.getLinkedEdges();

        vertex.setFlooded(true);
        unvisited.remove(vertex);

        int newDist;
        int oldDist;
        Vertex dest;

        for (Edge edge : edges){

            dest = edge.getDest();
            newDist = vertex.getDistance() + edge.getWeight();
            oldDist = edge.getDest().getDistance();

            if (oldDist > newDist){
                dest.setDistance(newDist);

            }
        }
    }

    // get an array of vertices with min distance
    private Vertex getMinDistVertex (){

        Vertex rtn = null;
        int dist = Integer.MAX_VALUE;

        if (unvisited.isEmpty()){
            return null;
        }

        for (Vertex vertex : unvisited){
            if (vertex.getDistance() < dist){
                rtn = vertex;
                dist = vertex.getDistance();
            }
        }
        return rtn;
    }


    // main function
    public void run(){

        Vertex temp;

        while (!unvisited.isEmpty()){
            temp = getMinDistVertex();
            searchUsing(temp);
        }

    }


    public static void main(String[] args) {

        Dijkstra dijkstra = new Dijkstra();

        dijkstra.getInput();
        dijkstra.run();


    }
}
