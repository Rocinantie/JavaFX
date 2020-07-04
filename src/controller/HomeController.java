package controller;

/*
  Created by
  Rocinante
  2020/7/3
 */

import javafx.event.ActionEvent;

import java.io.IOException;

public class HomeController {

    public void btnLoginClick(ActionEvent actionEvent) throws IOException {
        new ChangeScene("UserLogin.fxml");
    }

    public void btnRegisterClick(ActionEvent actionEvent) throws IOException {
        new ChangeScene("UserRegister.fxml");
    }
}
