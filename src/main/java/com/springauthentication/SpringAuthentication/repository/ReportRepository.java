package com.springauthentication.SpringAuthentication.repository;

import com.springauthentication.SpringAuthentication.model.PatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReportRepository extends JpaRepository<PatientInfo, Long>, CustomReportRepository {

     List<Object[]> goodsImportsFromSupplier(Date fromdate, Date todate, String type, String hospitalCode);
}
