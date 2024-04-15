package org.example.base;

import java.io.Serializable;

public interface IEnum extends Serializable {

    boolean equals(Object o);

    int hashCode();
}
