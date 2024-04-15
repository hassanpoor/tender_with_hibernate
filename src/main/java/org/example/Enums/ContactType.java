package org.example.Enums;

import org.example.base.IEnum;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ContactType implements IEnum {

    private static final int UNKNOWN_VALUE = -1;
    private static final int PHONE_VALUE = 1;
    private static final int CELLPHONE_VALUE = 1;
    private static final int EMAIL_VALUE = 1;

    private static final ContactType UNKNOWN = new ContactType(UNKNOWN_VALUE);
    private static final ContactType PHONE = new ContactType(PHONE_VALUE);
    private static final ContactType CELLPHONE = new ContactType(CELLPHONE_VALUE);
    private static final ContactType EMAIL = new ContactType(EMAIL_VALUE);
    private int type;

    public ContactType(int type) {
        super();
        this.type = type;
    }

    public ContactType() {
        super();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ContactType that = (ContactType) object;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
