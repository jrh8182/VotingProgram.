package attribute;

public class Department {
	private String Departname; //��������
	private String function;  //����ְ��

	//ÿ������1������  2������ ���ɹ�����Ա
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
	
	public static Department a =new Department("����","ά��ͬѧ�ǵ�������");
	public static Department b =new Department("�޹ܲ�","ά����������");
	public static Department c =new Department("�ڹ���","��չ�ڹ�Ȩ��");
	public static Department d =new Department("��ί","��չ��ί����");
	public static Department e =new Department("������","��չ������ػ");
	public static Department f =new Department("������","����������");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(a.getDepartname());
		
	}




}
