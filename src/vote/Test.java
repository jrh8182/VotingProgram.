package vote;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import attribute.Department;
import attribute.Position;

public class Test {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList <Invoter> invoter1 =Voting.invoter; 
		 ArrayList <Nonvoter> nonvoter1 =Voting.nonvoter; 
		 Set<Nonvoter> voters1 = Voting.voters;        //����Voting�еľ�̬����
		 Scanner in = new Scanner (System.in);
			//ʵ����  ��ѡѡ��
//			����
			Invoter a1= new Invoter("��СȪ",1,95.5,Department.a,Position.bz,"ѡ��ѡ�ҿ�ѡ�ң�������");
			Invoter a2= new Invoter("Ƚ���",2,85.5,Department.a,Position.bz,"��������ʱ�������Դ��ʵ��");
			Invoter a3= new Invoter("�����",3,75.8,Department.a,Position.bz,"˧����Ů��Ͷ��");
			Invoter a4= new Invoter("���",4,49.5,Department.a,Position.fbz,"�¸ҵ�������һ���������Լ�");
			Invoter a5= new Invoter("����",5,90,Department.a,Position.fbz,"ȼ���ഺ���飬��ս�����۷塣");
			Invoter a6= new Invoter("�����",6,88,Department.a,Position.fbz,"����һ�����ᣬ����һ���漣��");
//			�޹ܲ�
			Invoter b1= new Invoter("½�µ�",1,76,Department.b,Position.bz,"��ֻ��Ϊ��ҷ�����Ͷ��һƱ��");
			Invoter b2= new Invoter("ʯ����",2,76.5,Department.b,Position.bz,"�����ң�֧���ң������޵к�ѡ�ߡ�");
			Invoter b3= new Invoter("����ܽ",3,77,Department.b,Position.fbz,"�������ޣ���������");
			Invoter b4= new Invoter("��ƽ��",4,98,Department.b,Position.fbz,"���˻����һ�����ŵ���һ����һ����ж���");
			Invoter b5= new Invoter("�غ��",5,56,Department.b,Position.fbz,"������ã�ֻ����ã�");
//			�ڹ���
			Invoter c1= new Invoter("¬�ı�",1,78,Department.c,Position.bz,"�ҽ����������룬��������������������ʵ�Ĵ���");
			Invoter c2= new Invoter("������",2,88,Department.c,Position.bz,"ѡ���� �����");
			Invoter c3= new Invoter("�����",3,99,Department.c,Position.fbz,"����������������ơ�");
			Invoter c4= new Invoter("�����",4,72.5,Department.c,Position.fbz,"����һ����̨������һ�����ʣ�");
			Invoter c5= new Invoter("�ڹ���",5,64,Department.c,Position.fbz,"����һ�λ��ỹ��һ����ϲ��");
//			��ί	
			Invoter d1= new Invoter("���ְ�",1,73,Department.d,Position.bz,"�˲�ʱ������������ģ�⾺Ƹ���ֵ��ۡ�");
			Invoter d2= new Invoter("�ʺ���",2,71,Department.d,Position.bz,"��������ѡ�����漣��");
			Invoter d3= new Invoter("�ŷɳ�",3,84,Department.d,Position.fbz,"�ȵ���Ũ��������ף���Զ�����������֮��Ҳ��");
			Invoter d4= new Invoter("̷��Ԫ",4,49,Department.d,Position.fbz,"�������԰����ˣ���û������ȥ�����˵ġ�");
			Invoter d5= new Invoter("������",5,85,Department.d,Position.fbz,"���˽������䳤�ߣ�������ߣ����ܾ�Ҳ");
//			������	
			Invoter e1= new Invoter("������",1,79.5,Department.e,Position.bz,"Ҫ��ͬ�����˵������ѣ������ذ�ͬ�����˵������ѡ�");
			Invoter e2= new Invoter("�޷ɳ�",2,94,Department.e,Position.bz,"������֮ʿ���ص���ֱ֮�˴�����֮��");
			Invoter e3= new Invoter("Ҧ��ī",3,82,Department.e,Position.fbz,"���������ĸ��ã�����֧���Ұɣ�Ͷ��һƱ��лл��");
			Invoter e4= new Invoter("����Խ",4,83,Department.e,Position.fbz,"�͵����ҵ��Ը�Ŭ�����ҵĳ�ŵ��");
			Invoter e5= new Invoter("Ƚ���",5,84.5,Department.e,Position.fbz,"���ѡ�񲻻���ҵĳ�ŵ�����");
//			������
			Invoter f1= new Invoter("������",1,85.5,Department.f,Position.bz,"�ǽ��Ӿ�Ҫ����");
			Invoter f2= new Invoter("���߽�",2,86.5,Department.f,Position.bz,"�겻������֪�ɰأ��²�������֪���ӡ�");
			Invoter f3= new Invoter("������",3,18,Department.f,Position.fbz,"ͬ����ӣ�ͬ����Ӧ��������Ҳ��");
			Invoter f4= new Invoter("���˵�",4,22,Department.f,Position.fbz,"��֪ʤ������Լ��Ī��Ѱ���þۿ���");
			Invoter f5= new Invoter("�����",5,94,Department.f,Position.fbz,"�����߳࣬��ī�ߺڡ�");
			//��ѡѡ�� ����ArrayList
			invoter1.add(a1);
			invoter1.add(a2);
			invoter1.add(a3);
			invoter1.add(a4);
			invoter1.add(a5);
			invoter1.add(a6);
			
