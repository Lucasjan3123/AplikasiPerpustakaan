package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponAuthDTO {
    private Integer id_user;

    private String username;

    private String Password;

    private String role;

    private String email;

    private String token;
}
