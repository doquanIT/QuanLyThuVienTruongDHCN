/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class BanTaiLieu {
    private String MaDonHang , MaTaiLieu , HoVaTen ,SoDienThoai;
    private int   SoLuong;
    private float GiaTien;

    public BanTaiLieu() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.MaDonHang);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BanTaiLieu other = (BanTaiLieu) obj;
        if (!Objects.equals(this.MaDonHang, other.MaDonHang)) {
            return false;
        }
        return true;
    }

    public BanTaiLieu(String MaDonHang, String MaTaiLieu, String HoVaTen, String SoDienThoai, int SoLuong, float GiaTien) {
        this.MaDonHang = MaDonHang;
        this.MaTaiLieu = MaTaiLieu;
        this.HoVaTen = HoVaTen;
        this.SoDienThoai = SoDienThoai;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
    }

    public String getMaDonHang() {
        return MaDonHang;
    }

    public void setMaDonHang(String MaDonHang) {
        this.MaDonHang = MaDonHang;
    }

    public String getMaTaiLieu() {
        return MaTaiLieu;
    }

    public void setMaTaiLieu(String MaTaiLieu) {
        this.MaTaiLieu = MaTaiLieu;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

   

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    @Override
    public String toString() {
        return "BanTaiLieu{" + "MaDonHang=" + MaDonHang + ", MaTaiLieu=" + MaTaiLieu + ", HoVaTen=" + HoVaTen + ", SoDienThoai=" + SoDienThoai + ", SoLuong=" + SoLuong + ", GiaTien=" + GiaTien + '}';
    }
    
}
