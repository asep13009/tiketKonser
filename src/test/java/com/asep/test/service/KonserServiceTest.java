package com.asep.test.service;
import com.asep.test.model.Konser;
import com.asep.test.service.KonserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class KonserServiceTest {

    @Mock
    private KonserService konserService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearch() {
        String searchQuery = "concert";

        List<Konser> konserList = new ArrayList<>();
        konserList.add(new Konser("K123", "Concert 1"));
        konserList.add(new Konser("K456", "Concert 2"));

        when(konserService.search(searchQuery)).thenReturn(konserList);

        List<Konser> result = konserService.search(searchQuery);

        verify(konserService, times(1)).search(searchQuery);
        assertEquals(konserList, result);
    }

    @Test
    public void testCreate() {
        Konser konser = new Konser("K123", "Concert 1");

        when(konserService.create(konser)).thenReturn(konser);

        Konser result = konserService.create(konser);

        verify(konserService, times(1)).create(konser);
        assertEquals(konser, result);
    }

}