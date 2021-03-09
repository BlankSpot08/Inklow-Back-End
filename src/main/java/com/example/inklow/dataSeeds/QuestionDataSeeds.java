package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Question;
import com.example.inklow.service.QuestionService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(6)
public class QuestionDataSeeds implements ApplicationRunner {
    private final QuestionService questionService;

    public QuestionDataSeeds(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (questionService.questionCount() == 0) {
            Question question1 = new Question.Builder()
                    .category("ID/Sign-up")
                    .question("I lost my account password. How do I find my password?")
                    .answer("If you lose your account password, please try using the Find/Recover Password service.")
                    .build();

            Question question2 = new Question.Builder()
                    .category("Website")
                    .question("I can't leave comments on the website.")
                    .answer("Your ability to leave comments may be restricted if your previous comments/actions resulted in violations." +
                            " If you believe you did not engage in bad behavior and are still restricted, please contact us via Customer Support." +
                            " Follow the link below for more information regarding our Operational Policy.")
                    .build();

            Question question3 = new Question.Builder()
                    .category("Bugs/Errors")
                    .question("What should I do if I find a bug within the website?")
                    .answer("If you find a bug within the game, please submit a ticket under the Bug/Error category." +
                            " We ask that you include a screenshot of the issue and provide as many details as possible for us to resolve this issue.")
                    .build();

            questionService.handleQuestionRegistration(question1);
            questionService.handleQuestionRegistration(question2);
            questionService.handleQuestionRegistration(question3);
        }
    }
}
