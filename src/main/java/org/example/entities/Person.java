package org.example.entities;


import lombok.*;
import org.example.Enums.Gender;
import org.example.base.IEntity;
import org.example.entities.base.ContactDetail;
import org.example.entities.base.PlaceLocation;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person implements IEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String family;

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "type", column = @Column(name = "gender"))})
    private Gender gender;

    @OneToMany(fetch = FetchType.LAZY)
    private List<PlaceLocation> locations;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ContactDetail> contacts;

    private String nationalId;


}
