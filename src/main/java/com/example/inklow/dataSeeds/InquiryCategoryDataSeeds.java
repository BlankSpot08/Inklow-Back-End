package com.example.inklow.dataSeeds;

import com.example.inklow.service.InquiryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(9)
public class InquiryCategoryDataSeeds implements ApplicationRunner {
    private final InquiryCategoryService inquiryCategoryService;

    @Autowired
    public InquiryCategoryDataSeeds(InquiryCategoryService inquiryCategoryService) {
        this.inquiryCategoryService = inquiryCategoryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (inquiryCategoryService.inquiryCategoryCount() == 0) {

        }
    }
}
