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
	//直接用静态变量存储
	public static ArrayList <Invoter> invoter =new ArrayList<>();  //参选人实例化载入arraylist
	public static Set<Nonvoter> voters = new HashSet<Nonvoter>();  //存放已透过票的
	public static ArrayList <Nonvoter> nonvoter =new ArrayList<>();    //投票者实例化载入arraylist
	
	//修改参选者的综测成绩，按-1退出
	public static void ismodify(Department depar,Position poi){
		int num=0,isChanged=0;  //标记一下，未修改过则不需输出新的名单
		System.out.println("是否需要参选者修改信息,若需要请输入编号：(输入-1则跳过修改)");
		 try {num=in.nextInt();}
		 catch (InputMismatchException e) {
			 System.out.println("请输入整型数字！");
//			 若此时输入错误，num的值为0,会进入下列循环
			 in.next();
		 }
		while(num!=-1){
			int flag=1; //标签是否找到此人并修改成功，输入成绩失败也算失败
			for(Invoter i : invoter) {	
			  if((i.uid==num)&&(i.getWantDepar()==depar)&&(i.getWantpoi()==poi)) {
				  isChanged=1;
				  flag=0; //修改成功flag为0；
				  System.out.println(i.getName()+"的综测成绩修改：");
				  try{i.grade=ingrade.nextDouble();}
				  catch(InputMismatchException e){
					  System.out.println("请输入小数");
					  flag=1;
					  ingrade.next();
					  break;  //成绩应为小数，输错就重新输出，故break；
				  }
				  if(flag==0) {
				  System.out.println(i.getName()+"的综测成绩已修改成功！"+"修改为："+i.grade);
				  }

				  System.out.println("是否需要参选者修改信息,若需要请输入编号：(输入-1则跳过修改)");
				  try {num=in.nextInt();}
					 catch (InputMismatchException e) {
						 System.out.println("请输入整型数字！");
						 in.next();
					 }
			  }
			  }
			   if(flag==1) {
				  System.out.println("输入方式错误或查无此人，请重新输入或退出修改：（请再次输入编号）");

				 try {num=in.nextInt();}
				 catch (InputMismatchException e) {
					 System.out.println("请输入整型数字！");
					 in.next(); //再次输入要选的编号，保留给下次赋值，但若再次输错还是会进行上一次对象的修改。
				 }
				 

			}
		}
		
		if(isChanged==1) {
		System.out.println("修改后：");
		checkList(depar,poi);}
		else if(isChanged==0) {
			System.out.println("既然无需修改那我们开始投票吧！");
		}
		
	}
	
	//此处应添加throw语句，，若是输入非整型字符的情况
	public static void voterFor(Department depar,int answer,Position poi){
		 int flag=0;  //标志是否在ArrayList中存在这个对象
		for(Invoter i : invoter) {
		  
		  if((i.uid==answer)&&(i.getWantDepar()==depar)&&(i.getWantpoi()==poi)) {
			  flag=1;
			  i.voteIncrease(); //有效得票数+1
			  System.out.println("你投给了"+answer+"号"+i.name+" 感谢你的投票！");
			  break; //终止
		  }
		 
	  } 
		if(flag==0) {
		System.out.println("该票未投给正确的参选者，视为弃权!"); //没找到就说明弃权，废票。
		}
	}
	
	//查看要选举部门的参选者的总名单
	public static void checkList(Department depar,Position pos) {
		System.out.println("***********************************************************************");
		System.out.println(depar.getDepartname()+"的职能是"+depar.getFunction());
		System.out.println("查看"+depar.getDepartname()+"的竞选名单:");
		for(Invoter i : invoter) {
			if(i.getWantDepar()==depar&&i.getWantpoi()==pos)
			System.out.println(i.toString());
		}
	}
	
	public static void startVote(Department depar) //选择此次要进行投票的部门。此方法内容可再精简，把单次投票过程封装成一个函数。
	{                                                                      
//		checkList(depar); //查看名单
		
	    Position now = Position.bz;   //设定此时投票对象为部长	    
	    checkList(depar,now); //查看此时要投票的名单  选部长
		ismodify(depar,now);  //是否要修改综测成绩 ，并印出修改后
		
		for(Nonvoter j: nonvoter) {
			if(j.getDepar()==depar&&!voters.contains(j)) {
						
				if(j.getVotenum()>0) {
					System.out.print("现在轮到"+j.getName()+"同学，请您投票"+"填写你心目中部长人选的编号  ");
					while(j.getVotenum()>0) {
						System.out.println("（您现有"+j.getVotenum()+"票可投）");
						try{voterFor(depar,in.nextInt(),now);}
						catch (InputMismatchException e) {  
							System.out.println("输入的值形式不正确 要为整数且对应上述编号！请重投！"); 
							//只是简单的捕获这种错误，会导致scanner里的值输不出去，后续一直都是错的。
							in.next();//在接收一次值可需要的Int 
							j.setVotenum(j.getVotenum() + 1); //抵消掉输入错误的票数
						}
						j.setVotenum(j.getVotenum() - 1);
						if(j.getVotenum()==0)
						{
							  System.out.println("**************你的票数已用完,谢谢参与！********************\n");
						}
					}
				}
							
//				voters.add(j);   还要投第二次,先不添加。
			}
		}
		System.out.println("-----------------------部长投票已结束，现在开始进行副部长选举投票--------------------------");
		
		now = Position.fbz; //设定此时投票对象为部长
	    checkList(depar,now); //查看此时要投票的名单  选副部长
		ismodify(depar,now); 
		for(Nonvoter j: nonvoter) {
			if(j.getPoi()==Position.bz) {
				j.setVotenum(2);
			}
			else if(j.getPoi()==Position.fbz||j.getPoi()==Position.gzry) {
				j.setVotenum(1);  //恢复票数
			}
			if(j.getDepar()==depar&&!voters.contains(j)) {
//				第一次投完部长，选名的票数已经清零现在要恢复相应的票数。
				if(j.getVotenum()>0) {
					System.out.print("现在轮到"+j.getName()+"同学，请您投票"+"填写你心目中副部长人选的编号  ");
					while(j.getVotenum()>0) {
						System.out.println("（您现有"+j.getVotenum()+"票可投）");
						try{voterFor(depar,in.nextInt(),now);}
						catch (InputMismatchException e) {  
							System.out.println("输入的值形式不正确 要为整数且对应上述编号！请重投！"); 
							in.next();//在接收一次值可需要的Int,再一次循环赋给try中的方法
							j.setVotenum(j.getVotenum() + 1); //抵消掉输入错误的票数
						}
						j.setVotenum(j.getVotenum() - 1); //投完一票，无论投票成功还是作废，票数都要减一
						if(j.getVotenum()==0)
						{
							  System.out.println("**************你的票数已用完,谢谢参与！********************\n");
						}
					}
				}
			
				
				voters.add(j);  //完成本部门投票，放入堆
			}
		}	
		
		//查询单个选民得票数
		System.out.println("     输入要查询的选民名字："+       "无需查询输入'n'跳过");
		searchVote(in.next(),depar);   
		
		//打印得票情况，公布获选者
		viewGetvote(depar);
	
//		System.out.println(voters.isEmpty());
		}


