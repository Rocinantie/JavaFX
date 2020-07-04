package controller;

/*
  Created by
  Rocinante
  2020/7/3
 */

import javafx.event.ActionEvent;

import java.io.IOException;

public class EncryptController {

    public void btnTextEncrypt(ActionEvent actionEvent) throws IOException {
        new ChangeScene("TextEncrypt.fxml");
    }

    public void btnFileEncrypt(ActionEvent actionEvent) throws IOException {
        new ChangeScene("FileEncrypt.fxml");
    }
}
