package com.asep.test.model;


import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbsModelTest {

    @Test
    public void testCreateDateNotNull() {
        Konser concreteModel = new Konser();
        concreteModel.setCreatedate(new Date());
        assertNotNull(concreteModel.getCreatedate());
    }

    @Test
    public void testUpdateDateNotNull() {
        Konser concreteModel = new Konser();
        concreteModel.setUpdatdate(new Date());
        assertNotNull(concreteModel.getUpdatdate());
    }

    @Test
    public void testCreateDateBeforeUpdateDate() {
        Konser concreteModel = new Konser();
        concreteModel.setCreatedate(new Date());
        concreteModel.setUpdatdate(new Date());

        Date createDate = concreteModel.getCreatedate();
        Date updateDate = concreteModel.getUpdatdate();
        assertNotNull(createDate);
        assertNotNull(updateDate);
        assertEquals(0, createDate.compareTo(updateDate));
    }
}