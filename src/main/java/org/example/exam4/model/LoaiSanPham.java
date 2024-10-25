package org.example.exam4.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "loai_san_pham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLoaiSp;

    private String tenLoaiSp;

    public LoaiSanPham(Integer maLoaiSp, String tenLoaiSp) {
        this.maLoaiSp = maLoaiSp;
        this.tenLoaiSp = tenLoaiSp;
    }
    @OneToMany(mappedBy = "loaiSanPham")
    private List<SanPham> sanPhams;
    public Integer getMaLoaiSp() {
        return maLoaiSp;
    }

    public List<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }

    public void setMaLoaiSp(Integer maLoaiSp) {
        this.maLoaiSp = maLoaiSp;
    }

    public String getTenLoaiSp() {
        return tenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        this.tenLoaiSp = tenLoaiSp;
    }

    public LoaiSanPham() {
    }
}
