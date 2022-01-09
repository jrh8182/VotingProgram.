package vote;

import java.util.Comparator;
////创建按投票数排序的比较器实现Comparator接口
public class Compare_byVotenum  implements Comparator<Invoter>{

	@Override
	//按得票数排序，若得票数相同，考虑成绩。若成绩相同应重投，
	public int compare(Invoter a1, Invoter a2) {
		if(a1.getVote()<a2.getVote()) {
			return 1;
		}
		else if(a1.getVote()==a2.getVote()){
			if(a1.grade<a2.grade) {
				return 1;
			}
			else if(a1.grade>a2.grade) {
				return -1;
			}
			else {
				return 0;
			}
		}
		else {
			return -1;
		}
	}
	}


