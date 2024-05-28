package com.hutech.ngay3c5.RequestEntities;

import com.hutech.ngay3c5.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateUser {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private Role role;
}
