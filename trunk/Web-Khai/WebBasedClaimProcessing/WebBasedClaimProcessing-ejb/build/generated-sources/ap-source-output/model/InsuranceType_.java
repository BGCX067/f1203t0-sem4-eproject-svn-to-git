package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Insurance;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-21T10:02:15")
@StaticMetamodel(InsuranceType.class)
public class InsuranceType_ { 

    public static volatile SingularAttribute<InsuranceType, String> insuranceTypeName;
    public static volatile SingularAttribute<InsuranceType, String> insuranceTypeContent;
    public static volatile SingularAttribute<InsuranceType, Boolean> status;
    public static volatile SingularAttribute<InsuranceType, Integer> insuranceTypeID;
    public static volatile CollectionAttribute<InsuranceType, Insurance> insuranceCollection;
    public static volatile SingularAttribute<InsuranceType, Double> insuranceTypeMaximumReimbursement;
    public static volatile SingularAttribute<InsuranceType, String> insuranceTypeCreatedDate;
    public static volatile SingularAttribute<InsuranceType, String> insuranceTypeDescription;

}