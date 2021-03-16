//package com.texas.hamburgeradmin.controller;
//
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.texas.hamburgeradmin.model.Location;
//import com.texas.hamburgeradmin.service.LocationService;
//
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(value = LocationController.class)
//public class HamburgerControllerMockMvcStandAlone {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private LocationService locationService;
//	
//	@Test
//	public void testCreateTicket() throws Exception {
//		
//		Location mockTicket = new Location();
//		mockTicket.setId("abc");
//		mockTicket.setLatitiude("25.222");
//		mockTicket.setLongitude("32.22");
//		mockTicket.setAddress("address");
//		mockTicket.setName("burger");
//		mockTicket.setStatus(true);
//		
//		String inputInJson = this.mapToJson(mockTicket);
//		
//		String URI = "/api/locations";
//		
//		Mockito.when(locationService.createLocation(Mockito.any(Location.class))).thenReturn(mockTicket);
//		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post(URI)
//				.accept(MediaType.APPLICATION_JSON).content(inputInJson)
//				.contentType(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//		
//		String outputInJson = response.getContentAsString();
//		
//		assertThat(outputInJson).isEqualTo(inputInJson);
//		assertEquals(HttpStatus.OK.value(), response.getStatus());
//		
//	
//	}
//	
//	
//	
//	
//	private String mapToJson(Object object) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.writeValueAsString(object);
//	}
//	
//}
