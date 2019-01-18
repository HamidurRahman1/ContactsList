package graphGUI.model;

import graphGUI.util.Util;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Graph
{
    private Map<Vertex, Set<Edge>> vertexSetMap;
    private Set<Edge> edgeSet;
    
    public Graph()
    {
        edgeSet = new LinkedHashSet<>();
        vertexSetMap = new LinkedHashMap<>();
    }
    
    public boolean addVertex(Vertex vertex)
    {
        if(Util.FIND_CLOSEST_VERTEX(this, vertex.getCircle().getCenterX(), vertex.getCircle().getCenterY()) == null)
        {
            vertexSetMap.put(vertex, new LinkedHashSet <>());
            return true;
        }
        return false;
    }
    
    public boolean addEdge(Vertex v1, Vertex v2, Edge edge)
    {
        if(edgeSet.add(edge))
        {
            vertexSetMap.get(v1).add(edge);
            vertexSetMap.get(v2).add(edge);
            return true;
        }
        return false;
    }
    
    public Set<Edge> getEdges(Vertex vertex)
    {
        return vertexSetMap.get(vertex);
    }
    
    public Set<Vertex> getNeighborsOf(Vertex vertex)
    {
        Set<Vertex> neighbors = new LinkedHashSet <>();
        for(Edge edge : vertexSetMap.get(vertex))
        {
            Vertex v1 = edge.getVertex1();
            Vertex v2 = edge.getVertex2();
            if(v1.equals(vertex)) neighbors.add(v2);
            else neighbors.add(v1);
        }
        return neighbors;
    }
    
    public void removeVertex(Vertex vertex)
    {
        Set<Edge> deleteEdges = getEdges(vertex);
        vertexSetMap.remove(vertex);
        edgeSet.removeAll(deleteEdges);
        vertexSetMap.keySet().forEach(vertex1 -> vertexSetMap.get(vertex1).removeAll(deleteEdges));
    }
    
    public void removeEdge(Edge edge)
    {
        edgeSet.remove(edge);
        Vertex v1 = edge.getVertex1();
        Vertex v2 = edge.getVertex2();
        vertexSetMap.get(v1).remove(edge);
        vertexSetMap.get(v2).remove(edge);
    }
    
    public boolean containsVertex(Vertex vertex)
    {
        return vertexSetMap.containsKey(vertex);
    }
    
    public boolean containsEdge(Vertex v1, Vertex v2, Edge edge)
    {
        return (edgeSet.contains(edge) && vertexSetMap.get(v1).contains(edge)
                && vertexSetMap.get(v2).contains(edge));
    }
    
    public boolean containsEdge(Vertex v1, Vertex v2)
    {
        for(Edge e : vertexSetMap.get(v1)) if(vertexSetMap.get(v2).contains(e)) return true;
        return false;
    }
    
    public int totalVertices()
    {
        return vertexSetMap.keySet().size();
    }
    
    public int totalEdges()
    {
        return edgeSet.size();
    }
    
    public Set<Vertex> getAllVertices()
    {
        return new LinkedHashSet <>(vertexSetMap.keySet());
    }
    
    public Set<Edge> getAllEdges()
    {
        return edgeSet;
    }
    
    public void clear()
    {
        edgeSet = null;
        edgeSet = new LinkedHashSet <>();
        vertexSetMap = null;
        vertexSetMap = new LinkedHashMap <>();
    }
}
