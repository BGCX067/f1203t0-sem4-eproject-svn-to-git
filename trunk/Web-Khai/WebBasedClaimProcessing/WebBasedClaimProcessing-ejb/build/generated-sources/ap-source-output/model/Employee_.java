package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Account;
import model.BankInfo;
import model.Insurance;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-21T10:02:15")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> employeeID;
    public static volatile SingularAttribute<Employee, String> employeeIDNumber;
    public static volatile SingularAttribute<Employee, Boolean> status;
    public static volatile SingularAttribute<Employee, String> employeeDateOfBirth;
    public static volatile SingularAttribute<Employee, BankInfo> employeeBankID;
    public static volatile SingularAttribute<Employee, String> employeeAccountNumber;
    public static volatile CollectionAttribute<Employee, Insurance> insuranceCollection;
    public static volatile SingularAttribute<Employee, String> employeeCreatedDate;
    public static volatile SingularAttribute<Employee, String> employeeLastName;
    public static volatile CollectionAttribute<Employee, Account> accountCollection;
    public static volatile SingularAttribute<Employee, String> employeeFirstName;
    public static volatile SingularAttribute<Employee, String> employeeMiddleName;
    public static volatile SingularAttribute<Employee, String> employeeAccountCode;

}