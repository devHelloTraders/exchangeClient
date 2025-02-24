package org.example;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/* loaded from: classes3.dex */
final class CryptLib {

    /* renamed from: a, reason: collision with root package name */
    private Cipher f19858a = Cipher.getInstance("AES/CBC/PKCS5Padding");

    /* renamed from: b, reason: collision with root package name */
    private byte[] f19859b = new byte[32];

    /* renamed from: c, reason: collision with root package name */
    private byte[] f19860c = new byte[16];

    CryptLib() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    enum EncryptMode {
        ENCRYPT,
        DECRYPT
    }

    private String a(byte[] str, String str2, EncryptMode encryptMode, String str3) throws UnsupportedEncodingException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String str4;
        int length = str2.getBytes("UTF-8").length;
        int length2 = str2.getBytes("UTF-8").length;
        byte[] bArr = this.f19859b;
        if (length2 > bArr.length) {
            length = bArr.length;
        }
        int length3 = str3.getBytes("UTF-8").length;
        int length4 = str3.getBytes("UTF-8").length;
        byte[] bArr2 = this.f19860c;
        if (length4 > bArr2.length) {
            length3 = bArr2.length;
        }
        System.arraycopy(str2.getBytes("UTF-8"), 0, this.f19859b, 0, length);
        System.arraycopy(str3.getBytes("UTF-8"), 0, this.f19860c, 0, length3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f19859b, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(this.f19860c);
        if (encryptMode.equals(EncryptMode.ENCRYPT)) {
            this.f19858a.init(1, secretKeySpec, ivParameterSpec);
            str4 = java.util.Base64.getEncoder().encodeToString(this.f19858a.doFinal(str));
        } else {
            str4 = "";
        }
        if (!encryptMode.equals(EncryptMode.DECRYPT)) {
            return str4;
        }
        try {
            this.f19858a.init(2, secretKeySpec, ivParameterSpec);
            com.loopj.android.http.Base64.decode(str,0);
            return new String(this.f19858a.doFinal(str), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return str4;
        }
    }

    public final String b(byte[] str, String str2, String str3) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return a(str, str2, EncryptMode.DECRYPT, str3);
    }

    public final String a(byte[] str, String str2, String str3) throws InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return a(str, str2, EncryptMode.ENCRYPT, str3);
    }




}