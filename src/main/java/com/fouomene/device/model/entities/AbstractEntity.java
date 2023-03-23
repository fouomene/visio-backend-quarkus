package com.fouomene.device.model.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;


/**
 * Instantiates a new abstract entity.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity extends PanacheEntity {


    @Column(name = "created_date", updatable = false)
    protected  Instant createdDate = Instant.now();

    @Column(name = "last_modified_date")
    protected  Instant lastModifiedDate = Instant.now();

    public Long getId() {
        return  this.id;
    }

    /* when app use Spring Security
    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    protected String createdBy;

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    protected String lastModifiedBy;
   */
}

