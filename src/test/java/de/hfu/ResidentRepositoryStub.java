package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository {

    List<Resident> residents = new ArrayList<Resident>(){{
        add(new Resident("Peter", "Altmaier",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12)));
        add(new Resident("Angela", "Merkel",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12)));
        add(new Resident("Angela", "Merkel",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12)));
        add(new Resident("Andi", "Scheuer",
                "*", "*", new Date(12, Calendar.DECEMBER,12)));
    }};

    @Override
    public List<Resident> getResidents() {
        return residents;
    }
}
