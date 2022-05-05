package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class ResidentServiceTest {

    @Test
    public void testGetUniqueResidentMockWildcardTest() throws ResidentServiceException {
        BaseResidentService brs = new BaseResidentService();
        ResidentRepository mock = createMock(ResidentRepository.class);
        List<Resident> l = new ArrayList<Resident>(){{
            add(new Resident("Andi", "Scheuer",
                    "*", "*", new Date(12, Calendar.DECEMBER,12)));}};
        expect(mock.getResidents()).andReturn(l);
        replay(mock);
        brs.setResidentRepository(mock);
        Resident r1 = new Resident("Andi", "Scheuer",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12));
        try {
            Resident r2 = brs.getUniqueResident(r1);
            fail();
        } catch(Exception e) {}
    }

    @Test
    public void testGetUniqueResidentExist() throws ResidentServiceException {
        BaseResidentService brs = new BaseResidentService();
        brs.setResidentRepository(new ResidentRepositoryStub());
        Resident r1 = new Resident("Peter", "Altmaier",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12));
        Resident r2 = brs.getUniqueResident(r1);
        assertEquals(r1.getFamilyName(), r2.getFamilyName());
        assertEquals(r1.getGivenName(), r2.getGivenName());
        assertEquals(r1.getStreet(), r2.getStreet());
        assertEquals(r1.getDateOfBirth(), r2.getDateOfBirth());
    }

    @Test
    public void testGetUniqueResidentWildcard() throws ResidentServiceException {
        BaseResidentService brs = new BaseResidentService();
        brs.setResidentRepository(new ResidentRepositoryStub());
        Resident r1 = new Resident("Friedrich", "*",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12));
        try {
            Resident r2 = brs.getUniqueResident(r1);
            fail();
        } catch(Exception e) {}
    }

    @Test
    public void testGetUniqueResidentExistTwice() throws ResidentServiceException {
        BaseResidentService brs = new BaseResidentService();
        brs.setResidentRepository(new ResidentRepositoryStub());
        Resident r1 = new Resident("Angela", "Merkel",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12));
        try {
            Resident r2 = brs.getUniqueResident(r1);
            fail();
        } catch(Exception e) {}
    }

    @Test
    public void testGetFilteredResidentsListExistsOnce() {
        BaseResidentService brs = new BaseResidentService();
        brs.setResidentRepository(new ResidentRepositoryStub());
        brs.setResidentRepository(new ResidentRepositoryStub());
        Resident r1 = new Resident("Peter", "Altmaier",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12));
        List<Resident> l = brs.getFilteredResidentsList(r1);
        if (l.size() != 1){
            fail();
        }
    }

    @Test
    public void testGetFilteredResidentsListExistsTwice() {
        BaseResidentService brs = new BaseResidentService();
        brs.setResidentRepository(new ResidentRepositoryStub());
        Resident r1 = new Resident("Angela", "Merkel",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12));
        List<Resident> l = brs.getFilteredResidentsList(r1);
        if (l.size() != 2){
            fail();
        }
    }

    @Test
    public void testGetFilteredResidentsListNotExist() {
        BaseResidentService brs = new BaseResidentService();
        brs.setResidentRepository(new ResidentRepositoryStub());
        Resident r1 = new Resident("Christian", "Lindner",
                "the street", "Berlin", new Date(12, Calendar.DECEMBER,12));
        List<Resident> l = brs.getFilteredResidentsList(r1);
        if (l.size() != 0){
            fail();
        }
    }
}
