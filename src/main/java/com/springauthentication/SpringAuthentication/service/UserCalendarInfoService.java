package com.springauthentication.SpringAuthentication.service;

import com.springauthentication.SpringAuthentication.request.UserCalendarInfoRequest;
import com.springauthentication.SpringAuthentication.usermodel.UserCalendarInfo;
import com.springauthentication.SpringAuthentication.userrepository.UserCalendarInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserCalendarInfoService implements  IUserCalendarInfoService {

    private  final UserCalendarInfoRepository userCalendarInfoRepository;
    @Override
    public List<UserCalendarInfo> findAll() {
        return userCalendarInfoRepository.findAll();
    }

    @Override
    public List<UserCalendarInfo> findByDate(String date) {
        return userCalendarInfoRepository.findByDate(date);
    }

    @Override
    public UserCalendarInfo saveUserCalendarInfo(UserCalendarInfoRequest request) {
        var userCalendarInfoCheckExist = userCalendarInfoRepository.findByCalendarId(request.getCalendarId());
        if (userCalendarInfoCheckExist.isPresent()){
            return userCalendarInfoCheckExist.get();
        }
        UserCalendarInfo userCalendarInfo = new UserCalendarInfo();

        userCalendarInfo.setCalendarId(request.getCalendarId());
        userCalendarInfo.setDate(request.getDate());
        userCalendarInfo.setRecord(request.getRecord());
        userCalendarInfo.setStatus(request.getStatus());
        userCalendarInfo.setFacultyId(request.getFacultyId());
        userCalendarInfo.setFacultyName(request.getFacultyName());

        userCalendarInfo.setPatientId(request.getPatientId());
        userCalendarInfo.setPatientBirthYear(request.getPatientBirthYear());
        userCalendarInfo.setPatientCode(request.getPatientCode());
        userCalendarInfo.setPatientName(request.getPatientName());

        userCalendarInfoRepository.save(userCalendarInfo);
        return userCalendarInfo;

    }
    @Override
    public  UserCalendarInfo updateUserCalendarInfo(Long id, int status){
        UserCalendarInfo userCalendarInfo = userCalendarInfoRepository.findById(id).get();
        userCalendarInfo.setStatus(status);
        userCalendarInfoRepository.save(userCalendarInfo);
        return userCalendarInfo;
    }



    @Override
    public UserCalendarInfo deleteUerCalendarInfo(long id) {
        Optional<UserCalendarInfo> userCalendarInfo = userCalendarInfoRepository.findById(id);
        if(userCalendarInfo.isPresent()){
            userCalendarInfoRepository.deleteById(id);
        }
        return userCalendarInfo.get();
    }

}
