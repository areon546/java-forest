package forest.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Seed {

    // Uses the SHA 256 algorithm and converts from Str to Long
    public static long New(String str) {
        try {
            // Get SHA256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

            // Convert to Hexadecimal
            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            String hexVal = hexString.toString();

            // Convert to Big Integer so no error, and then to Long
            BigInteger bi = new BigInteger(hexVal, 16);
            return bi.longValue();
        } catch (NoSuchAlgorithmException e) {
            return 0;
        }
    }
}
