package main;

/*
  Created by
  Rocinante
  2020/7/4
 */

import java.util.prefs.Preferences;

public class SoftwareRestore {
    public static void main(String[] args) {
        Preferences preferences = Preferences.systemRoot().node("user");
        preferences.put("software_status", "unlicensed");
        System.out.println("软件已恢复默认设置！");
    }
}
