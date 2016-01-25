package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Hello World");

        Scene scene = new Scene(root, 300, 275);


        ListView<String> listView1 = new ListView<String>();
        listView1.setItems(FXCollections.observableArrayList("Single", "Double", "Suite", "Family App"));

        ListView<String> listView2 = new ListView<String>();
        listView2.setItems(FXCollections.observableArrayList("asda", "Double", "Suite", "Family App"));

        ListView<String> listView3 = new ListView<String>();
        listView3.setItems(FXCollections.observableArrayList("Sinasddgle", "Double", "Suite", "Family App"));

        ListView<String> listView4 = new ListView<String>();
        listView4.setItems(FXCollections.observableArrayList("Singsdsdle", "Doublsdse"));

        HBox hBox = new HBox();
        hBox.getChildren().add(listView1);
        hBox.getChildren().add(listView2);
        hBox.getChildren().add(listView3);
        hBox.getChildren().add(listView4);

        root.setCenter(hBox);
        root.setTop(new Label("Test Label"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
