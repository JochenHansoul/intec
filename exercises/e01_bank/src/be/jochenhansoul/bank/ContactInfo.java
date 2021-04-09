package be.jochenhansoul.bank;

import be.jochenhansoul.bank.Identifier;

public class ContactInfo {
    private Identifier  identifier;
    private long number;

    public ContactInfo(Identifier  identifier, long number) throws Exception {
        this.identifier = identifier;
        this.number = checkNumber(number);
    }

    public void setIdentifier(Identifier  identifier) {
        this.identifier = identifier;
    }

    public void setNumber(long number) throws Exception {
        this.number = checkNumber(number);
    }

    public Identifier  getIdentifier() {
        return this.identifier;
    }

    public long getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return this.identifier + ": " + this.number;
    }

    private long checkNumber(long number) throws Exception {
        if (number >= 0) {
            return number;
        } else {
            throw new Exception("number may not be lower then zero");
        }
    }
}
