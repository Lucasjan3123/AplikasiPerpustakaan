package com.example.AplikasiPerpustakaan.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PeminjamanDetailKey implements Serializable {

    @Column(name = "peminjaman_id")
    Integer peminjamanId;

    @Column(name = "buku_id")
    Integer bukuId;
}
