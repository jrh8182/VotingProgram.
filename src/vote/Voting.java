package vote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import attribute.Department;
import attribute.Position;


public class Voting {
	static Scanner in =new Scanner (System.in);
	static Scanner ingrade=new Scanner (System.in);
	//ֱ���þ�̬�����洢
	public static ArrayList <Invoter> invoter =new ArrayList<>();  //��ѡ��ʵ��������arraylist
	public static Set<Nonvoter> voters = new HashSet<Nonvoter>();  //�����͸��Ʊ��
	public static ArrayList <Nonvoter> nonvoter =new ArrayList<>();    //ͶƱ��ʵ��������arraylist
	
	//�޸Ĳ�ѡ�ߵ��۲�ɼ�����-1�˳�
	public static void ismodify(Department depar,Position poi){
		int num=0,isChanged=0;  //���һ�£�δ�޸Ĺ���������µ�����
		System.out.println("�Ƿ���Ҫ��ѡ���޸���Ϣ,����Ҫ�������ţ�(����-1�������޸�)");
		 try {num=in.nextInt();}
		 catch (InputMismatchException e) {
			 System.out.println("�������������֣�");
//			 ����ʱ�������num��ֵΪ0,���������ѭ��
			 in.next();
		 }
		while(num!=-1){
			int flag=1; //��ǩ�Ƿ��ҵ����˲��޸ĳɹ�������ɼ�ʧ��Ҳ��ʧ��
			for(Invoter i : invoter) {	
			  if((i.uid==num)&&(i.getWantDepar()==depar)&&(i.getWantpoi()==poi)) {
				  isChanged=1;
				  flag=0; //�޸ĳɹ�flagΪ0��
				  System.out.println(i.getName()+"���۲�ɼ��޸ģ�");
				  try{i.grade=ingrade.nextDouble();}
				  catch(InputMismatchException e){
					  System.out.println("������С��");
					  flag=1;
					  ingrade.next();
					  break;  //�ɼ�ӦΪС�������������������break��
				  }
				  if(flag==0) {
				  System.out.println(i.getName()+"���۲�ɼ����޸ĳɹ���"+"�޸�Ϊ��"+i.grade);
				  }

				  System.out.println("�Ƿ���Ҫ��ѡ���޸���Ϣ,����Ҫ�������ţ�(����-1�������޸�)");
				  try {num=in.nextInt();}
					 catch (InputMismatchException e) {
						 System.out.println("�������������֣�");
						 in.next();
					 }
			  }
			  }
			   if(flag==1) {
				  System.out.println("���뷽ʽ�������޴��ˣ�������������˳��޸ģ������ٴ������ţ�");

				 try {num=in.nextInt();}
				 catch (InputMismatchException e) {
					 System.out.println("�������������֣�");
					 in.next(); //�ٴ�����Ҫѡ�ı�ţ��������´θ�ֵ�������ٴ�����ǻ������һ�ζ�����޸ġ�
				 }
				 

			}
		}
		
		if(isChanged==1) {
		System.out.println("�޸ĺ�");
		checkList(depar,poi);}
		else if(isChanged==0) {
			System.out.println("��Ȼ�����޸������ǿ�ʼͶƱ�ɣ�");
		}
		
	}
	
	//�˴�Ӧ���throw��䣬����������������ַ������
	public static void voterFor(Department depar,int answer,Position poi){
		 int flag=0;  //��־�Ƿ���ArrayList�д����������
		for(Invoter i : invoter) {
		  
		  if((i.uid==answer)&&(i.getWantDepar()==depar)&&(i.getWantpoi()==poi)) {
			  flag=1;
			  i.voteIncrease(); //��Ч��Ʊ��+1
			  System.out.println("��Ͷ����"+answer+"��"+i.name+" ��л���ͶƱ��");
			  break; //��ֹ
		  }
		 
	  } 
		if(flag==0) {
		System.out.println("��ƱδͶ����ȷ�Ĳ�ѡ�ߣ���Ϊ��Ȩ!"); //û�ҵ���˵����Ȩ����Ʊ��
		}
	}
	
	//�鿴Ҫѡ�ٲ��ŵĲ�ѡ�ߵ�������
	public static void checkList(Department depar,Position pos) {
		System.out.println("***********************************************************************");
		System.out.println(depar.getDepartname()+"��ְ����"+depar.getFunction());
		System.out.println("�鿴"+depar.getDepartname()+"�ľ�ѡ����:");
		for(Invoter i : invoter) {
			if(i.getWantDepar()==depar&&i.getWantpoi()==pos)
			System.out.println(i.toString());
		}
	}
	
