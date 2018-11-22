package kwm.test.service.impl;

import io.jboot.aop.annotation.Bean;
import kwm.test.service.UserService;
import kwm.test.model.User;
import io.jboot.service.JbootServiceBase;

import javax.inject.Singleton;

@Bean
@Singleton
public class UserServiceImpl extends JbootServiceBase<User> implements UserService {

}