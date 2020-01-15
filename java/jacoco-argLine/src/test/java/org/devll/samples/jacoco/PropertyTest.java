package org.devll.samples.jacoco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PropertyTest {
    @Test
    void systemPropertyIsSet() {
        assertEquals(System.getProperty("foo"), "bar");
    }
}
