package vote;

import attribute.Department;
import attribute.Position;

public class Nonvoter extends Voter {
	
	private Department Depar;//部门 
	private Position poi;//职务
	private int votenum; //可投票数
	

	public Department getDepar() {
		return Depar;
	}

	public void setDepar(Department depar) {
		Depar = depar;
	}

	public Position getPoi() {
		return poi;
	}

	public void setPoi(Position poi) {
		this.poi = poi;
	}

	public int getVotenum() {
		return votenum;
	}

	public void setVotenum(int votenum) {
		this.votenum = votenum;
	}

	Nonvoter(String name,int num,Department Depar,Position poi){
	 this.name=name;
	 this.uid=num;
	 this.Depar=Depar;
	 this.poi=poi;
     //按职位分配票数 
	 if(poi.getPostname().equals("部长")) {
		 votenum=2; 
	 }
	 else {
		 votenum=1;
	 }
	}
}
