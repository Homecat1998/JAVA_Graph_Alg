import java.util.ArrayList;
import java.util.Scanner;

public class Dijkstra {

    public int numberOfVertices,road;


    public ArrayList<Vertex> vertexList = new ArrayList();
    public ArrayList<Vertex>VertexOnLink = new ArrayList();
    public Scanner console;

    public Dijkstra(){
        console = new Scanner(System.in);
    }

    public void getInput() {
        System.out.println("How many vertices?");
        numberOfVertices = console.nextInt();
        System.out.println("How many roads?");
        road = console.nextInt();

        // add the source vertex
        vertexList.add(new Vertex(0, 0));

        // else vertices
        for (int i = 1; i < numberOfVertices; i++) {
            vertexList.add(new Vertex(i));
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







    public static void main(String[] args) {

        Dijkstra dijkstra = new Dijkstra();

    }
}
