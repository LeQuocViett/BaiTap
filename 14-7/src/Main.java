import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Chuong trinh ma hoa va giai mã");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500,400);

            JTextArea inputArea = new JTextArea("Nha du lieu o day....");
            JTextArea outputArea = new JTextArea();
            outputArea.setEditable(false);

            JButton aesButton = new JButton("Dung AES");
            JButton rsaButton = new JButton("Dung RSA");

            aesButton.addActionListener(e -> new Thread(() -> {
               try {
                   AESEncryption aes = new AESEncryption();
                   byte[] encrypted = aes.encrypt(inputArea.getText().getBytes());
                   byte[] decrypted = aes.decrypt(encrypted);
                   SwingUtilities.invokeLater(() -> outputArea.setText("Giai ma AES: " + new String(decrypted)));
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
            }).start());


            rsaButton.addActionListener(e-> new Thread(() -> {
               try {
                   RSAEncryption rsa = new RSAEncryption();
                   byte[] encrypted = rsa.encrypt(inputArea.getText().getBytes());
                   byte[] decrypted = rsa.decrypt(encrypted);
                   SwingUtilities.invokeLater(() -> outputArea.setText("Giai ma RSA: " + new String(decrypted)));
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
            }).start());

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(inputArea), BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(aesButton);
            buttonPanel.add(rsaButton);

            panel.add(buttonPanel, BorderLayout.CENTER);
            panel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}