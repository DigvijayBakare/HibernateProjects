package com.map;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    private int question_id;
    private String question;

//    @OneToOne
//    @JoinColumn(name = "a_id")
//    private Answer answer;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Answer> answers;

    public Question() {
        super();
    }

    /*public Question(int question_id, String question, Answer answer) {
        this.question_id = question_id;
        this.question = question;
        this.answer = answer;
    }*/

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

   /* public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }*/

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(int question_id, String question, List<Answer> answers) {
        this.question_id = question_id;
        this.question = question;
        this.answers = answers;
    }
}
