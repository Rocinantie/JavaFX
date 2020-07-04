package utillity;

/*
  Created by
  Rocinante
  2020/6/29
 */

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Dll extends Library {

    //    加载 DLL 库
    @Deprecated
    Dll instance = Native.loadLibrary("libMD5", Dll.class);

    //    调用 DLL 里的方法：第一个参数是要加密的字符串，第二个参数是返回加密的结果
    void md5(String str, byte[] bytes);
}
