package com.springauthentication.SpringAuthentication.repository;

import com.springauthentication.SpringAuthentication.model.PatientInfo;
import com.springauthentication.SpringAuthentication.model.RecordInfo;
import com.springauthentication.SpringAuthentication.model.ServiceRequest;
import com.springauthentication.SpringAuthentication.response.RecordInfoResponse;
import org.apache.coyote.RequestInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class RecordInfoRepositoryImpl implements  CustomRecordInfoRepository{
    @PersistenceContext(unitName ="patientEntityManager")
    private @Qualifier("patientEntityManager") EntityManager entityManager;

    @Override
    @Transactional
    public Object [] findRecordInfoByFacultyIdAndStatus(int facultyId, String status) throws NoSuchFieldException, IllegalAccessException {
        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();
        var query = entityManager.createNativeQuery("select a.BENHAN_ID, a.SOBENHAN, a.BENHNHAN_ID, a.TRANGTHAI, " +
                "a.THOIGIANVAOVIEN, a.THOIGIANRAVIEN, a.TIEPNHAN_ID,  a.CHANDOANVAOKHOA, a.CHANDOANKHAC, a.KHOAVAO_ID" +
                ", a.CHANDOANKHAMBENH, a.CHANDOANPHU,  a.CHANDOANTUYENDUOI, a.CHANDOANICDPHANBIET , a.CHANDOANICDPHUVAOKHOA, a.CHANDOANRAVIEN,  b.TENBENHNHAN" +
                " from TT_Noitru_benhan a join TT_BENHNHAN b on a.Benhnhan_id = b.Benhnhan_id  where khoavao_id = "
                + String.valueOf(facultyId) + " and trangthai = '" + status +"'" );

        List<Object[]> resultList = query.getResultList();
        List<RecordInfoResponse> recordInfos = new ArrayList<>();
        Set<Integer> patiendIs = new HashSet<>();
        Set<Integer> recordIds = new HashSet<>();
        if (!resultList.isEmpty()){
            for (int i=0; i < resultList.size(); i++){
                recordInfos.add( new RecordInfoResponse(
                        Integer.valueOf(resultList.get(i)[0].toString()),
                        resultList.get(i)[1].toString(),
                        Integer.valueOf(resultList.get(i)[2].toString()),
                        resultList.get(i)[3].toString(),
                        LocalDateTime.parse(((Timestamp)resultList.get(i)[4]).toLocalDateTime()
                                .toString().replace("+0700","")),
                        resultList.get(i)[5] == null? null:LocalDateTime.parse(resultList.get(i)[5].toString()),
                        Integer.valueOf(resultList.get(i)[6].toString()),
                        resultList.get(i)[7] ==null?null: resultList.get(i)[7].toString(),
                        resultList.get(i)[8] ==null? null: resultList.get(i)[8].toString(),
                        Integer.valueOf(resultList.get(i)[9].toString()),
                        resultList.get(i)[9] ==null?null: resultList.get(i)[9].toString(),
                        resultList.get(i)[10] ==null?null: resultList.get(i)[10].toString(),
                        resultList.get(i)[11] ==null?null: resultList.get(i)[11].toString(),
                        resultList.get(i)[12] ==null?null: resultList.get(i)[12].toString(),
                        resultList.get(i)[13] ==null?null: resultList.get(i)[13].toString(),
                        resultList.get(i)[14] ==null?null: resultList.get(i)[14].toString(),
                        null, null
                        ,resultList.get(i)[4].toString()
                        ,resultList.get(i)[5] == null? null:resultList.get(i)[5].toString()
                        ,resultList.get(i)[16].toString()

                ));
                patiendIs.add(Integer.valueOf(resultList.get(i)[2].toString()));
                recordIds.add(Integer.valueOf(resultList.get(i)[0].toString()));

            }

}
        List finalResults = entityManager.createQuery("select a from ServiceRequest a"
                        + " where a.recordInfo.recordId in :recordIds", ServiceRequest.class)
                .setParameter("recordIds", recordIds)
                .getResultList();

        return new Object []{recordInfos,finalResults};
}
}
