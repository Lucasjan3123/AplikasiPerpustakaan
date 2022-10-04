package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO
{
    private Integer id_user;
    private String username;
    private String password;
    private String email;
    private String role;

}
