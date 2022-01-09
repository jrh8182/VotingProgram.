package attribute;

public class Department {
	private String Departname; //部门名字
	private String function;  //部门职能

	//每个部门1名部长  2名副部 若干工作人员
	public String getDepartname() {
		return Departname;
	}


	public void setDepartname(String departname) {
		Departname = departname;
	}
  

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Department(String Departname,String function) {
		this.Departname=Departname;
		this.function=function;
	}
	
	public static Department a =new Department("心理部","维护同学们的心理健康");
	public static Department b =new Department("宿管部","维护宿舍内务");
	public static Department c =new Department("勤工部","开展勤工权益活动");
	public static Department d =new Department("团委","开展团委事务");
	public static Department e =new Department("体育部","开展体育相关活动");
	public static Department f =new Department("外联部","外联拉赞助");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(a.getDepartname());
		
	}




}
