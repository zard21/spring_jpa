package com.zard21.jpa.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
public class User extends BaseAuditEntity implements Serializable {

    @Id
    @Column(length = 100, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
