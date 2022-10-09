package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pengembalians")
@Getter
@Setter
@NoArgsConstructor

public class Pengembalian
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String tgl_pengembalian;

    @Column
    private Double Denda;

    @ManyToOne
    @JoinColumn (name = "anggota_id")
    private Anggota anggota;
    @ManyToOne
    @JoinColumn (name = "petugas_id")
    private Petugas petugas;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "Pengembalian_Detail",
            joinColumns = {@JoinColumn(name = "pengembalian_id")},
            inverseJoinColumns = {@JoinColumn(name = "buku_id")}
    )
    private Set<Buku> buku=new HashSet<>();

}