	public static void startVote(Department depar) //ѡ��˴�Ҫ����ͶƱ�Ĳ��š��˷������ݿ��پ��򣬰ѵ���ͶƱ���̷�װ��һ��������
	{                                                                      
//		checkList(depar); //�鿴����
		
	    Position now = Position.bz;   //�趨��ʱͶƱ����Ϊ����	    
	    checkList(depar,now); //�鿴��ʱҪͶƱ������  ѡ����
		ismodify(depar,now);  //�Ƿ�Ҫ�޸��۲�ɼ� ����ӡ���޸ĺ�
		
		for(Nonvoter j: nonvoter) {
			if(j.getDepar()==depar&&!voters.contains(j)) {
						
				if(j.getVotenum()>0) {
					System.out.print("�����ֵ�"+j.getName()+"ͬѧ������ͶƱ"+"��д����Ŀ�в�����ѡ�ı��  ");
					while(j.getVotenum()>0) {
						System.out.println("��������"+j.getVotenum()+"Ʊ��Ͷ��");
						try{voterFor(depar,in.nextInt(),now);}
						catch (InputMismatchException e) {  
							System.out.println("�����ֵ��ʽ����ȷ ҪΪ�����Ҷ�Ӧ������ţ�����Ͷ��"); 
							//ֻ�Ǽ򵥵Ĳ������ִ��󣬻ᵼ��scanner���ֵ�䲻��ȥ������һֱ���Ǵ�ġ�
							in.next();//�ڽ���һ��ֵ����Ҫ��Int 
							j.setVotenum(j.getVotenum() + 1); //��������������Ʊ��
						}
						j.setVotenum(j.getVotenum() - 1);
						if(j.getVotenum()==0)
						{
							  System.out.println("**************���Ʊ��������,лл���룡********************\n");
						}
					}
				}
							
//				voters.add(j);   ��ҪͶ�ڶ���,�Ȳ���ӡ�
			}
		}
		System.out.println("-----------------------����ͶƱ�ѽ��������ڿ�ʼ���и�����ѡ��ͶƱ--------------------------");
		
		now = Position.fbz; //�趨��ʱͶƱ����Ϊ����
	    checkList(depar,now); //�鿴��ʱҪͶƱ������  ѡ������
		ismodify(depar,now); 
		for(Nonvoter j: nonvoter) {
			if(j.getPoi()==Position.bz) {
				j.setVotenum(2);
			}
			else if(j.getPoi()==Position.fbz||j.getPoi()==Position.gzry) {
				j.setVotenum(1);  //�ָ�Ʊ��
			}
			if(j.getDepar()==depar&&!voters.contains(j)) {
//				��һ��Ͷ�겿����ѡ����Ʊ���Ѿ���������Ҫ�ָ���Ӧ��Ʊ����
				if(j.getVotenum()>0) {
					System.out.print("�����ֵ�"+j.getName()+"ͬѧ������ͶƱ"+"��д����Ŀ�и�������ѡ�ı��  ");
					while(j.getVotenum()>0) {
						System.out.println("��������"+j.getVotenum()+"Ʊ��Ͷ��");
						try{voterFor(depar,in.nextInt(),now);}
						catch (InputMismatchException e) {  
							System.out.println("�����ֵ��ʽ����ȷ ҪΪ�����Ҷ�Ӧ������ţ�����Ͷ��"); 
							in.next();//�ڽ���һ��ֵ����Ҫ��Int,��һ��ѭ������try�еķ���
							j.setVotenum(j.getVotenum() + 1); //��������������Ʊ��
						}
						j.setVotenum(j.getVotenum() - 1); //Ͷ��һƱ������ͶƱ�ɹ��������ϣ�Ʊ����Ҫ��һ
						if(j.getVotenum()==0)
						{
							  System.out.println("**************���Ʊ��������,лл���룡********************\n");
						}
					}
				}
			
				
				voters.add(j);  //��ɱ�����ͶƱ�������
			}
		}	
		
		//��ѯ����ѡ���Ʊ��
		System.out.println("     ����Ҫ��ѯ��ѡ�����֣�"+       "�����ѯ����'n'����");
		searchVote(in.next(),depar);   
		
		//��ӡ��Ʊ�����������ѡ��
		viewGetvote(depar);
	
//		System.out.println(voters.isEmpty());
		}


//	!!!!!!�޸�viewGetvote����������ְ���������ӱȽϵ�Ʊ���ķ��������������ѡ��������
	public static void viewGetvote(Department depar) {
	   ArrayList <Invoter> bznow=new ArrayList<>();  //��ʱ��Ų�ѡ��������
	   ArrayList <Invoter> fbznow=new ArrayList<>(); 
		for(Invoter i : invoter) {
			if(i.getWantDepar()==depar&&i.getWantpoi()==Position.bz) {
				bznow.add(i);
			}
			if(i.getWantDepar()==depar&&i.getWantpoi()==Position.fbz) {
				fbznow.add(i);
			}	
		}
//		���ò��Ÿ�ְ��Ĳ�ѡ�߰���Ʊ���������У�ÿ��������һ������ǻ�ѡ��
		Collections.sort(bznow,new Compare_byVotenum());       //�ýӿ���Compare_byVotenum��ʵ��
		Collections.sort(fbznow,new Compare_byVotenum()); 
		
		String a1=bznow.get(0).name;  //�洢���������ѡ������
		String a2=fbznow.get(0).name; //�洢�����������ѡ������
		
		System.out.println("�������������������������������������������ֹ���������ѡ�ߵ�Ʊ���������������������������������������������");
		for(Invoter i:bznow) {
			System.out.println(i.printResult());
		}
		System.out.println("��ѡ���ǣ�   "+a1);
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
		
		System.out.println("�������������������������������������������ֹ�����������ѡ�ߵ�Ʊ���������������������������������������������");
		for(Invoter i:fbznow) {
			System.out.println(i.printResult());
		}
		System.out.println("��ѡ���ǣ�   "+a2);
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������");
	}
	
