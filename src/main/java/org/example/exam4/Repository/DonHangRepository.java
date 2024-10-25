package org.example.exam4.Repository;

import org.example.exam4.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    @Query("SELECT dh FROM DonHang dh WHERE dh.ngayMua BETWEEN :startDate AND :endDate")
    List<DonHang> findByDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    List<DonHang> findByNgayMuaBetween(LocalDateTime startDate, LocalDateTime endDate);
    @Query("SELECT dh FROM DonHang dh ORDER BY dh.soLuong * dh.sanPham.giaSp DESC")
    List<DonHang> findTopOrders(Pageable pageable);
}
