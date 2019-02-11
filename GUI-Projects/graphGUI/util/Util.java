package graphGUI.util;

import graphGUI.model.Edge;
import graphGUI.model.Graph;
import graphGUI.model.Vertex;
import javafx.scene.shape.Circle;

import java.awt.geom.Line2D;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Util
{
    public static void SET_ALL_UNVISITED(Graph graph)
    {
        graph.getAllVertices().forEach(vertex -> vertex.setVisited(false));
    }
    
    public static Set <Vertex> DIFFERENCE(Set<Vertex> set1, Set<Vertex> set2)
    {
        Set<Vertex> set = new LinkedHashSet <>(set1);
        set.removeAll(set2);
        return set;
    }
    
    public static Set<Vertex> BFS(Graph graph, Set<Vertex> toVisit)
    {
        Set<Vertex> visited = new LinkedHashSet <>();
        try
        {
            Vertex vertex = toVisit.iterator().next();
            vertex.setVisited(true);
            visited.add(vertex);
            Queue <Vertex> queue = new ConcurrentLinkedQueue <>();
            queue.add(vertex);
            while(!queue.isEmpty())
            {
                Vertex v = queue.poll();
                Set<Vertex> neighbors = graph.getNeighborsOf(v);
                for(Vertex v1 : neighbors)
                {
                    if(!v1.wasVisited())
                    {
                        queue.add(v1);
                        v1.setVisited(true);
                        visited.add(v1);
                    }
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return visited;
    }
    
    public static int TOTAL_COMPONENTS(Graph graph)
    {
        Set<Vertex> all = graph.getAllVertices();
        Set<Vertex> visited = BFS(graph, all);
        if(visited.size() <= 0) return 0;
        int i = 1;
        
        while(visited.size() != graph.totalVertices())
        {
            visited.addAll(BFS(graph, DIFFERENCE(all, visited)));
            i++;
        }
        SET_ALL_UNVISITED(graph);
        return i;
    }
    
    public static int TOTAL_CUT_VERTICES(Graph graph)
    {
        int components = Util.TOTAL_COMPONENTS(graph);
        int i = 0;
        for(Vertex vertex : graph.getAllVertices())
        {
            Set<Edge> edges = graph.getEdges(vertex);
            graph.removeVertex(vertex);
            if(components < Util.TOTAL_COMPONENTS(graph)) i++;
            Util.ADD_BACK(graph, vertex, edges);
        }
        return i;
    }
    
    public static void ADD_BACK(Graph graph, Vertex vertex, Set<Edge> edges)
    {
        graph.addVertex(vertex);
        for(Edge edge : edges)
        {
            Vertex v1 = edge.getVertex1();
            if(v1.equals(vertex))
            {
                graph.addEdge(edge.getVertex2(), vertex, edge);
            }
            else
            {
                graph.addEdge(v1, vertex, edge);
            }
        }
    }
    
    public static double DO_All(Edge edge1, double x3, double y3)
    {
        //        double m = SLOPE(edge);
        //        double b = CALCULATE_yINTERCEPT(m, edge.getVertex1());
        //        return DISTANCE_OfP3FromSL(m, b, x3, y3);
        
        double x1 = edge1.getVertex1().getCircle().getCenterX();
        double y1 = edge1.getVertex1().getCircle().getCenterY();
        double x2 = edge1.getVertex2().getCircle().getCenterX();
        double y2 = edge1.getVertex2().getCircle().getCenterY();
        
        Line2D edge = new Line2D.Double(x1, y1, x2, y2);
        return edge.ptLineDist(x3, y3);
    }
    
    public static double DISTANCE_OfP3FromSL(double slope, double b, double x3, double y3)
    {
        double By = 1*y3;
        double Ax = -1*slope*x3;
        double C = -1*b;
        double numerator = Math.abs(Ax+By+C);
        double denominator = Math.sqrt((slope*slope) + 1);
        return (numerator/denominator);
    }
    
    public static double CALCULATE_yINTERCEPT(double slope, Vertex v)
    {
        double y1 = v.getCircle().getCenterY();
        double x1 = v.getCircle().getCenterX();
        return y1 - (slope*x1);
    }
    
    public static double SLOPE(Edge edge1)
    {
        double y2 = edge1.getLine().getEndY();
        double x2 = edge1.getLine().getEndX();
        
        double y1 = edge1.getLine().getStartY();
        double x1 = edge1.getLine().getStartX();
        
        return (y2-y1)/(x2-x1);
    }
    
    public static Vertex FIND_CLOSEST_VERTEX(Graph graph, double x, double y)
    {
        return FIND_VERTEX(graph, new Vertex(x, y));
    }
    
    public static Vertex FIND_VERTEX(Graph graph, Vertex fakeVertex)
    {
        Vertex target = null;
        for(Vertex v : graph.getAllVertices())
        {
            if(ARE_INTERSECTING(v.getCircle(), fakeVertex.getCircle()))
            {
                target = v;
                return target;
            }
        }
        return target;
    }
    
    public static boolean ARE_INTERSECTING(Circle existingCircle, Circle clickedCircle)
    {
        double d = Math.sqrt((Math.abs((clickedCircle.getCenterX()-existingCircle.getCenterX()))
                * Math.abs((clickedCircle.getCenterX()-existingCircle.getCenterX())))
                + (Math.abs(clickedCircle.getCenterY()-existingCircle.getCenterY()))
                * (Math.abs(clickedCircle.getCenterY()-existingCircle.getCenterY())));
        return (d <= Vertex.getRadius() && d >= 0);
    }
    
    public static Graph GENERATE_RANDOM_GRAPH()
    {
        final int xy = 580;
        final Random random = new Random();
        final int numVertices = random.nextInt(8)+2;
        
        Graph graph = new Graph();
        
        GENERATE_N_VERTICES(graph, numVertices, xy);
        
        return graph;
    }
    
    private static void GENERATE_N_VERTICES(Graph graph, final int numVertices, final int xy)
    {
        Random rand = new Random();
        Vertex vertex;
        do
        {
            vertex = new Vertex(rand.nextInt(xy)+20, rand.nextInt(xy)+10);
            graph.addVertex(vertex);
        }
        while(graph.totalVertices() <= numVertices);
    }
}
