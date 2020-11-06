/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.BanTaiLieu;
import Object.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class BanTaiLieuController {
    public static ArrayList<BanTaiLieu> List = new ArrayList<>();
    public static ArrayList<BanTaiLieu> List1 = new ArrayList<>();

    public static void TheQuery(String sql) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
    }
    public static  boolean Check(String Matl) throws SQLException
    {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanTaiLieu where MaDonHang= '" + Matl + "'  ");
        if(re.next())
            return  true;
        else
            return false;
    }
    public static  boolean CheckKhoaNgoai(String Matl) throws SQLException
    {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TaiLieu where MaTaiLieu= '" + Matl + "'  ");
        if(re.next())
            return  true;
        else
            return false;
    }
    public static  boolean CheckDuLieu(String s){
        return  s.chars().allMatch(Character::isDigit);
    }
    
    public static void ThemHoaDon(BanTaiLieu tl ) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "insert into BanTaiLieu(MaDonHang ,MaTaiLieu , HoVaTen , DienThoai ,SoLuong,GiaTien ) "
                + "values(?,?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,tl.getMaDonHang());
        ps.setString(2,tl.getMaTaiLieu());
        ps.setString(3,tl.getHoVaTen());
        ps.setString(4,tl.getSoDienThoai());
        ps.setInt(5,tl.getSoLuong());
        ps.setFloat(6,tl.getGiaTien());
        ps.executeUpdate();
        
    }
    public static void SuaHoaDon(BanTaiLieu tl) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "update BanTaiLieu set  MaTaiLieu = ? , HoVaTen= ? , DienThoai= ? ,SoLuong= ? ,GiaTien= ? where MaDonHang = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(6,tl.getMaDonHang());
        ps.setString(1,tl.getMaTaiLieu());
        ps.setString(2,tl.getHoVaTen());
        ps.setString(3,tl.getSoDienThoai());
        ps.setInt(4,tl.getSoLuong());
        ps.setFloat(5,tl.getGiaTien());
        
        
        ps.executeUpdate();
    }
 


    public static ArrayList<BanTaiLieu> HienThi() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanTaiLieu ");

        List.removeAll(List);
        while (re.next()) {
            String MaDonHang = re.getString("MaDonHang");
            String MaTaiLieu = re.getString("MaTaiLieu");
            String HoVaTen = re.getString("HoVaTen");
            String DienThoai = re.getString("DienThoai");
            int SoLuong = re.getInt("SoLuong");
            float GiaTien = re.getFloat("GiaTien");
            BanTaiLieu x = new BanTaiLieu(MaDonHang, MaTaiLieu, HoVaTen, DienThoai, SoLuong, GiaTien);
            List.add(x);
        }

        return null;

    }
    
    public static ArrayList<BanTaiLieu> TimKiemMaDonHang(String s) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanTaiLieu where MaDonHang like '"+s+"%' ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaDonHang = re.getString("MaDonHang");
            String MaTaiLieu = re.getString("MaTaiLieu");
            String HoVaTen = re.getString("HoVaTen");
           String DienThoai = re.getString("DienThoai");
            int SoLuong = re.getInt("SoLuong");
            float GiaTien = re.getFloat("GiaTien");
            BanTaiLieu x = new BanTaiLieu(MaDonHang, MaTaiLieu, HoVaTen, DienThoai, SoLuong, GiaTien);
            List1.add(x);
        }

        return null;

    }
    
    public static ArrayList<BanTaiLieu> TimKiemMaTaiLieu(String s) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanTaiLieu where MaTaiLieu like '"+s+"%' ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaDonHang = re.getString("MaDonHang");
            String MaTaiLieu = re.getString("MaTaiLieu");
            String HoVaTen = re.getString("HoVaTen");
            String DienThoai = re.getString("DienThoai");
            int SoLuong = re.getInt("SoLuong");
            float GiaTien = re.getFloat("GiaTien");
            BanTaiLieu x = new BanTaiLieu(MaDonHang, MaTaiLieu, HoVaTen, DienThoai, SoLuong, GiaTien);
            List1.add(x);
        }

        return null;

    }
    public static ArrayList<BanTaiLieu> TimKiemHoVaTen(String s) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanTaiLieu where HoVaTen like'"+s+"%' ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaDonHang = re.getString("MaDonHang");
            String MaTaiLieu = re.getString("MaTaiLieu");
            String HoVaTen = re.getString("HoVaTen");
            String DienThoai = re.getString("DienThoai");
            int SoLuong = re.getInt("SoLuong");
            float GiaTien = re.getFloat("GiaTien");
            BanTaiLieu x = new BanTaiLieu(MaDonHang, MaTaiLieu, HoVaTen, DienThoai, SoLuong, GiaTien);
            List1.add(x);
        }

        return null;

    }
    
    
    
    
}
