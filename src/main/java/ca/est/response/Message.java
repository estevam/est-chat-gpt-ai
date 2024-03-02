package ca.est.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String role;
    private String content;
	public Message(String role, String content) {
		super();
		this.role = role;
		this.content = content;
	}
    
}
