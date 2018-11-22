package kwm.test.service.impl;

import io.jboot.aop.annotation.Bean;
import kwm.test.service.AdminService;
import kwm.test.model.Admin;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class AdminServiceImpl extends JbootServiceBase<Admin> implements AdminService {

}