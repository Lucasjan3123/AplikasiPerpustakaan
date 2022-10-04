package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.Peminjaman_detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamanDetailRepository extends JpaRepository<Peminjaman_detail,Integer> {
}