	//������ѯĳ��ѡ��ĵ�Ʊ���
	public static void searchVote(String name,Department depar) {	
		int flag=0; //�Ƿ��ҵ�

		for(Invoter i : invoter) {
			if(i.getWantDepar()==depar&&i.getName().equals(name)) {
				System.out.println(i.getName()+" ��ѡ��"+i.getWantpoi().getPostname()+" ���Ʊ����"+i.getVote()+'\n');
				flag=1;
				break;
			}
		}
		if(flag==0&&!name.equals("n")) {
			System.out.println("���޴���,��������һ��");
			searchVote(in.next(), depar); //�ٵ�������һ�Σ��ݹ�ֱ����ѯ��
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʵ����  ��ѡѡ��
//		����
		Invoter a1= new Invoter("��СȪ",1,95.5,Department.a,Position.bz,"ѡ��ѡ�ҿ�ѡ�ң�������");
		Invoter a2= new Invoter("Ƚ���",2,85.5,Department.a,Position.bz,"��������ʱ�������Դ��ʵ��");
		Invoter a3= new Invoter("�����",3,75.8,Department.a,Position.bz,"˧����Ů��Ͷ��");
		Invoter a4= new Invoter("���",4,49.5,Department.a,Position.fbz,"�¸ҵ�������һ���������Լ�");
		Invoter a5= new Invoter("����",5,90,Department.a,Position.fbz,"ȼ���ഺ���飬��ս�����۷塣");
		Invoter a6= new Invoter("�����",6,88,Department.a,Position.fbz,"����һ�����ᣬ����һ���漣��");
//		�޹ܲ�
		Invoter b1= new Invoter("½�µ�",1,76,Department.b,Position.bz,"��ֻ��Ϊ��ҷ�����Ͷ��һƱ��");
		Invoter b2= new Invoter("ʯ����",2,76.5,Department.b,Position.bz,"�����ң�֧���ң������޵к�ѡ�ߡ�");
		Invoter b3= new Invoter("����ܽ",3,77,Department.b,Position.fbz,"�������ޣ���������");
		Invoter b4= new Invoter("��ƽ��",4,98,Department.b,Position.fbz,"���˻����һ�����ŵ���һ����һ����ж���");
		Invoter b5= new Invoter("�غ��",5,56,Department.b,Position.fbz,"������ã�ֻ����ã�");
//		�ڹ���
		Invoter c1= new Invoter("¬�ı�",1,78,Department.c,Position.bz,"�ҽ����������룬��������������������ʵ�Ĵ���");
		Invoter c2= new Invoter("������",2,88,Department.c,Position.bz,"ѡ���� �����");
		Invoter c3= new Invoter("�����",3,99,Department.c,Position.fbz,"����������������ơ�");
		Invoter c4= new Invoter("�����",4,72.5,Department.c,Position.fbz,"����һ����̨������һ�����ʣ�");
		Invoter c5= new Invoter("�ڹ���",5,64,Department.c,Position.fbz,"����һ�λ��ỹ��һ����ϲ��");
//		��ί	
		Invoter d1= new Invoter("���ְ�",1,73,Department.d,Position.bz,"�˲�ʱ������������ģ�⾺Ƹ���ֵ��ۡ�");
		Invoter d2= new Invoter("�ʺ���",2,71,Department.d,Position.bz,"��������ѡ�����漣��");
		Invoter d3= new Invoter("�ŷɳ�",3,84,Department.d,Position.fbz,"�ȵ���Ũ��������ף���Զ�����������֮��Ҳ��");
		Invoter d4= new Invoter("̷��Ԫ",4,49,Department.d,Position.fbz,"�������԰����ˣ���û������ȥ�����˵ġ�");
		Invoter d5= new Invoter("������",5,85,Department.d,Position.fbz,"���˽������䳤�ߣ�������ߣ����ܾ�Ҳ");
//		������	
		Invoter e1= new Invoter("������",1,79.5,Department.e,Position.bz,"Ҫ��ͬ�����˵������ѣ������ذ�ͬ�����˵������ѡ�");
		Invoter e2= new Invoter("�޷ɳ�",2,94,Department.e,Position.bz,"������֮ʿ���ص���ֱ֮�˴�����֮��");
		Invoter e3= new Invoter("Ҧ��ī",3,82,Department.e,Position.fbz,"���������ĸ��ã�����֧���Ұɣ�Ͷ��һƱ��лл��");
		Invoter e4= new Invoter("����Խ",4,83,Department.e,Position.fbz,"�͵����ҵ��Ը�Ŭ�����ҵĳ�ŵ��");
		Invoter e5= new Invoter("Ƚ���",5,84.5,Department.e,Position.fbz,"���ѡ�񲻻���ҵĳ�ŵ�����");
//		������
		Invoter f1= new Invoter("������",1,85.5,Department.f,Position.bz,"�ǽ��Ӿ�Ҫ����");
		Invoter f2= new Invoter("���߽�",2,86.5,Department.f,Position.bz,"�겻������֪�ɰأ��²�������֪���ӡ�");
		Invoter f3= new Invoter("������",3,18,Department.f,Position.fbz,"ͬ����ӣ�ͬ����Ӧ��������Ҳ��");
		Invoter f4= new Invoter("���˵�",4,22,Department.f,Position.fbz,"��֪ʤ������Լ��Ī��Ѱ���þۿ���");
		Invoter f5= new Invoter("�����",5,94,Department.f,Position.fbz,"�����߳࣬��ī�ߺڡ�");
		//��ѡѡ�� ����ArrayList
		invoter.add(a1);
		invoter.add(a2);
		invoter.add(a3);
		invoter.add(a4);
		invoter.add(a5);
		invoter.add(a6);
		
		invoter.add(b1);
		invoter.add(b2);
		invoter.add(b3);
		invoter.add(b4);
		invoter.add(b5);
		
		invoter.add(c1);
		invoter.add(c2);
		invoter.add(c3);
		invoter.add(c4);
		invoter.add(c5);
		
		invoter.add(d1);
		invoter.add(d2);
		invoter.add(d3);
		invoter.add(d4);
		invoter.add(d5);
		
		invoter.add(e1);
		invoter.add(e2);
		invoter.add(e3);
		invoter.add(e4);
		invoter.add(e5);
		
		invoter.add(f1);
		invoter.add(f2);
		invoter.add(f3);
		invoter.add(f4);
		invoter.add(f5);
		

		//�ǲ�ѡѡ��ʵ���� 
//		1-����
		Nonvoter n1=new Nonvoter("��Ӣ��",1,Department.a,Position.bz);
		Nonvoter n2=new Nonvoter("������",2,Department.a,Position.fbz);
		Nonvoter n3=new Nonvoter("������",3,Department.a,Position.fbz);
		Nonvoter n4=new Nonvoter("��Ӣ��",4,Department.a,Position.gzry);
		Nonvoter n5=new Nonvoter("��Ԫ��",5,Department.a,Position.gzry);
		Nonvoter n6=new Nonvoter("������",6,Department.a,Position.gzry);
		Nonvoter n7=new Nonvoter("��Ӣ��",7,Department.a,Position.gzry);
		Nonvoter n8=new Nonvoter("�����",8,Department.a,Position.fbz);
		Nonvoter n9=new Nonvoter("���Ž�",9,Department.a,Position.gzry);
//		 2-�޹ܲ�
		Nonvoter m1=new Nonvoter("������",1,Department.b,Position.bz);
		Nonvoter m2=new Nonvoter("���ͥ",2,Department.b,Position.fbz);
		Nonvoter m3=new Nonvoter("������",3,Department.b,Position.fbz);
		Nonvoter m4=new Nonvoter("���˺�",4,Department.b,Position.gzry);
		Nonvoter m5=new Nonvoter("���Ƶ�",5,Department.b,Position.gzry);
		Nonvoter m6=new Nonvoter("��ɽܽ",6,Department.b,Position.gzry);
		Nonvoter m7=new Nonvoter("ʯ�ٷ�",7,Department.b,Position.gzry);
		Nonvoter m8=new Nonvoter("��᰷�",8,Department.b,Position.gzry);
		Nonvoter m9=new Nonvoter("������",9,Department.b,Position.gzry);
//		3-�ڹ���
		Nonvoter o1=new Nonvoter("����",1,Department.c,Position.bz);
		Nonvoter o2=new Nonvoter("׿����",2,Department.c,Position.fbz);
		Nonvoter o3=new Nonvoter("������",3,Department.c,Position.fbz);
		Nonvoter o4=new Nonvoter("������",4,Department.c,Position.gzry);
		Nonvoter o5=new Nonvoter("�ް���",5,Department.c,Position.gzry);
		Nonvoter o6=new Nonvoter("�¼���",6,Department.c,Position.gzry);
		Nonvoter o7=new Nonvoter("ؿ����",7,Department.c,Position.gzry);
		Nonvoter o8=new Nonvoter("������",8,Department.c,Position.gzry);
		Nonvoter o9=new Nonvoter("Ѧ���",9,Department.c,Position.gzry);
//		4-��ί
		Nonvoter q1=new Nonvoter("������",1,Department.d,Position.bz);
		Nonvoter q2=new Nonvoter("���Ĺ�",2,Department.d,Position.fbz);
		Nonvoter q3=new Nonvoter("����",3,Department.d,Position.fbz);
		Nonvoter q4=new Nonvoter("��Ӣ��",4,Department.d,Position.gzry);
		Nonvoter q5=new Nonvoter("������",5,Department.d,Position.gzry);
		Nonvoter q6=new Nonvoter("���ı�",6,Department.d,Position.gzry);
		Nonvoter q7=new Nonvoter("������",7,Department.d,Position.gzry);
		Nonvoter q8=new Nonvoter("֣���",8,Department.d,Position.gzry);
		Nonvoter q9=new Nonvoter("�����",9,Department.d,Position.gzry);
//		5-������
		Nonvoter r1=new Nonvoter("�ʽ���",1,Department.e,Position.bz);
		Nonvoter r2=new Nonvoter("��ǧ��",2,Department.e,Position.fbz);
		Nonvoter r3=new Nonvoter("ؿ����",3,Department.e,Position.fbz);
		Nonvoter r4=new Nonvoter("������",4,Department.e,Position.gzry);
		Nonvoter r5=new Nonvoter("���ɽ",5,Department.e,Position.gzry);
		Nonvoter r6=new Nonvoter("������",6,Department.e,Position.gzry);
		Nonvoter r7=new Nonvoter("������",7,Department.e,Position.gzry);
		Nonvoter r8=new Nonvoter("������",8,Department.e,Position.gzry);
		Nonvoter r9=new Nonvoter("���粨",9,Department.e,Position.gzry);
//		6-������		
		Nonvoter t1=new Nonvoter("Ǯ����",1,Department.f,Position.bz);
		Nonvoter t2=new Nonvoter("�α���",2,Department.f,Position.fbz);
		Nonvoter t3=new Nonvoter("��ī��",3,Department.f,Position.fbz);
		Nonvoter t4=new Nonvoter("������",4,Department.f,Position.gzry);
		Nonvoter t5=new Nonvoter("������",5,Department.f,Position.gzry);
		Nonvoter t6=new Nonvoter("������",6,Department.f,Position.gzry);
		Nonvoter t7=new Nonvoter("����ʱ",7,Department.f,Position.gzry);
		Nonvoter t8=new Nonvoter("Ц���",8,Department.f,Position.gzry);
		Nonvoter t9=new Nonvoter("�ͷ���",9,Department.f,Position.gzry);

		//�ǲ�ѡѡ�� �����ӦArrayList
		nonvoter.add(n1);
		nonvoter.add(n2);
		nonvoter.add(n3);
		nonvoter.add(n4);
		nonvoter.add(n5);
		nonvoter.add(n6);
		nonvoter.add(n7);
		nonvoter.add(n8);
		nonvoter.add(n9);
		
		nonvoter.add(m1);
		nonvoter.add(m2);
		nonvoter.add(m3);
		nonvoter.add(m4);
		nonvoter.add(m5);
		nonvoter.add(m6);
		nonvoter.add(m7);
		nonvoter.add(m8);
		nonvoter.add(m9);
		
		nonvoter.add(o1);
		nonvoter.add(o2);
		nonvoter.add(o3);
		nonvoter.add(o4);
		nonvoter.add(o5);
		nonvoter.add(o6);
		nonvoter.add(o7);
		nonvoter.add(o8);
		nonvoter.add(o9);
	
		nonvoter.add(q1);
		nonvoter.add(q2);
		nonvoter.add(q3);
		nonvoter.add(q4);
		nonvoter.add(q5);
		nonvoter.add(q6);
		nonvoter.add(q7);
		nonvoter.add(q8);
		nonvoter.add(q9);
		
		nonvoter.add(r1);
		nonvoter.add(r2);
		nonvoter.add(r3);
		nonvoter.add(r4);
		nonvoter.add(r5);
		nonvoter.add(r6);
		nonvoter.add(r7);
		nonvoter.add(r8);
		nonvoter.add(r9);
		
		nonvoter.add(t1);
		nonvoter.add(t2);
		nonvoter.add(t3);
		nonvoter.add(t4);
		nonvoter.add(t5);
		nonvoter.add(t6);
		nonvoter.add(t7);
		nonvoter.add(t8);
		nonvoter.add(t9);

		//��ʼ����ͶƱ
	System.out.println("������������������������****���ѽ���ͶƱ���򣡣���Ҫ�˳�����-1��****��������������������������");
	System.out.println("������Ҫ���е�ͶƱ��ţ�1~6�����δ�����������");	
	System.out.println("1-����  2-�޹ܲ� 3-�ڹ��� 4-��ί 5-������ 6-������");
		int i=-1;
        //��ʼֵ��Ϊ-1���������ֱ���˳�ϵͳ��
		try{i=in.nextInt();}
		
		catch(InputMismatchException e) {
			System.out.println("error! ��������������1-6��Ӧ��Ӧ����");			
		}
		while(i!=-1){
		switch(i) {
		//��������ͶƱ
		
		case 1: if(!voters.contains(n1)) {  //Ͷ��Ʊ�Ѿ��浽�˶���鿴һ�µ�һ��Ԫ������ڶ������ò�����Ͷ��
					startVote(Department.a); }
				else {
					System.out.println(Department.a.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�"); 
					}  //Ͷ������������Ż���ʾǰһ��Ͷ�Ĳ���
				break;
		//�����޹ܲ�ͶƱ
		case 2: if(!voters.contains(m1)) {
					startVote(Department.b); }
				else {
					System.out.println(Department.b.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
					}
				break;
		//�����ڹ���ͶƱ		
		case 3: if(!voters.contains(o1)) {
			startVote(Department.c); }
		else {
			System.out.println(Department.c.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
			}
		break;		
		//������ίͶƱ
		case 4:if(!voters.contains(q1)) {
			startVote(Department.d); }
		else {
			System.out.println(Department.d.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
			}
		break;		
		//����������ͶƱ
		case 5:if(!voters.contains(r1)) {
					startVote(Department.f); }
				else {
					System.out.println(Department.e.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
					}
				break;	
		//����������ͶƱ
		case 6:if(!voters.contains(t1)) {
			startVote(Department.f); }
		else {
			System.out.println(Department.f.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
			}
		break;	
		}
		System.out.println("��������һ��Ҫ����ͶƱ�ı�ţ�\n  (��ܰ��ʾ)1-����  2-�޹ܲ� 3-�ڹ��� 4-��ί 5-������ 6-������");
		try{i=in.nextInt();}
		catch(InputMismatchException e) {
			System.out.println("error! ������1-6��Ӧ��Ӧ����");
			in.next();  //�洢��ֵ����һ��ѭ��
		}
		}
		
		if(i==-1) {
			System.out.println("������������������������****�����˳�ͶƱ����лл��ϣ�****��������������������������");
		}
		
		
		
		
	}

}
