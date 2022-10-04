package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "peminjaman")
@Getter
@Setter
@NoArgsConstructor

public class Peminjaman
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer peminjaman_id;

    @Column
    private Date tgl_pinjam;

    @Column
    private Date tgl_kembali;


}
