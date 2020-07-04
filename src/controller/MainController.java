/*
  Created by
  Rocinante
  2020/6/30
 */

package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import utillity.Global;
import utillity.Ipconfig;
import utillity.MD5;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btnExit;

    @FXML
    public void btnExitClick() {
        btnExit.setOnAction(e -> Platform.exit());
        System.exit(0);
    }

    @FXML
    public void btnRegisterClick() {
        try {
            Global.updateSoftwareStatus(true);
//            MD5 md5 = new MD5();
            String localMAC = Ipconfig.getMacAddress();
//            System.out.println("本机 MAC 地址：" + md5.Encrypt(localMAC));
            if (Global.SOFTWARE_LICENSE.equals(MD5.Encrypt(localMAC))) {
                new ChangeScene("RegisterSuccess.fxml");
            } else {
                new ChangeScene("RegisterFailed.fxml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
