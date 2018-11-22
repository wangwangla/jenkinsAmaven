package kw.test.service.impl;

import io.jboot.aop.annotation.Bean;
import kw.test.service.UserService;
import kw.test.model.User;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class UserServiceImpl extends JbootServiceBase<User> implements UserService {

}