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
public class BanDoc {
    private String MaBanDoc , TenBanDoc , Khoa , GioiTinh;
    private Date NgaySinh ;
    private int SoDienThoai;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.MaBanDoc);
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
        final BanDoc other = (BanDoc) obj;
        if (!Objects.equals(this.MaBanDoc, other.MaBanDoc)) {
            return false;
        }
        return true;
    }

    public BanDoc() {
    }
    
    public BanDoc(String MaBanDoc, String TenBanDoc, String Khoa, String GioiTinh, Date NgaySinh, int SoDienThoai) {
        this.MaBanDoc = MaBanDoc;
        this.TenBanDoc = TenBanDoc;
        this.Khoa = Khoa;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.SoDienThoai = SoDienThoai;
    }

    public String getMaBanDoc() {
        return MaBanDoc;
    }

    public void setMaBanDoc(String MaBanDoc) {
        this.MaBanDoc = MaBanDoc;
    }

    public String getTenBanDoc() {
        return TenBanDoc;
    }

    public void setTenBanDoc(String TenBanDoc) {
        this.TenBanDoc = TenBanDoc;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public int getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(int SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    @Override
    public String toString() {
        return "BanDoc{" + "MaBanDoc=" + MaBanDoc + ", TenBanDoc=" + TenBanDoc + ", Khoa=" + Khoa + ", GioiTinh=" + GioiTinh + ", NgaySinh=" + NgaySinh + ", SoDienThoai=" + SoDienThoai + '}';
    }
    
}
