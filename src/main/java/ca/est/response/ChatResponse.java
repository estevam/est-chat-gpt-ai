package ca.est.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatResponse {
	private List<Choice> choices;

	public ChatResponse(List<Choice> choices) {
		super();
		this.choices = choices;
	}

	@Getter
	@Setter
	public static class Choice {

		private int index;
		private Message message;

		public Choice(int index, Message message) {
			super();
			this.index = index;
			this.message = message;
		}
	}
}