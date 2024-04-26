package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SearchingFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchingFacade.class);


    public List<Employee> searchEmployeeLike(String name){
        List<Employee> employees = employeeDao.retrieveEmployeeLike(name);
        if (employees.size() >=1) {
            LOGGER.info("Znalazłem pracowników");
        } else {
            LOGGER.error("Nie znalazłem pracowników");
        }
        return employees;
    }

    public List<Company> searchCompanyLike(String name) {
        List<Company> companies = companyDao.retrieveCompanyLike(name);
        if (companies.size() >=1) {
            LOGGER.info("Znalazłem firmy");
        } else {
            LOGGER.error("Nie znalazłem firmy");
        }
        return companies;
    }


}
