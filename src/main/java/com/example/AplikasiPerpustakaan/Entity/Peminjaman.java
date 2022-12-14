package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "peminjamans")
@Getter
@Setter
@NoArgsConstructor

public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date tgl_pinjam;

    @Column
    private Date tgl_kembali;

    @ManyToOne
    @JoinColumn(name = "anggota_id" , insertable = false, updatable = false)
    private Anggota anggota;
    @ManyToOne
    @JoinColumn(name = "petugas_id", insertable = false, updatable = false)
    private Petugas petugas;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Peminjaman_Detail",
            joinColumns = {@JoinColumn(name = "peminjaman_id", insertable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "buku_id", insertable = false, updatable = false)}
    )
    private Set<Buku> buku;

    @OneToMany(mappedBy = "peminjaman")
    private List<PeminjamanDetail> peminjamanDetails;

    @OneToMany(mappedBy = "pengembalian")
    private List<PengembalianDetail> pengembalianDetails;

}
