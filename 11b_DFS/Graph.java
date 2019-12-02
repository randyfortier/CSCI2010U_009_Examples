import java.util.*;

public class Graph {
   private class Vertex {
      private String name;
      private List<Vertex> adjacencies;

      public Vertex(String name) {
         this.name = name;
         adjacencies = new ArrayList<>();
      }

      public String getName() { return this.name; }

      public void addAdjacency(Vertex other) {
         adjacencies.add(other);
      }

      public List<Vertex> getAdjacencies() { return adjacencies; }

      public int getDegree() {
         return adjacencies.size();
      }
   }

   private class Edge {
      private Vertex v1;
      private Vertex v2;

      public Edge(Vertex v1, Vertex v2) {
         this.v1 = v1;
         this.v2 = v2;
      }

      public Vertex getVertex1() { return v1; }
      public Vertex getVertex2() { return v2; }
   }

   private HashMap<String, Vertex> vertices;

   public Graph() {
      vertices = new HashMap<>();
   }

   public void addVertex(String name) {
      vertices.put(name, new Vertex(name));
   }

   public void addEdge(String v1name, String v2name) {
      // collect the references to each vertex
      Vertex v1 = vertices.get(v1name);
      Vertex v2 = vertices.get(v2name);

      // add an adjacency from v1 to v2 AND an adjacency from v2 to v1
      v1.addAdjacency(v2);
      v2.addAdjacency(v1);
   }

   public Vertex getVertex(String name) {
      return vertices.get(name);
   }

   public Set<Vertex> visited;
   public Map<Vertex, Edge> discoveryEdges;

   // implement DFS
   public void dfs(String startingVertexName) {
      Vertex startingVertex = vertices.get(startingVertexName);

      visited = new HashSet<>();
      discoveryEdges = new HashMap<>();

      dfs(startingVertex);
   }

   private void dfs(Vertex u) {
      visited.add(u); // u is now visited

      List<Vertex> adjacencies = u.getAdjacencies();
      for (Vertex v : adjacencies) {
         if (!visited.contains(v)) {
            // remember discovery edge
            discoveryEdges.put(v, new Edge(v, u));

            // recursively DFS v
            dfs(v);
         }
      }
   }

   public static void main(String[] args) {
      Graph graph = new Graph();

      graph.addVertex("A");
      graph.addVertex("B");
      graph.addVertex("C");
      graph.addVertex("D");
      graph.addVertex("E");

      graph.addEdge("A", "B");
      graph.addEdge("A", "C");
      graph.addEdge("B", "D");
      graph.addEdge("C", "D");
      graph.addEdge("B", "E");
      graph.addEdge("D", "E");

      // test DFS
      graph.dfs("E");

      System.out.println("Visited vertices:");
      for (Vertex v : graph.visited) {
         System.out.println("\t" + v.getName());
      }

      System.out.println("Discovery edges:");
      for (Vertex v : graph.discoveryEdges.keySet()) {
         Edge e = graph.discoveryEdges.get(v);
         System.out.println("\t(" + e.getVertex1().getName() + 
                           ", " + e.getVertex2().getName() + ")");
      }
   }
}
