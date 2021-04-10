package be.jochenhansoul.bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactInfoTest {

    @Test
    public void testType() {
        ContactInfo contact = new ContactInfo(Identifier.PHONE, 1L);
        assertEquals(Identifier.PHONE, contact.getIdentifier());
    }
}
