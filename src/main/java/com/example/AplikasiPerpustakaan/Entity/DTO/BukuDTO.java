package com.example.AplikasiPerpustakaan.Entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BukuDTO
{
    private Integer ID;

    private String judul;

    private String tahun_terbit;

    private Integer jumlah;

    private String isbn;

    private PengarangDTO pengarang;

    private PenerbitDTO penerbit;

}
