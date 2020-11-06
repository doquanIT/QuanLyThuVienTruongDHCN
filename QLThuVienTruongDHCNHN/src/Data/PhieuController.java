/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.BanDoc;
import Object.Phieu;
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
public class PhieuController {
    public static ArrayList<Phieu> List = new ArrayList<>();
    public static ArrayList<Phieu> List1 = new ArrayList<>();

    public static void TheQuery(String sql) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
    }
    
    public static ArrayList<String> ListMaP = new ArrayList<>();
    public static ArrayList<TaiLieu> LayMaP() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu where NgayThucTra > NgayTra  ");
        ListMaP.removeAll(ListMaP);
        while (re.next()) {
            String MaP = re.getString("MaPhieu");
            ListMaP.add(MaP);
        }
        return null;
    }
    
    
    public static String LayTenSV ;
    public static String LayTenBD(String MaBD) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanDoc where MaBanDoc= '"+ MaBD +"'" );
        while (re.next()) {
            String TenBD = re.getString("TenBanDoc");
            LayTenSV = TenBD;
        }
        return LayTenSV;
    }

    
    public static ArrayList<String> ListMaTL = new ArrayList<>();
    public static ArrayList<TaiLieu> LayMaTL() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TaiLieu  ");
        ListMaTL.removeAll(ListMaTL);
        while (re.next()) {
            String MaTL = re.getString("MaTaiLieu");
            ListMaTL.add(MaTL);
        }
        return null;
    }
    public static void ThemPhieu(Phieu tl ) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "insert into Phieu(MaPhieu ,MaTaiLieu , NgayMuon , NgayThucTra ,MaBanDoc ,HoVaTen ,NgayTra ) "
                + "values(?,?,?,?,?,?,?) ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,tl.getMaPhieu() );
        ps.setString(2,tl.getMaTaiLieu());
        ps.setDate(3,new java.sql.Date(tl.getNgayMuon().getTime()) );
        ps.setDate(4,new java.sql.Date(tl.getNgayThucTra().getTime()) );
        ps.setString(5,tl.getMaBanDoc());
        ps.setString(6,tl.getHoVaTen());
        ps.setDate(7,new java.sql.Date(tl.getNgayTra().getTime()) );
        
        ps.executeUpdate();
        
    }
    

    public static ArrayList<Phieu> HienThi() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu ");

        List.removeAll(List);
        while (re.next()) {
            String MaPhieu = re.getString("MaPhieu");
            String MaTaiLieu = re.getString("MaTaiLieu");
            Date NgayMuon = re.getDate("NgayMuon");
            Date NgayThucTra = re.getDate("NgayThucTra");
            String MaBanDoc = re.getString("MaBanDoc");
            String HoVaTen = re.getString("HoVaTen");
            Date NgayTra = re.getDate("NgayTra");
            Phieu x = new Phieu(MaPhieu, MaTaiLieu, MaBanDoc, HoVaTen, NgayMuon, NgayTra, NgayThucTra);
            List.add(x);
        }

        return null;
    }
    
    public static ArrayList<Phieu> HTQuaHan() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu where NgayThucTra > NgayTra ");
        List.removeAll(List);
        while (re.next()) {
            String MaPhieu = re.getString("MaPhieu");
            String MaTaiLieu = re.getString("MaTaiLieu");
            Date NgayMuon = re.getDate("NgayMuon");
            Date NgayThucTra = re.getDate("NgayThucTra");
            String MaBanDoc = re.getString("MaBanDoc");
            String HoVaTen = re.getString("HoVaTen");
            Date NgayTra = re.getDate("NgayTra");
            Phieu x = new Phieu(MaPhieu, MaTaiLieu, MaBanDoc, HoVaTen, NgayMuon, NgayTra, NgayThucTra);
            List.add(x);
        }

        return null;
    }
    
    
    
    public static void SuaPhieu(Phieu tl) throws SQLException {
        Connection conn = DBConnector.getConnection();
        String sql = "update Phieu set  MaTaiLieu = ? , NgayMuon= ? , NgayThucTra= ? ,MaBanDoc= ? ,HoVaTen= ? ,NgayTra= ?  where MaPhieu = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(7,tl.getMaPhieu() );
        ps.setString(1,tl.getMaTaiLieu());
        ps.setDate(2,new java.sql.Date(tl.getNgayMuon().getTime()) );
        ps.setDate(3,new java.sql.Date(tl.getNgayThucTra().getTime()) );
        ps.setString(4,tl.getMaBanDoc());
        ps.setString(5,tl.getHoVaTen());
        ps.setDate(6,new java.sql.Date(tl.getNgayTra().getTime()) );
        
        
        ps.executeUpdate();
    }
    
   
    public static  boolean Check(String Matl) throws SQLException
    {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu where MaPhieu= '" + Matl + "'  ");
        if(re.next())
            return  true;
        else
            return false;
    }
    public static  boolean CheckKhoaNgoai(String Matl, String Mabd) throws SQLException
    {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        Statement st2 = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TaiLieu where MaTaiLieu= '" + Matl + "'  ");
         ResultSet re2 = st2.executeQuery("select * from BanDoc where MaBanDoc= '" + Mabd + "'  ");
        if(re.next() && re2.next())
            return  true;
        else
            return false;
    }
    
    public static void XoaPhieu(String MaNV) throws SQLException {
        String sql = "delete Phieu where MaPhieu = '" + MaNV + "'";
        TheQuery(sql);
    }
    
    public static ArrayList<Phieu> TimMaPhieu(String s) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu where MaPhieu like '"+s+"%' ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaPhieu = re.getString("MaPhieu");
            String MaTaiLieu = re.getString("MaTaiLieu");
            Date NgayMuon = re.getDate("NgayMuon");
            Date NgayThucTra = re.getDate("NgayThucTra");
            String MaBanDoc = re.getString("MaBanDoc");
            String HoVaTen = re.getString("HoVaTen");
            Date NgayTra = re.getDate("NgayTra");
            Phieu x = new Phieu(MaPhieu, MaTaiLieu, MaBanDoc, HoVaTen, NgayMuon, NgayTra, NgayThucTra);
            List1.add(x);
        }

        return null;

    }
    
    public static ArrayList<Phieu> TimMaSV(String s) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu where MaBanDoc like '"+s+"%' ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaPhieu = re.getString("MaPhieu");
            String MaTaiLieu = re.getString("MaTaiLieu");
            Date NgayMuon = re.getDate("NgayMuon");
            Date NgayThucTra = re.getDate("NgayThucTra");
            String MaBanDoc = re.getString("MaBanDoc");
            String HoVaTen = re.getString("HoVaTen");
            Date NgayTra = re.getDate("NgayTra");
            Phieu x = new Phieu(MaPhieu, MaTaiLieu, MaBanDoc, HoVaTen, NgayMuon, NgayTra, NgayThucTra);
            List1.add(x);
        }

        return null;

    }
    
    public static ArrayList<Phieu> TimMaTaiLieu(String s) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu where MaTaiLieu like '"+s+"%' ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaPhieu = re.getString("MaPhieu");
            String MaTaiLieu = re.getString("MaTaiLieu");
            Date NgayMuon = re.getDate("NgayMuon");
            Date NgayThucTra = re.getDate("NgayThucTra");
            String MaBanDoc = re.getString("MaBanDoc");
            String HoVaTen = re.getString("HoVaTen");
            Date NgayTra = re.getDate("NgayTra");
            Phieu x = new Phieu(MaPhieu, MaTaiLieu, MaBanDoc, HoVaTen, NgayMuon, NgayTra, NgayThucTra);
            List1.add(x);
        }

        return null;

    }
    public static ArrayList<Phieu> TimTenSV(String s) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from Phieu where HoVaTen like '"+s+"%' ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaPhieu = re.getString("MaPhieu");
            String MaTaiLieu = re.getString("MaTaiLieu");
            Date NgayMuon = re.getDate("NgayMuon");
            Date NgayThucTra = re.getDate("NgayThucTra");
            String MaBanDoc = re.getString("MaBanDoc");
            String HoVaTen = re.getString("HoVaTen");
            Date NgayTra = re.getDate("NgayTra");
            Phieu x = new Phieu(MaPhieu, MaTaiLieu, MaBanDoc, HoVaTen, NgayMuon, NgayTra, NgayThucTra);
            List1.add(x);
        }

        return null;

    }
   
  
}
