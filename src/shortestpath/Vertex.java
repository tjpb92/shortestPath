package shortestpath;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe décrivant une intersection de routes ou un vertex
 * @version 0.01
 * @author Thierry Baribaud
 */
@JsonIgnoreProperties({"visited"})
public class Vertex {
    
    /**
     * Identifiant du vertex
     */
    private String id;
    
    /**
     * Abscisse du vertex
     */
    private int x;
    
    /**
     * Ordonnée du vertex
     */
    private int y; 
    
    /**
     * Indique si le vertex a été visité ou non
     */
    private boolean visited = false;

    /**
     * @return l'identifiant du vertex
     */
    public String getId() {
        return id;
    }

    /**
     * @param id définit l'identifiant du vertex
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return l'abscisse du vertex
     */
    public int getX() {
        return x;
    }

    /**
     * @param x définit l'abscisse du vertex
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return l'ordonnée du vertex
     */
    public int getY() {
        return y;
    }

    /**
     * @param y définit l'ordonnée du vertex
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return si le vertex a été visité ou non
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * @param visited indique si le vertex a été visité ou non
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Vertex:{"
                + "id:" + getId()
                + ", x:" + getX()
                + ", y:" + getY()
                + ", visited:" + isVisited()
                + "}";
    }
}
