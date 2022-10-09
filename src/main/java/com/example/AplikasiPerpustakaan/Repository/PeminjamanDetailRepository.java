package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetail;
import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamanDetailRepository extends JpaRepository<PeminjamanDetail, PeminjamanDetailKey> {
}
