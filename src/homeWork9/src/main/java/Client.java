import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Master on 13.08.2016.
 */
public class Client extends Application {
    private static final double DOUBLE_SPACE = 10.0D;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox(DOUBLE_SPACE);
        vBox.setPadding(new Insets(DOUBLE_SPACE, DOUBLE_SPACE, DOUBLE_SPACE, DOUBLE_SPACE));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(DOUBLE_SPACE);
        gridPane.setVgap(DOUBLE_SPACE);

        Label loginLabel = new Label("Login:");
        TextField loginTextField = new TextField();

        Label messageLabel = new Label("Message:");
        TextArea messageTextArea = new TextArea();
        messageTextArea.setPrefRowCount(3);

        gridPane.getChildren().addAll(loginLabel, loginTextField, messageLabel, messageTextArea);
        GridPane.setConstraints(loginLabel, 0, 0);
        GridPane.setConstraints(loginTextField, 1, 0);
        GridPane.setConstraints(messageLabel, 0, 1);
        GridPane.setConstraints(messageTextArea, 1, 1);

        VBox alignVBox = new VBox();
        alignVBox.setSpacing(DOUBLE_SPACE);
        Button sendButton = new Button("Send");
        //sendButton.setOnAction();
        alignVBox.getChildren().addAll(sendButton, new Label("Messages:"));
        alignVBox.setAlignment(Pos.CENTER);

        TextArea inMessagesTextArea = new TextArea();

        vBox.getChildren().addAll(gridPane, alignVBox, inMessagesTextArea);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MessageClient");
        primaryStage.show();
    }
}
