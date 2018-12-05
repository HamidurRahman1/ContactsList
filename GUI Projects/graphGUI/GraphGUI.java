package graphGUI;

import graphGUI.view.View;

import javafx.application.Platform;

public class GraphGUI extends View
{
    public static void main(String[] args)
    {
        try
        {
            View.launch();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage() + "\n" + ex.getCause() + "\n" + ex.getStackTrace().toString());
            Platform.exit();
        }
    }
}
