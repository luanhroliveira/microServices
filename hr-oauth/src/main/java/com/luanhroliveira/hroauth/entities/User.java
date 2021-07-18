package com.luanhroliveira.hroauth.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String email;
    private String password;
    @Setter(AccessLevel.NONE)
    private Set<Role> roles = new HashSet<>();
}
