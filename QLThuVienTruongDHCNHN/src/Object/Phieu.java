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
public class Phieu {
    private String MaPhieu , MaTaiLieu , MaBanDoc , HoVaTen;
    private Date NgayMuon , NgayTra , NgayThucTra;

    public Phieu() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.MaPhieu);
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
        final Phieu other = (Phieu) obj;
        if (!Objects.equals(this.MaPhieu, other.MaPhieu)) {
            return false;
        }
        return true;
    }

    public Phieu(String MaPhieu, String MaTaiLieu, String MaBanDoc, String HoVaTen, Date NgayMuon, Date NgayTra, Date NgayThucTra) {
        this.MaPhieu = MaPhieu;
        this.MaTaiLieu = MaTaiLieu;
        this.MaBanDoc = MaBanDoc;
        this.HoVaTen = HoVaTen;
        this.NgayMuon = NgayMuon;
        this.NgayTra = NgayTra;
        this.NgayThucTra = NgayThucTra;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getMaTaiLieu() {
        return MaTaiLieu;
    }

    public void setMaTaiLieu(String MaTaiLieu) {
        this.MaTaiLieu = MaTaiLieu;
    }

    public String getMaBanDoc() {
        return MaBanDoc;
    }

    public void setMaBanDoc(String MaBanDoc) {
        this.MaBanDoc = MaBanDoc;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public Date getNgayThucTra() {
        return NgayThucTra;
    }

    public void setNgayThucTra(Date NgayThucTra) {
        this.NgayThucTra = NgayThucTra;
    }

    @Override
    public String toString() {
        return "Phieu{" + "MaPhieu=" + MaPhieu + ", MaTaiLieu=" + MaTaiLieu + ", MaBanDoc=" + MaBanDoc + ", HoVaTen=" + HoVaTen + ", NgayMuon=" + NgayMuon + ", NgayTra=" + NgayTra + ", NgayThucTra=" + NgayThucTra + '}';
    }
    
}
