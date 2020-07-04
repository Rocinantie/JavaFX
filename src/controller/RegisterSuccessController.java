package controller;

/*
  Created by
  Rocinante
  2020/7/3
 */

import javafx.event.ActionEvent;

import java.io.IOException;

public class RegisterSuccessController {

    public void btnOkClick(ActionEvent actionEvent) throws IOException {
        new ChangeScene("Home.fxml");
    }
}
