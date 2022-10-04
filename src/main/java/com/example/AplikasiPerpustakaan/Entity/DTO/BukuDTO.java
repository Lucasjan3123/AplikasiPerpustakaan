package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class BukuDTO
{
    private Integer buku_id;

    private String judul;

    private String tahun_terbit;

    private Integer jumlah;

    private String isbn;

}
