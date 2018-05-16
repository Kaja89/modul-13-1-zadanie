package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SearchingFacade {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public static final Logger LOGGER = LoggerFactory.getLogger(SearchingFacade.class);

    public void prepareData() throws DataException {
        LOGGER.info("Preparing data...");
        try{
            createAndSafeCompaniesAndEmployees();
            LOGGER.info("Data created");
        } catch(DataException e){
            throw new DataException(DataException.DATABASE_EXCEPTION);
        }
    }


    public void createAndSafeCompaniesAndEmployees() throws DataException{

        Company softwareMachine = new Company("SoftwareMachine");
        Company dataMaesters = new Company("DataMaesters");
        Company greyMatter = new Company("GreyMatter");

        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
    }

    public List<Employee> findEmployeeByLastName(String frag) throws DataException {
        LOGGER.info("Looking for employees");
        List<Employee> retrievedEmployees = employeeDao.findEmployeeByLastname(frag);
        for(Employee employee: retrievedEmployees){
            LOGGER.info("Employee " + employee.getFirstname() + " " + employee.getLastname() + " has been found");
        }
        if(retrievedEmployees.isEmpty()){
            LOGGER.info("No such employee exists " + DataException.COMPANY_NOT_FOUND);
            throw new DataException(DataException.EMPLOYEE_NOT_FOUND);
        }
        return retrievedEmployees;
    }

    public List<Company> findByCompanyName(String frag) throws DataException{
        LOGGER.info("Looking for companies");
        List<Company> retrievedCompanies= companyDao.findByThreeSigns(frag);
        for(Company company: retrievedCompanies){
            LOGGER.info("Company " + company.getName() + " has been found");
        }
        if(retrievedCompanies.isEmpty()){
            LOGGER.info("No such company exists " + DataException.COMPANY_NOT_FOUND);
            throw new DataException(DataException.COMPANY_NOT_FOUND);
        }
        return retrievedCompanies;
    }

}
