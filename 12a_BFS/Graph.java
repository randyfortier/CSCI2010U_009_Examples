import java.util.*;
import java.util.concurrent.*;

public class Graph {
   private class Vertex {
      private String name;
      private List<Vertex> adjacencies;

      public boolean isVisited = false;
      public Vertex parent = null;

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

   // BFS
   Vertex bfs(String startVertexName, String goalVertexName) 
                     throws InterruptedException {
      Vertex startVertex = getVertex(startVertexName);
      startVertex.parent = null;
      startVertex.isVisited = true;

      LinkedBlockingQueue<Vertex> queue = new LinkedBlockingQueue<>();
      queue.put(startVertex);

      while (queue.size() > 0) {
         Vertex v = queue.remove();

         if (v.getName().equals(goalVertexName)) {
            return v;
         }

         // search adjacencies of v
         List<Vertex> adjacencies = v.getAdjacencies();
         for (Vertex w : adjacencies) {
            if (!w.isVisited) {
               w.isVisited = true;
               w.parent = v;
               queue.put(w);
            }
         }
      }

      return null;
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

      // test BFS
      try {
         Vertex current = graph.bfs("A", "E");

         if (current == null) {
            System.out.println("No path found from A to E");
         } else {
            while (current != null) {
               System.out.print(current.getName() + " <- ");
               current = current.parent;
            }
         }
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}
