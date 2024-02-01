package com.asep.test.model;
import com.asep.test.model.Tiket;
import com.asep.test.model.Gate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TiketTest {

    @Test
    public void testGettersAndSetters() {
        Tiket tiket = new Tiket();
        tiket.setIdTiket("T123");

        Gate gate = new Gate();
        gate.setId(1L);
        gate.setNameGate("Gate 1");
        gate.setDescription("Gate description");
        List<Gate> gates = new ArrayList<>();
        gates.add(gate);

        tiket.setGates(gates);

        assertEquals("T123", tiket.getIdTiket());
        assertEquals(gates, tiket.getGates());

        tiket.setIdTiket("T456");

        Gate newGate = new Gate();
        newGate.setId(2L);
        newGate.setNameGate("Gate 2");
        newGate.setDescription("Updated gate description");
        gates.add(newGate);
        tiket.setGates(gates);

        assertEquals("T456", tiket.getIdTiket());
        assertEquals(gates, tiket.getGates());
    }
}