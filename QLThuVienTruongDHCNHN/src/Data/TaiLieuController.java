/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Object.TaiLieu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TaiLieuController {

    public static ArrayList<TaiLieu> List = new ArrayList<>();
    public static ArrayList<TaiLieu> List1 = new ArrayList<>();
    
    public static ArrayList<String> ListTheLoai = new ArrayList<>();
    public static ArrayList<TaiLieu> LayTenTheLoai() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TheLoai  ");
        ListTheLoai.removeAll(ListTheLoai);
        while (re.next()) {
            String TenTheLoai = re.getString("TenTheLoai");
            ListTheLoai.add(TenTheLoai);
        }
        return null;
    }
    
    
    public static ArrayList<String> ListNhaXuatBan = new ArrayList<>();
    public static ArrayList<TaiLieu> LayTenNhaXuatBan() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from NhaXuatBan  ");
        ListNhaXuatBan.removeAll(ListNhaXuatBan);
        while (re.next()) {
            String TenNhaXuatBan = re.getString("TenNhaXuatBan");
            ListNhaXuatBan.add(TenNhaXuatBan);
        }
        return null;
    }
    
    public static void TheQuery(String sql) throws SQLException {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
    }

    public static void ThemTaiLieu(TaiLieu tl) throws SQLException {
        String sql = "insert into TaiLieu values  ( '" + tl.getMaTaiLieu() + "' , '" + tl.getTenTaiLieu() + "' ,'"
                + tl.getNhaXuatBan() + "' , '" + tl.getTacGia() + "' , " + tl.getSoLuongCo() 
                + " , '" + tl.getTheLoai() + "' , " + tl.getNamXuatBan() + " ,'" +tl.getViTri()+ "'," + tl.getGiaSach() + " ) ";
        TheQuery(sql);
    }

    public static void XoaTaiLieu(String MaTaiLieu) throws SQLException {
        String sql = "delete from TaiLieu where MaTaiLieu = '" + MaTaiLieu + "'";
        TheQuery(sql);
    }

    public static void SuaTaiLieu(TaiLieu tl) throws SQLException {
        String sql = "update TaiLieu set TenTaiLieu= '" + tl.getTenTaiLieu() + "' , TenNhaXuatBan= '" + tl.getNhaXuatBan() 
                + "' , TacGia= '" + tl.getTacGia() + "' , SoLuongCo= " + tl.getSoLuongCo() + " , TenTheLoai= '" 
                + tl.getTheLoai() + "' , NamXuatBan= " + tl.getNamXuatBan() + " , Gia= " + tl.getGiaSach() 
                + " , ViTri='"+tl.getViTri() + "'  where MaTaiLieu = '" + tl.getMaTaiLieu() + "'   ";
        TheQuery(sql);
    }
    
    public static ArrayList<TaiLieu> HienThi() throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TaiLieu ");

        List.removeAll(List);
        while (re.next()) {
            String MaTaiLieu = re.getString("MaTaiLieu");
            String TenTaiLieu = re.getString("TenTaiLieu");
            String TheLoai = re.getString("TenTheLoai");
            String NhaXuatBan = re.getString("TenNhaXuatBan");
            String TacGia = re.getString("TacGia");
            int SoLuongCo = re.getInt("SoLuongCo");
            int NamXuatBan = re.getInt("NamXuatBan");
            float GiaSach = re.getFloat("Gia");
            String ViTri = re.getString("ViTri");
            TaiLieu x = new TaiLieu(MaTaiLieu, TenTaiLieu, TheLoai, NhaXuatBan, TacGia, SoLuongCo, NamXuatBan, GiaSach, ViTri);
            List.add(x);
        }

        return null;

    }
    public static  boolean Check(String Matl) throws SQLException
    {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TaiLieu where MaTaiLieu= '" + Matl + "'  ");
        if(re.next())
            return  true;
        else
            return false;
    }
    public static  boolean CheckKhoaNgoai(String Matl) throws SQLException
    {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        Statement st2 = conn.createStatement();
        ResultSet re = st.executeQuery("select * from BanTaiLieu where MaTaiLieu= '" + Matl + "'  ");
         ResultSet re2 = st2.executeQuery("select * from Phieu where MaTaiLieu= '" + Matl + "'  ");
        if(re.next() || re2.next())
            return  true;
        else
            return false;
    }
    public static ArrayList<TaiLieu> TimKiemMaTL(String Matl) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TaiLieu where MaTaiLieu like'" + Matl + "%'  ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaTaiLieu = re.getString("MaTaiLieu");
            String TenTaiLieu = re.getString("TenTaiLieu");
            String TheLoai = re.getString("TenTheLoai");
            String NhaXuatBan = re.getString("TenNhaXuatBan");
            String TacGia = re.getString("TacGia");
            int SoLuongCo = re.getInt("SoLuongCo");
            int NamXuatBan = re.getInt("NamXuatBan");
            float GiaSach = re.getFloat("Gia");
            String ViTri = re.getString("ViTri");

            TaiLieu x = new TaiLieu(MaTaiLieu, TenTaiLieu, TheLoai, NhaXuatBan, TacGia, SoLuongCo, NamXuatBan, GiaSach, ViTri);
            List1.add(x);
        }
        return null;

    }
    public static ArrayList<TaiLieu> TimKiemTenTL(String Matl) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TaiLieu where TenTaiLieu like'" + Matl + "%'  ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaTaiLieu = re.getString("MaTaiLieu");
            String TenTaiLieu = re.getString("TenTaiLieu");
            String TheLoai = re.getString("TenTheLoai");
            String NhaXuatBan = re.getString("TenNhaXuatBan");
            String TacGia = re.getString("TacGia");
            int SoLuongCo = re.getInt("SoLuongCo");
            int NamXuatBan = re.getInt("NamXuatBan");
            float GiaSach = re.getFloat("Gia");
            String ViTri = re.getString("ViTri");
            TaiLieu x = new TaiLieu(MaTaiLieu, TenTaiLieu, TheLoai, NhaXuatBan, TacGia, SoLuongCo, NamXuatBan, GiaSach, ViTri);
            List1.add(x);
        }
        return null;

    }


    public static ArrayList<TaiLieu> TimKiemTacGia(String Matl) throws Exception {
        Connection conn = DBConnector.getConnection();
        Statement st = conn.createStatement();
        ResultSet re = st.executeQuery("select * from TaiLieu where TacGia like '" + Matl + "%'     ");

        List1.removeAll(List1);
        while (re.next()) {
            String MaTaiLieu = re.getString("MaTaiLieu");
            String TenTaiLieu = re.getString("TenTaiLieu");
            String TheLoai = re.getString("TenTheLoai");
            String NhaXuatBan = re.getString("TenNhaXuatBan");
            String TacGia = re.getString("TacGia");
            int SoLuongCo = re.getInt("SoLuongCo");
            int NamXuatBan = re.getInt("NamXuatBan");
            float GiaSach = re.getFloat("Gia");
            String ViTri = re.getString("ViTri");
            TaiLieu x = new TaiLieu(MaTaiLieu, TenTaiLieu, TheLoai, NhaXuatBan, TacGia, SoLuongCo, NamXuatBan, GiaSach, ViTri);
            List1.add(x);
        }
        return null;

    }

}
