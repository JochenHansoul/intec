package be.jochenhansoul.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ContactInfoTest {

    @Test
    public void testGetIdentifier() throws Exception {
        ContactInfo contact = new ContactInfo(Identifier.PHONE, 1L);
        assertEquals(Identifier.PHONE, contact.getIdentifier());
    }

    @Test
    public void testGetNumber() throws Exception {
        ContactInfo contact = new ContactInfo(Identifier.PHONE, 1L);
        assertEquals(1L, contact.getNumber());
    }

    @Test
    public void testSetIdentifier() throws Exception {
        ContactInfo contact = new ContactInfo(Identifier.PHONE, 1L);
        contact.setIdentifier(Identifier.MOBILE_PHONE);
        assertEquals(Identifier.MOBILE_PHONE, contact.getIdentifier());
    }

    @Test
    public void testSetNumber() throws Exception {
        ContactInfo contact = new ContactInfo(Identifier.PHONE, 1L);
        contact.setNumber(2L);
        assertEquals(2L, contact.getNumber());
    }

    @Test
    public void testToString() throws Exception {
        ContactInfo contact = new ContactInfo(Identifier.PHONE, 1L);
        assertEquals("phone: 000000001", contact.toString());
    }
        
    @Test
    public void testToStringWithUnderscores() throws Exception {
        ContactInfo contact = new ContactInfo(Identifier.MOBILE_PHONE, 1L);
        assertEquals("mobile phone: 000000001", contact.toString());
    }
        
    @Test
    public void testConstructorThrowsException() {
        assertThrows(Exception.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                ContactInfo contact = new ContactInfo(Identifier.PHONE, -1L);
            }
        });
    }

    @Test
    public void testSetNumberThrowsException() {
        assertThrows(Exception.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                ContactInfo contact = new ContactInfo(Identifier.PHONE, 1L);
                contact.setNumber(-1L);
            }
        });
    }
}
