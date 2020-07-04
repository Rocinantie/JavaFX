package utillity;

/*
  Created by
  Rocinante
  2020/6/29
 */

public class MD5 {

    //    封装 MD5 加密方法，提供友好的接口
    public static String Encrypt(String text) {
        int size = 32;
        var dll = Dll.instance;
        byte[] byteArray = new byte[size];
        dll.md5(text, byteArray);
        return new String(byteArray);
    }
}
