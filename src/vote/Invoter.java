package vote;
import attribute.Department;
import attribute.Position;

public class Invoter extends Voter  {
	private Department wantDepar;//��ѡ���� 
	private Position wantpoi;//��ѡְ��
	private String announce; //��ѡ����
	private int getvote=0; //��Ʊ��
	           
	 //Ҫ�����֮ǰ���ȴ�����̬�����࣬��ְ���࣬��ʱ�򴫲�����ȥ
	public Invoter(String name,int num,double grade,Department Depar,Position poi,String announce){
		this.name=name;
		this.uid=num;
		this.grade=grade;
		this.wantDepar=Depar;
		this.wantpoi=poi;
		this.announce=announce;
		invote=true;		
	}
	//���������Ϣ
	public String toString() {
		return "���:"+this.uid +"  "+"����:"+this.name+"  "+"�۲⿼���ɼ�:"+this.grade+"  ��ѡ����:"+this.wantDepar.getDepartname()+this.wantpoi.getPostname()+"  ְ��:"+wantpoi.getNeed()+" "+
	" ��ѡ����:"+ this.announce+"\n";
	}
	//�����Ʊ��Ϣ
	public String printResult() {
		return "���:"+this.uid +"  "+"����:"+this.name+"  "+"�۲⿼���ɼ�:"+this.grade+"  "+"��Ʊ��:"+this.getvote+ "\n";
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


