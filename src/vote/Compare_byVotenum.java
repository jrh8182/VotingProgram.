package vote;

import java.util.Comparator;
////������ͶƱ������ıȽ���ʵ��Comparator�ӿ�
public class Compare_byVotenum  implements Comparator<Invoter>{

	@Override
	//����Ʊ����������Ʊ����ͬ�����ǳɼ������ɼ���ͬӦ��Ͷ��
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


