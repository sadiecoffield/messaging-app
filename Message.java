import java.util.Date;

public class Message {
    private String contents;
    private boolean isRead;
    private Date timestamp;
    private String recipientUserID; 

    
    public Message(String contents, Date timestamp, String recipientUserID) {
        this.contents = contents;
        this.timestamp = timestamp;
        this.isRead = false;
        this.recipientUserID = recipientUserID;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getRecipientUserID() {
        return recipientUserID;
    }

    public void setRecipientUserID(String recipientUserID) {
        this.recipientUserID = recipientUserID;
    }

    public void sendMessage(String contents, Date timestamp, String recipientUserID) {
        this.contents = contents;
        this.timestamp = timestamp;
        this.recipientUserID = recipientUserID;
        this.isRead = false;
    }

    public void readMessage() {
        this.isRead = true;
    }

    public Date getDateTimeSent() {
        return this.timestamp;
    }
}