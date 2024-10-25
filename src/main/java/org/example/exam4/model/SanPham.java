package org.example.exam4.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSp;

    private String tenSp;
    private BigDecimal giaSp;
    private String tinhTrangSp;

    @ManyToOne
    @JoinColumn(name = "ma_loai_sp")
    private LoaiSanPham loaiSanPham;

    public Integer getMaSp() {
        return maSp;
    }

    public void setMaSp(Integer maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public BigDecimal getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(BigDecimal giaSp) {
        this.giaSp = giaSp;
    }

    public String getTinhTrangSp() {
        return tinhTrangSp;
    }

    public void setTinhTrangSp(String tinhTrangSp) {
        this.tinhTrangSp = tinhTrangSp;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
}
