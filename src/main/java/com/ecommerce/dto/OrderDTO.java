package com.ecommerce.dto;

import com.ecommerce.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private List<OrderItem> items;
    private Long distributionCenterId;

    public Long getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Long getDistributionCenterId() {
        return distributionCenterId;
    }

}
