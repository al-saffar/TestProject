package classes;

public class Message {

	private String sender;
	private String reciver;
	private String type;
	private String messageInfo;

	public Message(String sender, String reciver, String type,
			String messageInfo) {

		this.sender = sender;
		this.reciver = reciver;
		this.type = type;
		this.messageInfo = messageInfo;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

}
