package com.example.AplikasiPerpustakaan.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

public class PengembalianDetailKey implements Serializable {

    @Column(name = "pengembalian_id")
    Integer pengembalianId;

    @Column(name = "buku_id")
    Integer bukuId;
}
