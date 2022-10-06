package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PenerbitDTO {
    private Integer id;

    private String nama;

    private String alamat;

    private String telp;

}
