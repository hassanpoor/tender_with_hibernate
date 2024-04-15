package org.example.Enums;

import org.example.base.IEnum;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Gender implements IEnum {
    ;
    private static final int UNKNOWN_VALUE = -1;
    private static final int MAN_VALUE = 0;
    private static final int WOMAN_VALUE = 1;
    private int type;

    public Gender(int type) {
        super();
        this.type = type;
    }

    public Gender() {
        super();
    }


    public static final Gender UNKNOWN = new Gender(UNKNOWN_VALUE);
    public static final Gender MAN = new Gender(MAN_VALUE);
    public static final Gender WOMAN = new Gender(WOMAN_VALUE);

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Gender gender = (Gender) object;
        return type == gender.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
