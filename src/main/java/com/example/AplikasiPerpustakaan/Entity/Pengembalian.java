package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pengembalian")
@Getter
@Setter
@NoArgsConstructor

public class Pengembalian
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pengembalian_id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String tgl_pengembalian;

    @Column
    private Double Denda;
}
