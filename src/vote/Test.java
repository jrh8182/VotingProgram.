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
		 Set<Nonvoter> voters1 = Voting.voters;        //引用Voting中的静态变量
		 Scanner in = new Scanner (System.in);
			//实例化  参选选民
//			心理部
			Invoter a1= new Invoter("陈小泉",1,95.5,Department.a,Position.bz,"选我选我快选我！！！！");
			Invoter a2= new Invoter("冉浩岚",2,85.5,Department.a,Position.bz,"年轻就是资本，自信源于实力");
			Invoter a3= new Invoter("公孙策",3,75.8,Department.a,Position.bz,"帅哥美女们投我");
			Invoter a4= new Invoter("周瑜",4,49.5,Department.a,Position.fbz,"勇敢的迈出第一步，相信自己");
			Invoter a5= new Invoter("关羽",5,90,Department.a,Position.fbz,"燃烧青春激情，挑战自我巅峰。");
			Invoter a6= new Invoter("诸葛亮",6,88,Department.a,Position.fbz,"给我一个机会，还您一个奇迹。");
//			宿管部
			Invoter b1= new Invoter("陆孤丹",1,76,Department.b,Position.bz,"我只想为大家服务！请投我一票！");
			Invoter b2= new Invoter("石寒香",2,76.5,Department.b,Position.bz,"相信我，支持我，我是无敌候选者。");
			Invoter b3= new Invoter("暨妙芙",3,77,Department.b,Position.fbz,"任期有限，责任无限");
			Invoter b4= new Invoter("宋平宁",4,98,Department.b,Position.fbz,"别人会给你一万个承诺，我会给你一万个行动！");
			Invoter b5= new Invoter("关宏峻",5,56,Department.b,Position.fbz,"不求最好，只求更好！");
//			勤工部
			Invoter c1= new Invoter("卢文斌",1,78,Department.c,Position.bz,"我将想你们所想，急你们所急，做你们忠实的代表");
			Invoter c2= new Invoter("徐天纵",2,88,Department.c,Position.bz,"选择我 不会错。");
			Invoter c3= new Invoter("刘锐进",3,99,Department.c,Position.fbz,"不做最范儿，就做友善。");
			Invoter c4= new Invoter("红浩气",4,72.5,Department.c,Position.fbz,"给我一个舞台，还你一个精彩！");
			Invoter c5= new Invoter("乌光明",5,64,Department.c,Position.fbz,"给我一次机会还你一个惊喜。");
//			团委	
			Invoter d1= new Invoter("相乐安",1,73,Department.d,Position.bz,"人才时代百舸争流，模拟竞聘伯乐迭驰。");
			Invoter d2= new Invoter("甘鸿羽",2,71,Department.d,Position.bz,"我有能力选我有奇迹。");
			Invoter d3= new Invoter("杜飞驰",3,84,Department.d,Position.fbz,"先淡后浓，先疏后亲，先远后近，交朋友之道也。");
			Invoter d4= new Invoter("谭永元",4,49,Department.d,Position.fbz,"不懂得自爱的人，是没有能力去爱别人的。");
			Invoter d5= new Invoter("朱明珠",5,85,Department.d,Position.fbz,"与人交，推其长者，讳其短者，故能久也");
//			体育部	
			Invoter e1= new Invoter("白文宣",1,79.5,Department.e,Position.bz,"要把同道的人当作朋友，而不必把同利的人当作朋友。");
			Invoter e2= new Invoter("罗飞尘",2,94,Department.e,Position.bz,"凡才智之士，必得忠直之人从劳制之。");
			Invoter e3= new Invoter("姚子墨",3,82,Department.e,Position.fbz,"让我们做的更好！请大家支持我吧！投我一票，谢谢。");
			Invoter e4= new Invoter("汪彭越",4,83,Department.e,Position.fbz,"低调是我的性格，努力是我的承诺。");
			Invoter e5= new Invoter("冉飞鸾",5,84.5,Department.e,Position.fbz,"你的选择不会错，我的承诺不会空");
