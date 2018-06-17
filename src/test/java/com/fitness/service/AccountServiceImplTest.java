//package com.fitness.service;
//
//import com.fitness.request.UserWithAccountRequest;
//import com.fitness.repository.UserRepository;
//import com.fitness.service.impl.AccountServiceImpl;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.mockito.Matchers.anyLong;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class AccountServiceImplTest {
//
//    @Mock
//    UserRepository userRepository;
//
//
//    @InjectMocks
//    AccountServiceImpl accountService;
//
//    @Before
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    public void testSaveWithNullUsersByUserid(){
//        when(userRepository.findOne(anyLong())).thenReturn(null);
//        UserWithAccountRequest userDTOWithAccount = new UserWithAccountRequest();
//        userDTOWithAccount.setAccountName("");
//    }
//
//}
