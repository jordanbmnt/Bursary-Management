package com.bbd.bursary.manager.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcInstituteRepository implements InstituteInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Institute institute) {
        return jdbcTemplate.update("INSERT INTO Institute_Info")
    }
}
