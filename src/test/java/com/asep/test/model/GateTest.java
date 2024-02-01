package com.asep.test.model;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GateTest {

    @Test
    public void testGettersAndSetters() {
        Gate gate = new Gate();
        gate.setId(1L);
        gate.setNameGate("Gate 1");
        gate.setDescription("Gate description");
        gate.setHarga(BigInteger.valueOf(50));

        List<Gate> gates = new ArrayList<>();
        gates.add(gate);

        Tiket tiket = new Tiket();
        tiket.setIdTiket("T123");
        tiket.setGates(gates);

        List<Tiket> tiketList = new ArrayList<>();
        tiketList.add(tiket);

        gate.setTiket(tiketList);

        assertEquals(1L, gate.getId());
        assertEquals("Gate 1", gate.getNameGate());
        assertEquals("Gate description", gate.getDescription());
        assertEquals(BigInteger.valueOf(50), gate.getHarga());
        assertEquals(tiketList, gate.getTiket());

        gate.setId(2L);
        gate.setNameGate("Gate 2");
        gate.setDescription("Updated gate description");
        gate.setHarga(BigInteger.valueOf(100));
        gates.add(gate);
        Tiket newTiket = new Tiket();
        newTiket.setIdTiket("T456");
        newTiket.setGates(gates);

        List<Tiket> newTiketList = new ArrayList<>();
        newTiketList.add(newTiket);

        gate.setTiket(newTiketList);

        assertEquals(2L, gate.getId());
        assertEquals("Gate 2", gate.getNameGate());
        assertEquals("Updated gate description", gate.getDescription());
        assertEquals(BigInteger.valueOf(100), gate.getHarga());
        assertEquals(newTiketList, gate.getTiket());
    }
}