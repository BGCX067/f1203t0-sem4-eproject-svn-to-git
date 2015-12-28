package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-21T10:02:15")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, String> newsCreatedDate;
    public static volatile SingularAttribute<News, Integer> newsID;
    public static volatile SingularAttribute<News, Boolean> status;
    public static volatile SingularAttribute<News, String> newsDescription;
    public static volatile SingularAttribute<News, String> newsContent;
    public static volatile SingularAttribute<News, String> newsTitle;

}