package FXtest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.lang.math.NumberUtils;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 250, 125);
        stage.setScene(scene);
        stage.setTitle("String Check");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scene.setRoot(grid);

        final TextField field = new TextField();
        field.setPromptText("Enter your String");
        field.setPrefColumnCount(10);
        field.getText();
        GridPane.setConstraints(field, 0, 0);
        grid.getChildren().add(field);

        final Button button = new Button("Check");
        GridPane.setConstraints(button, 1, 0);
        grid.getChildren().add(button);

        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);


        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (NumberUtils.isNumber(field.getText())) {
                    label.setText("Your String is a number");
                } else {
                    label.setText("It's not a number");
                }
            }
        });

        stage.show();

    }
}
