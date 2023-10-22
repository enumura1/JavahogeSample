package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class HogeDTO implements Serializable{
  // StudentBeanクラスのオブジェクトが入る（型宣言）
  private ArrayList<HogeBean> list;
  
  // コンストラクタ
  public HogeDTO() {
	  list = new ArrayList<HogeBean>();
  }
  
  // beanをDTOのリストに追加
  public void add(HogeBean sb) {
	  list.add(sb);
  }
  
  // DTOのリストからbeanを取得
  public HogeBean get(int i) {
	  return list.get(i);
  }
  
  // DTOのリストの要素数を取得
  public int size() {
	  return list.size();
  }
  
}
