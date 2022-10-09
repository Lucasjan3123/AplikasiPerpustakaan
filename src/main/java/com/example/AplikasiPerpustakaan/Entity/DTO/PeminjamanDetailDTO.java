package com.example.AplikasiPerpustakaan.Entity.DTO;


import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetailKey;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeminjamanDetailDTO {
    private PeminjamanDetailKey id;
    private BukuDTO buku;
    private PeminjamanDTO peminjaman;


}
