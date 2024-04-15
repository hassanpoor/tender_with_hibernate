package org.example.dao;

import org.assertj.core.api.Assertions;
import org.example.Enums.Gender;
import org.example.Enums.LocationType;
import org.example.entities.Person;
import org.example.entities.base.PlaceLocation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GeneralDaoTest {
    @Test
    public void persist() {
        List<PlaceLocation> location = new ArrayList<>();
        location.add(PlaceLocation.builder().locationType(LocationType.HOME)
                .city("MASHHAD").state("KHORASAN")
                .country("IRAN").details("BLV")
                .zipCode("123456789").gpsPoint("123456789")
                .build());
        Person person = Person.builder().name("Hossein")
                .family("Hassanpour")
                .nationalId("123456789").build();
        GeneralDao.getInstance().persist(person);
        Person findPerson = (Person) GeneralDao.getInstance().find(Person.class, person.getId());

        Assertions.assertThat(person).usingRecursiveComparison().isEqualTo(findPerson);
    }
}