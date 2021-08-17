package com.delivery.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class RoleDto {
    private int id;
    private  String role;
}
