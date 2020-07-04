package controller;

/*
  Created by
  Rocinante
  2020/7/4
 */

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RegisterFailedController {
    @FXML
    private Button btnOK;

    public void btnOkClick() {
        btnOK.setOnAction(e -> Platform.exit());
        System.exit(0);
    }
}
