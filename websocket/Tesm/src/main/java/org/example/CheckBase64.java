package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.Base64;

public class CheckBase64 {
    public static void main(String[] args) throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\bunty\\Downloads\\Maths.pdf"));
        String decoded =decryptFile(bytes);
        System.out.println("Decoded Content: \n" + decoded);
    }

    public static String decryptFile(byte[] str) {
        try {
         //   String randomString = BaseUtils.getRandomString();
        //    String a10 = new CryptLib().a(str2, "t8I8n6wctuVfyNG49l3lUOrlJ4bYi1ZW", randomString);
            CryptLib cryptLib = new CryptLib();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update("rzpisunitedred".getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : digest) {
                stringBuffer.append(String.format("%02x", Byte.valueOf(b10)));
            }
            return cryptLib.b(str, "t8I8n6wctuVfyNG49l3lUOrlJ4bYi1ZW", "glorygloryunited");
        } catch (Exception e10) {
           // AnalyticsUtil.reportError(e10.getMessage(), AnalyticsConstants.WARNING, e10.getLocalizedMessage());
            e10.getMessage();
            return null;
        }
    }


  /*  public static String getFileFromInternal(String str, String str2) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(activity.openFileInput(getVersionedAssetName("MD5", str)), "UTF-8"));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return decryptFile(sb2.toString());
            }
            sb2.append(readLine);
        }
    }

    public static String getVersionedAssetName(String str, String str2) {
        return str.replaceAll("\\.", "-") + "-" + str2;
    }

*/






}
