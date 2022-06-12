/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.CNhanVien;
import static Controller.CNhanVien.conn;
import static Controller.CNhanVien.pstate;
import static Controller.CNhanVien.rs;
import static Controller.CNhanVien.sql;
import static Controller.CNhanVien.state;
import Model.NhanVien;
import View.FrameLogin;
import View.FrameMain;
import View.displayvalueModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author huy
 */
public class MainClass {
    public static  View.FrameMain frmMain=new FrameMain();
    public static Database.ConnectDB connection = new  Database.ConnectDB ();
    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=QuanLySanPhamZ;username=sa;password=1704";
    public static String UN ,PW ;
    public static void main(String[] args) {
       View.FrameLogin frmLogin= new View.FrameLogin(); 
       frmLogin.show();
        frmMain.setLocationRelativeTo(null);
        frmMain.setVisible(true);
    } 
}
