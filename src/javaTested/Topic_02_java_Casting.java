package javaTested;

public class Topic_02_java_Casting {

	public static void main(String[] args) {
		//*Widening
		//Transfer data from smaller to bigger
//		byte bnum = 126;
//		System.out.println(bnum);
//		
//		short snum = bnum;
//		System.out.println(snum);
//		
//		int inum = snum;
//		System.out.println(inum);
//		
//		long lnum = inum;
//		System.out.println(lnum);
//		
//		float fnum = lnum;
//		System.out.println(fnum);
//		
//		double dnum = fnum;
//		System.out.println(dnum);
		
		//*Narrowwing
		//Transfer data from bigger to smaller
		double dnum = 128999018;
		System.out.println(dnum);
		
		float fnum = (float) dnum;
		System.out.println(fnum);
		
		long lnum = (long) fnum;
		System.out.println(lnum);
	}

}
