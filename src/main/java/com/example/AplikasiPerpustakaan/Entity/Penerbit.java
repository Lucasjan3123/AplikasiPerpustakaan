package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "penerbit")
@Getter
@Setter
@NoArgsConstructor

public class Penerbit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer penerbit_id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String nama;
    @Column(columnDefinition = "VARCHAR(255)")
    private String alamat;

    @Column(columnDefinition = "VARCHAR(20)")
    private String telp;

}