//			外联部
			Invoter f1= new Invoter("钟向荣",1,85.5,Department.f,Position.bz,"是金子就要闪光");
			Invoter f2= new Invoter("蒋高杰",2,86.5,Department.f,Position.bz,"岁不寒无以知松柏，事不难无以知君子。");
			Invoter f3= new Invoter("陈乐正",3,18,Department.f,Position.fbz,"同类相从，同声相应，固天理也。");
			Invoter f4= new Invoter("桂兴德",4,22,Department.f,Position.fbz,"须知胜友真良约，莫作寻常旅聚看。");
			Invoter f5= new Invoter("范鸿才",5,94,Department.f,Position.fbz,"近来者赤，近墨者黑。");
			//参选选民 加入ArrayList
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
			

			//非参选选民实例化 
//			1-心理部
			Nonvoter n1=new Nonvoter("贺英卫",1,Department.a,Position.bz);
			Nonvoter n2=new Nonvoter("宋宜人",2,Department.a,Position.fbz);
			Nonvoter n3=new Nonvoter("国星洲",3,Department.a,Position.fbz);
			Nonvoter n4=new Nonvoter("段英博",4,Department.a,Position.gzry);
			Nonvoter n5=new Nonvoter("孟元甲",5,Department.a,Position.gzry);
			Nonvoter n6=new Nonvoter("于鹏云",6,Department.a,Position.gzry);
			Nonvoter n7=new Nonvoter("祖英华",7,Department.a,Position.gzry);
			Nonvoter n8=new Nonvoter("黎高阳",8,Department.a,Position.fbz);
			Nonvoter n9=new Nonvoter("容雅洁",9,Department.a,Position.gzry);
//			 2-宿管部
			Nonvoter m1=new Nonvoter("邴雅素",1,Department.b,Position.bz);
			Nonvoter m2=new Nonvoter("贡娅庭",2,Department.b,Position.fbz);
			Nonvoter m3=new Nonvoter("空韶丽",3,Department.b,Position.fbz);
			Nonvoter m4=new Nonvoter("汤运虹",4,Department.b,Position.gzry);
			Nonvoter m5=new Nonvoter("许芷蝶",5,Department.b,Position.gzry);
			Nonvoter m6=new Nonvoter("梁山芙",6,Department.b,Position.gzry);
			Nonvoter m7=new Nonvoter("石觅风",7,Department.b,Position.gzry);
			Nonvoter m8=new Nonvoter("韩岚风",8,Department.b,Position.gzry);
			Nonvoter m9=new Nonvoter("宁悦媛",9,Department.b,Position.gzry);
//			3-勤工部
			Nonvoter o1=new Nonvoter("许经武",1,Department.c,Position.bz);
			Nonvoter o2=new Nonvoter("卓兴生",2,Department.c,Position.fbz);
			Nonvoter o3=new Nonvoter("宫嘉言",3,Department.c,Position.fbz);
			Nonvoter o4=new Nonvoter("宫嘉言",4,Department.c,Position.gzry);
			Nonvoter o5=new Nonvoter("罗安翔",5,Department.c,Position.gzry);
			Nonvoter o6=new Nonvoter("陈嘉祥",6,Department.c,Position.gzry);
			Nonvoter o7=new Nonvoter("乜明煦",7,Department.c,Position.gzry);
			Nonvoter o8=new Nonvoter("辛修明",8,Department.c,Position.gzry);
			Nonvoter o9=new Nonvoter("薛和璧",9,Department.c,Position.gzry);
//			4-团委
			Nonvoter q1=new Nonvoter("冷锐利",1,Department.d,Position.bz);
			Nonvoter q2=new Nonvoter("焦文光",2,Department.d,Position.fbz);
			Nonvoter q3=new Nonvoter("弓昊穹",3,Department.d,Position.fbz);
			Nonvoter q4=new Nonvoter("燕英毅",4,Department.d,Position.gzry);
			Nonvoter q5=new Nonvoter("贾敏智",5,Department.d,Position.gzry);
			Nonvoter q6=new Nonvoter("车文彬",6,Department.d,Position.gzry);
			Nonvoter q7=new Nonvoter("弓俊名",7,Department.d,Position.gzry);
			Nonvoter q8=new Nonvoter("郑温瑜",8,Department.d,Position.gzry);
			Nonvoter q9=new Nonvoter("常浩宕",9,Department.d,Position.gzry);
