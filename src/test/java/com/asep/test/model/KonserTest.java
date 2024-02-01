package com.asep.test.model;
import com.asep.test.model.Konser;
import com.asep.test.model.Gate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KonserTest {

    @Test
    public void testGettersAndSetters() {

        Konser konser = new Konser();
        konser.setIdKonser("K123");
        konser.setNamaKonser("Concert 1");
        konser.setDescKonser("Concert description");
        konser.setPoster("poster.jpg");
        konser.setActive(true);
        konser.setWaktuPelaksanaan(new Date());

        Gate gate = new Gate();
        gate.setId(1L);
        gate.setNameGate("Gate 1");
        gate.setDescription("Gate description");

        List<Gate> gateList = new ArrayList<>();
        gateList.add(gate);

        konser.setHargaKonser(gateList);

        assertEquals("K123", konser.getIdKonser());
        assertEquals("Concert 1", konser.getNamaKonser());
        assertEquals("Concert description", konser.getDescKonser());
        assertEquals("poster.jpg", konser.getPoster());
        assertEquals(true, konser.isActive());
        assertNotNull(konser.getWaktuPelaksanaan());
        assertEquals(gateList, konser.getHargaKonser());

        konser.setIdKonser("K456");
        konser.setNamaKonser("Concert 2");
        konser.setDescKonser("Updated concert description");
        konser.setPoster("new_poster.jpg");
        konser.setActive(false);
        konser.setWaktuPelaksanaan(new Date());

        Gate newGate = new Gate();
        newGate.setId(2L);
        newGate.setNameGate("Gate 2");
        newGate.setDescription("Updated gate description");

        List<Gate> newGateList = new ArrayList<>();
        newGateList.add(newGate);

        konser.setHargaKonser(newGateList);

        assertEquals("K456", konser.getIdKonser());
        assertEquals("Concert 2", konser.getNamaKonser());
        assertEquals("Updated concert description", konser.getDescKonser());
        assertEquals("new_poster.jpg", konser.getPoster());
        assertEquals(false, konser.isActive());
        assertNotNull(konser.getWaktuPelaksanaan());
        assertEquals(newGateList, konser.getHargaKonser());
    }
}