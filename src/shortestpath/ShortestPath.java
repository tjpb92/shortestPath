package shortestpath;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
        
        Vertex begin;
        Vertex end;
        VertexList vertexList;
        Adjacency adjacency;
        AdjacencyMatrix adjacencyMatrix;
        BlockedLane blockedLane;
        BlockedLaneList blockedLaneList;
        Lane lane;
        Lane aLane;
        Map vertices;
        Map lanes;
        Map blockedLanes;
        int nbLanes;
        int nbBlockedLanes;
        
        try {
            begin = objectMapper.readValue(new File("vertex.json"), Vertex.class);
            System.out.println(begin);
            end = new Vertex();
            end.setId("2");
            end.setX(128);
            end.setY(128);
            
            vertexList = new VertexList();
            vertexList.add(begin);
            vertexList.add(end);
            System.out.println("Nombre de vertex : " + vertexList.size());
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(vertexList);
            System.out.println("vertexList (json)=" + json);

            vertexList = objectMapper.readValue(new File("vertices.json"), VertexList.class);
            System.out.println("Nombre de vertex : " + vertexList.size());
            
            adjacency = new Adjacency();
            adjacency.setId("1");
            adjacency.addNeighbor("2");
            adjacency.addNeighbor("16");
            adjacency.addNeighbor("97");
            adjacency.addNeighbor("8");
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(adjacency);
            System.out.println("adjacency (json)=" + json);

            adjacencyMatrix = objectMapper.readValue(new File("adjacencyMatrix.json"), AdjacencyMatrix.class);
            System.out.println("Nombre d'adjacents : " + adjacencyMatrix.size());
            
            blockedLane = new BlockedLane();
            blockedLane.setBegin("60");
            blockedLane.setEnd("66");
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(blockedLane);
            System.out.println("blockedLane (json)=" + json);
            
            blockedLaneList = objectMapper.readValue(new File("blockedLanes.json"), BlockedLaneList.class);
            System.out.println("Nombre de voie(s) bloquée(s) : " + blockedLaneList.size());
            
            lane = new Lane(begin, end);
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(lane);
            System.out.println("blockedLane (json)=" + json + ", " + lane);
            
            vertices = new HashMap();
            for (Vertex v: vertexList) {
                vertices.put(v.getId(), v);
            }
            
            lanes = new HashMap();
            nbLanes = 0;
            for (Adjacency a: adjacencyMatrix) {
                if (vertices.containsKey(a.getId())) {
                    begin = (Vertex) vertices.get(a.getId());
                    for (String id: a.getNeighbors()) {
                        end = (Vertex) vertices.get(id);
                        nbLanes++;
                        lane = new Lane(begin, end);
                        lanes.put(lane.getId(), lane);
                    }
                }
            }
            System.out.println("Nombre de voie(s) : " + nbLanes);
            
            nbBlockedLanes = 0;
            for (BlockedLane b: blockedLaneList) {
                begin = (Vertex) vertices.get(b.getBegin());
                end = (Vertex) vertices.get(b.getEnd());
                aLane = new Lane(begin, end);
                if (lanes.containsKey(aLane.getId())) {
                    nbBlockedLanes++;
                    lane = (Lane) lanes.get(aLane.getId());
                    lane.setBlocked(true);
                }
            }
            System.out.println("Nombre de voie(s) bloquée(s): " + nbBlockedLanes);
            
            lanes.forEach((k,v)->System.out.println(v));
            
        } catch (IOException exception) {
            Logger.getLogger(ShortestPath.class.getName()).log(Level.SEVERE, null, exception);
        }
        
    }
    
}
