package controller;

/*
  Created by
  Rocinante
  2020/7/3
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utillity.MD5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class UserRegisterController implements Initializable {

    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField rePasswordField;
    @FXML
    private Label prompt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void btnRegisterClick() {
        try {
            if (userNameField.getText().equals("")) {
                prompt.setText("请输入用户名！");
            } else if (passwordField.getText().equals("")) {
                prompt.setText("请输入密码！");
            } else if (rePasswordField.getText().equals("")) {
                prompt.setText("请确认您的密码！");
            } else if (!passwordField.getText().equals(rePasswordField.getText())) {
                prompt.setText("两次输入密码不一致！");
            } else {
                Preferences preferences = Preferences.systemRoot().node("user");
                preferences.put(userNameField.getText(), MD5.Encrypt(passwordField.getText()));
                new ChangeScene("UserLogin.fxml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnExitClick() throws IOException {
        new ChangeScene("Home.fxml");
    }
}
