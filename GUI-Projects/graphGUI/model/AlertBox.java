package graphGUI.model;

import javafx.scene.control.Alert;

public class AlertBox
{
    public static void DisplayAlert(String content)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }
    
    public static void DisplayText(String title, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setResizable(true);
        alert.showAndWait();
    }
}
