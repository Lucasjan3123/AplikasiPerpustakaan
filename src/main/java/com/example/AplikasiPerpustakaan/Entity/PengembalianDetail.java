package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pengembaliandetail")
@Getter
@Setter
@NoArgsConstructor

public class PengembalianDetail {
    @EmbeddedId
    PengembalianDetailKey id;

    @ManyToOne
    @MapsId("pengembalianId")
    @JoinColumn(name = "pengembalian_id")
    Pengembalian pengembalian;

    @ManyToOne
    @MapsId("bukuId")
    @JoinColumn(name = "buku_id")
    Buku buku;

}
