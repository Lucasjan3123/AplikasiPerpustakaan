package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "peminjamandetail")
@Getter
@Setter
@NoArgsConstructor
public class PeminjamanDetail {
    @EmbeddedId
    PeminjamanDetailKey id;

    @ManyToOne
    @MapsId("peminjamanId")
    @JoinColumn(name = "peminjaman_id")
    Peminjaman peminjaman;

    @ManyToOne
    @MapsId("bukuId")
    @JoinColumn(name = "buku_id")
    Buku buku;

}
