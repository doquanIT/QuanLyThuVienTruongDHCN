/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import static Data.TaiLieuController.TheQuery;
import Object.NhanVien;
import Object.TaiLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class NhanVienController {
    public static ArrayList<NhanVien> List = new ArrayList<>();
    public static ArrayList<NhanVien> List1 = new ArrayList<>();
    public static ArrayList<NhanVien> List2 = new ArrayList<>();

    public static void TheQuery(String sql) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
    }

    public static void ThemNhanVienQLMT(NhanVien tl ) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "insert into NhanVienQLMT(MaNhanVien ,TenNhanVien , DienThoai , DiaChi ,NgaySinh ,GioiTinh ,TenDangNhap , MatKhau) "
                + "values(?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,tl.getMaNhanVien() );
        ps.setString(2,tl.getTenNhanVien());
        ps.setInt(3,tl.getSoDienThoai());
        ps.setString(4,tl.getDiaChi());
        ps.setDate(5,new java.sql.Date(tl.getNgaySinh().getTime()) );
        ps.setString(6,tl.getGioiTinh());
        ps.setString(7,tl.getTaiKhoan());
        ps.setString(8,tl.getMatKhau());
        ps.executeUpdate();
        
    }
    
    public static void ThemNhanVienQLTL(NhanVien tl ) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "insert into NhanVienQLTL(MaNhanVien ,TenNhanVien , DienThoai , DiaChi ,NgaySinh ,GioiTinh ,TenDangNhap , MatKhau) "
                + "values(?,?,?,?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,tl.getMaNhanVien() );
        ps.setString(2,tl.getTenNhanVien());
        ps.setInt(3,tl.getSoDienThoai());
        ps.setString(4,tl.getDiaChi());
        ps.setDate(5,new java.sql.Date(tl.getNgaySinh().getTime()) );
        ps.setString(6,tl.getGioiTinh());
        ps.setString(7,tl.getTaiKhoan());
        ps.setString(8,tl.getMatKhau());
        ps.executeUpdate();
        
    }

    public static  boolean Check(String Matl , String Tentk) throws SQLException
    {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from NhanVienQLMT where MaNhanVien= '" + Matl + "' or TenDangNhap = '"+Tentk+"'  ");
        Statement st1 = conn.createStatement();
        ResultSet re1 = st1.executeQuery("select * from NhanVienQLTL where TenDangNhap = '"+Tentk+"'   ");
        Statement st2 = conn.createStatement();
        ResultSet re2 = st2.executeQuery("select * from ADmin where TenDangNhap= '" + Matl + "'  ");
        if(re.next() || re1.next() || re2.next())
            return  true;
        else
            return false;
    }
    public static  boolean Check1(String Matl , String Tentk) throws SQLException
    {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from NhanVienQLMT where TenDangNhap = '"+Tentk+"'  ");
        Statement st1 = conn.createStatement();
        ResultSet re1 = st1.executeQuery("select * from NhanVienQLTL where MaNhanVien= '" + Matl + "' or TenDangNhap = '"+Tentk+"'   ");
        Statement st2 = conn.createStatement();
        ResultSet re2 = st2.executeQuery("select * from ADmin where TenDangNhap= '" + Matl + "'  ");
        if(re.next() || re1.next() || re2.next())
            return  true;
        else
            return false;
    }
    
    public static ArrayList<NhanVien> HienThiNVQLMT() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from NhanVienQLMT ");

        List.removeAll(List);
        while (re.next()) {
            String MaNhanVien = re.getString("MaNhanVien");
            String TenNhanVien = re.getString("TenNhanVien");
            String DiaChi = re.getString("DiaChi");
            String TenDangNhap = re.getString("TenDangNhap");
            String GioiTinh = re.getString("GioiTinh");
            String MatKhau = re.getString("MatKhau");
            int DienThoai = re.getInt("DienThoai");
            Date NgaySinh = re.getDate("NgaySinh");
            NhanVien x = new NhanVien(TenDangNhap, MatKhau, MaNhanVien, TenNhanVien, DiaChi, GioiTinh, DienThoai, NgaySinh);
            List.add(x);
        }

        return null;

    }
    
    public static ArrayList<NhanVien> HienThiNVQLTL() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from NhanVienQLTL ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaNhanVien = re.getString("MaNhanVien");
            String TenNhanVien = re.getString("TenNhanVien");
            String DiaChi = re.getString("DiaChi");
            String TenDangNhap = re.getString("TenDangNhap");
            String GioiTinh = re.getString("GioiTinh");
            String MatKhau = re.getString("MatKhau");
            int DienThoai = re.getInt("DienThoai");
            Date NgaySinh = re.getDate("NgaySinh");
            NhanVien x = new NhanVien(TenDangNhap, MatKhau, MaNhanVien, TenNhanVien, DiaChi, GioiTinh, DienThoai, NgaySinh);
            List1.add(x);
        }

        return null;

    }
    public static ArrayList<NhanVien> TimKiemMaNV(String s ) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from NhanVienQLTL where MaNhanVien like '"+s+"%'");
        Statement st1 = conn.createStatement();
        ResultSet re1 = st1.executeQuery("select * from NhanVienQLMT where MaNhanVien like '"+s+"%'");
        List2.removeAll(List2);
        while (re.next()) {
            String MaNhanVien = re.getString("MaNhanVien");
            String TenNhanVien = re.getString("TenNhanVien");
            String DiaChi = re.getString("DiaChi");
            String TenDangNhap = re.getString("TenDangNhap");
            String GioiTinh = re.getString("GioiTinh");
            String MatKhau = re.getString("MatKhau");
            int DienThoai = re.getInt("DienThoai");
            Date NgaySinh = re.getDate("NgaySinh");
            NhanVien x = new NhanVien(TenDangNhap, MatKhau, MaNhanVien, TenNhanVien, DiaChi, GioiTinh, DienThoai, NgaySinh);
            List2.add(x);
        }
        while (re1.next()) {
            String MaNhanVien = re1.getString("MaNhanVien");
            String TenNhanVien = re1.getString("TenNhanVien");
            String DiaChi = re1.getString("DiaChi");
            String TenDangNhap = re1.getString("TenDangNhap");
            String GioiTinh = re1.getString("GioiTinh");
            String MatKhau = re1.getString("MatKhau");
            int DienThoai = re1.getInt("DienThoai");
            Date NgaySinh = re1.getDate("NgaySinh");
            NhanVien x = new NhanVien(TenDangNhap, MatKhau, MaNhanVien, TenNhanVien, DiaChi, GioiTinh, DienThoai, NgaySinh);
            List2.add(x);
        }

        return null;

    }
    
    public static ArrayList<NhanVien> TimKiemTenNV(String s ) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from NhanVienQLTL where TenNhanVien like '"+s+"%'");
        Statement st1 = conn.createStatement();
        ResultSet re1 = st1.executeQuery("select * from NhanVienQLMT where TenNhanVien like '"+s+"%'");
        List2.removeAll(List2);
        while (re.next()) {
            String MaNhanVien = re.getString("MaNhanVien");
            String TenNhanVien = re.getString("TenNhanVien");
            String DiaChi = re.getString("DiaChi");
            String TenDangNhap = re.getString("TenDangNhap");
            String GioiTinh = re.getString("GioiTinh");
            String MatKhau = re.getString("MatKhau");
            int DienThoai = re.getInt("DienThoai");
            Date NgaySinh = re.getDate("NgaySinh");
            NhanVien x = new NhanVien(TenDangNhap, MatKhau, MaNhanVien, TenNhanVien, DiaChi, GioiTinh, DienThoai, NgaySinh);
            List2.add(x);
        }
        while (re1.next()) {
            String MaNhanVien = re1.getString("MaNhanVien");
            String TenNhanVien = re1.getString("TenNhanVien");
            String DiaChi = re1.getString("DiaChi");
            String TenDangNhap = re1.getString("TenDangNhap");
            String GioiTinh = re1.getString("GioiTinh");
            String MatKhau = re1.getString("MatKhau");
            int DienThoai = re1.getInt("DienThoai");
            Date NgaySinh = re1.getDate("NgaySinh");
            NhanVien x = new NhanVien(TenDangNhap, MatKhau, MaNhanVien, TenNhanVien, DiaChi, GioiTinh, DienThoai, NgaySinh);
            List2.add(x);
        }

        return null;

    }
    public static ArrayList<NhanVien> TimKiemTenTK(String s ) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from NhanVienQLTL where TenDangNhap like '"+s+"%'");
        Statement st1 = conn.createStatement();
        ResultSet re1 = st1.executeQuery("select * from NhanVienQLMT where TenDangNhap like '"+s+"%'");
        List2.removeAll(List2);
        while (re.next()) {
            String MaNhanVien = re.getString("MaNhanVien");
            String TenNhanVien = re.getString("TenNhanVien");
            String DiaChi = re.getString("DiaChi");
            String TenDangNhap = re.getString("TenDangNhap");
            String GioiTinh = re.getString("GioiTinh");
            String MatKhau = re.getString("MatKhau");
            int DienThoai = re.getInt("DienThoai");
            Date NgaySinh = re.getDate("NgaySinh");
            NhanVien x = new NhanVien(TenDangNhap, MatKhau, MaNhanVien, TenNhanVien, DiaChi, GioiTinh, DienThoai, NgaySinh);
            List2.add(x);
        }
        while (re1.next()) {
            String MaNhanVien = re1.getString("MaNhanVien");
            String TenNhanVien = re1.getString("TenNhanVien");
            String DiaChi = re1.getString("DiaChi");
            String TenDangNhap = re1.getString("TenDangNhap");
            String GioiTinh = re1.getString("GioiTinh");
            String MatKhau = re1.getString("MatKhau");
            int DienThoai = re1.getInt("DienThoai");
            Date NgaySinh = re1.getDate("NgaySinh");
            NhanVien x = new NhanVien(TenDangNhap, MatKhau, MaNhanVien, TenNhanVien, DiaChi, GioiTinh, DienThoai, NgaySinh);
            List2.add(x);
        }
        return null;

    }
    public static void SuaNhanVienQLMT(NhanVien tl) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "update NhanVienQLMT set  TenNhanVien = ? , DienThoai= ? , DiaChi= ? ,NgaySinh= ? ,GioiTinh= ? ,TenDangNhap= ? , MatKhau= ? where MaNhanVien = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(8,tl.getMaNhanVien() );
        ps.setString(1,tl.getTenNhanVien());
        ps.setInt(2,tl.getSoDienThoai());
        ps.setString(3,tl.getDiaChi());
        ps.setDate(4,new java.sql.Date(tl.getNgaySinh().getTime()) );
        ps.setString(5,tl.getGioiTinh());
        ps.setString(6,tl.getTaiKhoan());
        ps.setString(7,tl.getMatKhau());
        ps.executeUpdate();
    }
    
    public static void SuaNhanVienQLTL(NhanVien tl) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "update NhanVienQLTL set  TenNhanVien = ? , DienThoai= ? , DiaChi= ? ,NgaySinh= ? ,GioiTinh= ? ,TenDangNhap= ? , MatKhau= ? where MaNhanVien = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(8,tl.getMaNhanVien() );
        ps.setString(1,tl.getTenNhanVien());
        ps.setInt(2,tl.getSoDienThoai());
        ps.setString(3,tl.getDiaChi());
        ps.setDate(4,new java.sql.Date(tl.getNgaySinh().getTime()) );
        ps.setString(5,tl.getGioiTinh());
        ps.setString(6,tl.getTaiKhoan());
        ps.setString(7,tl.getMatKhau());
        ps.executeUpdate();
    }
    
    public static void XoaNhanvienQLMT(String MaNV) throws SQLException {
        String sql = "delete from NhanVienQLMT where MaNhanVien = '" + MaNV + "'";
        TheQuery(sql);
    }
    
    public static void XoaNhanvienQLTL(String MaNV) throws SQLException {
        String sql = "delete from NhanVienQLTL where MaNhanVien = '" + MaNV + "'";
        TheQuery(sql);
    }
}

    
    