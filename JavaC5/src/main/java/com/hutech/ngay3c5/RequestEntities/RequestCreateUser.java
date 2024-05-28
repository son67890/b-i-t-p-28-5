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
public class RequestCreateUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private Role role;
    private boolean isDeleted;
}
