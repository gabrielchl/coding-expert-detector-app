package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.List;

public class Main extends Application {

    @FXML
    private javafx.scene.control.Label closeBtn;
    @FXML
    private javafx.scene.control.Button fileSelectBtn;
    private ObservableList<FeaturesData> featuresDataList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void selectFileTrigger(ActionEvent actionEvent) throws Exception {
        FileChooser fileChooser = new FileChooser();
        List<File> files = fileChooser.showOpenMultipleDialog(fileSelectBtn.getScene().getWindow());
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "result.fxml"
            )
        );
        fileSelectBtn.getScene().setRoot(loader.load());
        ResultController controller = loader.getController();
        controller.setFiles(files);
        featuresDataList.removeAll();
    }

    public ObservableList<FeaturesData> getFeaturesDataList() {
        featuresDataList.setAll(new FeaturesData(
                "filename", "pro", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12", "13", "14"
        ));
        return featuresDataList;
    }

    public void closeWindow(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
