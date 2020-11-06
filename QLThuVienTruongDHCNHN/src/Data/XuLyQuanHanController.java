/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.XuLyQuaHan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ducqu
 */
public class XuLyQuanHanController {

    public static ArrayList<XuLyQuaHan> List = new ArrayList<>();
    public static ArrayList<XuLyQuaHan> List1 = new ArrayList<>();

    public static void TheQuery(String sql) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
    }

    public static void Them(XuLyQuaHan tl) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "insert into XuLyPhieu(MaXuLy ,MaPhieu , LyDo , TienPhat ,TrangThai) "
                + "values(?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tl.getMaXuLy());
        ps.setString(2, tl.getMaPhieuMuon());
        ps.setString(3, tl.getLyDo());
        ps.setDouble(4, tl.getTienPhat());
        ps.setString(5, tl.getTrangThai());
        ps.executeUpdate();

    }

    public static void SuaXuLy(XuLyQuaHan tl) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "update XuLyPhieu set  MaPhieu= ? ,LyDo= ? ,TienPhat= ? ,TrangThai= ?  where MaXuLy = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(5, tl.getMaXuLy());
        ps.setString(1, tl.getMaPhieuMuon());
        ps.setString(2, tl.getLyDo());
        ps.setDouble(3, tl.getTienPhat());
        ps.setString(4, tl.getTrangThai());

        ps.executeUpdate();
    }

    public static ArrayList<XuLyQuaHan> HienThi() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from XuLyPhieu ");

        List.removeAll(List);
        while (re.next()) {
            String MaXuLy = re.getString("MaXuLy");
            String MaPhieuMuon = re.getString("MaPhieu");
            String LyDo = re.getString("LyDo");
            double TienPhat = re.getDouble("TienPhat");
            String TrangThai = re.getString("TrangThai");

            XuLyQuaHan x = new XuLyQuaHan(MaXuLy, MaPhieuMuon, LyDo, TienPhat, TrangThai);
            List.add(x);
        }
        return null;

    }
    public static ArrayList<XuLyQuaHan> TimKiemMaXuLy(String Maxl) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from XuLyPhieu where MaXuLy like '"+Maxl+"%'");

        List1.removeAll(List1);
        while (re.next()) {
            String MaXuLy = re.getString("MaXuLy");
            String MaPhieuMuon = re.getString("MaPhieu");
            String LyDo = re.getString("LyDo");
            double TienPhat = re.getDouble("TienPhat");
            String TrangThai = re.getString("TrangThai");

            XuLyQuaHan x = new XuLyQuaHan(MaXuLy, MaPhieuMuon, LyDo, TienPhat, TrangThai);
            List1.add(x);
        }
        return null;

    }
    public static ArrayList<XuLyQuaHan> TimKiemMaPhieu(String Maxl) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from XuLyPhieu where MaPhieu like '"+Maxl+"%'");

        List1.removeAll(List1);
        while (re.next()) {
            String MaXuLy = re.getString("MaXuLy");
            String MaPhieuMuon = re.getString("MaPhieu");
            String LyDo = re.getString("LyDo");
            double TienPhat = re.getDouble("TienPhat");
            String TrangThai = re.getString("TrangThai");

            XuLyQuaHan x = new XuLyQuaHan(MaXuLy, MaPhieuMuon, LyDo, TienPhat, TrangThai);
            List1.add(x);
        }
        return null;

    }
    public static boolean Check(String MaXL) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from XuLyPhieu where MaXuLy= '" + MaXL + "'  ");

        if (re.next()) {
            return true;
        } else {
            return false;
        }
    }

}
