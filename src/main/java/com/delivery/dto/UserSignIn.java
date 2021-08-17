package com.delivery.dto;

import lombok.*;
import lombok.experimental.Accessors;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class UserSignIn {

  private  String email;
  private  String password;
}
