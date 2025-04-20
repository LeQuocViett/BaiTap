import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAEncryption implements Encryptable{
    private PublicKey publickey;
    private PrivateKey privatekey;

    public RSAEncryption() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();
        publickey = pair.getPublic();
        privatekey = pair.getPrivate();
    }

    @Override
    public byte[] encrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publickey);
        return cipher.doFinal(data);
    }

    @Override
    public byte[] decrypt(byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privatekey);
        return cipher.doFinal(encryptedData);
    }


}
