import java.util.Date;

public class Message {
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

    @Override
    public String toString() {
        return  "Skapad: " + createdAt + "\n" +
                "Senast uppdaterad: " + updatedAt + "\n" +
                "Meddelande: " + message + "\n" +
                "Författare: " + author + "\n";
    }
}
