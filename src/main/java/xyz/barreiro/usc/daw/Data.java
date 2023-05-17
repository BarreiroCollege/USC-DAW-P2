package xyz.barreiro.usc.daw;

import xyz.barreiro.usc.daw.models.CD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {
    public static final List<CD> CD_LIST = Collections.unmodifiableList(new ArrayList<CD>() {{
        add(new CD("1", "Yuan", "The Guo Brothers", "China", 14.95));
        add(new CD("2", "Drums of Passion", "Babatunde Olatunji", "Nigeria", 16.95));
        add(new CD("3", "Kaira", "Tounami Diabate", "Mali", 16.95));
        add(new CD("4", "The Lion is Loose", "Eliades Ochoa", "Cuba", 13.95));
        add(new CD("5", "Dance the Devil Away", "Outback", "Australia", 14.95));
        add(new CD("6", "Record of Changes", "Samulnori", "Korea", 12.95));
        add(new CD("7", "Djelika", "Tounami Diabate", "Mali", 14.95));
        add(new CD("8", "Rapture", "Nusrat Fateh Ali Khan", "Pakistan", 12.95));
        add(new CD("9", "Cesaria Evora", "Cesaria Evora", "Cape Verde", 16.95));
        add(new CD("10", "DAA", "GSTIC", "Spain", 50.00));
    }});

    public final List<CD> getCdList() {
        return CD_LIST;
    }

    public static CD getCdById(String id) {
        for (CD cd : CD_LIST) {
            if (cd.getId().equals(id)) {
                return cd;
            }
        }

        return null;
    }
}
