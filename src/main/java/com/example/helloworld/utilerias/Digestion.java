package com.example.helloworld.utilerias;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digestion {
    private Digestion() {
  }
    public static String generateMd5(String input) {
        String palablraSecreta="Arellano1967";
        byte[] arreglo;
        try {
            arreglo = generateSaltedMd5(input, palablraSecreta);
        } catch (NoSuchAlgorithmException e) {
            return "ERROR";
        }
        return toHexString(arreglo);
    }
    private static byte[] generateSaltedMd5(String source, String salt) throws NoSuchAlgorithmException {
        String input = source + salt;
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    private static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        String hexa = number.toString(16);
        StringBuilder hexString = new StringBuilder(hexa);
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}