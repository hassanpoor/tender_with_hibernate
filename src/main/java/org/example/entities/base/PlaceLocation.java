package org.example.entities.base;

import lombok.*;
import org.example.Enums.LocationType;
import org.example.base.IEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceLocation implements IEntity<Long> {
    @Id
    @GeneratedValue
    Long id;

    private String country;
    private String state;
    private String city;
    private String details;
    private String zipCode;
    private String gpsPoint;

    @Embedded
    private LocationType locationType;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }



}
