package com.bbd.bursary.manager.Repository;

import com.bbd.bursary.manager.Model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcInstituteRepository implements InstituteInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Institute institute) {
        return jdbcTemplate.update("INSERT INTO Institute_Info (InstituteName, ContactDetailsID, BBDBursaryInstituteStatus) VALUES (?,?,?)",
                new Object[] {
                        institute.getInstituteName()
                });
    }

    public int updateFundAllocation(Institute institute) {
        return jdbcTemplate.update("UPDATE Institution_fund_allocation SET AllocatedAmount WHERE InstituteId=?",
                new Object[] {institute.setAllocatedAmount()}
                );
    }

    public int updateStatus(Institute institute) {
        return jdbcTemplate.update("UPDATE Institute_info SET BBDBursaryInstituteStatus WHERE InstituteID = ?",
                new Object[] { institute.getBbdBursaryInstituteStatus()}
                );
    }

    public int
}
