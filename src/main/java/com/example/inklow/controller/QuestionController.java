package com.example.inklow.controller;

import com.example.inklow.entities.Question;
import com.example.inklow.service.InquiryService;
import com.example.inklow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping(value = "/api" + QuestionController.QUESTION_ENDPOINTS.QUESTION)
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = QUESTION_ENDPOINTS.GET_ALL, method = RequestMethod.GET)
    public ResponseEntity<?> getAllQuestions() {
        List<Question> listOfQuestions = questionService.getListOfQuestion();

        return ResponseEntity.status(HttpStatus.OK).body(listOfQuestions);
    }

    @RequestMapping(value = QUESTION_ENDPOINTS.GET_FAQ, method = RequestMethod.GET)
    public ResponseEntity<?> getFAQ() {
        List<Question> listOfQuestions = questionService.getListOfFAQ();

        return ResponseEntity.status(HttpStatus.OK).body(listOfQuestions);
    }

    @RequestMapping(value = QUESTION_ENDPOINTS.GET_ALL_FILT, method = RequestMethod.POST)
    public ResponseEntity<?> getAllQuestionsFilteredBy(@RequestParam String filter) {
        List<Question> listOfQuestions = questionService.getListOfQuestionFilteredBy(filter);

        return ResponseEntity.status(HttpStatus.OK).body(listOfQuestions);
    }

    @RequestMapping(value = QUESTION_ENDPOINTS.GET_ALL_CAT, method = RequestMethod.POST)
    public ResponseEntity<?> getAllQuestionsCategorizedBy(@RequestParam String category) {
        List<Question> listOfQuestions = questionService.getListOfQuestionCategorizedBy(category);

        return ResponseEntity.status(HttpStatus.OK).body(listOfQuestions);
    }

    protected static final class QUESTION_ENDPOINTS {
        protected static final String QUESTION = "/question";

        protected static final String GET_ALL = "/getAll";
        protected static final String GET_FAQ = "/getFAQ";

        protected static final String GET_ALL_FILT = "/getAll/filteredBy";
        protected static final String GET_ALL_CAT = "/getAll/categorizedBy";

        protected static final String DELETE_ALL = "/deleteAll";
    }
}
