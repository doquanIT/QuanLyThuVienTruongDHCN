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
public class TaiLieu {
    private String MaTaiLieu , TenTaiLieu , TheLoai , NhaXuatBan , TacGia;
    private int SoLuongCo , NamXuatBan ;
    private float GiaSach;
    private String ViTri;

    public TaiLieu() {
    }

    public TaiLieu(String MaTaiLieu, String TenTaiLieu, String TheLoai, String NhaXuatBan, String TacGia, int SoLuongCo, int NamXuatBan, float GiaSach, String ViTri) {
        this.MaTaiLieu = MaTaiLieu;
        this.TenTaiLieu = TenTaiLieu;
        this.TheLoai = TheLoai;
        this.NhaXuatBan = NhaXuatBan;
        this.TacGia = TacGia;
        this.SoLuongCo = SoLuongCo;
        this.NamXuatBan = NamXuatBan;
        this.GiaSach = GiaSach;
        this.ViTri = ViTri;
    }

    

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }
    

    public String getMaTaiLieu() {
        return MaTaiLieu;
    }

    public void setMaTaiLieu(String MaTaiLieu) {
        this.MaTaiLieu = MaTaiLieu;
    }

    public String getTenTaiLieu() {
        return TenTaiLieu;
    }

    public void setTenTaiLieu(String TenTaiLieu) {
        this.TenTaiLieu = TenTaiLieu;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String NhaXuatBan) {
        this.NhaXuatBan = NhaXuatBan;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public int getSoLuongCo() {
        return SoLuongCo;
    }

    public void setSoLuongCo(int SoLuongCo) {
        this.SoLuongCo = SoLuongCo;
    }

    public int getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(int NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }

    public float getGiaSach() {
        return GiaSach;
    }

    public void setGiaSach(float GiaSach) {
        this.GiaSach = GiaSach;
    }

    @Override
    public String toString() {
        return "TaiLieu{" + "MaTaiLieu=" + MaTaiLieu + ", TenTaiLieu=" + TenTaiLieu + ", TheLoai=" + TheLoai + ", NhaXuatBan=" + NhaXuatBan + ", TacGia=" + TacGia + ", SoLuongCo=" + SoLuongCo + ", NamXuatBan=" + NamXuatBan + ", GiaSach=" + GiaSach + ", ViTri=" + ViTri +'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.MaTaiLieu);
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
        final TaiLieu other = (TaiLieu) obj;
        return Objects.equals(this.MaTaiLieu, other.MaTaiLieu);
    }
    
}
