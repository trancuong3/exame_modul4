package org.example.exam4.Repository;

import org.example.exam4.model.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    List<DonHang> findByNgayMuaBetween(LocalDateTime startDate, LocalDateTime endDate);
    Page<DonHang> findByNgayMuaBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

}
