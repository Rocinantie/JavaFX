package utillity;

/*
  Created by
  Rocinante
  2020/6/30
 */

import java.net.InetAddress;
import java.net.NetworkInterface;

public class Ipconfig {
    public static void main(String[] args) {
    }

    public static String getMacAddress() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();

        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) stringBuffer.append("-");
            String s = Integer.toHexString(mac[i] & 0xFF);
            stringBuffer.append(s.length() == 1 ? 0 + s : s);
        }

        return stringBuffer.toString().toUpperCase();
    }

}
