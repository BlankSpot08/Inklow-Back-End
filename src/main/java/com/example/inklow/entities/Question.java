package com.example.inklow.entities;

import java.util.UUID;

public class Question {
    private final UUID id;
    private final String question;
    private final String answer;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Question(UUID id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public final static class Builder {
        private UUID id;
        private String question = "";
        private String answer = "";

        public Builder() {   }

        public Builder(UUID id, String question, String answer) {
            this.id = id;
            this.question = question;
            this.answer = answer;
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder question(String question) {
            this.question = question;
            return this;
        }

        public Builder answer(String answer) {
            this.answer = answer;
            return this;
        }

        public Question build() {
            return new Question(id, question, answer);
        }
    }
}
