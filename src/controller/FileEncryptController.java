package controller;

/*
  Created by
  Rocinante
  2020/7/4
 */

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import main.Main;
import utillity.MD5;

import java.io.*;

public class FileEncryptController {

    @FXML
    private TextArea outputText;
    @FXML
    private TextArea fileInArea;

    public void btnSelectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("请选择要加密的文件");
        File filePath = fileChooser.showOpenDialog(Main.stage);
        Main.stage.show();
        File file = new File(String.valueOf(filePath));
        try {
            if (file.isFile() && file.exists()) {
                InputStreamReader reader = new InputStreamReader(
                        new FileInputStream(file)
                );
                BufferedReader bufferedReader = new BufferedReader(reader);
                String text;
                while ((text = bufferedReader.readLine()) != null) {
                    fileInArea.setText(text);
                }
                reader.close();
            } else {
                System.out.println("找不到此文件！");
            }
        } catch (Exception e) {
            System.out.println("文件读取出错！");
            e.printStackTrace();
        }
    }

    public void btnReturnClick() throws IOException {
        new ChangeScene("EncryptMain.fxml");
    }

    public void btnEncryptClick() {
        outputText.setText(MD5.Encrypt(fileInArea.getText()));
    }
}
