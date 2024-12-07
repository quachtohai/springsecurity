package com.springauthentication.SpringAuthentication.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CustomReportRepositoryImpl implements  CustomReportRepository{
    @PersistenceContext(unitName ="patientEntityManager")
    private @Qualifier("patientEntityManager") EntityManager entityManager;
    @Override
    @Transactional
    public List<Object[]> goodsImportsFromSupplier(Date fromdate, Date todate, String type, String hospitalCode) {

        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery( "PHA00B00501_BKTHNDTNCC_PO" );
        query.registerStoredProcedureParameter( 1, String.class, ParameterMode.IN );
        query.registerStoredProcedureParameter( 2, Date.class, ParameterMode.IN );
        query.registerStoredProcedureParameter( 3, Date.class, ParameterMode.IN );
        query.registerStoredProcedureParameter( 4, String.class, ParameterMode.IN );
        query.setParameter( 1, hospitalCode );
        query.setParameter( 2, fromdate );
        query.setParameter( 3, todate );
        query.setParameter( 4, type );

        query.execute();
        return query.getResultList();

    };
}



