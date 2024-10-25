package org.example.exam4.Controller;

import org.example.exam4.Repository.DonHangRepository;
import org.example.exam4.Repository.LoaiSanPhamRepository;
import org.example.exam4.Repository.SanPhamRepository;
import org.example.exam4.Service.DonHangService;
import org.example.exam4.model.DonHang;
import org.example.exam4.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class DonHangController {

    @Autowired
    private DonHangService donHangService;

    @Autowired
    private DonHangRepository donHangRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @GetMapping
    public String getAllOrders(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DonHang> ordersPage = donHangService.getAllOrders(pageable);

<<<<<<< HEAD
      
        model.addAttribute("ordersPage", ordersPage != null ? ordersPage : Page.empty());
        model.addAttribute("loaiSanPhams", loaiSanPhamRepository.findAll()); 
=======
       
        if (ordersPage == null || ordersPage.isEmpty()) {
            model.addAttribute("ordersPage", null); 
        } else {
            model.addAttribute("ordersPage", ordersPage);
        }
>>>>>>> 5396c6d8c3d9e88cc00514bf1982369bf18982de

        return "orderList";
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<SanPham>> searchProducts(@RequestParam("query") String query) {
        List<SanPham> products = sanPhamRepository.findByTenSpContainingIgnoreCase(query);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/date-range")
    public String getOrdersByDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DonHang> ordersPage = donHangService.getOrdersByDateRange(startDate.atStartOfDay(), endDate.atTime(23, 59, 59), pageable);

        model.addAttribute("ordersPage", ordersPage);
        return "orderList";
    }


    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable("id") int id, Model model) {
        Optional<DonHang> donHangOptional = donHangService.findById(id);

        if (donHangOptional.isPresent()) {
            DonHang donHang = donHangOptional.get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            String formattedNgayMua = donHang.getNgayMua().format(formatter);

            model.addAttribute("donHang", donHang);
            model.addAttribute("formattedNgayMua", formattedNgayMua);
            model.addAttribute("sanPhams", sanPhamRepository.findAll());
            model.addAttribute("loaiSanPhams", loaiSanPhamRepository.findAll());
            return "edit";
        } else {
            return "redirect:/orders";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable Integer id,
                              @ModelAttribute DonHang donHang,
                              @RequestParam("ngayMua") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime ngayMua) {
        donHang.setNgayMua(ngayMua);
        donHang.setMaDonHang(id);
        donHangRepository.save(donHang);
        return "redirect:/orders";
    }
}
