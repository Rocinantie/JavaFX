/*
  Created by
  Rocinante
  2020/6/23
 */

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utillity.Global;

public class Main extends Application {

    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root;
            if (!Global.checkSoftWareStatus()) {
                root = FXMLLoader.load(getClass().getResource("../resources/Main.fxml"));
            } else if (Global.checkLicense()) {
                root = FXMLLoader.load(getClass().getResource("../resources/RegisterFailed.fxml"));
            } else {
                root = FXMLLoader.load(getClass().getResource("../resources/Home.fxml"));
            }
            primaryStage.setTitle("MD5 动态链接库应用");
            primaryStage.getIcons().add(
                    new Image("/resources/BG.jpg")
            );

            if (Global.checkSoftWareStatus() && Global.checkLicense()) {
                primaryStage.setScene(new Scene(root, 300, 180));
                primaryStage.setX(650);
                primaryStage.setY(290);
            } else {
                primaryStage.setScene(new Scene(root, 600, 400));
                primaryStage.setX(500);
                primaryStage.setY(180);
            }

            stage = primaryStage;
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}