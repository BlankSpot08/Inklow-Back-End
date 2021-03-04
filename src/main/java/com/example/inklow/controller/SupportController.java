package com.example.inklow.controller;

import com.example.inklow.entities.Question;
import com.example.inklow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping(value = "/api" + SupportController.SUPPORT_ENDPOINTS.SUPPORT)
public class SupportController {
    private final QuestionService questionService;

    @Autowired
    public SupportController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = SUPPORT_ENDPOINTS.QUESTION_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllQuestions() {
        List<Question> listOfQuestions = questionService.getListOfQuestion();

        return ResponseEntity.status(HttpStatus.OK).body(listOfQuestions);
    }

    protected static final class SUPPORT_ENDPOINTS {
        protected static final String SUPPORT = "/support";

        protected static final class QUESTION_ENDPOINTS {
            private static final String QUESTION = "/question";

            protected static final String GET_ALL = QUESTION + "/getAll";

            protected static final String DELETE_ALL = QUESTION + "/deleteAll";
        }

        protected static final class INQUIRY_ENDPOINTS {
            private static final String INQUIRY = "/inquiry";

            protected static final String GET_ALL = INQUIRY + "/getAll";

            protected static final String DELETE_ALL = INQUIRY + "/deleteAll";
        }
    }
}

