package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.Pengarang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PengarangRepository extends JpaRepository<Pengarang,Integer> {
}
