package be.jochenhansoul.bank.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class AddressTest {
    private Address address;

    @BeforeEach
    public void testCreateAddress() {
        this.address = new Address(
            "Langenakkerstraat",
            47,
            "b",
            3830,
            "Wellen",
            "Belgie");
    }

    @Test
    public void testGetStreet() {
        assertEquals("Langenakkerstraat", this.address.getStreet());
    }

    @Test
    public void testGetNumber() {
        assertEquals(47, this.address.getNumber());
    }

    @Test
    public void testGetNumberAddition() {
        assertEquals("b", this.address.getNumberAddition());
    }

    @Test
    public void testGetPostalCode() {
        assertEquals(3830, this.address.getPostalCode());
    }

    @Test
    public void testGetCity() {
        assertEquals("Wellen", this.address.getCity());
    }

    @Test
    public void testGetCountry() {
        assertEquals("Belgie", this.address.getCountry());
    }

    @Test
    public void testToString() {
        assertEquals("Langenakkerstraat 47b, 3830 Wellen, Belgie", this.address.toString());
    }
}
