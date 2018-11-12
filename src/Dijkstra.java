import java.util.*;

public class Dijkstra {

    int numberOfVertices, road, minDistNotFlooded;
    boolean end = false;


    ArrayList<Vertex> vertexList = new ArrayList();
    HashMap<Vertex, Integer> distanceMap = new HashMap<>();
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
        distanceMap.put(v0, v0.getDistance());

        // else vertices
        for (int i = 1; i < numberOfVertices; i++) {
            Vertex vi = new Vertex(i);
            vertexList.add(vi);
            distanceMap.put(vi, vi.getDistance());
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
        distanceMap.remove(vertex);

        int newDist;
        int oldDist;
        Vertex dest;

        for (Edge edge : edges){

            dest = edge.getDest();
            newDist = vertex.getDistance() + edge.getWeight();
            oldDist = edge.getDest().getDistance();

            if (oldDist > newDist){
                dest.setDistance(newDist);

                if (!dest.isFlooded()){
                    distanceMap.put(edge.getDest(), newDist);
                }
            }
        }

    }


    // get an array of vertices with min distance
    public Vertex getMinDistVertex (){

        Vertex rtn = null;

        if (end){
            return rtn;
        }

        for (Map.Entry<Vertex, Integer> entry : distanceMap.entrySet()){
            if (entry.getValue() == minDistNotFlooded){
                rtn = entry.getKey();
            }
        }

        return rtn;
    }


    // get the min dist
    public void minDist (){

        if (distanceMap.isEmpty()){
            end = true;
            minDistNotFlooded = Integer.MAX_VALUE;
        } else {
            Object[] dists = distanceMap.values().toArray();
            Arrays.sort(dists);
            minDistNotFlooded = Integer.parseInt(dists[0].toString());
        }


    }






    public static void main(String[] args) {

        Dijkstra dijkstra = new Dijkstra();

        HashMap<String, Integer> test = new HashMap<>();

        test.put("hehe", 4);
        test.put("haha", 5);
        test.put("enen", 3);
        test.put("guna", 2);
        test.put("shit", 1);

        Object[] dists = test.values().toArray();
        Arrays.sort(dists);
        int result = Integer.parseInt(dists[0].toString()) + 10000;
        System.out.println(result);


    }
}
