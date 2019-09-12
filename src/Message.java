import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message implements java.io.Serializable{
    // DateFormat format = new SimpleDateFormat("E M W kms z y");
    private Date createdAt;
    private Date updatedAt;
    private String message;
    private String author;

    public Message(String s) {
        message = s;
        author = System.getProperty("user.name");
        createdAt = new Date();
        updatedAt = new Date();
    }

    /* public Message(String readLine, String readLine1, String readLine2, String readLine3) throws ParseException {
        updatedAt = format.parse(readLine);
        createdAt = format.parse(readLine1);
        author = readLine2;
        message = readLine3;
    } */

    public void msgChange(String s) {
        message = s;
        updatedAt = new Date();
    }

    public String fileSaver() {
        return  createdAt + "\n" +
                updatedAt + "\n" +
                message + "\n" +
                author;
    }

    @Override
    public String toString() {
        return  "Skapad: " + createdAt + "\n" +
                "Senast uppdaterad: " + updatedAt + "\n" +
                "Meddelande: " + message + "\n" +
                "Författare: " + author + "\n";
    }
}
