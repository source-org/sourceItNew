package Homework2;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Coder {

    private static final String SHA256 = "SHA-256";
    private static final String MD5 = "MD5";

    public void coder (String type, String phrase) throws NoSuchAlgorithmException {

        if (type.equals(SHA256)) {
            System.out.println(toSHA256(phrase.getBytes(StandardCharsets.UTF_8)));
        } else if (type.equals(MD5)) {
            System.out.println(toMD5(phrase.getBytes()));
        }
        else{
            System.out.println("choose between SHA-256 and MD5");
        }
    }

    private String toSHA256(byte[] phrase) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(StandardCharsets.UTF_8.encode(String.valueOf(phrase)));
        return String.format("%032x", new BigInteger(1,sha.digest()));
    }

    private String toMD5(byte[] phrase) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(StandardCharsets.UTF_8.encode(String.valueOf(phrase)));
        return String.format("%032x", new BigInteger(1,md5.digest()));
    }
}
