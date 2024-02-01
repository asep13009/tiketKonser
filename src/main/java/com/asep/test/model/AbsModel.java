package com.asep.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsModel {
    @CreationTimestamp
    @Column(name = "createdate", nullable = false, updatable = false)
    private Date createdate;

    @UpdateTimestamp
    @Column(name = "updatdate")
    private Date updatdate;

}
