package org.example.Enums;

import org.example.base.IEnum;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class LocationType implements IEnum {

    private static final int UNKNOWN_VALUE = -1;
    private static final int HOME_VALUE = 1;
    private static final int OFFICE_VALUE = 2;

    public static final LocationType UNKNOWN = new LocationType(UNKNOWN_VALUE);
    public static final LocationType HOME = new LocationType(HOME_VALUE);
    public static final LocationType OFFICE = new LocationType(OFFICE_VALUE);
    private int type;

    public LocationType(int type) {
        super();
        this.type = type;
    }

    public LocationType() {
        super();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LocationType that = (LocationType) object;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
