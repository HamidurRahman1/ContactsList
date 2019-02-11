package graphGUI.model;

import javafx.scene.paint.Color;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class ColorGenerator
{
    private final Set<Color> colorSet;
    private Random random;
    
    public ColorGenerator()
    {
        random = new Random();
        colorSet = new LinkedHashSet <>();
    }
    
    public Color getAColor()
    {
        final Color black = Color.BLACK;
        int red = random.nextInt(128) + 128;
        int blue = random.nextInt(128) + 128;
        int green = random.nextInt(128) + 128;
        Color color = Color.rgb(red, green, blue);
        
        while(!colorSet.add(color) && !black.equals(color))
        {
            red = random.nextInt(128) + 128;
            blue = random.nextInt(128) + 128;
            green = random.nextInt(128) + 128;
            color = Color.rgb(red, green, blue);
        }
        return color;
    }
}
