package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "buku")
@Getter
@Setter
@NoArgsConstructor

public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer buku_id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String judul;

    @Column(columnDefinition = "VARCHAR(255)")
    private String tahun_terbit;

    @Column
    private Integer jumlah;

    @Column(columnDefinition = "VARCHAR(20)")
    private String isbn;

}
