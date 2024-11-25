package ru.suyundukov.MyProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Embeddable
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreationInfo {
    @Column(name = "create_user_login", nullable = false)
    private String createUserLogin;
    @Column(name = "create_user_full_name", nullable = false)
    private String createUserFullName;
    @Column(name = "create_date_time", nullable = false, updatable = false)
    private Instant createDateTime;

    @JsonIgnore
    public LocalDate getCreateDate() {
        return createDateTime.atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
