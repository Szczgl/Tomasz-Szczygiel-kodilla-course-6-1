package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
public class SearchingFacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private SearchingFacade searchingFacade;

    @Test
    public void searchCompanyName() {

        //GIVEN
        companyDao.save(new Company("AnaCompany"));
        companyDao.save(new Company("AnaCompany2"));
        companyDao.save(new Company("Company"));

        //WHEN
        List<Company> result = searchingFacade.searchCompanyLike("Ana");

        //THEN
        assertEquals(2, result.size());
    }

    @Test
    public void searchEmployeeName() {

        //GIVEN
        employeeDao.save(new Employee("AnaCompany","Test"));
        employeeDao.save(new Employee("AnaCompany2","Test2"));
        employeeDao.save(new Employee("Company","Te3"));

        //WHEN
        List<Employee> result = searchingFacade.searchEmployeeLike("Test");

        //THEN
        assertEquals(2, result.size());
    }


}
