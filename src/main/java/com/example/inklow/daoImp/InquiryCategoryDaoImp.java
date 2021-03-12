package com.example.inklow.daoImp;

import com.example.inklow.dao.InquiryCategoryDao;
import com.example.inklow.dao.InquiryDao;
import com.example.inklow.entities.CategoryInquiry;
import com.example.inklow.entities.Inquiry;
import com.example.inklow.entities.InquiryCategory;
import com.example.inklow.mapper.CategoryInquiryMapper;
import com.example.inklow.mapper.InquiryCategoryMapper;
import com.example.inklow.mapper.InquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class InquiryCategoryDaoImp implements InquiryCategoryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InquiryCategoryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<InquiryCategory> getListOfInquiryCategory() {
        String query = "" +
                "SELECT * FROM inquiry_categories;";

        List<InquiryCategory> listOfInquiryCategory = jdbcTemplate.query(query, new InquiryCategoryMapper());

        return listOfInquiryCategory;
    }

    @Override
    public List<CategoryInquiry> getInquiryCategoriesById(Inquiry inquiry) {
        String query = "" +
                "SELECT * FROM inquiry_categories AS ic " +
                "JOIN category_inquiry AS ci " +
                "ON ci.id = ic.inquiry_categoryId " +
                "WHERE ic.inquiryId = ?;";

        List<CategoryInquiry> listOfInquiryCategory = jdbcTemplate.query(query, new Object[] { inquiry.getId() }, new CategoryInquiryMapper());

        return listOfInquiryCategory;
    }

    @Override
    public CategoryInquiry getInquiryCategoryById(InquiryCategory inquiryCategory) {
        String query = "" +
                "SELECT * FROM inquiry_categories AS ic " +
                "WHERE ic.inquiryId = ? AND ic.inquiry_categoryId = ?;";

        CategoryInquiry temp = jdbcTemplate.queryForObject(
                query,
                new Object[] {inquiryCategory.getInquiryId(), inquiryCategory.getCategoryId()},
                new CategoryInquiryMapper());

        return temp;
    }

    @Override
    public InquiryCategory addInquiryCategory(InquiryCategory inquiryCategory) {
        String query = "" +
                "INSERT INTO inquiry_categories(inquiryId, inquiry_categoryId) " +
                "VALUES(?, ?);";

        int statusCode = jdbcTemplate.update(query, inquiryCategory.getInquiryId(), inquiryCategory.getCategoryId());

        if (statusCode == 0) {
            return null;
        }

        return inquiryCategory;
    }

    @Override
    public InquiryCategory removeInquiryCategory(InquiryCategory inquiryCategory) {
        String query = "" +
                "DELETE FROM inquiry_categories " +
                "WHERE inquiryId = ? AND inquiry_categoryId = ?;";

        int statusCode = jdbcTemplate.update(query, inquiryCategory.getInquiryId(), inquiryCategory.getCategoryId());

        if (statusCode == 0) {
            return null;
        }

        return inquiryCategory;

    }

    @Override
    public Boolean removeAllInquiryCategory() {
        String query = "" +
                "DELETE FROM inquiry_categories";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}
