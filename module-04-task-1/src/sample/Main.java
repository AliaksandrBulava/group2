package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.bean.Result;
import sample.bean.ResultAdapter;
import sample.bean.Task;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();
        primaryStage.setTitle("Hello World");

        Scene scene = new Scene(root, 500, 375);

        List<Task> tasks = new ArrayList<Task>();
        List<Result> results = new ArrayList<Result>();


        ListView<Task> taskListView = new ListView<Task>();
        ListView<Result> resultListView = new ListView<Result>();

        Button addButton = new Button("Add Task");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                final Stage dialog = createAddDialog(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Task task = new Task();
                        Button button = (Button) event.getSource();
                        ObservableList observableList = button.getParent().getChildrenUnmodifiable();

                        HBox descriptionHBox = (HBox) observableList.get(0);
                        TextField descriptionInput = (TextField) descriptionHBox.getChildren().get(1);
                        String description = descriptionInput.getText();

                        HBox timeHBox = (HBox) observableList.get(1);
                        TextField timeInput = (TextField) timeHBox.getChildren().get(1);
                        String time = timeInput.getText();

                        task.setDescription(description);
                        task.setScheduledTime(Integer.valueOf(time));
                        task.setStatus("New");

                        if (tasks != null) {
                            tasks.add(task);
                            taskListView.setItems((FXCollections.observableArrayList(tasks)));
                        }

                        Stage dialog = (Stage) button.getScene().getWindow();
                        dialog.close();
                    }
                });
                dialog.show();
            }
        });

        Button completeButton = new Button("Complete");
        completeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task task = taskListView.getSelectionModel().getSelectedItem();
                if (task != null) {
                    ResultAdapter resultAdapter = new ResultAdapter(task);

                    final Stage dialog = createCompliteDialog(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Button button = (Button) event.getSource();
                            ObservableList observableList = button.getParent().getChildrenUnmodifiable();

                            HBox timeHBox = (HBox) observableList.get(0);
                            TextField timeInput = (TextField) timeHBox.getChildren().get(1);
                            String time = timeInput.getText();

                            resultAdapter.setResultSpentTime(Integer.valueOf(time));
                            resultAdapter.setResultStatus("Complete");

                            if (resultAdapter != null) {
                                results.add(resultAdapter);
                                tasks.remove(task);
                                taskListView.setItems((FXCollections.observableArrayList(tasks)));
                                resultListView.setItems((FXCollections.observableArrayList(results)));
                            }

                            Stage dialog = (Stage) button.getScene().getWindow();
                            dialog.close();
                        }
                    });
                    dialog.show();
                }
            }
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task task = taskListView.getSelectionModel().getSelectedItem();
                if (task != null) {
                    ResultAdapter resultAdapter = new ResultAdapter(task);
                    resultAdapter.setResultStatus("Canceled");
                    results.add(resultAdapter);
                    tasks.remove(task);
                    taskListView.setItems((FXCollections.observableArrayList(tasks)));
                    resultListView.setItems((FXCollections.observableArrayList(results)));
                }
            }
        });
        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(addButton);
        buttonBox.getChildren().add(completeButton);
        buttonBox.getChildren().add(cancelButton);

        HBox hBox = new HBox();
        hBox.getChildren().add(taskListView);
        hBox.getChildren().add(resultListView);

        root.setCenter(hBox);
        root.setTop(buttonBox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Stage createCompliteDialog(EventHandler<ActionEvent> eventHandler) {

        final Stage dialog = new Stage();
        VBox hBox = new VBox();

        dialog.setTitle("Add Task");


        HBox timeHBox = new HBox(20);
        timeHBox.getChildren().add(new Text("Spent Time"));
        timeHBox.getChildren().add(new TextField());
        timeHBox.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Complete");
        addButton.setOnAction(eventHandler);
        addButton.setAlignment(Pos.CENTER);

        hBox.getChildren().add(timeHBox);
        hBox.getChildren().add(addButton);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        Scene dialogScene = new Scene(hBox, 300, 150);
        dialog.setScene(dialogScene);
        dialog.setResizable(false);

        return dialog;
    }

    private Stage createAddDialog(EventHandler<ActionEvent> eventHandler) {

        final Stage dialog = new Stage();
        VBox hBox = new VBox();

        dialog.setTitle("Add Task");

        HBox descriptionHBox = new HBox(20);
        descriptionHBox.getChildren().add(new Text("Description"));
        descriptionHBox.getChildren().add(new TextField());
        descriptionHBox.setPadding(new Insets(10, 10, 10, 10));

        HBox timeHBox = new HBox(20);
        timeHBox.getChildren().add(new Text("Scheduled Time"));
        timeHBox.getChildren().add(new TextField());
        timeHBox.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Add");
        addButton.setOnAction(eventHandler);
        addButton.setAlignment(Pos.CENTER);

        hBox.getChildren().add(descriptionHBox);
        hBox.getChildren().add(timeHBox);
        hBox.getChildren().add(addButton);
        hBox.setPadding(new Insets(10, 10, 10, 10));



        Scene dialogScene = new Scene(hBox, 300, 150);
        dialog.setScene(dialogScene);
        dialog.setResizable(false);

        return dialog;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
