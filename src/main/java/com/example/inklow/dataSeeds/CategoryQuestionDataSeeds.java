package com.example.inklow.dataSeeds;

import com.example.inklow.entities.CategoryQuestion;
import com.example.inklow.service.CategoryQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

@Service
@Order(6)
public class CategoryQuestionDataSeeds implements ApplicationRunner {
    private final CategoryQuestionService categoryQuestionService;

    @Autowired
    public CategoryQuestionDataSeeds(CategoryQuestionService categoryQuestionService) {
        this.categoryQuestionService = categoryQuestionService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            categoryQuestionService.questionCategoryCount();
        } catch (BadSqlGrammarException e) {
            CategoryQuestion idCategory = new CategoryQuestion.Builder()
                    .name("Id/Sign-up")
                    .build();

            CategoryQuestion gameRelatedCategory = new CategoryQuestion.Builder()
                    .name("Game Related")
                    .build();

            CategoryQuestion bugsErrorsCategory = new CategoryQuestion.Builder()
                    .name("Bugs/Errors")
                    .build();

            CategoryQuestion websiteCategory = new CategoryQuestion.Builder()
                    .name("Website")
                    .build();

            CategoryQuestion billingCategory = new CategoryQuestion.Builder()
                    .name("Billing")
                    .build();

            categoryQuestionService.handleQuestionCategoryRegistration(idCategory);
            categoryQuestionService.handleQuestionCategoryRegistration(gameRelatedCategory);
            categoryQuestionService.handleQuestionCategoryRegistration(bugsErrorsCategory);
            categoryQuestionService.handleQuestionCategoryRegistration(websiteCategory);
            categoryQuestionService.handleQuestionCategoryRegistration(billingCategory);
        }
    }
}
