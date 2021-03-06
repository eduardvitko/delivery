package com.delivery.dto;

import com.delivery.domain.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    private String firstName;

    private String lastName;
    private String phoneNumber;

    private String email;

    private String password;
    private List<RoleDto> roles = new ArrayList<>();


    private AddressDto addressDto;

    private Set<BillDto> bills;

}

