package controller;

/*
  Created by
  Rocinante
  2020/7/3
 */

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utillity.MD5;

import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class UserLoginController {
    @FXML
    private Button btnExit;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label prompt;

    //    检查用户是否存在
    private static boolean checkUserExistence(String username) throws BackingStoreException {
        boolean userExistence = false;
        Preferences preference = Preferences.systemRoot().node("user");
        String[] userNameList = preference.keys();
        for (String s : userNameList) {
            if (s.equals(username)) {
                userExistence = true;
                break;
            }
        }
        return userExistence;
    }

    //    检查用户名密码是否匹配
    private static boolean checkUserMatch(String username, String password) {
        boolean userMatch = false;
        Preferences preference = Preferences.systemRoot().node("user");
        String returnPassword = preference.get(username, "0");
        if (returnPassword.equals(password)) {
            userMatch = true;
        }
        return userMatch;
    }

    public void btnLoginClick() throws IOException, BackingStoreException {
        if (userNameField.getText().equals("")) {
            prompt.setText("请输入用户名！");
        } else if (passwordField.getText().equals("")) {
            prompt.setText("请输入密码！");
        } else {
            if (!checkUserExistence(userNameField.getText())) {
                prompt.setText("用户不存在！");
            } else if (!checkUserMatch(userNameField.getText(), MD5.Encrypt(passwordField.getText()))) {
                prompt.setText("用户名或密码错误！");
            } else {
                new ChangeScene("EncryptMain.fxml");
            }
        }
    }

    public void btnExitClick() {
        btnExit.setOnAction(e -> Platform.exit());
        System.exit(0);
    }
}
