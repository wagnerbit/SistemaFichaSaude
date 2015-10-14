package repositorios;

import java.security.MessageDigest;
import java.sql.*;

public class RepositorioUsuario extends DAO {

    public void adicionarUsuario(String login, String senha) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection(false);
            pstmt = conn.prepareStatement("INSERT INTO usuario(login, senha) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, login);            
            pstmt.setString(2, senha);

            pstmt.executeUpdate();
            conn.commit();

        } catch (SQLException ex) {
            try {
                conn.rollback();
                System.err.println(ex.getMessage());
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } finally {
            try {
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
    }

    public boolean checkLogin(String login, String senha){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection(true);
            pstmt = conn.prepareStatement("SELECT * from usuario WHERE username = ? and pass = ?");
            pstmt.setString(1, login);

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(senha.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }

            pstmt.setString(2, sb.toString());

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
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
        return false;
    }
}
