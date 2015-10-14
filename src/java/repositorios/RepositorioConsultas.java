/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ionarameh
 */
public class RepositorioConsultas extends DAO{
   
    public int getArea(int gid){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection(true);
            pstmt = conn.prepareStatement("SELECT ST_Area(ST_Union(geom)) FROM bacias_pe WHERE gid = ?");
            //Statement.RETURN_GENERATED_KEYS
            pstmt.setInt(1, gid);
            rs = pstmt.executeQuery();
            
            String r = rs.getString("st_area");
            
            return Integer.parseInt(r);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return 0;
    }
}
