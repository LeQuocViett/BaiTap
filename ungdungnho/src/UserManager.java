import org.mindrot.jbcrypt.BCrypt;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();

    // Đăng ký người dùng mới, hash mật khẩu bằng bcrypt
    public boolean registerUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)) return false;
        }
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        users.add(new User(password, hashed));
        return true;
    }

    public boolean loginUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && BCrypt.checkpw(password, u.getPasswordHash())) {
                return true;
            }
        }
        return false;
    }

    // Xuất danh sách người dùng (trừ mật khẩu) ra file XML
    public void exportToXML(String filePath) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element root = doc.createElement("users");
        doc.appendChild(root);

        for (User u : users) {
            Element userElem = doc.createElement("user");
            Element nameElem = doc.createElement("username");
            nameElem.appendChild(doc.createTextNode(u.getUsername()));
            userElem.appendChild(nameElem);
            root.appendChild(userElem);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
    }

    // Nhập danh sách người dùng từ file XML (chỉ username, không có password hash)
    public boolean importFromXML(String filePath) {
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Kiểm tra định dạng gốc là <users>
            if (!doc.getDocumentElement().getNodeName().equals("users")) return false;

            NodeList nList = doc.getElementsByTagName("user");
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String username = eElement.getElementsByTagName("username").item(0).getTextContent();
                    // Mật khẩu tạm thời để hiển thị, không có trong file XML
                    users.add(new User(username, ""));
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void printUsers() {
        for (User u : users) {
            System.out.println("Username: " + u.getUsername());
        }
    }
}


