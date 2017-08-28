package com.musala.lfm;

public class Sheet {
	private String topic;
	private String text;

	// Constructors
	public Sheet() {
		setTopic("");
		setText("");
	}

	// Getters and setters

	private void setTopic(String topic) {
		if (topic != null) {
			this.topic = topic;
		}

	}

	public void setText(String text) {
		if (text != null) {
			this.text = text;
		}
	}

	public String getText() {
		return text;
	}

	public String getTopic() {
		return topic;
	}

	// Public methods

}
