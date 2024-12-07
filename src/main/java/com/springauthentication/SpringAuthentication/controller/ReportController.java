package com.springauthentication.SpringAuthentication.controller;

import com.springauthentication.SpringAuthentication.repository.ReportRepository;
import com.springauthentication.SpringAuthentication.request.GoodsImportsRevenue;
import com.springauthentication.SpringAuthentication.request.PaymentRevenue;
import com.springauthentication.SpringAuthentication.request.SupplierRevenue;
import com.springauthentication.SpringAuthentication.response.GoodsImportsResponse;
import com.springauthentication.SpringAuthentication.usermodel.UserPaymentInfo;
import com.springauthentication.SpringAuthentication.usermodel.UserSupplierInfo;
import com.springauthentication.SpringAuthentication.userrepository.UserPaymentInfoRepository;
import com.springauthentication.SpringAuthentication.userrepository.UserSupplierInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;

@RestController

@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserPaymentInfoRepository userPaymentInfoRepository;

    @Autowired
    private UserSupplierInfoRepository userSupplierInfoRepository;


    @GetMapping("/")
    List<GoodsImportsResponse> goodsImportsFromSupplier(String fromDate, String toDate, String type, String hospitalCode) throws ParseException {
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
        Date fromDateFormat =formatter.parse(fromDate);
        Date toDateFormat =formatter.parse(toDate);
        List<Object[]> objects=  reportRepository.goodsImportsFromSupplier(fromDateFormat,toDateFormat, type,hospitalCode);
        List<GoodsImportsResponse> results  = new ArrayList<GoodsImportsResponse>();
        objects.forEach(object -> results.add(
                new GoodsImportsResponse(Integer.valueOf(object[6].toString()),
                        object[7].toString(), object[17].toString(),object[18].toString(),
                        object[19].toString(),
                        object[3] ==null ? "": object[3].toString(),
                        object[3] ==null ? "": object[3].toString(),new BigDecimal(object[33].toString()))
        ));
        return results;

    };

    @GetMapping("/totalrevenue")
    List<SupplierRevenue> totalRevenues(String fromDate, String toDate, String type, String hospitalCode) throws ParseException {
        SimpleDateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
        Date fromDateFormat =formatter.parse(fromDate);
        Date toDateFormat =formatter.parse(toDate);
        List<Object[]> objects=  reportRepository.goodsImportsFromSupplier(fromDateFormat,toDateFormat, type,hospitalCode);

        List<GoodsImportsResponse> results  = new ArrayList<GoodsImportsResponse>();
        objects.forEach(object -> results.add(
                new GoodsImportsResponse(Integer.valueOf(object[6].toString()),
                        object[7].toString(), object[17].toString(),object[18].toString(),
                        object[19].toString(),
                        object[3].toString(),object[4].toString(),new BigDecimal(object[33].toString()))
        ));
        List<UserPaymentInfo> paymentInfos = userPaymentInfoRepository.findAll();
        List<UserSupplierInfo> userSupplierInfos = userSupplierInfoRepository.findAll();
        List<GoodsImportsRevenue> goodsImportsRevenues = results.stream()
                .map(e-> new GoodsImportsRevenue(e.getSupplierId(),e.getSupplierName(),e.getItemCode(),e.getItemHospitalCode(),
                        e.getItemName(),e.getInvoiceNo(), e.getInvoiceDate(),Double.parseDouble(e.getAmount().toString())
                        ,userSupplierInfos.size()>0 && userSupplierInfos.stream().filter(userSupplierInfo -> userSupplierInfo.getSupplierId()==
                        e.getSupplierId() && userSupplierInfo.getItemCode()==e.getItemCode()).toList().size()>0 ?
                        userSupplierInfos.stream().filter(userSupplierInfo -> userSupplierInfo.getSupplierId()==
                                e.getSupplierId() && userSupplierInfo.getItemCode().equals(e.getItemCode())).toList().get(0).getRate():0 ,
                                Double.parseDouble(e.getAmount().toString())*(userSupplierInfos.size()>0 && userSupplierInfos.stream().filter(userSupplierInfo -> userSupplierInfo.getSupplierId()==
                                        e.getSupplierId() && userSupplierInfo.getItemCode().equals(e.getItemCode())).toList().size()>0 ?
                                        userSupplierInfos.stream().filter(userSupplierInfo -> userSupplierInfo.getSupplierId()==
                                                e.getSupplierId() && userSupplierInfo.getItemCode().equals(e.getItemCode())).toList().get(0).getRate():0)/100

                                ,Double.parseDouble(e.getAmount().toString()) - Double.parseDouble(e.getAmount().toString())*(userSupplierInfos.size()>0 && userSupplierInfos.stream().filter(userSupplierInfo -> userSupplierInfo.getSupplierId()==
                                e.getSupplierId() && userSupplierInfo.getItemCode().equals(e.getItemCode())).toList().size()>0 ?
                                userSupplierInfos.stream().filter(userSupplierInfo -> userSupplierInfo.getSupplierId()==
                                        e.getSupplierId() && userSupplierInfo.getItemCode().equals(e.getItemCode())).toList().get(0).getRate():0)/100)
                        ).toList();

        List<PaymentRevenue> resultPayments = paymentInfos.stream()
                .filter(p->p.getPaymentDate().before(toDateFormat) && p.getPaymentDate().after(fromDateFormat))
                .collect(groupingBy(x->x.getSupplierId(), Collectors.summarizingDouble(y->
                        Double.parseDouble(y.getAmount().toString()))))
                .entrySet()
                .stream()
                .map(e-> new PaymentRevenue(e.getKey(), e.getValue().getSum())).toList();

        List<SupplierRevenue> totalRevenues =
                goodsImportsRevenues.stream()
                        .collect(groupingBy(x->Arrays.asList(x.getSupplierId(),x.getSupplierName()),
                                Collectors.teeing(
                                        Collectors.summarizingDouble(GoodsImportsRevenue:: getAmount),
                                        Collectors.summarizingDouble(GoodsImportsRevenue::getDiscounts),
                                        Pair::of)

                                )).entrySet().stream().map(e-> new SupplierRevenue(Integer.valueOf(e.getKey().get(0).toString()) , e.getKey().get(1).toString()
                                ,e.getValue().getFirst().getSum()
                                ,resultPayments.size() >= 0 && resultPayments.stream().filter(p->p.getSupplierId() ==
                                Integer.valueOf(e.getKey().get(0).toString())).toList().size()>0 ?
                                       resultPayments.stream().filter(p->p.getSupplierId() ==
                                               Integer.valueOf(e.getKey().get(0).toString())).toList().get(0).getPaymentAmount():0
                                ,e.getValue().getSecond().getSum(),
                                e.getValue().getFirst().getSum()-e.getValue().getSecond().getSum(),
                                goodsImportsRevenues.stream().filter(x->x.getSupplierId()==Integer.valueOf(e.getKey().get(0).toString())).toList()
                                ))
                        .collect(Collectors.toList());
                return totalRevenues;

    }
}