			invoter1.add(b1);
			invoter1.add(b2);
			invoter1.add(b3);
			invoter1.add(b4);
			invoter1.add(b5);
			
			invoter1.add(c1);
			invoter1.add(c2);
			invoter1.add(c3);
			invoter1.add(c4);
			invoter1.add(c5);
			
			invoter1.add(d1);
			invoter1.add(d2);
			invoter1.add(d3);
			invoter1.add(d4);
			invoter1.add(d5);
			
			invoter1.add(e1);
			invoter1.add(e2);
			invoter1.add(e3);
			invoter1.add(e4);
			invoter1.add(e5);
			
			invoter1.add(f1);
			invoter1.add(f2);
			invoter1.add(f3);
			invoter1.add(f4);
			invoter1.add(f5);
			

			//�ǲ�ѡѡ��ʵ���� 
//			1-����
			Nonvoter n1=new Nonvoter("��Ӣ��",1,Department.a,Position.bz);
			Nonvoter n2=new Nonvoter("������",2,Department.a,Position.fbz);
			Nonvoter n3=new Nonvoter("������",3,Department.a,Position.fbz);
			Nonvoter n4=new Nonvoter("��Ӣ��",4,Department.a,Position.gzry);
			Nonvoter n5=new Nonvoter("��Ԫ��",5,Department.a,Position.gzry);
			Nonvoter n6=new Nonvoter("������",6,Department.a,Position.gzry);
			Nonvoter n7=new Nonvoter("��Ӣ��",7,Department.a,Position.gzry);
			Nonvoter n8=new Nonvoter("�����",8,Department.a,Position.fbz);
			Nonvoter n9=new Nonvoter("���Ž�",9,Department.a,Position.gzry);
//			 2-�޹ܲ�
			Nonvoter m1=new Nonvoter("������",1,Department.b,Position.bz);
			Nonvoter m2=new Nonvoter("���ͥ",2,Department.b,Position.fbz);
			Nonvoter m3=new Nonvoter("������",3,Department.b,Position.fbz);
			Nonvoter m4=new Nonvoter("���˺�",4,Department.b,Position.gzry);
			Nonvoter m5=new Nonvoter("���Ƶ�",5,Department.b,Position.gzry);
			Nonvoter m6=new Nonvoter("��ɽܽ",6,Department.b,Position.gzry);
			Nonvoter m7=new Nonvoter("ʯ�ٷ�",7,Department.b,Position.gzry);
			Nonvoter m8=new Nonvoter("��᰷�",8,Department.b,Position.gzry);
			Nonvoter m9=new Nonvoter("������",9,Department.b,Position.gzry);
//			3-�ڹ���
			Nonvoter o1=new Nonvoter("����",1,Department.c,Position.bz);
			Nonvoter o2=new Nonvoter("׿����",2,Department.c,Position.fbz);
			Nonvoter o3=new Nonvoter("������",3,Department.c,Position.fbz);
			Nonvoter o4=new Nonvoter("������",4,Department.c,Position.gzry);
			Nonvoter o5=new Nonvoter("�ް���",5,Department.c,Position.gzry);
			Nonvoter o6=new Nonvoter("�¼���",6,Department.c,Position.gzry);
			Nonvoter o7=new Nonvoter("ؿ����",7,Department.c,Position.gzry);
			Nonvoter o8=new Nonvoter("������",8,Department.c,Position.gzry);
			Nonvoter o9=new Nonvoter("Ѧ���",9,Department.c,Position.gzry);
//			4-��ί
			Nonvoter q1=new Nonvoter("������",1,Department.d,Position.bz);
			Nonvoter q2=new Nonvoter("���Ĺ�",2,Department.d,Position.fbz);
			Nonvoter q3=new Nonvoter("����",3,Department.d,Position.fbz);
			Nonvoter q4=new Nonvoter("��Ӣ��",4,Department.d,Position.gzry);
			Nonvoter q5=new Nonvoter("������",5,Department.d,Position.gzry);
			Nonvoter q6=new Nonvoter("���ı�",6,Department.d,Position.gzry);
			Nonvoter q7=new Nonvoter("������",7,Department.d,Position.gzry);
			Nonvoter q8=new Nonvoter("֣���",8,Department.d,Position.gzry);
			Nonvoter q9=new Nonvoter("�����",9,Department.d,Position.gzry);
//			5-������
			Nonvoter r1=new Nonvoter("�ʽ���",1,Department.e,Position.bz);
			Nonvoter r2=new Nonvoter("��ǧ��",2,Department.e,Position.fbz);
			Nonvoter r3=new Nonvoter("ؿ����",3,Department.e,Position.fbz);
			Nonvoter r4=new Nonvoter("������",4,Department.e,Position.gzry);
			Nonvoter r5=new Nonvoter("���ɽ",5,Department.e,Position.gzry);
			Nonvoter r6=new Nonvoter("������",6,Department.e,Position.gzry);
			Nonvoter r7=new Nonvoter("������",7,Department.e,Position.gzry);
			Nonvoter r8=new Nonvoter("������",8,Department.e,Position.gzry);
			Nonvoter r9=new Nonvoter("���粨",9,Department.e,Position.gzry);
//			6-������		
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
			nonvoter1.add(n1);
			nonvoter1.add(n2);
			nonvoter1.add(n3);
			nonvoter1.add(n4);
			nonvoter1.add(n5);
			nonvoter1.add(n6);
			nonvoter1.add(n7);
			nonvoter1.add(n8);
			nonvoter1.add(n9);
			
