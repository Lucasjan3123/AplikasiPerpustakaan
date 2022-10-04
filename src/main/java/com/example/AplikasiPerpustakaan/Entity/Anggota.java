package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "anggota")
@Getter
@Setter
@NoArgsConstructor
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer anggota_id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String nama;

    @Column(columnDefinition = "VARCHAR(255)")
    private String jenis_kelamin;

    @Column(columnDefinition = "VARCHAR(255)")
    private String alamat;

    @Column(columnDefinition = "VARCHAR(20)")
    private String telp;
}
