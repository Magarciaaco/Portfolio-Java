/**
 * Window is a test class for and instanced object Graph
 */
public class Window {
    public static void main(String[] args) {
        Graph G = new Graph();

        System.out.println("TEST 1: ");
        G._Add_Vertex_("V1");
        G._Add_Vertex_("V2", "V2", "V1");
        G._Set_Vertex_Edge_("V1", "V1", "V2");
        G._Add_Vertex_("V3");
        G._Console_Show_();
        
        if (!G._is_Adjacent("V3", "V2"))
            G._Set_Vertex_Edge_("V3", "V3", "V2");
        
        
            System.out.println("\nTEST 2: ");
        if(G._is_Adjacent("V3", "V2"))
            G._Console_Show_();
    }
}