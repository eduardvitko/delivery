package com.delivery.respositories;

import com.delivery.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRole(String role);
}
