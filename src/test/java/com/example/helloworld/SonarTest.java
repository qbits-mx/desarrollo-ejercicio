package com.example.helloworld;

import org.junit.jupiter.api.Test;
import com.example.helloworld.utilerias.Digestion;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SonarTest{
    @Test
    void contextLoads() {
        Digestion dig = new Digestion();
        int res = dig.errorParaDetecionDeSonar(3, 7);
        assertEquals(res, 10);
    }

}
