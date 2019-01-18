package graphGUI.controller;

import graphGUI.model.AlertBox;
import graphGUI.model.ColorGenerator;
import graphGUI.model.Edge;
import graphGUI.model.Graph;
import graphGUI.model.Vertex;
import graphGUI.util.Util;
import graphGUI.view.View;

import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class Controller
{
    private View view;
    private Graph graph;
    
    public Controller(View view)
    {
        this.view = view;
        this.graph = new Graph();
    }
    
    public void addVertex()
    {
        try
        {
            if(view.getAddVertex().isSelected())
            {
                setNull();
                view.getCenter().setOnMouseClicked(event ->
                {
                    Vertex vertex = new Vertex(event.getX(), event.getY());
                    try
                    {
                        if(!graph.addVertex(vertex)) throw new Exception("Vertex exists in the selected position.");
                        else
                        {
                            graph.addVertex(vertex);
                            view.getCenter().getChildren().add(vertex.getCircle());
                        }
                    }
                    catch(Exception ex)
                    {
                        AlertBox.DisplayAlert(ex.getMessage());
                    }
                });
            }
        }
        catch(Exception ex)
        {
            AlertBox.DisplayAlert(ex.getMessage());
        }
    }
    
    public void addEdge()
    {
        if(view.getAddEdge().isSelected())
        {
            setNull();
            view.getCenter().setOnMouseClicked(event1 ->
            {
                Vertex v1 = Util.FIND_CLOSEST_VERTEX(graph, event1.getX(), event1.getY());
                try
                {
                    if(v1 == null) throw new Exception("Click was not near vertex 1");
                    else
                    {
                        v1.getCircle().setFill(Color.GREEN);
                        view.getCenter().setOnMouseClicked(event2 ->
                        {
                            try
                            {
                                Vertex v2 = Util.FIND_CLOSEST_VERTEX(graph, event2.getX(), event2.getY());
                                if(v2 == null) throw new Exception("Click was not near vertex 2.");
                                else if(v1.equals(v2)) throw new Exception("Can't create an Edge. Vertex 1 and Vertex 2 are same.");
                                else if(graph.containsEdge(v1, v2)) throw new Exception("Vertex 1 and Vertex 2 has an edge.");
                                else
                                {
                                    Edge edge = new Edge(v1, v2);
                                    graph.addEdge(v1, v2, edge);
                                    view.getCenter().getChildren().add(edge.getLine());
                                    v1.getCircle().setFill(Color.BLACK);
                                    setNull();
                                    addEdge();
                                }
                            }
                            catch(Exception ex)
                            {
                                v1.getCircle().setFill(Color.BLACK);
                                AlertBox.DisplayAlert(ex.getMessage());
                                setNull();
                                addEdge();
                            }
                        });
                    }
                }
                catch(Exception ex)
                {
                    AlertBox.DisplayAlert(ex.getMessage());
                    setNull();
                    addEdge();
                }
            });
        }
    }
    
    public void removeVertex()
    {
        if(view.getRemoveVertex().isSelected())
        {
            setNull();
            view.getCenter().setOnMouseClicked(event ->
            {
                try
                {
                    Vertex vertex = Util.FIND_CLOSEST_VERTEX(graph, event.getX(), event.getY());
                    if(vertex == null) throw new NullPointerException("Mouse click was not on any vertices.");
                    else
                    {
                        view.getCenter().getChildren().remove(vertex.getCircle());
                        Set<Edge> edges = graph.getEdges(vertex);
                        graph.removeVertex(vertex);
                        edges.forEach(edge -> view.getCenter().getChildren().remove(edge.getLine()));
                    }
                }
                catch(NullPointerException ex)
                {
                    AlertBox.DisplayAlert(ex.getMessage());
                    removeVertex();
                }
            });
        }
    }
    
    public void removeEdge()
    {
        final double MAX_RADIUS = 15;
        if(view.getRemoveEdge().isSelected())
        {
            setNull();
            view.getCenter().setOnMouseClicked(event ->
            {
                try
                {
                    Set<Edge> edges = graph.getAllEdges();
                    Edge deleteEdge = null;
                    double dis = Integer.MAX_VALUE;
                    for(Edge edge : edges)
                    {
                        double disOfEdge = Util.DO_All(edge, event.getX(), event.getY());
                        
                        if(disOfEdge < dis)
                        {
                            deleteEdge = edge;
                            dis = disOfEdge;
                        }
                    }
    
                    if(dis <= MAX_RADIUS)
                    {
                        graph.removeEdge(deleteEdge);
                        view.getCenter().getChildren().remove(deleteEdge.getLine());
                    }
                    else throw new Exception("Click was not near enough to remove an edge.");
                    view.getCenter().requestFocus();
                }
                catch(Exception ex)
                {
                    AlertBox.DisplayAlert(ex.getMessage());
                }
                removeEdge();
            });
        }
    }
    
    public void moveVertex()
    {
        if(view.getMoveVertex().isSelected())
        {
            setNull();
            view.getCenter().setOnMousePressed(event1 ->
            {
                try
                {
                    Vertex vertex = Util.FIND_CLOSEST_VERTEX(graph, event1.getX(), event1.getY());
                    if(vertex == null) throw new
                            NullPointerException("No vertex were pressed to move to a new position.");
                    else
                    {
                        vertex.getCircle().setFill(Color.GREEN);
                        vertex.getCircle().setCursor(Cursor.HAND);
                        Set<Edge> edgeSet = graph.getEdges(vertex);
                        view.getCenter().setOnMouseReleased(event2 ->
                        {
                            if(edgeSet.size() > 0)
                            {
                                try
                                {
                                    Vertex newVertex = new Vertex(event2.getX(), event2.getY());
                                    if(graph.addVertex(newVertex))
                                    {
                                        view.getCenter().getChildren().remove(vertex.getCircle());
                                        edgeSet.forEach(edge -> view.getCenter().getChildren().remove(edge.getLine()));
                                        view.getCenter().getChildren().add(newVertex.getCircle());
                                        oldVertexEdgesToNewVertexEdges(vertex, newVertex);
                                        graph.removeVertex(vertex);
                                    }
                                    else
                                    {
                                        vertex.getCircle().setFill(Color.BLACK);
                                        throw new Exception("Vertex exists in the new position.\n" +
                                                "Not moving from the initial position.");
                                    }
                                }
                                catch(Exception ex)
                                {
                                    AlertBox.DisplayAlert(ex.getMessage());
                                }
                            }
                            else
                            {
                                Vertex vertex1 = new Vertex(event2.getX(), event2.getY());
                                if(!graph.addVertex(vertex1))
                                {
                                    event1.consume();
                                    event2.consume();
                                    vertex.getCircle().setFill(Color.BLACK);
                                    AlertBox.DisplayAlert("Vertex exists in the new position.\n" +
                                            "Not moving from the initial position.");
                                }
                                else
                                {
                                    view.getCenter().getChildren().remove(vertex.getCircle());
                                    graph.removeVertex(vertex);
                                    view.getCenter().getChildren().add(vertex1.getCircle());
                                    graph.addVertex(vertex1);
                                }
                            }
                        });
                    }
                }
                catch(NullPointerException ex)
                {
                    AlertBox.DisplayAlert(ex.getMessage());
                }
                catch(IllegalArgumentException ex)
                {
                    AlertBox.DisplayAlert(ex.getMessage());
                }
                catch(Exception ex)
                {
                    AlertBox.DisplayAlert("Select a vertex and press to move it around");
                }
            });
        }
    }
    
    private void oldVertexEdgesToNewVertexEdges(Vertex oldVertex, Vertex newVertex)
    {
        for(Vertex v1 : graph.getAllVertices())
        {
            if(v1.equals(oldVertex)) continue;
            if(graph.containsEdge(v1, oldVertex))
            {
                Edge newEdge = new Edge(v1, newVertex);
                graph.addEdge(v1, newVertex, newEdge);
                view.getCenter().getChildren().add(newEdge.getLine());
            }
        }
    }
    
    public void numOfVertices()
    {
        deselectToggleGroup();
        final String header = "Number of Vertices";
        final String content = "Total number of Vertices in the graph is: " + graph.totalVertices();
        AlertBox.DisplayText(header, content);
    }
    
    public void numOfEdges()
    {
        deselectToggleGroup();
        final String header = "Number of Edge(s)";
        final String content = "Total number of Edges in the graph is: " + graph.totalEdges();
        AlertBox.DisplayText(header, content);
    }
    
    public void numOfConnCompo()
    {
        deselectToggleGroup();
        if(graph.totalVertices() <= 0)
        {
            final String header = "Zero Connected Component in the Graph.";
            final String content = "Graph does not have any vertices. Therefore, no connected components in the graph yet.";
            AlertBox.DisplayText(header, content);
        }
        else
        {
            final String header = "Number of Connected Components";
            final String content = "Total number of Connected Components in the graph is: "
                    + Util.TOTAL_COMPONENTS(graph);
            AlertBox.DisplayText(header, content);
        }
    }
    
    public void numOfCutVertices()
    {
        deselectToggleGroup();
        if(graph.totalVertices() <= 0)
        {
            final String header = "Graph does not have any vertices";
            final String content = "Add some vertices and edges to the graph or click 'Random Graph' to generate" +
                    " a random graph for you then calculate Cut Vertices'.";
            AlertBox.DisplayText(header, content);
        }
        else
        {
            final String header = "NUmber of Cut Vertices";
            final String content = "Total number of Cut Vertices in the graph is: "
                    + Util.TOTAL_CUT_VERTICES(graph);
            AlertBox.DisplayText(header, content);
        }
    }
    
    public void addAllEdges()
    {
        try
        {
            if(graph.totalVertices() == 0) throw new NoSuchElementException("No vertices in the graph yet\n" +
                    "Setting Radio Button 'Add Vertex' to add vertex and then to add all edges");
            else if(graph.totalVertices() == 1) throw new Exception("Graph has only 1 vertex\n" +
                    "Setting Radio Button 'Add Vertex' to add more vertex and then to add all edges");
            else
            {
                deselectToggleGroup();
                addAllPossibleEdges();
            }
        }
        catch(NoSuchElementException ex)
        {
            AlertBox.DisplayAlert(ex.getMessage());
            view.getAddVertex().setSelected(true);
            addVertex();
        }
        catch(Exception ex)
        {
            AlertBox.DisplayAlert(ex.getMessage());
            view.getAddVertex().setSelected(true);
            addVertex();
        }
    }
    
    private void addAllPossibleEdges()
    {
        for(Vertex v1 : graph.getAllVertices())
        {
            for(Vertex v2 : graph.getAllVertices())
            {
                if(v1.equals(v2)) continue;
                if(graph.containsEdge(v1, v2)) continue;
                else
                {
                    Edge edge = new Edge(v1, v2);
                    graph.addEdge(v1, v2, edge);
                    view.getCenter().getChildren().add(edge.getLine());
                }
            }
        }
    }
    
    public void connectedComponents()
    {
        if(graph.totalVertices() < 1)
        {
            AlertBox.DisplayAlert("Graph does not have any vertices to show connected components.");
        }
        else
        {
            deselectToggleGroup();
            
            final ColorGenerator colorGenerator = new ColorGenerator();
    
            Set<Vertex> all = graph.getAllVertices();
            Set<Vertex> visited = Util.BFS(graph, all);
            Color color = colorGenerator.getAColor();
            colorVisited(visited, color);
            
            while(visited.size() != graph.totalVertices())
            {
                Set<Vertex> toVisit = Util.DIFFERENCE(all, visited);
                Set<Vertex> visited2 = Util.BFS(graph, toVisit);
                visited.addAll(visited2);
                color = colorGenerator.getAColor();
                colorVisited(visited2, color);
            }
            Util.SET_ALL_UNVISITED(graph);
        }
    }
    
    public void showCutVertices()
    {
        deselectToggleGroup();
        
        Set<Vertex> cutVertices = new LinkedHashSet <>();
        
        int components = Util.TOTAL_COMPONENTS(graph);
        for(Vertex vertex : graph.getAllVertices())
        {
            Set<Edge> edges = graph.getEdges(vertex);
            graph.removeVertex(vertex);
            if(components < Util.TOTAL_COMPONENTS(graph)) cutVertices.add(vertex);
            Util.ADD_BACK(graph, vertex, edges);
        }
        colorVisited(cutVertices, Color.RED);
    }
    
    public void doBFS()
    {
        deselectToggleGroup();
        
        final ColorGenerator colorGenerator = new ColorGenerator();
        Color color = colorGenerator.getAColor();
        
        Set<Vertex> all = graph.getAllVertices();
        Set<Vertex> visited = Util.BFS(graph, all);
        sleepColor(visited, color);
    
        while(visited.size() != graph.totalVertices())
        {
            Set<Vertex> toVisit = Util.DIFFERENCE(all, visited);
            Set<Vertex> visited2 = Util.BFS(graph, toVisit);
            sleepColor(visited2, color);
            visited.addAll(visited2);
        }
        Util.SET_ALL_UNVISITED(graph);
    }
    
    private void sleepColor(Set<Vertex> visited, Color color)
    {
        for(Vertex vertex : visited)
        {
            vertex.getCircle().setFill(color);
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void doDFS()
    {
        deselectToggleGroup();
    }
    
    private void colorVisited(Set<Vertex> visited, Color color)
    {
        for(Vertex vertex : visited) vertex.getCircle().setFill(color);
    }
    
    public void shortestPath()
    {
        if(view.getShortestPath().isSelected())
        {
            setNull();
            view.getCenter().setOnMouseClicked(event1 ->
            {
                view.getCenter().setOnMouseClicked(event2 ->
                {
                    //
                });
            });
        }
    }
    
    public void generateGraph()
    {
        deselectToggleGroup();
        
        if(graph.totalVertices() <= 0)
        {
            graph = Util.GENERATE_RANDOM_GRAPH();
            for(Vertex vertex : graph.getAllVertices()) view.getCenter().getChildren().add(vertex.getCircle());
            addAllPossibleEdges();
        }
        else
        {
            AlertBox.DisplayAlert("There is an existing graph. Please click 'Delete' button to delete that graph " +
                    "and then click this button to generate a new graph.");
        }
    }
    
    public void deleteGraph()
    {
        deselectToggleGroup();
        
        if(graph.totalVertices() < 1)
        {
            AlertBox.DisplayText("Graph does not exist!", "There exists no graph. " +
                    "Click 'Random Graph' to generate a random graph.");
        }
        else
        {
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want to delete the graph?", yes, no);
    
            alert.setTitle("Deleting the graph?");
            Optional<ButtonType> result = alert.showAndWait();
    
            if (result.orElse(no) == yes)
            {
                graph.clear();
                view.getCenter().getChildren().clear();
            }
        }
    }
    
    public void help()
    {
        Alert help = new Alert(Alert.AlertType.INFORMATION);
        help.setTitle("Help");
        help.setHeaderText("Information regarding how to use 'Graph GUI' will be here");
        help.setContentText("Help window");
        help.setHeight(500);
        help.setWidth(600);
        help.setResizable(true);
        help.showAndWait();
    }
    
    public void aboutTheGraph()
    {
    
    }
    
    private void setNull()
    {
        view.getCenter().setOnMouseClicked(null);
        view.getCenter().setOnMousePressed(null);
        view.getCenter().setOnMouseDragged(null);
        view.getCenter().setOnMouseReleased(null);
    }
    
    private void deselectToggleGroup()
    {
        if(view.getToggleGroup().getSelectedToggle() != null)
        {
            view.getToggleGroup().getSelectedToggle().setSelected(false);
            setNull();
        }
    }
}
