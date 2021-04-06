package com.example.inklow.dataSeeds;

import com.example.inklow.entities.CategoryQuestion;
import com.example.inklow.entities.Question;
import com.example.inklow.service.CategoryQuestionService;
import com.example.inklow.service.QuestionService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

@Service
@Order(7)
public class QuestionDataSeeds implements ApplicationRunner {
    private final QuestionService questionService;
    private final CategoryQuestionService categoryQuestionService;

    @Autowired
    public QuestionDataSeeds(QuestionService questionService, CategoryQuestionService categoryQuestionService) {
        this.questionService = questionService;
        this.categoryQuestionService = categoryQuestionService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            questionService.questionCount();
        } catch (BadSqlGrammarException e) {
            String categoryQuestion1 = "Id/Sign-up";

            CategoryQuestion categoryQuestion1Object = new CategoryQuestion.Builder()
                    .name(categoryQuestion1)
                    .build();

            String categoryQuestion1Id = categoryQuestionService.findQuestionCategoryByName(categoryQuestion1Object).getName();

            System.out.println(categoryQuestion1Id);
            Question question1 = new Question.Builder()
                    .category(categoryQuestion1Id)
                    .question("I lost my account password. How do I find my password?")
                    .answer("If you lose your account password, please try using the Find/Recover Password service.")
                    .build();

            String categoryQuestion2 = "Website";

            CategoryQuestion categoryQuestion2Object = new CategoryQuestion.Builder()
                    .name(categoryQuestion2)
                    .build();

            String categoryQuestion2Id = categoryQuestionService.findQuestionCategoryByName(categoryQuestion2Object).getName();

            System.out.println(categoryQuestion2Id);
            Question question2 = new Question.Builder()
                    .category(categoryQuestion2Id)
                    .question("I can't leave comments on the website.")
                    .answer("Your ability to leave comments may be restricted if your previous comments/actions resulted in violations." +
                            " If you believe you did not engage in bad behavior and are still restricted, please contact us via Customer Support." +
                            " Follow the link below for more information regarding our Operational Policy.")
                    .build();

            String categoryQuestion3 = "Bugs/Errors";

            CategoryQuestion categoryQuestion3Object = new CategoryQuestion.Builder()
                    .name(categoryQuestion3)
                    .build();

            String categoryQuestion3Id = categoryQuestionService.findQuestionCategoryByName(categoryQuestion3Object).getName();

            System.out.println(categoryQuestion3Id);
            Question question3 = new Question.Builder()
                    .category(categoryQuestion3Id)
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
