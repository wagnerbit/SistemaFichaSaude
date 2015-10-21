package servlets;

import base.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositorios.RepositorioUsuario;


public class AdicionarUsuario extends HttpServlet {

    
    
    /*
    Adicionar os campos necessarios para inserir um usuário
       */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nome = request.getParameter("nome");
            String sobrenome =  request.getParameter("sobrenome");
            String login =  request.getParameter("login");
            Usuario usuario = new Usuario(nome, sobrenome, login);
            
            RepositorioUsuario repUsuario = new RepositorioUsuario();
            repUsuario.adicionarUsuario(usuario);
            
            //request.getRequestDispatcher("VisualizarBacias").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
