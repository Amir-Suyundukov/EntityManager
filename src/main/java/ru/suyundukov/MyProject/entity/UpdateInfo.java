package ru.suyundukov.MyProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Embeddable
@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = -8259900372449892356L;

    @Column(name = "update_user_login")
    private String updateUserLogin;
    @Column(name = "update_user_full_name")
    private String updateUserFullName;
    @Column(name = "update_date_time")
    private Instant updateDateTime;
}
