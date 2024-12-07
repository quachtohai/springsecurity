package com.springauthentication.SpringAuthentication.repository;

import java.util.Date;
import java.util.List;

public interface CustomReportRepository {
    List<Object[]> goodsImportsFromSupplier(Date fromdate, Date todate, String type, String hospitalCode);
}
