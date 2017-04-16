package shortestpath;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Programme permettant de déterminer le plus court chemin entre deux points.
 * @version 0.01
 * @author Thierry Baribaud
 */
public class ShortestPath {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Common Json string
     */
    private static String json;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vertex vertex;
        VertexList vertices;
        Adjacency adjacency;
        AdjacencyMatrix adjacencies;
        BlockedLane blockedLane;
        BlockedLaneList blockedLaneList;
        
        try {
            vertex = objectMapper.readValue(new File("vertex.json"), Vertex.class);
            System.out.println(vertex);
            
            vertices = new VertexList();
            vertices.add(vertex);
            vertices.add(vertex);
            System.out.println("Nombre de vertex : " + vertices.size());
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(vertices);
            System.out.println("vertexList (json)=" + json);

            vertices = objectMapper.readValue(new File("vertices.json"), VertexList.class);
            System.out.println("Nombre de vertex : " + vertices.size());
            
            adjacency = new Adjacency();
            adjacency.setId("1");
            adjacency.addNeighbor("2");
            adjacency.addNeighbor("16");
            adjacency.addNeighbor("97");
            adjacency.addNeighbor("8");
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(adjacency);
            System.out.println("adjacency (json)=" + json);

            adjacencies = objectMapper.readValue(new File("adjacencyMatrix.json"), AdjacencyMatrix.class);
            System.out.println("Nombre d'adjacents : " + adjacencies.size());
            
            blockedLane = new BlockedLane();
            blockedLane.setBegin("60");
            blockedLane.setEnd("66");
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(blockedLane);
            System.out.println("blockedLane (json)=" + json);
            
            blockedLaneList = objectMapper.readValue(new File("blockedLanes.json"), BlockedLaneList.class);
            System.out.println("Nombre de voie(s) bloquée(s) : " + blockedLaneList.size());
            
        } catch (IOException exception) {
            Logger.getLogger(ShortestPath.class.getName()).log(Level.SEVERE, null, exception);
        }
        
    }
    
}
