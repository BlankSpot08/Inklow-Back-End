package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Question;
import com.example.inklow.service.QuestionCategoryService;
import com.example.inklow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Order(7)
public class QuestionDataSeeds implements ApplicationRunner {
    private final QuestionService questionService;
    private final QuestionCategoryService questionCategoryService;

    @Autowired
    public QuestionDataSeeds(QuestionService questionService, QuestionCategoryService questionCategoryService) {
        this.questionService = questionService;
        this.questionCategoryService = questionCategoryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (questionService.questionCount() == 0) {

            String question1Category = "Id/Sign-up";
            String question1CategoryId = questionCategoryService.findQuestionCategoryByName(question1Category).getName();

            System.out.println(question1CategoryId);
            Question question1 = new Question.Builder()
                    .category(question1CategoryId)
                    .question("I lost my account password. How do I find my password?")
                    .answer("If you lose your account password, please try using the Find/Recover Password service.")
                    .build();

            String question2Category = "Website";
            String question2CategoryId = questionCategoryService.findQuestionCategoryByName(question2Category).getName();

            System.out.println(question2CategoryId);
            Question question2 = new Question.Builder()
                    .category(question2CategoryId)
                    .question("I can't leave comments on the website.")
                    .answer("Your ability to leave comments may be restricted if your previous comments/actions resulted in violations." +
                            " If you believe you did not engage in bad behavior and are still restricted, please contact us via Customer Support." +
                            " Follow the link below for more information regarding our Operational Policy.")
                    .build();

            String question3Category = "Bugs/Errors";
            String question3CategoryId = questionCategoryService.findQuestionCategoryByName(question3Category).getName();

            System.out.println(question3CategoryId);
            Question question3 = new Question.Builder()
                    .category(question3CategoryId)
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
