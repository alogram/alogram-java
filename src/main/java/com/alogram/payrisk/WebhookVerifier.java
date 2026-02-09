package com.alogram.payrisk;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class WebhookVerifier {
    private static final String HMAC_SHA256 = "HmacSHA256";

    public static boolean verify(byte[] payload, String headerSignature, String secret) {
        if (headerSignature == null || secret == null || secret.isEmpty()) {
            return false;
        }

        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
            mac.init(secretKeySpec);
            byte[] hashBytes = mac.doFinal(payload);
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            String expectedSignature = sb.toString();

            return MessageDigest.isEqual(
                expectedSignature.getBytes(StandardCharsets.UTF_8), 
                headerSignature.getBytes(StandardCharsets.UTF_8)
            );
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Failed to verify webhook signature", e);
        }
    }
}
