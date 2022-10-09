package com.example.AplikasiPerpustakaan.Entity.DTO;

import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetailKey;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PengembalianDetailDTO {

    private PeminjamanDetailKey id;
    private BukuDTO buku;
    private PengembalianDTO pengembalian;

}
