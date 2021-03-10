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
        CategoryInquiry categoryInquiry1 = new CategoryInquiry.Builder()
                .name("")
                .build();

        categoryInquiryService.handleQuestionCategoryRegistration(categoryInquiry1);
    }
}
