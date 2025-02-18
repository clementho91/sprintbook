package com.sprintbook.mappers;

import com.sprintbook.dto.Customer;
import com.sprintbook.model.CustomerModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerModel map(Customer customer);

    Customer map(CustomerModel model);
}
