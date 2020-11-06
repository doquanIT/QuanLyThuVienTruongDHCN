/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class NhanVien {
    private String TaiKhoan , MatKhau ,MaNhanVien , TenNhanVien , DiaChi , GioiTinh;
    private int SoDienThoai ;
    private Date NgaySinh;

    public NhanVien() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.MaNhanVien);
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
        final NhanVien other = (NhanVien) obj;
        if (!Objects.equals(this.MaNhanVien, other.MaNhanVien)) {
            return false;
        }
        return true;
    }

    public NhanVien(String TaiKhoan, String MatKhau, String MaNhanVien, String TenNhanVien, String DiaChi, String GioiTinh, int SoDienThoai, Date NgaySinh) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.NgaySinh = NgaySinh;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(int SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "TaiKhoan=" + TaiKhoan + ", MatKhau=" + MatKhau + ", MaNhanVien=" + MaNhanVien + ", TenNhanVien=" + TenNhanVien + ", DiaChi=" + DiaChi + ", GioiTinh=" + GioiTinh + ", SoDienThoai=" + SoDienThoai + ", NgaySinh=" + NgaySinh + '}';
    }

    public NhanVien(String TaiKhoan, String MatKhau) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
    }

}
