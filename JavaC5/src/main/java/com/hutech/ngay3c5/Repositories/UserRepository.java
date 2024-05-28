package com.hutech.ngay3c5.Repositories;

import com.hutech.ngay3c5.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
