package graphGUI.model;

import javafx.scene.shape.Circle;

public class Vertex
{
    private Circle circle;
    private static final int radius = 8;
    private boolean wasVisited;
    
    public Vertex(double x, double y)
    {
        circle = new Circle(x, y, radius);
    }
    
    public Circle getCircle()
    {
        return circle;
    }
    
    public static int getRadius()
    {
        return radius;
    }
    
    public boolean wasVisited()
    {
        return wasVisited;
    }
    
    public void setVisited(boolean wasVisited)
    {
        this.wasVisited = wasVisited;
    }
    
    @Override
    public String toString()
    {
        return "Vertex{" + circle.getCenterX() + " " + circle.getCenterY() + '}';
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null) return false;
        if(!(o instanceof Vertex)) return false;
        if(this == o) return true;
        Vertex thatVertex = (Vertex) o;
        return ((getCircle().getCenterX() == thatVertex.getCircle().getCenterX()) &&
                (getCircle().getCenterY() == thatVertex.getCircle().getCenterY()));
    }
    
    @Override
    public int hashCode()
    {
        int result = (int)getCircle().getCenterX();
        result = 31 * result + (int)getCircle().getCenterY();
        return result;
    }
}
