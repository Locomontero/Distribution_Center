package com.ecommerce.controller;

import com.ecommerce.model.DistributionCenterResponse;
import com.ecommerce.service.IDistributionCenterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class DistributionCenterControllerMockTest {

    @Mock
    private IDistributionCenterService distributionCenterService;

    @InjectMocks
    private DistributionCenterController distributionCenterController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRequestDistributionCenter() {
        String itemId = "item123";
        DistributionCenterResponse mockResponse = new DistributionCenterResponse(List.of("CD1", "CD2", "CD3"));

        when(distributionCenterService.requestDistributionCenter(itemId)).thenReturn(mockResponse);

        DistributionCenterResponse response = distributionCenterController.requestDistributionCenter(itemId);

        assertNotNull(response);
        assertEquals(3, response.getDistributionCenters().size());
        assertTrue(response.getDistributionCenters().contains("CD1"));
        assertTrue(response.getDistributionCenters().contains("CD2"));
        assertTrue(response.getDistributionCenters().contains("CD3"));

        List<String> expectedCenters = List.of("CD1", "CD2", "CD3");
        assertEquals(expectedCenters, response.getDistributionCenters());

        verify(distributionCenterService).requestDistributionCenter(itemId);

        System.out.println("Centros de Distribuição: " + response.getDistributionCenters());
    }
}
