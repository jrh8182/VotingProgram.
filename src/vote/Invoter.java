package vote;
import attribute.Department;
import attribute.Position;

public class Invoter extends Voter  {
	private Department wantDepar;//竞选部门 
	private Position wantpoi;//竞选职务
	private String announce; //竞选宣言
	private int getvote=0; //得票数
	           
	 //要传这个之前，先创建静态部门类，和职务类，到时候传参数进去
	public Invoter(String name,int num,double grade,Department Depar,Position poi,String announce){
		this.name=name;
		this.uid=num;
		this.grade=grade;
		this.wantDepar=Depar;
		this.wantpoi=poi;
		this.announce=announce;
		invote=true;		
	}
	//输出个人信息
	public String toString() {
		return "编号:"+this.uid +"  "+"姓名:"+this.name+"  "+"综测考评成绩:"+this.grade+"  竞选意向:"+this.wantDepar.getDepartname()+this.wantpoi.getPostname()+"  职责:"+wantpoi.getNeed()+" "+
	" 竞选宣言:"+ this.announce+"\n";
	}
	//输出得票信息
	public String printResult() {
		return "编号:"+this.uid +"  "+"姓名:"+this.name+"  "+"综测考评成绩:"+this.grade+"  "+"得票数:"+this.getvote+ "\n";
	}
	
	public int getVote() {
		return this.getvote;
	}
	public Department getWantDepar() {
		return wantDepar;
	}
	public void setWantDepar(Department wantDepar) {
		this.wantDepar = wantDepar;
	}
	public Position getWantpoi() {
		return wantpoi;
	}
	public void setWantpoi(Position wantpoi) {
		this.wantpoi = wantpoi;
	}
	public String getAnnounce() {
		return announce;
	}
	public void setAnnounce(String announce) {
		this.announce = announce;
	}
    
	public void voteIncrease() {
		this.getvote++;
	}
	}


