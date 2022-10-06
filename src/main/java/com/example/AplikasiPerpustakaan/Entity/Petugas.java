package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "petugas")
@Getter
@Setter
@NoArgsConstructor
public class Petugas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String nama;

    @Column(columnDefinition = "VARCHAR(20)")
    private String telp;

    @Column(columnDefinition = "TINYTEXT")
    private String alamat;

    @OneToMany(mappedBy = "petugas")
    private List<Pengembalian> pengembalianList;

    @OneToMany(mappedBy = "petugas")
    private List<Peminjaman> peminjamanList;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


}

