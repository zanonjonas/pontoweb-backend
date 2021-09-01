package br.com.zanonjonas.pontoweb.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.zanonjonas.pontoweb.model.User;
import br.com.zanonjonas.pontoweb.service.UserService;
import br.com.zanonjonas.pontoweb.testutils.TestUtils;
import br.com.zanonjonas.pontoweb.utils.JsonUtils;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	void testGetAllUsers() throws Exception {
		User userMock = new User(1L, "Jonas Zanon", "jonas.zanon");

		List<User> userMockList = new ArrayList<User>();
		userMockList.add(userMock);

		when(userService.getUsers()).thenReturn(userMockList);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/user");
		
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().json(JsonUtils.toJson(userMockList)));
	}
	
	@Test
	void testCreateUser() throws Exception {
		User newUser = new User(1L, "Jonas Zanon", "jonas.zanon");
				
		when(userService.createUser()).thenReturn(newUser);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user2")
				.content(TestUtils.objToJson(newUser));
		
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().json(JsonUtils.toJson(newUser)));
	}
	
	

}
