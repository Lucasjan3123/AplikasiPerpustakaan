package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bukus")
@Getter
@Setter
@NoArgsConstructor

public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @Column(columnDefinition = "VARCHAR(255)")
    private String judul;

    @Column(columnDefinition = "VARCHAR(255)")
    private String tahun_terbit;

    @Column
    private Integer jumlah;

    @Column(columnDefinition = "VARCHAR(20)")
    private String isbn;

    @ManyToOne
    @JoinColumn (name = "Pengarang_id")
    private Pengarang pengarang;

    @ManyToOne
    @JoinColumn (name = "Penerbit_id")
    private Penerbit penerbit;

    @ManyToMany (mappedBy = "buku", fetch = FetchType.LAZY)
    private Set<Peminjaman> peminjaman ;



    @ManyToMany (mappedBy = "buku", fetch = FetchType.LAZY)
    private Set<Pengembalian> pengembalian  = new HashSet<>();

    @OneToMany(mappedBy = "buku")
    private List<PeminjamanDetail> detail;

    @OneToMany(mappedBy = "buku")
    private List<PengembalianDetail> details;




}
