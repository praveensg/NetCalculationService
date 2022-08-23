package com.pk.netcalculation;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.pk.netcalculation.controller.NetCalculationController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NetCalculationApplication.class)
class NetCalculationApplicationTests {
	
	@InjectMocks
	NetCalculationController netCalculationController;
	
	
	@Autowired
    WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
    public void initTests() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

	@Test
	public void whenTestApp_thenEmptyResponse() throws Exception {
		this.mockMvc.perform(get("/calculateNetPrice")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}
}
