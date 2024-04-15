package org.example.base;

import java.io.Serializable;

public interface IEntity<I extends Serializable> extends Serializable {

    I getId();

    void setId(I id);
}
