package com.example.inklow.dataSeeds;

import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.entities.Inquiry;
import com.example.inklow.entities.InquiryCategory;
import com.example.inklow.service.CategoryInquiryService;
import com.example.inklow.service.InquiryCategoryService;
import com.example.inklow.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

@Service
@Order(9)
public class InquiryCategoryDataSeeds implements ApplicationRunner {
    private final InquiryCategoryService inquiryCategoryService;
    private final CategoryInquiryService categoryInquiryService;
    private final InquiryService inquiryService;

    @Autowired
    public InquiryCategoryDataSeeds(InquiryCategoryService inquiryCategoryService,
                                    InquiryService inquiryService,
                                    CategoryInquiryService categoryInquiryService) {
        this.inquiryCategoryService = inquiryCategoryService;
        this.categoryInquiryService = categoryInquiryService;
        this.inquiryService = inquiryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            inquiryCategoryService.inquiryCategoryCount();
        } catch (BadSqlGrammarException e) {
            String name1 = "Report/Restriction";

            Inquiry nameInquiry1 = new Inquiry.Builder()
                    .name(name1)
                    .build();

            Inquiry inquiry1 = inquiryService.getInquiryByName(nameInquiry1);

            String categoryName1 = "Report System Exploitation";

            CategoryInquiry categoryInquiry1 = new CategoryInquiry.Builder()
                    .name(categoryName1)
                    .build();

            CategoryInquiry realCategoryInquiry1 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry1);

            String categoryName2 = "Report Bots/Macros";

            CategoryInquiry categoryInquiry2 = new CategoryInquiry.Builder()
                    .name(categoryName2)
                    .build();

            CategoryInquiry realCategoryInquiry2 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry2);

            String categoryName3 = "Report User Behavior";

            CategoryInquiry categoryInquiry3 = new CategoryInquiry.Builder()
                    .name(categoryName3)
                    .build();

            CategoryInquiry realCategoryInquiry3 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry3);

            InquiryCategory inquiryCategory1 = new InquiryCategory.Builder(inquiry1.getId(), realCategoryInquiry1.getId()).build();
            InquiryCategory inquiryCategory2 = new InquiryCategory.Builder(inquiry1.getId(), realCategoryInquiry2.getId()).build();
            InquiryCategory inquiryCategory3 = new InquiryCategory.Builder(inquiry1.getId(), realCategoryInquiry3.getId()).build();

            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory1);
            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory2);
            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory3);

            String name2 = "Website";

            Inquiry nameInquiry2 = new Inquiry.Builder()
                    .name(name2)
                    .build();

            Inquiry inquiry2 = inquiryService.getInquiryByName(nameInquiry2);

            String categoryName4 = "Membership Information";

            CategoryInquiry categoryInquiry4 = new CategoryInquiry.Builder()
                    .name(categoryName4)
                    .build();

            CategoryInquiry realCategoryInquiry4 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry4);

            String categoryName5 = "Web Storage Related";

            CategoryInquiry categoryInquiry5 = new CategoryInquiry.Builder()
                    .name(categoryName5)
                    .build();

            CategoryInquiry realCategoryInquiry5 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry5);

            String categoryName6 = "Website Related";

            CategoryInquiry categoryInquiry6 = new CategoryInquiry.Builder()
                    .name(categoryName6)
                    .build();

            CategoryInquiry realCategoryInquiry6 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry6);

            InquiryCategory inquiryCategory4 = new InquiryCategory.Builder(inquiry2.getId(), realCategoryInquiry4.getId()).build();
            InquiryCategory inquiryCategory5 = new InquiryCategory.Builder(inquiry2.getId(), realCategoryInquiry5.getId()).build();
            InquiryCategory inquiryCategory6 = new InquiryCategory.Builder(inquiry2.getId(), realCategoryInquiry6.getId()).build();

            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory4);
            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory5);
            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory6);

            String name3 = "Technical Issues";

            Inquiry nameInquiry3 = new Inquiry.Builder()
                    .name(name3)
                    .build();

            Inquiry inquiry3 = inquiryService.getInquiryByName(nameInquiry3);

            String categoryName7 = "Unable to Install";

            CategoryInquiry categoryInquiry7 = new CategoryInquiry.Builder()
                    .name(categoryName7)
                    .build();

            CategoryInquiry realCategoryInquiry7 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry7);

            String categoryName8 = "Unable to Update";

            CategoryInquiry categoryInquiry8 = new CategoryInquiry.Builder()
                    .name(categoryName8)
                    .build();

            CategoryInquiry realCategoryInquiry8 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry8);

            String categoryName9 = "Cannot Run";

            CategoryInquiry categoryInquiry9 = new CategoryInquiry.Builder()
                    .name(categoryName9)
                    .build();

            CategoryInquiry realCategoryInquiry9 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry9);

            String categoryName10 = "Lag/Crash";

            CategoryInquiry categoryInquiry10 = new CategoryInquiry.Builder()
                    .name(categoryName10)
                    .build();

            CategoryInquiry realCategoryInquiry10 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry10);

            InquiryCategory inquiryCategory7 = new InquiryCategory.Builder(inquiry3.getId(), realCategoryInquiry7.getId()).build();
            InquiryCategory inquiryCategory8 = new InquiryCategory.Builder(inquiry3.getId(), realCategoryInquiry8.getId()).build();
            InquiryCategory inquiryCategory9 = new InquiryCategory.Builder(inquiry3.getId(), realCategoryInquiry9.getId()).build();
            InquiryCategory inquiryCategory10 = new InquiryCategory.Builder(inquiry3.getId(), realCategoryInquiry10.getId()).build();

            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory7);
            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory8);
            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory9);
            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory10);

            String name4 = "Compromised Account/Appeal";

            Inquiry nameInquiry4 = new Inquiry.Builder()
                    .name(name4)
                    .build();

            Inquiry inquiry4 = inquiryService.getInquiryByName(nameInquiry4);

            String categoryName11 = "Compromised Account";

            CategoryInquiry categoryInquiry11 = new CategoryInquiry.Builder()
                    .name(categoryName11)
                    .build();

            CategoryInquiry realCategoryInquiry11 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry11);

            String categoryName12 = "Appeal Restriction";

            CategoryInquiry categoryInquiry12 = new CategoryInquiry.Builder()
                    .name(categoryName12)
                    .build();

            CategoryInquiry realCategoryInquiry12 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry12);

            InquiryCategory inquiryCategory11 = new InquiryCategory.Builder(inquiry4.getId(), realCategoryInquiry11.getId()).build();
            InquiryCategory inquiryCategory12 = new InquiryCategory.Builder(inquiry4.getId(), realCategoryInquiry12.getId()).build();

            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory11);
            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory12);

            String name5 = "Other";

            Inquiry nameInquiry5 = new Inquiry.Builder()
                    .name(name5)
                    .build();

            Inquiry inquiry5 = inquiryService.getInquiryByName(nameInquiry5);

            String categoryName13 = "Other Inquiries";

            CategoryInquiry categoryInquiry13 = new CategoryInquiry.Builder()
                    .name(categoryName13)
                    .build();

            CategoryInquiry realCategoryInquiry13 = categoryInquiryService.findQuestionCategoryByName(categoryInquiry13);

            InquiryCategory inquiryCategory13 = new InquiryCategory.Builder(inquiry5.getId(), realCategoryInquiry13.getId()).build();

            inquiryCategoryService.handleInquiryCategoryRegistration(inquiryCategory13);
        }
    }
}
