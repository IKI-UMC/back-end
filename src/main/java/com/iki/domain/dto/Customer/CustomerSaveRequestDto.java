package com.iki.domain.dto.Customer;

import com.iki.domain.entity.Customer;
import com.iki.domain.entity.Orders;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CustomerSaveRequestDto {
    String customerNumber;
    Long orderId;

}
