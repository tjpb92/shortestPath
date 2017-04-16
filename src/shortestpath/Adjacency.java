package shortestpath;

import java.util.ArrayList;

/**
 * Classe décrivant les vertex voisins d'un vertex données.
 * @author Thierry Baribaud
 * @version 0.01
 */
public class Adjacency {
    
    /**
     * Identifiant unique du vertex
     */
    private String id;
    
    /**
     * Liste des vertex voisins
     */
    private ArrayList<String> neighbors;

    /**
     * Constructeur principal de la classe
     */
    public Adjacency() {
        neighbors = new ArrayList();
    }
    
    /**
     * @return L'identifiant unique du vertex
     */
    public String getId() {
        return id;
    }

    /**
     * @param id Définit l'identifiant unique du vertex
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return La liste des vertex voisins
     */
    public ArrayList<String> getNeighbors() {
        return neighbors;
    }

    /**
     * @param neighbors Définit la liste des vertex voisins
     */
    public void setNeighbors(ArrayList<String> neighbors) {
        this.neighbors = neighbors;
    }

    /** 
     * @param id ajoute un vertex à la liste
     */
    public void addNeighbor(String id) {
        neighbors.add(id);
    }
    
    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Adjacency:{"
                + "id:" + getId()
                + ", neighbors:[" + getNeighbors() + "]"
                + "}";
    }
}
