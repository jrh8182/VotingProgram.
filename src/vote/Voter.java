package vote;

public abstract class Voter {
	//Ҫ������̳У���protected����
	protected String name;
	protected int uid;  //ѡ����
	protected boolean invote=false; //�Ƿ��ѡ��Ĭ��Ϊ��
	protected double grade; //�۲�ɼ�����

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int  num) {
		this.uid = num;
	}

	public boolean isInvote() {
		return invote;
	}

	public void setInvote(boolean invote) {
		this.invote = invote;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
