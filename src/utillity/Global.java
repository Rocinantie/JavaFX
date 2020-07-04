/*
  Created by
  Rocinante
  2020/6/30
 */

package utillity;

import java.util.prefs.Preferences;

public class Global {

    //    无效注册码
//    final public static String SOFTWARE_LICENSE = "7aba610726fe6b0bd4342b1dd32fe0b1";

    //    有效注册码
    final public static String SOFTWARE_LICENSE = "7aba610726fe6b0bd4342b1dd32fe0b5";

    public static String SOFTWARE_STATUS = "unlicensed";

    //    检查软件注册状态（已注册、未注册）
    public static boolean checkSoftWareStatus() {
        Preferences preferences = Preferences.systemRoot().node("user");
        String check = preferences.get("software_status", "0");
        return check.equals("licensed");
    }

    //    更新软件注册状态（已注册、未注册）
    public static void updateSoftwareStatus(boolean flag) {
        if (flag) {
            SOFTWARE_STATUS = "licensed";/*已注册*/
        } else {
            SOFTWARE_STATUS = "unlicensed";/*未注册*/
        }
        Preferences preferences = Preferences.systemRoot().node("user");
        preferences.put("software_status", SOFTWARE_STATUS);
    }

    //    检查注册码
    public static boolean checkLicense() {
        boolean LICENSED = false;
        try {
            String localMAC = Ipconfig.getMacAddress();
            if (Global.SOFTWARE_LICENSE.equals(MD5.Encrypt(localMAC))) {
                LICENSED = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return !LICENSED;
    }

}
