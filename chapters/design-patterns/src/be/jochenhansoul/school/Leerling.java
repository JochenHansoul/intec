package be.jochenhansoul.school;

import java.lang.StringBuilder;

public class Leerling {
    private String name;
    private String actie = "";
    private String description = "";

    public Leerling(String name) {
        this.name = name;
    }

    public String getInfo(Modus modus) {
        if (modus.equals(Modus.DAD)) {
            return this.name;
        } else if (modus.equals(Modus.ME)) {
            return this.name + " " + this.actie;
        } else {
            return this.name + " " + this.actie + " " + this.description;
        }
    }
}
