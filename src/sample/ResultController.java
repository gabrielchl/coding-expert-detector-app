package sample;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.net.URI;

import org.apache.commons.text.StringEscapeUtils;

public class ResultController {
    @FXML
    private javafx.scene.control.Label closeBtn;
    @FXML
    private javafx.scene.control.TableView table;
    List<File> files;

    void initialize() {
        System.out.println("init");
    }

    void setFiles(List<File> files) throws IOException, InterruptedException {
        this.files = files;
        for (File file : files) {

            String requestBody = "code=" + URLEncoder.encode(Files.readString(file.toPath()), StandardCharsets.UTF_8);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:5000/api/get-class-and-features"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
            String[] params = response.body().split("\n");
            if (params[0].equals("1.0")) {
                params[0] = "Expert";
            } else {
                params[0] = "Novice";
            }

            table.getItems().add(new FeaturesData(
                file.getName(), params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8], params[9], params[10], params[11], params[12], params[13], params[14]
            ));
        }
    }

//    public ObservableList<FeaturesData> getFeaturesDataList() {
//        List list = new ArrayList();
//        for (File file : files) {
//            list.add(new FeaturesData(
//                file.getName(), "pro", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"
//            ));
//        }
//        return FXCollections.observableList(list);
//    }

    public void closeWindow(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
