package com.example.inklow.dataSeeds;

import com.example.inklow.entities.Inquiry;
import com.example.inklow.service.InquiryService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.BadSqlGrammarException;
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
        try {
            inquiryService.inquiryCount();
        } catch (BadSqlGrammarException e) {
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

            Inquiry inquiry6 = new Inquiry.Builder()
                    .name("Game")
                    .build();

            Inquiry inquiry7 = new Inquiry.Builder()
                    .name("In-Game Recovery")
                    .build();

            Inquiry inquiry8 = new Inquiry.Builder()
                    .name("Billing")
                    .build();

            Inquiry inquiry9 = new Inquiry.Builder()
                    .name("Event/Coupon")
                    .build();

            inquiryService.handleInquiryRegistration(inquiry1);
            inquiryService.handleInquiryRegistration(inquiry2);
            inquiryService.handleInquiryRegistration(inquiry3);
            inquiryService.handleInquiryRegistration(inquiry4);
            inquiryService.handleInquiryRegistration(inquiry5);
            inquiryService.handleInquiryRegistration(inquiry6);
            inquiryService.handleInquiryRegistration(inquiry7);
            inquiryService.handleInquiryRegistration(inquiry8);
            inquiryService.handleInquiryRegistration(inquiry9);
        }
    }
}
