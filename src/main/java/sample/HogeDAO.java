package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.HogeBean;
import bean.HogeDTO;

public class HogeDAO {
	//DB接続のための変数
	private final String URL = "jdbc:mysql://localhost/sampledb";
	private final String USER = "root";
	private final String PASS = "************************";
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
	
	public HogeDTO select() {
		Statement stmt = null;
		ResultSet rs = null;
		
		// DTOオブジェクト生成（この時はDTOのリストは空）
		HogeDTO sdto = new HogeDTO();
		
		// SQL（studentテーブルの全件検索）
	    String sql = "SELECT * FROM student";
	    
	    try {
	    	// DB接続
	    	connect();
	    	stmt = con.createStatement();
	    	
	    	// SQLの実行 （テーブルの全てのデータが格納）
	    	rs = stmt.executeQuery(sql);
	    	
	    	while(rs.next()) {
	    		// beamオブジェクトの生成（この時は空）
	    		HogeBean sb = new HogeBean();
	    		
	    		// ゲッターでstudentテーブルの列項目を取得し、それをセッターでbeanに格納
	    		sb.setNo(rs.getInt("no"));
	    		sb.setName(rs.getString("name"));
	    		sb.setScore(rs.getInt("score"));
	    		
	    		// DTOのリストにbeanを要素として追加
	    		sdto.add(sb);
	    	}
	    }catch(Exception e){
	  	      e.printStackTrace();
  	    } finally {
  	      try{
  	        if(rs != null) rs.close();
  	        if(stmt != null) stmt.close();
  	      } catch(Exception e){
  	        e.printStackTrace();
  	      }
  	    }
	    // DB切断
	    disconnect();
  	    return sdto;
		
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
