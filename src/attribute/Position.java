package attribute;

public class Position {
	private String postname;
	private String need;
	
	public 	Position(String pos,String need) {
		this.postname=pos.toString();
		this.need=need;		
	}
	
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public String getNeed() {
		return need;
	}
	public void setNeed(String need) {
		this.need = need; //ְλ��Ҫ
	}
	
	public static Position bz=new Position("����","��֯���飬��չ�");
	public static Position fbz=new Position("������","Э��������չ����");
	public static Position gzry =new Position("������Ա","�����ճ�����");
	public static Position wu =new Position("��","��");
	
	
}