			nonvoter1.add(m1);
			nonvoter1.add(m2);
			nonvoter1.add(m3);
			nonvoter1.add(m4);
			nonvoter1.add(m5);
			nonvoter1.add(m6);
			nonvoter1.add(m7);
			nonvoter1.add(m8);
			nonvoter1.add(m9);
			
			nonvoter1.add(o1);
			nonvoter1.add(o2);
			nonvoter1.add(o3);
			nonvoter1.add(o4);
			nonvoter1.add(o5);
			nonvoter1.add(o6);
			nonvoter1.add(o7);
			nonvoter1.add(o8);
			nonvoter1.add(o9);
		
			nonvoter1.add(q1);
			nonvoter1.add(q2);
			nonvoter1.add(q3);
			nonvoter1.add(q4);
			nonvoter1.add(q5);
			nonvoter1.add(q6);
			nonvoter1.add(q7);
			nonvoter1.add(q8);
			nonvoter1.add(q9);
			
			nonvoter1.add(r1);
			nonvoter1.add(r2);
			nonvoter1.add(r3);
			nonvoter1.add(r4);
			nonvoter1.add(r5);
			nonvoter1.add(r6);
			nonvoter1.add(r7);
			nonvoter1.add(r8);
			nonvoter1.add(r9);
			
			nonvoter1.add(t1);
			nonvoter1.add(t2);
			nonvoter1.add(t3);
			nonvoter1.add(t4);
			nonvoter1.add(t5);
			nonvoter1.add(t6);
			nonvoter1.add(t7);
			nonvoter1.add(t8);
			nonvoter1.add(t9);
			
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
			
			case 1: if(!voters1.contains(n1)) {  //Ͷ��Ʊ�Ѿ��浽�˶���鿴һ�µ�һ������ڶ������ò�����Ͷ��
						Voting.startVote(Department.a); }
					else {
						System.out.println(Department.a.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�"); 
						}  //Ͷ������������Ż���ʾǰһ��Ͷ�Ĳ���
					break;
			//�����޹ܲ�ͶƱ
			case 2: if(!voters1.contains(m1)) {
						Voting.startVote(Department.b); }
					else {
						System.out.println(Department.b.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
						}
					break;
			//�����ڹ���ͶƱ		
			case 3: if(!voters1.contains(o1)) {
					Voting.startVote(Department.c); }
			else {
				System.out.println(Department.c.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
				}
			break;		
			//������ίͶƱ
			case 4:if(!voters1.contains(q1)) {
				Voting.startVote(Department.d); }
			else {
				System.out.println(Department.d.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
				}
			break;		
			//����������ͶƱ
			case 5:if(!voters1.contains(r1)) {
					Voting.startVote(Department.f); }
					else {
						System.out.println(Department.e.getDepartname()+"��ͶƱ������ѡ���������Ż��˳�");
						}
					break;	
			//����������ͶƱ
			case 6:if(!voters1.contains(t1)) {
					Voting.startVote(Department.f); }
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
			in.close();
	}

}
