package graphGUI.view;

import graphGUI.controller.Controller;
import graphGUI.style.CommonStyle;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application
{
    private Controller controller;
    private BorderPane borderPane;

    private ToggleGroup toggleGroup;
    
    private RadioButton addVertex;
    private RadioButton addEdge;
    private RadioButton removeVertex;
    private RadioButton removeEdge;
    private RadioButton moveVertex;
    
    private Pane center;

    @Override
    public void start(Stage primaryStage)
    {
        final String title = "Graph GUI";
    
        initialize();
    
        Scene mainScene = new Scene(borderPane, 1000, 900);
        
        primaryStage.setMinWidth(700);
        primaryStage.setMinHeight(750);
        primaryStage.setTitle(title);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    private void initialize()
    {
        borderPane = new BorderPane();
        center = new Pane();
        toggleGroup = new ToggleGroup();
    
        MenuBar top = setTop();
        HBox bottom = setBottom();
        VBox left = setLeftSide();
    
        borderPane.setTop(top);
        borderPane.setBottom(bottom);
        borderPane.setLeft(left);
        borderPane.setCenter(center);
        
        controller = new Controller(this);
    }
    
    private MenuBar setTop()
    {
        final MenuBar menuBar = new MenuBar();
        final Menu about = new Menu("About");
        about.setStyle(CommonStyle.Fm_Fs_Fw());
        final Menu help = new Menu("Help");
        help.setStyle(CommonStyle.Fm_Fs_Fw());
        final MenuItem aboutMI = new MenuItem("About");
        final MenuItem helpMI = new MenuItem("Help");
        
        about.getItems().add(aboutMI);
        help.getItems().add(helpMI);
        menuBar.getMenus().addAll(about, help);
        
        aboutMI.setOnAction(e -> controller.aboutTheGraph());
        helpMI.setOnAction(e -> controller.help());
    
        return menuBar;
    }
    
    private HBox setBottom()
    {
        final Label label = new Label("Developed By: Hamidur Rahman");
        label.setStyle(CommonStyle.LabelStyle());
        final HBox hBox = new HBox(label);
        hBox.setPrefWidth(center.getPrefWidth());
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle(CommonStyle.VBoxCSS());
        return hBox;
    }

    private VBox setLeftSide()
    {
        final VBox vBox = new VBox();
        
        addVertex = new RadioButton("Add Vertex");
        addVertex.setToggleGroup(toggleGroup);
        addVertex.setStyle(CommonStyle.RadioButtonCSS());
        addVertex.setOnAction(e -> controller.addVertex());

        addEdge = new RadioButton("Add Edge");
        addEdge.setToggleGroup(toggleGroup);
        addEdge.setStyle(CommonStyle.RadioButtonCSS());
        addEdge.setOnAction(e -> controller.addEdge());

        removeVertex = new RadioButton("Remove Vertex");
        removeVertex.setToggleGroup(toggleGroup);
        removeVertex.setStyle(CommonStyle.RadioButtonCSS());
        removeVertex.setOnAction(e -> controller.removeVertex());

        removeEdge = new RadioButton("Remove Edge");
        removeEdge.setToggleGroup(toggleGroup);
        removeEdge.setStyle(CommonStyle.RadioButtonCSS());
        removeEdge.setOnAction(e -> controller.removeEdge());

        moveVertex = new RadioButton("Move Vertex");
        moveVertex.setToggleGroup(toggleGroup);
        moveVertex.setStyle(CommonStyle.RadioButtonCSS());
        moveVertex.setOnAction(e -> controller.moveVertex());
        
        Button numOfVertices = new Button("# of Vertices");
        numOfVertices.setStyle(CommonStyle.ButtonCSS());
        numOfVertices.setOnAction(e -> controller.numOfVertices());
    
        Button numOfEdges = new Button("# of Edges");
        numOfEdges.setStyle(CommonStyle.ButtonCSS());
        numOfEdges.setOnAction(e -> controller.numOfEdges());
    
        Button numOfConnectedComp = new Button("# of Conn. Comps");
        numOfConnectedComp.setStyle(CommonStyle.ButtonCSS());
        numOfConnectedComp.setOnAction(e -> controller.numOfConnCompo());
    
        Button numOfCutVer = new Button("# of Cut Vertices");
        numOfCutVer.setStyle(CommonStyle.ButtonCSS());
        numOfCutVer.setOnAction(e -> controller.numOfCutVertices());

        Button addAllEdges = new Button("Add All Edges");
        addAllEdges.setStyle(CommonStyle.ButtonCSS());
        addAllEdges.setOnAction(e -> controller.addAllEdges());

        Button connectedComponents = new Button("Connected Comps");
        connectedComponents.setStyle(CommonStyle.ButtonCSS());
        connectedComponents.setOnAction(e -> controller.connectedComponents());

        Button showCutVertices = new Button("Show Cut Vertices");
        showCutVertices.setStyle(CommonStyle.ButtonCSS());
        showCutVertices.setOnAction(e -> controller.showCutVertices());
        
        Button generateRandGraph = new Button("Random Graph");
        generateRandGraph.setStyle(CommonStyle.RandomGraphCSS());
        generateRandGraph.setOnAction(e -> controller.generateGraph());
        
        Button deleteGraph = new Button("Delete Graph");
        deleteGraph.setStyle(CommonStyle.DeleteGraphCSS());
        deleteGraph.setOnAction(e -> controller.deleteGraph());
    
        final String dashedString = "-----------------";
        
        vBox.getChildren().add(addVertex);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(addEdge);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(removeVertex);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(removeEdge);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(moveVertex);
        
        vBox.getChildren().add(separatorLabel(dashedString));
        
        vBox.getChildren().add(numOfVertices);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(numOfEdges);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(numOfConnectedComp);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(numOfCutVer);
        
        vBox.getChildren().add(separatorLabel(dashedString));
        
        vBox.getChildren().add(addAllEdges);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(connectedComponents);
        vBox.getChildren().add(new Separator());
        vBox.getChildren().add(showCutVertices);
        
        vBox.getChildren().add(separatorLabel(dashedString));
    
        vBox.getChildren().add(generateRandGraph);
        
        vBox.getChildren().add(separatorLabel(dashedString));
        
        vBox.getChildren().add(deleteGraph);
        
        vBox.setStyle(CommonStyle.VBoxCSS());
        return vBox;
    }
    
    private Label separatorLabel(String string)
    {
        final Label label = new Label(string);
        label.setStyle(CommonStyle.LabelStyle());
        return label;
    }
    
    public Pane getCenter()
    {
        return center;
    }
    
    public RadioButton getAddVertex()
    {
        return addVertex;
    }
    
    public RadioButton getAddEdge()
    {
        return addEdge;
    }
    
    public RadioButton getRemoveVertex()
    {
        return removeVertex;
    }
    
    public RadioButton getMoveVertex()
    {
        return moveVertex;
    }
    
    public RadioButton getRemoveEdge()
    {
        return removeEdge;
    }
    
    public ToggleGroup getToggleGroup()
    {
        return toggleGroup;
    }
}
