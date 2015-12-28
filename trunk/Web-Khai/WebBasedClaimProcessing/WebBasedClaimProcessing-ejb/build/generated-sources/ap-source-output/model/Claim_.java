package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Account;
import model.Insurance;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-21T10:02:15")
@StaticMetamodel(Claim.class)
public class Claim_ { 

    public static volatile SingularAttribute<Claim, String> claimHospitalAddress;
    public static volatile SingularAttribute<Claim, String> claimDate;
    public static volatile SingularAttribute<Claim, Integer> claimID;
    public static volatile SingularAttribute<Claim, Account> accountID;
    public static volatile SingularAttribute<Claim, String> claimAttachment;
    public static volatile SingularAttribute<Claim, String> claimHospitalName;
    public static volatile SingularAttribute<Claim, Insurance> insuranceID;
    public static volatile SingularAttribute<Claim, String> claimHospitalPhone;
    public static volatile SingularAttribute<Claim, Boolean> status;
    public static volatile SingularAttribute<Claim, String> claimStatus;
    public static volatile SingularAttribute<Claim, String> claimHospitalFax;
    public static volatile SingularAttribute<Claim, String> claimHospitalEmail;
    public static volatile SingularAttribute<Claim, Double> claimAmount;
    public static volatile SingularAttribute<Claim, String> claimReason;

}