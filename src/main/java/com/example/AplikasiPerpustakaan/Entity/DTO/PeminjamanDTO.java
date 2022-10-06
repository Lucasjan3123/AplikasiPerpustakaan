package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PeminjamanDTO {
    private Integer id;

    private Date tgl_pinjam;

    private Date tgl_kembali;

    private AnggotaDTO anggota;

    private PetugasDTO petugas;



}
