import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 2/7/12
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class TripleDESTest {

    public static void main(String[] args) throws Exception {

        String text = "igdefault";

        byte[] codedtext = new TripleDESTest().encrypt(text);
        String decodedtext = new TripleDESTest().decrypt(codedtext);

        System.out.println(codedtext); // this is a byte array, you'll just see a reference to an array
        System.out.println(decodedtext); // This correctly shows "kyle boon"
    }

    public byte[] encrypt(String message) throws Exception {
        final MessageDigest md = MessageDigest.getInstance("md5");
        final byte[] digestOfPassword = md.digest("1234567812345678"
                .getBytes("utf-8"));
        final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        for (int j = 0, k = 8; j < 16; ) {
            keyBytes[k++] = keyBytes[j++];
        }

        final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
        final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
        final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);

        final byte[] plainTextBytes = message.getBytes("utf-8");
        final byte[] cipherText = cipher.doFinal(plainTextBytes);
        // final String encodedCipherText = new sun.misc.BASE64Encoder()
        // .encode(cipherText);

        return cipherText;
    }

    public String decrypt(byte[] message) throws Exception {
        System.out.println("helelo===" + message);
         byte[] plainText = null;
        try {
            final MessageDigest md = MessageDigest.getInstance("md5");
            final byte[] digestOfPassword = md.digest("1234567812345678"
                    .getBytes("utf-8"));
            final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            for (int j = 0, k = 8; j < 16; ) {
                keyBytes[k++] = keyBytes[j++];
            }

            final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
            final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            decipher.init(Cipher.DECRYPT_MODE, key, iv);

            // final byte[] encData = new
            // sun.misc.BASE64Decoder().decodeBuffer(message);
            System.out.println("message===="+message);
            plainText = decipher.doFinal(message);
            System.out.println("=========" + new String(plainText, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(plainText, "UTF-8");
    }
}
