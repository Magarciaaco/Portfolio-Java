/**
 * Edge
 * @author Miguel Angel Garcia Acosta
 */
public class Edge {
    public String[] Selected;
    public Edge _Next_Edge_;

    // Class Constructor
    Edge() {
        this.Selected = new String[2];
    }

    /**
     * Set the Edge position of A
     * @param A edge label
     */
    public void _Set_Edge_A_(String A) {
        Selected[0] = A;
    }

    /**
     * Set the Edge position of B
     * @param B edge label
     */
    public void _Set_Edge_B_(String B) {
        Selected[1] = B;
    }

    /**
     * Returns Edge Selection A or B
     * @param e integer of selection: 0 -> A, 1 -> B
     * @return Selected: null if not 0 or 1
     */
    public String _get_Selected_(int e) {
        return (e == 0) ? Selected[0] : ((e == 1) ? Selected[1] : null);
    }

    /**
     * Returns Edge to String { A , B }
     * @return edge String
     */
    public String _toString_() {
        return "{ " + Selected[0] + " , " + Selected[1] + " }";
    }
}