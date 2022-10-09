package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeminjamanRepository extends JpaRepository<Peminjaman,Integer> {
}
