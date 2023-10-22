package sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.HogeDTO;


@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
       
    public HelloServlet() {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// DAOのインスタンス
		HogeDAO sdao = new HogeDAO();
		
		// DTOに格納(○○テーブルのデータ=sdto)
		HogeDTO sdto = sdao.select();
		
	    //検索結果をリクエストスコープに格納
	    request.setAttribute("sdto", sdto);
	    
	    //JSPにフォワード(処理を転送)
	    RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
	    rd.forward(request, response);
	}

}
