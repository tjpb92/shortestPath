package shortestpath;

/**
 * Classe décrivant une route bloquée
 *
 * @author Thierry Baribaud
 * @version 0.01
 */
public class BlockedLane {

    /**
     * Identifiant du vertex de début de la voie
     */
    private String begin;

    /**
     * Identifiant du vertex de fin de la voie
     */
    private String end;

    /**
     * @return l'identifiant du vertex de début de la voie
     */
    public String getBegin() {
        return begin;
    }

    /**
     * @param begin définit l'identifiant du vertex de début de la voie
     */
    public void setBegin(String begin) {
        this.begin = begin;
    }

    /**
     * @return l'identifiant du vertex de fin de la voie
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end définit l'identifiant du vertex de fin de la voie
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return Retourne l'objet sous forme textuelle
     */
    @Override
    public String toString() {
        return "BlockedLane:{"
                + "begin:" + getBegin()
                + ", end:" + getEnd()
                + "}";
    }
}
