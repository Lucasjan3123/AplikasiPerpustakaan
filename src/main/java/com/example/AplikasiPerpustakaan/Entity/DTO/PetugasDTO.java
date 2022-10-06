package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PetugasDTO {
    private Integer id;

    private String nama;

    private String telp;

    private String alamat;

    private UserDTO user;


}
