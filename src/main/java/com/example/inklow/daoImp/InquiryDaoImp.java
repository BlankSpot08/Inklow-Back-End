package com.example.inklow.daoImp;

import com.example.inklow.dao.InquiryDao;
import com.example.inklow.entities.Inquiry;
import com.example.inklow.mapper.InquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InquiryDaoImp implements InquiryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InquiryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Inquiry> listOfInquiries() {
        String query = "SELECT * FROM inquiries;";

        List<Inquiry> listOfInquiry = jdbcTemplate.query(query, new InquiryMapper());

        return listOfInquiry;
    }

    @Override
    public Inquiry findInquiryById(Inquiry inquiry) {
        String query = "SELECT * FROM inquiries WHERE id = ?;";

        Inquiry temp = jdbcTemplate.queryForObject(query, new Object[] { inquiry.getId() }, new InquiryMapper());

        if (temp == null) {
            return null;
        }

        return temp;
    }

    @Override
    public Inquiry addInquiry(Inquiry inquiry) {
        String query = "INSERT INTO inquiries(name) VALUES(?);";

        int statusCode = jdbcTemplate.update(query, inquiry.getName());

        if (statusCode == 0) {
            return null;
        }

        return inquiry;
    }

    @Override
    public Inquiry deleteInquiry(Inquiry inquiry) {
        String query = "DELETE FROM inquiries WHERE id = ?;";

        int statusCode = jdbcTemplate.update(query, inquiry.getId());

        if (statusCode == 0) {
            return null;
        }

        return inquiry;
    }

    @Override
    public Inquiry updateInquiry(Inquiry inquiry) {

        String query = "UPDATE inquiries " +
                "SET name = ? " +
                "WHERE id = ?;";

        int statusCode = jdbcTemplate.update(query,
                inquiry.getName(),
                inquiry.getId());

        if (statusCode == 0) {
            return null;
        }

        return inquiry;
    }

    @Override
    public Boolean removeAllInquiry() {
        String query = "DELETE FROM inquiries";

        int statusCode = jdbcTemplate.update(query);

        if (statusCode == 0) {
            return null;
        }

        return true;
    }
}
