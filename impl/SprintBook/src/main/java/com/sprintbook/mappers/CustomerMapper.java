package com.sprintbook.mappers;

import com.sprintbook.dto.CreateCustomer;
import com.sprintbook.dto.Customer;
import com.sprintbook.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerMapper {

    CustomerModel map(Customer customer);

    Customer map(CustomerModel model);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CustomerModel mapCreate(CreateCustomer customer);
}
