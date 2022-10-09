package com.example.AplikasiPerpustakaan.Entity.DTO;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PeminjamanDTO {
    private Integer id;

    private Date tgl_pinjam;

    private Date tgl_kembali;

    private AnggotaDTO anggota;

    private PetugasDTO petugas;





}
