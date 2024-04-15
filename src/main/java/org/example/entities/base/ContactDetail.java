package org.example.entities.base;

import lombok.*;
import org.example.Enums.ContactType;
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
public class ContactDetail implements IEntity<Long> {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private ContactType cType;

    private String detail;

    private String cValue;
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
