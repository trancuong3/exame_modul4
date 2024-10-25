package org.example.exam4.Service;

import org.example.exam4.Repository.DonHangRepository;
import org.example.exam4.Repository.LoaiSanPhamRepository;
import org.example.exam4.Repository.SanPhamRepository;
import org.example.exam4.model.DonHang;
import org.example.exam4.model.LoaiSanPham;
import org.example.exam4.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonHangService {
    @Autowired
    private DonHangRepository donHangRepository;
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;
    public List<DonHang> getAllOrders() {
        return donHangRepository.findAll();
    }

    public Page<DonHang> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return donHangRepository.findByNgayMuaBetween(startDate, endDate, pageable);
    }


    public Optional<DonHang> findById(Integer id) {
        return donHangRepository.findById(id);
    }
    public SanPham findSanPhamById(Integer id) {
        return sanPhamRepository.findById(id).orElse(null);
    }
    public List<LoaiSanPham> getAllLoaiSanPham() {
        return loaiSanPhamRepository.findAll();
    }
    public void updateSanPham(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }
    public Page<DonHang> getOrdersPage(Pageable pageable) {
        return donHangRepository.findAll(pageable);
    }
    public List<DonHang> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return donHangRepository.findByNgayMuaBetween(startDate, endDate);
    }
    public Page<DonHang> getAllOrders(Pageable pageable) {
        return donHangRepository.findAll(pageable);
    }

}