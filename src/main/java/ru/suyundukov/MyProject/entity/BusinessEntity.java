package ru.suyundukov.MyProject.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public abstract class BusinessEntity extends DomainObject {
    @Embedded
    private CreationInfo creationInfo;
    @Embedded
    private UpdateInfo updateInfo;

    @PrePersist
    public void prePersist() {
        if (creationInfo == null){
            creationInfo = new CreationInfo();
        }
        creationInfo.setCreateDateTime(Instant.now());
    }

    @PreUpdate
    public void preUpdate() {
        if (updateInfo == null) {
            updateInfo = new UpdateInfo();
        }
        updateInfo.setUpdateDateTime(Instant.now());
    }
}
