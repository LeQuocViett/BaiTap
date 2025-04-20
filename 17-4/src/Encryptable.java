public interface Encryptable {
    byte[] encrypt(byte[] data) throws Exception; // Mã hóa dữ liệu
    byte[] decrypt(byte[] encryptedData) throws Exception; // Giải mã dữ liệu
}