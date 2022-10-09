package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PengembalianDTO {
    private Integer id;

    private String tgl_pengembalian;

    private Double Denda;

    private AnggotaDTO anggota;
    private PetugasDTO petugas;




}
