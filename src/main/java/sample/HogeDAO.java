package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HogeDAO {
	//DB接続のための変数
	private final String URL = "jdbc:mysql://localhost/sampledb";
	private final String USER = "root";
	private final String PASS = "**********";
	private Connection con = null;
	
	
	// DBに接続メソッド
	public void connect(){
	    try{
	      //①DBに接続
	      con = DriverManager.getConnection(URL, USER, PASS);
	    } catch(Exception e){
	      e.printStackTrace();
	    }
	}
	
	// DBから値を取得
	public String select(int stuNo) {
	    Statement stmt = null;
	    ResultSet rs = null;
	    String result = null;
	    
	    // SQL
	    String sql = "SELECT name FROM student WHERE no = " + stuNo;
	    try{
	      //②ステートメントを生成
	      stmt = con.createStatement();
	      //③SQLを実行
	      rs = stmt.executeQuery(sql);
	      //④検索結果の処理
	      rs.next();
	      result = rs.getString("name");
	    } catch(Exception e){
	      e.printStackTrace();
	    } finally {
	      try{
	        if(rs != null) rs.close();
	        if(stmt != null) stmt.close();
	      } catch(Exception e){
	        e.printStackTrace();
	      }
	    }
	    return result;
	}
	
	//接続解除
	public void disconnect(){
	    try{
	      //⑤DBを切断
	      if(con != null) con.close();
	    } catch(Exception e){
	      e.printStackTrace();
	    }
	  }
}
