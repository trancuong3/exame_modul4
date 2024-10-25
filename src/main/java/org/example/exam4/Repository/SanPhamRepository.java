package org.example.exam4.Repository;

import org.example.exam4.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    List<SanPham> findByTenSpContainingIgnoreCase(String tenSp);


}