package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Claim;
import model.Employee;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-21T10:02:15")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> accountCreatedDate;
    public static volatile SingularAttribute<Account, Integer> accountID;
    public static volatile SingularAttribute<Account, Employee> employeeID;
    public static volatile CollectionAttribute<Account, Claim> claimCollection;
    public static volatile SingularAttribute<Account, Boolean> status;
    public static volatile SingularAttribute<Account, String> accountImage;
    public static volatile SingularAttribute<Account, String> accountAddress;
    public static volatile SingularAttribute<Account, String> accountPassword;
    public static volatile SingularAttribute<Account, String> accountUsername;
    public static volatile SingularAttribute<Account, String> accountEmail;
    public static volatile SingularAttribute<Account, String> accountPhoneNumber;

}