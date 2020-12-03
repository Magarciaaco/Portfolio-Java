/**
 * Vertex is a Class for Graph Vertices with n number of Edges
 * @author Miguel Angel Garcia Acosta
 */
public class Vertex {
    // Next and Previous Vertices (if Available)
    public Vertex _Next_Vertex_;
    public Vertex _Previous_Vertex_;
    // Label and Edges
    private String _Vertex_Label_;
    private Edge _Edges_;

    // Class Constructor
    Vertex(String Label) {
        _Vertex_Label_ = Label;
    }

    /**
     * Set New Edge details { A, B } => Using Linked List Data Structure
     * @param A initial position of the Vertex Label
     * @param B final position of the Vertex Label
     */
    public void _set_Edge_(String A, String B) {
        // Base Case: No Edges are set on the Vertex
        if (_Edges_ == null) {
            // Create the Edge Object
            _Edges_ = new Edge();
            
            // Set the new Edge Object Data { A, B }
            _Edges_._Set_Edge_A_(A);
            _Edges_._Set_Edge_B_(B);

            return;
        }

        // Call the Set Methods for the current Edge on the List
        Edge _Edge_Manager_ = _Edges_; // Use a Manager variable to add a new edge
        
        // Go to end of List, and Add a new Edge
        while (_Edge_Manager_._Next_Edge_ != null)
            _Edge_Manager_ = _Edge_Manager_._Next_Edge_;
        // Create the new Edge Object
        _Edge_Manager_._Next_Edge_ = new Edge();
        
        // Set the new Edge Object Data { A, B }
        _Edge_Manager_._Next_Edge_._Set_Edge_A_(A);
        _Edge_Manager_._Next_Edge_._Set_Edge_B_(B);
    }

    /**
     * Returns Edges Linked List
     * @return Edges in the Vertex
     */
    public Edge _get_Edge_() {
        return _Edges_;
    }

    /**
     * Returns the Vertex's Label
     * @return label
     */
    public String _get_Label_() {
        return _Vertex_Label_;
    }

    /**
     * Returns the set of edges in the Vertex
     * @return Set of edges as String
     */
    public String _Edges_toString_() {
        if (_Edges_ == null)
            return "{ EMPTY }";
        
        String S = "";

        Edge _Edge_Manager_ = _Edges_; // Use a Manager variable to traverse the Vertex Edges Matrix List
        while (_Edge_Manager_ != null) {
            S = S + _Edge_Manager_._toString_();
            _Edge_Manager_ = _Edge_Manager_._Next_Edge_;
        }

        return S;
    }
}