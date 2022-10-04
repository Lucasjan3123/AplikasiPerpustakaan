package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "petugas")
@Getter
@Setter
@NoArgsConstructor
public class Petugas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer petugas_id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String nama;

    @Column(columnDefinition = "VARCHAR(20)")
    private String telp;

    @Column(columnDefinition = "TINYTEXT")
    private String alamat;


}

