package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Inquiry;
import com.example.inklow.service.InquiryService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(8)
public class InquiryDataSeeds implements ApplicationRunner {
    private final InquiryService inquiryService;

    public InquiryDataSeeds(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (inquiryService.inquiryCount() == 0) {
            Inquiry inquiry1 = new Inquiry.Builder()
                    .name("Report/Restriction")
                    .build();

            Inquiry inquiry2 = new Inquiry.Builder()
                    .name("Technical Issues")
                    .build();

            Inquiry inquiry3 = new Inquiry.Builder()
                    .name("Website")
                    .build();

            Inquiry inquiry4 = new Inquiry.Builder()
                    .name("Compromised Account/Appeal")
                    .build();

            Inquiry inquiry5 = new Inquiry.Builder()
                    .name("Other")
                    .build();

            inquiryService.handleInquiryRegistration(inquiry1);
            inquiryService.handleInquiryRegistration(inquiry2);
            inquiryService.handleInquiryRegistration(inquiry3);
            inquiryService.handleInquiryRegistration(inquiry4);
            inquiryService.handleInquiryRegistration(inquiry5);
        }
    }
}
