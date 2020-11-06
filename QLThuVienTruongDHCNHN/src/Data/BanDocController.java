/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.BanDoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class BanDocController {

    public static ArrayList<BanDoc> List = new ArrayList<>();
    public static ArrayList<BanDoc> List1 = new ArrayList<>();

    public static void TheQuery(String sql) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
    }
    final static String DATE_FORMAT = "yyyy-MM-dd";

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public static boolean CheckTime(String date)
    {
        return isDateValid(date);
    }
    public static void ThemBanDoc(BanDoc tl) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "insert into BanDoc(MaBanDoc ,TenBanDoc , NgaySinh , Khoa ,DienThoai ,GioiTinh ) "
                + "values(?,?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tl.getMaBanDoc());
        ps.setString(2, tl.getTenBanDoc());
        ps.setDate(3, new java.sql.Date(tl.getNgaySinh().getTime()));
        ps.setString(4, tl.getKhoa());
        ps.setInt(5, tl.getSoDienThoai());
        ps.setString(6, tl.getGioiTinh());
        ps.executeUpdate();

    }

    public static void XoaBanDoc(String MaBanDoc) throws SQLException {
        String sql = "delete from BanDoc where MaBanDoc = '" + MaBanDoc + "'";
        TheQuery(sql);
    }

    public static void SuaBanDoc(BanDoc tl) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "update BanDoc set  TenBanDoc = ? , NgaySinh= ? , Khoa= ? ,DienThoai= ? ,GioiTinh= ?  where MaBanDoc = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(6, tl.getMaBanDoc());
        ps.setString(1, tl.getTenBanDoc());
        ps.setDate(2, new java.sql.Date(tl.getNgaySinh().getTime()));
        ps.setString(3, tl.getKhoa());
        ps.setInt(4, tl.getSoDienThoai());
        ps.setString(5, tl.getGioiTinh());
        ps.executeUpdate();
    }

    public static ArrayList<BanDoc> HienThi() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanDoc ");

        List.removeAll(List);
        while (re.next()) {
            String MaBanDoc = re.getString("MaBanDoc");
            String TenBanDoc = re.getString("TenBanDoc");
            Date NgaySinh = re.getDate("NgaySinh");
            String Khoa = re.getString("Khoa");
            int DienThoai = re.getInt("DienThoai");
            String GioiTinh = re.getString("GioiTinh");
            BanDoc x = new BanDoc(MaBanDoc, TenBanDoc, Khoa, GioiTinh, NgaySinh, DienThoai);
            List.add(x);
        }

        return null;

    }

    

    public static boolean Check(String Mabd) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanDoc where MaBanDoc= '" + Mabd + "'  ");
        if (re.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean CheckKhoaNgoai(String Mabd) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu where MaBanDoc= '" + Mabd + "'  ");
        if (re.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<BanDoc> TimKiemMaSV(String Masv) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanDoc where MaBanDoc like '" + Masv + "%' ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaBanDoc = re.getString("MaBanDoc");
            String TenBanDoc = re.getString("TenBanDoc");
            Date NgaySinh = re.getDate("NgaySinh");
            String Khoa = re.getString("Khoa");
            int DienThoai = re.getInt("DienThoai");
            String GioiTinh = re.getString("GioiTinh");
            BanDoc x = new BanDoc(MaBanDoc, TenBanDoc, Khoa, GioiTinh, NgaySinh, DienThoai);
            List1.add(x);
        }
        return null;

    }

    public static ArrayList<BanDoc> TimKiemTenSV(String Matl) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanDoc where TenBanDoc like '" + Matl + "%'  ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaBanDoc = re.getString("MaBanDoc");
            String TenBanDoc = re.getString("TenBanDoc");
            Date NgaySinh = re.getDate("NgaySinh");
            String Khoa = re.getString("Khoa");
            int DienThoai = re.getInt("DienThoai");
            String GioiTinh = re.getString("GioiTinh");
            BanDoc x = new BanDoc(MaBanDoc, TenBanDoc, Khoa, GioiTinh, NgaySinh, DienThoai);
            List1.add(x);
        }
        return null;

    }

}
