package controller;

/*
  Created by
  Rocinante
  2020/7/4
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import utillity.MD5;

import java.io.IOException;

public class TextEncryptController {
    @FXML
    private TextArea inputText;
    @FXML
    private TextArea outputText;

    public void btnEncryptClick(ActionEvent actionEvent) {
        outputText.setText(MD5.Encrypt(inputText.getText()));
    }

    public void btnReturnClick(ActionEvent actionEvent) throws IOException {
        new ChangeScene("EncryptMain.fxml");
    }
}
