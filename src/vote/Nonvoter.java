package vote;

import attribute.Department;
import attribute.Position;

public class Nonvoter extends Voter {
	
	private Department Depar;//���� 
	private Position poi;//ְ��
	private int votenum; //��ͶƱ��
	

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
     //��ְλ����Ʊ�� 
	 if(poi.getPostname().equals("����")) {
		 votenum=2; 
	 }
	 else {
		 votenum=1;
	 }
	}
}
