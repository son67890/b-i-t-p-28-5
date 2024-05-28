package com.hutech.ngay3c5.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String role_id;
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<User> users;
}
