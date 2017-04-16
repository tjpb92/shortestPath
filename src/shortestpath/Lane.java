package shortestpath;

import static java.lang.Math.sqrt;

/**
 * Classe décrivant une voie
 *
 * @author Thierry Baribaud
 * @version 0.02
 */
public class Lane {

    /**
     * Identifiant de la voie
     */
    private String id;

    /**
     * Vertex du début de la voie
     */
    private Vertex begin;

    /**
     * Vertex de la fin de la voie
     */
    private Vertex end;

    /**
     * Longueur de la voie
     */
    private float length;

    /**
     * La voie est-elle bloquée ou non ?
     */
    private boolean blocked = false;

    /**
     * Constructeur principal
     *
     * @param begin vertex du début de la voie
     * @param end vertex de la fin de la voie
     */
    public Lane(Vertex begin, Vertex end) {
        this.begin = begin;
        this.end = end;
        setId(begin, end);
        setLength(begin, end);
    }

    /**
     * @return l'identifiant de la voie
     */
    public String getId() {
        return id;
    }

    /**
     * @param id définit l'identifiant de la voie
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Définit l'identifiant de la voie
     *
     * @param begin vertex du début de la voie
     * @param end vertex de la fin de la voie
     */
    public void setId(Vertex begin, Vertex end) {
        String beginId = begin.getId();
        String endId = end.getId();

        this.id = (beginId.compareTo(endId) < 0) ? beginId + "x" + endId : endId + "x" + beginId;
    }

    /**
     * @return le vertex du début de la voie
     */
    public Vertex getBegin() {
        return begin;
    }

    /**
     * @param begin définit le vertex du début de la voie
     */
    public void setBegin(Vertex begin) {
        this.begin = begin;
    }

    /**
     * @return le vertex de la fin de la voie
     */
    public Vertex getEnd() {
        return end;
    }

    /**
     * @param end définit le vertex de la fin de la voie
     */
    public void setEnd(Vertex end) {
        this.end = end;
    }

    /**
     * @return la longueur de la voie
     */
    public float getLength() {
        return length;
    }

    /**
     * @param length définit la longueur de la voie
     */
    public void setLength(float length) {
        this.length = length;
    }

    /**
     * Définit la longueur de la voie
     *
     * @param begin vertex du début de la voie
     * @param end vertex de la fin de la voie
     */
    public void setLength(Vertex begin, Vertex end) {
        float dx = (float) (end.getX() - begin.getX());
        float dy = (float) (end.getY() - begin.getY());

        this.length = (float) sqrt(dx * dx + dy * dy);

    }

    /**
     * @return indique si la voie est bloquée ou non
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * @param blocked définit si la voie est bloquée ou non
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "Lane:{"
                + "id:" + getId()
                + ", begin:" + getBegin()
                + ", end:" + getEnd()
                + ", length:" + getLength()
                + ", blocked:" + isBlocked()
                + "}";
    }
}
