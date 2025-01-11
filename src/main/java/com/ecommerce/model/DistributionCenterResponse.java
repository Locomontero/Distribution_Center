package com.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class DistributionCenterResponse {

    private List<String> distributionCenters;
}
