package com.example.inklow.dataSeeds;

import com.example.inklow.entities.QuestionCategory;
import com.example.inklow.service.QuestionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(6)
public class QuestionCategoryDataSeeds implements ApplicationRunner {
    private final QuestionCategoryService questionCategoryService;

    @Autowired
    public QuestionCategoryDataSeeds(QuestionCategoryService questionCategoryService) {
        this.questionCategoryService = questionCategoryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (questionCategoryService.questionCategoryCount() == 0) {
            QuestionCategory idCategory = new QuestionCategory.Builder()
                    .name("Id/Sign-up")
                    .build();

            QuestionCategory gameRelatedCategory = new QuestionCategory.Builder()
                    .name("Game Related")
                    .build();

            QuestionCategory bugsErrorsCategory = new QuestionCategory.Builder()
                    .name("Bugs/Errors")
                    .build();

            QuestionCategory websiteCategory = new QuestionCategory.Builder()
                    .name("Website")
                    .build();

            QuestionCategory billingCategory = new QuestionCategory.Builder()
                    .name("Billing")
                    .build();

            questionCategoryService.handleQuestionCategoryRegistration(idCategory);
            questionCategoryService.handleQuestionCategoryRegistration(gameRelatedCategory);
            questionCategoryService.handleQuestionCategoryRegistration(bugsErrorsCategory);
            questionCategoryService.handleQuestionCategoryRegistration(websiteCategory);
            questionCategoryService.handleQuestionCategoryRegistration(billingCategory);
        }
    }
}
