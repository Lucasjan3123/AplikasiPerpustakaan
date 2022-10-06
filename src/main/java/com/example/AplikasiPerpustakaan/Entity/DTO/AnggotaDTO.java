package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnggotaDTO {

    private Integer id;

    private String nama;

    private String jenis_kelamin;

    private String alamat;

    private String telp;

    private AnggotaDTO anggota;


}
