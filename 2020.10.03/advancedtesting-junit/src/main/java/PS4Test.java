package main.java;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PS4Test {
    private static PS4 ps4;

    @BeforeEach
    void setUp() {
        ps4 = new PS4();
    }

    @Test
    void bePoweredAfterPowerToggle() {
        ps4.powerToggle();

        assertTrue(ps4.isPowered());
    }

    @Test
    @DisplayName("should be unpowered if power button was not touched")
    void beUnpowered() {
        assertFalse(ps4.isPowered());
    }

    @Test
    void shouldBeUnpoweredAfterTogglingThePowerTwice() {
        ps4.powerToggle();
        ps4.powerToggle();

        assertFalse(ps4.isPowered());
    }

}