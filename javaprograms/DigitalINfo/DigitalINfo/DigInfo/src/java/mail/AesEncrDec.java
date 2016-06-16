/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import sun.misc.BASE64Encoder;


public class AesEncrDec {

    private static String cipherText;
    private static String decryptedText;

 /* public static void main(String args[]) {
        String encriptdata = new AesEncrDec().encrypt("123456789");
        String decriptdata = new AesEncrDec().decrypt(encriptdata);
        System.out.println(encriptdata + "----" + decriptdata);


    }
*/
    

    public static String encrypt(String plainData) {
        try {

            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] byteDataToEncrypt = plainData.getBytes();
            byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
            cipherText = new BASE64Encoder().encode(byteCipherText);
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey, aesCipher.getParameters());
            byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
            decryptedText = new String(byteDecryptedText);
        } catch (Exception e) {
        }


        return cipherText;
    }

    public static String decrypt(String cipherText) {
        try {

            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES");
            byte[] byteCipherText = cipherText.getBytes();
            cipherText = new BASE64Encoder().encode(byteCipherText);
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey, aesCipher.getParameters());
            byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
            decryptedText = new String(byteDecryptedText);
        } catch (Exception e) {
        }


        return decryptedText;
    }
}
