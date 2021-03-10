package com.example.inklow.dataSeeds;

import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.service.CategoryInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(9)
public class CategoryInquiryDataSeeds implements ApplicationRunner {
    private final CategoryInquiryService categoryInquiryService;

    @Autowired
    public CategoryInquiryDataSeeds(CategoryInquiryService categoryInquiryService) {
        this.categoryInquiryService = categoryInquiryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (categoryInquiryService.questionCategoryCount() == 0) {
            CategoryInquiry categoryInquiry1 = new CategoryInquiry.Builder()
                    .name("Compromised Account")
                    .build();

            CategoryInquiry categoryInquiry2 = new CategoryInquiry.Builder()
                    .name("Appeal Restriction")
                    .build();

            CategoryInquiry categoryInquiry3 = new CategoryInquiry.Builder()
                    .name("Other Inquiries")
                    .build();

            CategoryInquiry categoryInquiry4 = new CategoryInquiry.Builder()
                    .name("Unable to Install")
                    .build();

            CategoryInquiry categoryInquiry5 = new CategoryInquiry.Builder()
                    .name("Unable to Update")
                    .build();

            CategoryInquiry categoryInquiry6 = new CategoryInquiry.Builder()
                    .name("Cannot Run")
                    .build();

            CategoryInquiry categoryInquiry7 = new CategoryInquiry.Builder()
                    .name("Lag/Crash")
                    .build();

            CategoryInquiry categoryInquiry9 = new CategoryInquiry.Builder()
                    .name("Report System Exploitation")
                    .build();

            CategoryInquiry categoryInquiry10 = new CategoryInquiry.Builder()
                    .name("Report Bots/Macros")
                    .build();

            CategoryInquiry categoryInquiry11 = new CategoryInquiry.Builder()
                    .name("Report User Behavior")
                    .build();

            CategoryInquiry categoryInquiry12 = new CategoryInquiry.Builder()
                    .name("Membership Information")
                    .build();

            CategoryInquiry categoryInquiry13 = new CategoryInquiry.Builder()
                    .name("Web Storage Related")
                    .build();

            CategoryInquiry categoryInquiry14 = new CategoryInquiry.Builder()
                    .name("Website Related")
                    .build();

            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry1);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry2);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry3);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry4);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry5);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry6);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry7);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry9);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry10);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry11);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry12);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry13);
            categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry14);
        }
    }
}
