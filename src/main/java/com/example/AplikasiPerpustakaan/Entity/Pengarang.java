package com.example.AplikasiPerpustakaan.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pengarangs")
@Getter
@Setter
@NoArgsConstructor

public class Pengarang {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @Column(columnDefinition = "VARCHAR(255)")
        private String nama;
        @Column(columnDefinition = "VARCHAR(255)")
        private String alamat;

        @Column(columnDefinition = "VARCHAR(20)")
        private String telp;

        @OneToMany(mappedBy = "pengarang")
        private List<Buku> bukuList;


}
