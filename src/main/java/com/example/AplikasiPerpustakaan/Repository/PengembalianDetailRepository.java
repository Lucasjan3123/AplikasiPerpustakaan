package com.example.AplikasiPerpustakaan.Repository;

import com.example.AplikasiPerpustakaan.Entity.PengembalianDetail;
import com.example.AplikasiPerpustakaan.Entity.PengembalianDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PengembalianDetailRepository extends JpaRepository<PengembalianDetail, PengembalianDetailKey> {
}