//	!!!!!!修改viewGetvote方法，加入职务参数，添加比较得票数的方法。公布最后人选！！！！
	public static void viewGetvote(Department depar) {
	   ArrayList <Invoter> bznow=new ArrayList<>();  //临时存放参选部长的人
	   ArrayList <Invoter> fbznow=new ArrayList<>(); 
		for(Invoter i : invoter) {
			if(i.getWantDepar()==depar&&i.getWantpoi()==Position.bz) {
				bznow.add(i);
			}
			if(i.getWantDepar()==depar&&i.getWantpoi()==Position.fbz) {
				fbznow.add(i);
			}	
		}
//		将该部门该职务的参选者按得票数降序排列，每个容器第一对象便是获选者
		Collections.sort(bznow,new Compare_byVotenum());       //该接口在Compare_byVotenum类实现
		Collections.sort(fbznow,new Compare_byVotenum()); 
		
		String a1=bznow.get(0).name;  //存储部长最后人选的名字
		String a2=fbznow.get(0).name; //存储副部长最后人选的名字
		
		System.out.println("—————————————————————现公布部长竞选者得票情况—————————————————————");
		for(Invoter i:bznow) {
			System.out.println(i.printResult());
		}
		System.out.println("获选者是：   "+a1);
		System.out.println("—————————————————————————————————————————————————————————————————");
		
		System.out.println("—————————————————————现公布副部长竞选者得票情况—————————————————————");
		for(Invoter i:fbznow) {
			System.out.println(i.printResult());
		}
		System.out.println("获选者是：   "+a2);
		System.out.println("—————————————————————————————————————————————————————————————————");
	}
	
	//用来查询某个选民的得票情况
	public static void searchVote(String name,Department depar) {	
		int flag=0; //是否找到

		for(Invoter i : invoter) {
			if(i.getWantDepar()==depar&&i.getName().equals(name)) {
				System.out.println(i.getName()+" 竞选："+i.getWantpoi().getPostname()+" 获得票数："+i.getVote()+'\n');
				flag=1;
				break;
			}
		}
		if(flag==0&&!name.equals("n")) {
			System.out.println("查无此人,请再输入一次");
			searchVote(in.next(), depar); //再调用自身一次，递归直至查询到
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//实例化  参选选民
//		心理部
		Invoter a1= new Invoter("陈小泉",1,95.5,Department.a,Position.bz,"选我选我快选我！！！！");
		Invoter a2= new Invoter("冉浩岚",2,85.5,Department.a,Position.bz,"年轻就是资本，自信源于实力");
		Invoter a3= new Invoter("公孙策",3,75.8,Department.a,Position.bz,"帅哥美女们投我");
		Invoter a4= new Invoter("周瑜",4,49.5,Department.a,Position.fbz,"勇敢的迈出第一步，相信自己");
		Invoter a5= new Invoter("关羽",5,90,Department.a,Position.fbz,"燃烧青春激情，挑战自我巅峰。");
		Invoter a6= new Invoter("诸葛亮",6,88,Department.a,Position.fbz,"给我一个机会，还您一个奇迹。");
//		宿管部
		Invoter b1= new Invoter("陆孤丹",1,76,Department.b,Position.bz,"我只想为大家服务！请投我一票！");
		Invoter b2= new Invoter("石寒香",2,76.5,Department.b,Position.bz,"相信我，支持我，我是无敌候选者。");
		Invoter b3= new Invoter("暨妙芙",3,77,Department.b,Position.fbz,"任期有限，责任无限");
		Invoter b4= new Invoter("宋平宁",4,98,Department.b,Position.fbz,"别人会给你一万个承诺，我会给你一万个行动！");
		Invoter b5= new Invoter("关宏峻",5,56,Department.b,Position.fbz,"不求最好，只求更好！");
//		勤工部
		Invoter c1= new Invoter("卢文斌",1,78,Department.c,Position.bz,"我将想你们所想，急你们所急，做你们忠实的代表");
		Invoter c2= new Invoter("徐天纵",2,88,Department.c,Position.bz,"选择我 不会错。");
		Invoter c3= new Invoter("刘锐进",3,99,Department.c,Position.fbz,"不做最范儿，就做友善。");
		Invoter c4= new Invoter("红浩气",4,72.5,Department.c,Position.fbz,"给我一个舞台，还你一个精彩！");
		Invoter c5= new Invoter("乌光明",5,64,Department.c,Position.fbz,"给我一次机会还你一个惊喜。");
//		团委	
		Invoter d1= new Invoter("相乐安",1,73,Department.d,Position.bz,"人才时代百舸争流，模拟竞聘伯乐迭驰。");
		Invoter d2= new Invoter("甘鸿羽",2,71,Department.d,Position.bz,"我有能力选我有奇迹。");
		Invoter d3= new Invoter("杜飞驰",3,84,Department.d,Position.fbz,"先淡后浓，先疏后亲，先远后近，交朋友之道也。");
		Invoter d4= new Invoter("谭永元",4,49,Department.d,Position.fbz,"不懂得自爱的人，是没有能力去爱别人的。");
		Invoter d5= new Invoter("朱明珠",5,85,Department.d,Position.fbz,"与人交，推其长者，讳其短者，故能久也");
//		体育部	
		Invoter e1= new Invoter("白文宣",1,79.5,Department.e,Position.bz,"要把同道的人当作朋友，而不必把同利的人当作朋友。");
		Invoter e2= new Invoter("罗飞尘",2,94,Department.e,Position.bz,"凡才智之士，必得忠直之人从劳制之。");
		Invoter e3= new Invoter("姚子墨",3,82,Department.e,Position.fbz,"让我们做的更好！请大家支持我吧！投我一票，谢谢。");
		Invoter e4= new Invoter("汪彭越",4,83,Department.e,Position.fbz,"低调是我的性格，努力是我的承诺。");
		Invoter e5= new Invoter("冉飞鸾",5,84.5,Department.e,Position.fbz,"你的选择不会错，我的承诺不会空");
//		外联部
		Invoter f1= new Invoter("钟向荣",1,85.5,Department.f,Position.bz,"是金子就要闪光");
		Invoter f2= new Invoter("蒋高杰",2,86.5,Department.f,Position.bz,"岁不寒无以知松柏，事不难无以知君子。");
		Invoter f3= new Invoter("陈乐正",3,18,Department.f,Position.fbz,"同类相从，同声相应，固天理也。");
		Invoter f4= new Invoter("桂兴德",4,22,Department.f,Position.fbz,"须知胜友真良约，莫作寻常旅聚看。");
		Invoter f5= new Invoter("范鸿才",5,94,Department.f,Position.fbz,"近来者赤，近墨者黑。");
		//参选选民 加入ArrayList
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
		

		//非参选选民实例化 
//		1-心理部
		Nonvoter n1=new Nonvoter("贺英卫",1,Department.a,Position.bz);
		Nonvoter n2=new Nonvoter("宋宜人",2,Department.a,Position.fbz);
		Nonvoter n3=new Nonvoter("国星洲",3,Department.a,Position.fbz);
		Nonvoter n4=new Nonvoter("段英博",4,Department.a,Position.gzry);
		Nonvoter n5=new Nonvoter("孟元甲",5,Department.a,Position.gzry);
		Nonvoter n6=new Nonvoter("于鹏云",6,Department.a,Position.gzry);
		Nonvoter n7=new Nonvoter("祖英华",7,Department.a,Position.gzry);
		Nonvoter n8=new Nonvoter("黎高阳",8,Department.a,Position.fbz);
		Nonvoter n9=new Nonvoter("容雅洁",9,Department.a,Position.gzry);
//		 2-宿管部
		Nonvoter m1=new Nonvoter("邴雅素",1,Department.b,Position.bz);
		Nonvoter m2=new Nonvoter("贡娅庭",2,Department.b,Position.fbz);
		Nonvoter m3=new Nonvoter("空韶丽",3,Department.b,Position.fbz);
		Nonvoter m4=new Nonvoter("汤运虹",4,Department.b,Position.gzry);
		Nonvoter m5=new Nonvoter("许芷蝶",5,Department.b,Position.gzry);
		Nonvoter m6=new Nonvoter("梁山芙",6,Department.b,Position.gzry);
		Nonvoter m7=new Nonvoter("石觅风",7,Department.b,Position.gzry);
		Nonvoter m8=new Nonvoter("韩岚风",8,Department.b,Position.gzry);
		Nonvoter m9=new Nonvoter("宁悦媛",9,Department.b,Position.gzry);
//		3-勤工部
		Nonvoter o1=new Nonvoter("许经武",1,Department.c,Position.bz);
		Nonvoter o2=new Nonvoter("卓兴生",2,Department.c,Position.fbz);
		Nonvoter o3=new Nonvoter("宫嘉言",3,Department.c,Position.fbz);
		Nonvoter o4=new Nonvoter("宫嘉言",4,Department.c,Position.gzry);
		Nonvoter o5=new Nonvoter("罗安翔",5,Department.c,Position.gzry);
		Nonvoter o6=new Nonvoter("陈嘉祥",6,Department.c,Position.gzry);
		Nonvoter o7=new Nonvoter("乜明煦",7,Department.c,Position.gzry);
		Nonvoter o8=new Nonvoter("辛修明",8,Department.c,Position.gzry);
		Nonvoter o9=new Nonvoter("薛和璧",9,Department.c,Position.gzry);
//		4-团委
		Nonvoter q1=new Nonvoter("冷锐利",1,Department.d,Position.bz);
		Nonvoter q2=new Nonvoter("焦文光",2,Department.d,Position.fbz);
		Nonvoter q3=new Nonvoter("弓昊穹",3,Department.d,Position.fbz);
		Nonvoter q4=new Nonvoter("燕英毅",4,Department.d,Position.gzry);
		Nonvoter q5=new Nonvoter("贾敏智",5,Department.d,Position.gzry);
		Nonvoter q6=new Nonvoter("车文彬",6,Department.d,Position.gzry);
		Nonvoter q7=new Nonvoter("弓俊名",7,Department.d,Position.gzry);
		Nonvoter q8=new Nonvoter("郑温瑜",8,Department.d,Position.gzry);
		Nonvoter q9=new Nonvoter("常浩宕",9,Department.d,Position.gzry);
//		5-体育部
		Nonvoter r1=new Nonvoter("甘金鑫",1,Department.e,Position.bz);
		Nonvoter r2=new Nonvoter("訾千凝",2,Department.e,Position.fbz);
		Nonvoter r3=new Nonvoter("乜甘泽",3,Department.e,Position.fbz);
		Nonvoter r4=new Nonvoter("蒋贝晨",4,Department.e,Position.gzry);
		Nonvoter r5=new Nonvoter("鱼谷山",5,Department.e,Position.gzry);
		Nonvoter r6=new Nonvoter("党凌珍",6,Department.e,Position.gzry);
		Nonvoter r7=new Nonvoter("白云琼",7,Department.e,Position.gzry);
		Nonvoter r8=new Nonvoter("景金玉",8,Department.e,Position.gzry);
		Nonvoter r9=new Nonvoter("公晴波",9,Department.e,Position.gzry);
//		6-外联部		
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

		//开始进行投票
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
		
		case 1: if(!voters.contains(n1)) {  //投完票已经存到了堆里，查看一下第一个元素如果在堆里。代表该部门已投过
					startVote(Department.a); }
				else {
					System.out.println(Department.a.getDepartname()+"已投票过，请选择其他部门或退出"); 
					}  //投过或输入错误编号会显示前一个投的部门
				break;
		//进行宿管部投票
		case 2: if(!voters.contains(m1)) {
					startVote(Department.b); }
				else {
					System.out.println(Department.b.getDepartname()+"已投票过，请选择其他部门或退出");
					}
				break;
		//进行勤工部投票		
		case 3: if(!voters.contains(o1)) {
			startVote(Department.c); }
		else {
			System.out.println(Department.c.getDepartname()+"已投票过，请选择其他部门或退出");
			}
		break;		
		//进行团委投票
		case 4:if(!voters.contains(q1)) {
			startVote(Department.d); }
		else {
			System.out.println(Department.d.getDepartname()+"已投票过，请选择其他部门或退出");
			}
		break;		
		//进行体育部投票
		case 5:if(!voters.contains(r1)) {
					startVote(Department.f); }
				else {
					System.out.println(Department.e.getDepartname()+"已投票过，请选择其他部门或退出");
					}
				break;	
		//进行外联部投票
		case 6:if(!voters.contains(t1)) {
			startVote(Department.f); }
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
		
		
		
		
	}

}
