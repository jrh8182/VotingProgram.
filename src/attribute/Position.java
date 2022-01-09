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
		this.need = need; //职位需要
	}
	
	public static Position bz=new Position("部长","组织会议，开展活动");
	public static Position fbz=new Position("副部长","协助部长开展工作");
	public static Position gzry =new Position("工作人员","进行日常工作");
	public static Position wu =new Position("无","无");
	
	
}
