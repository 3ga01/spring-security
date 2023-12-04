package com.example.springSecurity;

import com.example.springSecurity.controller.UserController;
import com.example.springSecurity.repository.UserRepository;
import com.example.springSecurity.service.userService.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@BeforeEach
	void setUp(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void getLoginShouldReturnLoginView(){
		ModelAndView modelAndView = userController.getLogin();
		assertEquals("login", modelAndView.getViewName());
	}

	@Test
	void contextLoads() {
	}

}
