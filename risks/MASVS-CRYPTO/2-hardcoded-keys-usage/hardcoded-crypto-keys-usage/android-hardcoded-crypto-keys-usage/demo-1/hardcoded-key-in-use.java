public class Foo {
    void good() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Properties.getKey(), "AES");
    }

    void bad() {
        SecretKeySpec secretKeySpec = new SecretKeySpec("my secret here".getBytes(), "AES");
    }
}

public void setSecretKey(String secretKey) {
    String encryptionKey = "lakdsljkalkjlksdfkl";
    byte[] keyBytes = encryptionKey.getBytes();
    SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
}

public void setSecretKey(String secretKey) {

  SecretKey key = new SecretKeySpec(secretKey.getBytes(), "AES");

}