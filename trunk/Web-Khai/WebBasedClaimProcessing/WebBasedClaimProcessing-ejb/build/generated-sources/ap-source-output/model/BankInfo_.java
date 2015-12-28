package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Employee;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-21T10:02:15")
@StaticMetamodel(BankInfo.class)
public class BankInfo_ { 

    public static volatile CollectionAttribute<BankInfo, Employee> employeeCollection;
    public static volatile SingularAttribute<BankInfo, String> bankName;
    public static volatile SingularAttribute<BankInfo, Integer> bankID;
    public static volatile SingularAttribute<BankInfo, String> bankAddress;

}