/**
 * Graph is a Class manager to implement Visual operations of a given Graph
 * @author Miguel Angel Garcia Acosta
 */
public class Graph {
    private Vertex V;
    private int Degree;

    // Class constructor
    public Graph() {
        Degree = 0; // Initialize to a 0 degree Graph | No Graph Status until Two Existing Vertices
    }

    public void _Generate_Degree_() {
        // Base Case: No Vertex or null Vertex
        if (V == null)
            return;
        
        Vertex _Vertex_Manager_ = V; // Use a Manager variable to add a new Vertex
        while (_Vertex_Manager_ != null) {
            _Vertex_Manager_ = _Vertex_Manager_._Next_Vertex_;
            Degree++;
        }
    }

    // VERTEX OVERLOAD METHODS START
    // ----------------------------------------------------------------------------------------- //
    
    /**
     * Add a new Vertex V to the Graph with no Edges => Using Doubly Linked List Data Structure
     * @param Label identification vertex label
     */
    public void _Add_Vertex_(String Label) {
        // Base Case: No Vertex or null Vertex
        if (V == null) {
            V = new Vertex(Label);

            return;
        }

        // Add a new Vertex to the Graph
        Vertex _Vertex_Manager_ = V; // Use a Manager variable to add a new Vertex
        while (_Vertex_Manager_._Next_Vertex_ != null) {
            _Vertex_Manager_._Previous_Vertex_ = _Vertex_Manager_;
            _Vertex_Manager_ = _Vertex_Manager_._Next_Vertex_;
        }
        _Vertex_Manager_._Next_Vertex_ = new Vertex(Label);
        _Vertex_Manager_._Next_Vertex_._Previous_Vertex_ = _Vertex_Manager_;
    }
    
    /**
     * Add a new Vertex V to the Graph with a single Edge { A, B } => Using Doubly Linked List Data Structure
     * @param Label identification vertex label
     * @param A initial position of the Vertex
     * @param B final position of the Vertex
     */
    public void _Add_Vertex_(String Label, String A, String B) {
        // Base Case: No Vertex or null Vertex
        if (V == null) {
            V = new Vertex(Label);
            V._set_Edge_(A, B);

            return;
        }

        // Add a new Vertex to the Graph
        Vertex _Vertex_Manager_ = V; // Use a Manager variable to add a new Vertex
        while (_Vertex_Manager_._Next_Vertex_ != null) {
            _Vertex_Manager_._Previous_Vertex_ = _Vertex_Manager_;
            _Vertex_Manager_ = _Vertex_Manager_._Next_Vertex_;
        }
        _Vertex_Manager_._Next_Vertex_ = new Vertex(Label);
        _Vertex_Manager_._Next_Vertex_._set_Edge_(A, B);
        _Vertex_Manager_._Next_Vertex_._Previous_Vertex_ = _Vertex_Manager_;
    }
    // VERTEX OVERLOAD METHODS END
    // ----------------------------------------------------------------------------------------- //

    /**
     *  Sets a new Edge to an existing labeled Vertex
     * @param Label labeled Vertex to find (target Vertex)
     * @param A initial position of the Vertex
     * @param B final position of the Vertex
     */
    public void _Set_Vertex_Edge_(String Label, String A, String B) {
        // Base Case: No Vertex or null Vertex
        if (V == null) {
            System.out.println("ERROR: null Vertex (Empty)");
            return;
        }

        Vertex _Vertex_Manager_ = V; // Use a Manager variable to traverse the Vertex Matrix List
        while (_Vertex_Manager_ != null) {
            if ( Label.equals(_Vertex_Manager_._get_Label_()) ) {
                _Vertex_Manager_._set_Edge_(A, B); // Set a new Edge to the target Vertex
                return; // Stop
            }
            _Vertex_Manager_ = _Vertex_Manager_._Next_Vertex_;
        }

        System.out.println("ERROR: No Existing Vertex " + Label + " was found");
    }

    /**
     * Returns true if vertex A is adjacent with Vertex B, or false if the vertices are not adjacent
     * @param A Vertex
     * @param B Vertex
     * @return
     */
    public Boolean _is_Adjacent(String A, String B) {
        // Base Case: No Vertex or null Vertex
        if (V == null)
            return false;
        
        Edge // use two Edge managers to identify A Vertex Edges, and B Vertex Edges
            _Edge_Manager_A_ = null,
            _Edge_Manager_B_ = null;
        Vertex _Vertex_Manager_ = V; // Use a Manager variable to traverse the Adjacency Matrix Doubly Linked List

        // Load Edges
        while (_Vertex_Manager_ != null) {

            switch (_Vertex_Manager_._get_Label_().equals(A) ? 1 : 0) {
                case 1:
                    _Edge_Manager_A_ = _Vertex_Manager_._get_Edge_();
                    break;
                case 0:
                    _Edge_Manager_B_ = _Vertex_Manager_._get_Edge_();
                    break;
            }

            // Check for loaded Edges A and B
            if (_Edge_Manager_A_ != null && _Edge_Manager_B_ != null)
                break;
            
                _Vertex_Manager_ = _Vertex_Manager_._Next_Vertex_;
        }

        // Base Case: Vertex A or B has no edges

        // Empty A
        if (_Edge_Manager_A_ == null) {

            System.out.println(A + " and " + B + " are not adjacent");
            return false;
        }

        // Empty B
        if (_Edge_Manager_B_ == null) {

            System.out.println(A + " and " + B + " are not adjacent");
            return false;
        }

        // Look for Adjacencies in A to B
        Edge Ref = _Edge_Manager_A_;
        while (_Edge_Manager_A_ != null) {

            // Check for Adjacency
            if (_Edge_Manager_A_._get_Selected_(0).equals(_Edge_Manager_B_._get_Selected_(1))) {
                System.out.println(A + " and " + B + " are adjacent");
                return true;
            }

            _Edge_Manager_A_ = _Edge_Manager_A_._Next_Edge_;
        }

        _Edge_Manager_A_ = Ref;
        // Look for Adjacencies in B to A
        while (_Edge_Manager_B_ != null) {

            // Check for Adjacency
            if (_Edge_Manager_B_._get_Selected_(0).equals(_Edge_Manager_A_._get_Selected_(1))) {
                System.out.println(A + " and " + B + " are adjacent");
                return true;
            }

            _Edge_Manager_B_ = _Edge_Manager_B_._Next_Edge_;
        }

        System.out.println(A + " and " + B + " are not adjacent");
        return false;
    }

    /**
     * Returns the graph's degree
     * @return degree
     */
    public int getDegree() {
        return Degree;
    }

    /**
     * Console (Terminal) display of graph G in Adjacency List Form
     */
    public void _Console_Show_() {
        // Base Case 1: 
        if (V == null) {
            System.out.println("EMPTY GRAPH");
            return;
        }

        Vertex _Vertex_Manager_ = V; // Use a Manager variable to traverse the Vertex Matrix List
        while(_Vertex_Manager_ != null) {
            System.out.print("V: " + _Vertex_Manager_._get_Label_() + " { " + _Vertex_Manager_._Edges_toString_() + " }\n");
            _Vertex_Manager_ = _Vertex_Manager_._Next_Vertex_;
        }
    }
}
