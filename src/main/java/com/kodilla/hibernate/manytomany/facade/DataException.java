package com.kodilla.hibernate.manytomany.facade;

public class DataException extends Exception {
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found";
    public static final String COMPANY_NOT_FOUND = "Company not found";
    public static final String DATABASE_EXCEPTION = "Problems with data persistance";

    public DataException(String message){
        super(message);
    }
}
