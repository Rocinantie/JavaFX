package controller;

/*
  Created by
  Rocinante
  2020/7/3
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.Main;

import java.io.IOException;

public class ChangeScene {
    public ChangeScene(String fxml) throws IOException {
        String src = "../resources/" + fxml;
        Parent root = FXMLLoader.load(getClass().getResource(src));

        Main.stage.setTitle("MD5 动态链接库应用");

        Main.stage.setScene(new Scene(root));
        if (fxml.equals("RegisterSuccess.fxml") || fxml.equals("RegisterFailed.fxml")) {
            Main.stage.setX(650);
            Main.stage.setY(290);
        } else {
            Main.stage.setX(500);
            Main.stage.setY(180);
        }
        Main.stage.show();
    }
}
