package com.sprintbook.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.sprintbook.dto.CreateCustomer;
import com.sprintbook.dto.Customer;
import com.sprintbook.repository.CustomerRepository;
import com.sprintbook.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.hamcrest.Matchers.greaterThan;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")
class CustomerControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void addTest() throws Exception {
        UUID customerId = UUID.randomUUID();
        Customer customer = Customer.builder().firstName("Clement").lastName("Ho").middleName(null).email("myworkemail@gmail.com").build();

        when(customerService.Add( new CreateCustomer() )).thenReturn(customer);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/customer")
                        .contentType("application/json").content( objectMapper.writeValueAsString(customer) ))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect( jsonPath("$.firstName").value(customer.getFirstName()))
                .andExpect( jsonPath("$.lastName").value(customer.getLastName()) )
                .andExpect( jsonPath("$.email").value(customer.getEmail()) )
                .andReturn();
    }

    @Test
    void indexTest() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.get("/customer").contentType("application/json") )
                .andDo( print())
                .andExpect(jsonPath("$.*").isArray())
                .andExpect( status().is2xxSuccessful() );

    }

    @Test
    void findById() throws Exception {
        UUID customerId = UUID.randomUUID();
        Customer customer = Customer.builder().id(customerId).firstName("Clement").lastName("Ho").middleName(null).email("myworkemail@gmail.com").build();
        when(customerService.FindById(customerId)).thenReturn( customer  );

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/customer/" + customerId).contentType("application/json"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        assertEquals(JsonPath.parse(response).read("$.id").toString(), customerId.toString());
    }

    @Test
    void findByIdBadRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/customer/badrequest" ).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
    }

    @Test
    void deleteTestBadRequest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/customer/badrequest" ).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void deleteTestSuccessfull() throws Exception {
        UUID customerId = UUID.randomUUID();
        Customer customer = Customer.builder().id(customerId).firstName("Clement").lastName("Ho").middleName(null).email("myworkemail@gmail.com").build();
        when(customerService.FindById(customerId)).thenReturn( customer  );

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/customer/" + customerId ).contentType("application/json"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }
}