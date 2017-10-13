package edu.asu.cse360._03._07;

public class Lesson {

	private String html, typeA, question;
	private int attempts;
	private String[] choices, hints, answers;
	private int answer;
	private int numAttempts;

	public Lesson(String html, String typeA, String question, int attempts, String[] choices, String[] hints, String[] answers) {
		this.html = html;
		this.typeA = typeA;
		this.question = question;
		this.attempts = attempts;
		this.choices = choices;
		this.hints = hints;
		this.answers = answers;
		this.answer = 0;
		this.numAttempts = 0;
	}

	public String getTypeA() {
		return typeA;
	}
	
	public String[] getChoices() {
		return choices;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getHtml() {
		return "resources/" + html;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
	public String[] getHints() {
		return hints;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getNumAttempts() {
		return numAttempts;
	}

	public void setNumAttempts(int numAttempts) {
		this.numAttempts = numAttempts;
	}

	public int getAttempts() {
		return attempts;
	}
}
