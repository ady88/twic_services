package com.adrian.twic_services_core.helpers;

import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonStringType.class),})
@MappedSuperclass
public class BaseEntity {
}
