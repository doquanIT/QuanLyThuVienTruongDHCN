/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.Objects;

/**
 *
 * @author ducqu
 */
public class XuLyQuaHan {
    private String MaXuLy, MaPhieuMuon, LyDo ;
    private double TienPhat;
    private String TrangThai;

    public XuLyQuaHan(String MaXuLy, String MaPhieuMuon, String LyDo, double TienPhat, String TrangThai) {
        this.MaXuLy = MaXuLy;
        this.MaPhieuMuon = MaPhieuMuon;
        this.LyDo = LyDo;
        this.TienPhat = TienPhat;
        this.TrangThai = TrangThai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.MaXuLy);
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
        final XuLyQuaHan other = (XuLyQuaHan) obj;
        if (!Objects.equals(this.MaXuLy, other.MaXuLy)) {
            return false;
        }
        return true;
    }

    public String getMaXuLy() {
        return MaXuLy;
    }

    public void setMaXuLy(String MaXuLy) {
        this.MaXuLy = MaXuLy;
    }

    public String getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public void setMaPhieuMuon(String MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String LyDo) {
        this.LyDo = LyDo;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public double getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(double TienPhat) {
        this.TienPhat = TienPhat;
    }

    public XuLyQuaHan() {
    }

    
    
    
}
