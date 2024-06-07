package com.tina.batch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@MappedSuperclass
@ToString
public abstract class BasicAuditColumns {
    @Column(name = "last_update_dt")
    private String lastUpdateDt;
}
