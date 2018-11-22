package kw.test.service.impl;

import io.jboot.aop.annotation.Bean;
import kw.test.model.request.AdminLoginRequest;
import kw.test.service.AdminService;
import kw.test.model.Admin;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;
import java.util.List;

@Bean
@Singleton
public class AdminServiceImpl extends JbootServiceBase<Admin> implements AdminService {

    @Override
    public List<Admin> login(AdminLoginRequest adminLoginRequest) {
        return DAO.find("select *from admin where username='"+adminLoginRequest.getUserName()+"' and password='"+adminLoginRequest.getPassword()+"'");
    }
}