//			5-体育部
			Nonvoter r1=new Nonvoter("甘金鑫",1,Department.e,Position.bz);
			Nonvoter r2=new Nonvoter("訾千凝",2,Department.e,Position.fbz);
			Nonvoter r3=new Nonvoter("乜甘泽",3,Department.e,Position.fbz);
			Nonvoter r4=new Nonvoter("蒋贝晨",4,Department.e,Position.gzry);
			Nonvoter r5=new Nonvoter("鱼谷山",5,Department.e,Position.gzry);
			Nonvoter r6=new Nonvoter("党凌珍",6,Department.e,Position.gzry);
			Nonvoter r7=new Nonvoter("白云琼",7,Department.e,Position.gzry);
			Nonvoter r8=new Nonvoter("景金玉",8,Department.e,Position.gzry);
			Nonvoter r9=new Nonvoter("公晴波",9,Department.e,Position.gzry);
//			6-外联部		
			Nonvoter t1=new Nonvoter("钱采文",1,Department.f,Position.bz);
			Nonvoter t2=new Nonvoter("游冰香",2,Department.f,Position.fbz);
			Nonvoter t3=new Nonvoter("侯墨玉",3,Department.f,Position.fbz);
			Nonvoter t4=new Nonvoter("伊唱月",4,Department.f,Position.gzry);
			Nonvoter t5=new Nonvoter("富白莲",5,Department.f,Position.gzry);
			Nonvoter t6=new Nonvoter("加利囚",6,Department.f,Position.gzry);
			Nonvoter t7=new Nonvoter("豪相时",7,Department.f,Position.gzry);
			Nonvoter t8=new Nonvoter("笑斐舞",8,Department.f,Position.gzry);
			Nonvoter t9=new Nonvoter("劳费雾",9,Department.f,Position.gzry);

			//非参选选民 加入对应ArrayList
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
			
			System.out.println("————————————****你已进入投票程序！（若要退出输入-1）****—————————————");
			System.out.println("请输入要进行的投票编号（1~6）依次代表六个部门");	
			System.out.println("1-心理部  2-宿管部 3-勤工部 4-团委 5-体育部 6-外联部");
			int i=-1;
	        //初始值设为-1，若输错则直接退出系统！
			try{i=in.nextInt();}
			
			catch(InputMismatchException e) {
				System.out.println("error! 重启程序！请输入1-6对应相应部门");			
			}
			while(i!=-1){
			switch(i) {
			//进行心理部投票
			
			case 1: if(!voters1.contains(n1)) {  //投完票已经存到了堆里，查看一下第一个如果在堆里。代表该部门已投过
						Voting.startVote(Department.a); }
					else {
						System.out.println(Department.a.getDepartname()+"已投票过，请选择其他部门或退出"); 
						}  //投过或输入错误编号会显示前一个投的部门
					break;
			//进行宿管部投票
			case 2: if(!voters1.contains(m1)) {
						Voting.startVote(Department.b); }
					else {
						System.out.println(Department.b.getDepartname()+"已投票过，请选择其他部门或退出");
						}
					break;
			//进行勤工部投票		
			case 3: if(!voters1.contains(o1)) {
					Voting.startVote(Department.c); }
			else {
				System.out.println(Department.c.getDepartname()+"已投票过，请选择其他部门或退出");
				}
			break;		
			//进行团委投票
			case 4:if(!voters1.contains(q1)) {
				Voting.startVote(Department.d); }
			else {
				System.out.println(Department.d.getDepartname()+"已投票过，请选择其他部门或退出");
				}
			break;		
			//进行体育部投票
			case 5:if(!voters1.contains(r1)) {
					Voting.startVote(Department.f); }
					else {
						System.out.println(Department.e.getDepartname()+"已投票过，请选择其他部门或退出");
						}
					break;	
			//进行外联部投票
			case 6:if(!voters1.contains(t1)) {
					Voting.startVote(Department.f); }
			else {
				System.out.println(Department.f.getDepartname()+"已投票过，请选择其他部门或退出");
				}
			break;	
			}
			System.out.println("请输入下一组要进行投票的编号：\n  (温馨提示)1-心理部  2-宿管部 3-勤工部 4-团委 5-体育部 6-外联部");
			try{i=in.nextInt();}
			catch(InputMismatchException e) {
				System.out.println("error! 请输入1-6对应相应部门");
				in.next();  //存储数值到下一轮循环
			}
			}
			
			if(i==-1) {
				System.out.println("————————————****你已退出投票程序！谢谢配合！****—————————————");
			}
			in.close();
	}

}
