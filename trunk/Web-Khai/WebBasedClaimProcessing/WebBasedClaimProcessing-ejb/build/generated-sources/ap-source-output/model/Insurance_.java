package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Claim;
import model.Employee;
import model.InsuranceType;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-21T10:02:15")
@StaticMetamodel(Insurance.class)
public class Insurance_ { 

    public static volatile SingularAttribute<Insurance, Employee> employeeID;
    public static volatile SingularAttribute<Insurance, Integer> insuranceID;
    public static volatile CollectionAttribute<Insurance, Claim> claimCollection;
    public static volatile SingularAttribute<Insurance, String> insurancePolicyNumber;
    public static volatile SingularAttribute<Insurance, InsuranceType> insuranceTypeID;

}