package com.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Gen_DESAES_key {
    public static void main(String[] args) {
        try {
            // Messaggio da cifrare
            byte[] message = "Hello World".getBytes();

            // Generatore di chiavi per DES
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey desKey = keyGenerator.generateKey();

            // Cifratore DES
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            desCipher.init(Cipher.ENCRYPT_MODE, desKey);

            // Cifratura del messaggio
            byte[] encryptedMessage = desCipher.doFinal(message);

            // Stampa del messaggio cifrato
            System.out.println("Messaggio cifrato: " + bytesToHex(encryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo helper per convertire i byte in una stringa esadecimale
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
}
