package vote;

public abstract class Voter {
	//要让子类继承，用protected修饰
	protected String name;
	protected int uid;  //选民编号
	protected boolean invote=false; //是否参选，默认为否
	protected double grade; //综测成绩分数

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
