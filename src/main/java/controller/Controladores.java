package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.Login;

public class Controladores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controladores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
        String usuario, clave, msg="";
		usuario = request.getParameter("usuario");
		clave = request.getParameter("pass");
		
		try {
			if(Login.validar(usuario,clave)>0) {
				msg = "Usuario y Clave Correcta";
			}
			else {
				msg = "Usuario y Clave Incorrecta";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		msg = msg.toUpperCase();
		RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");	
		request.setAttribute("mensaje", msg);
		despachador.forward(request, response);
	}

}
