package clases;

public class Converter {
	private static char[] chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrtsuvwxyz".toCharArray();
	
	public static boolean checkNum(String nbase,int base) {
		char[] nbaseArray=nbase.toCharArray();
		for(int i=0;i<nbaseArray.length;i++) 
			if(Converter.searchChar(nbaseArray[i])>=base || Converter.searchChar(nbaseArray[i])==-1)
				return false;
		return true;
	}
	
	private static int searchChar(char c) {
		for(int i=0;i<62;i++)
			if(chars[i]==c)
				return i;
		return -1;
	}
	
	
	private static long nbaseToDecimal(String nbase,int base) {
		char[] nbaseArray=nbase.toCharArray();
		long n=0;
		for(int i=0;i<nbaseArray.length;i++) 
			n+=Converter.searchChar(nbaseArray[i])*Math.pow(base,nbaseArray.length-1-i);
		return n;
	}
	
	
	private static String decimalToNBase(long dec,int base) {
		long r;
		String s="";
		while(dec>0) {
			r=dec%base;
			s=Character.toString(chars[(int) r])+s;
			dec=dec/base;
		}
		return s;
	}
	
	
	public static String nBaseToMBase(String num,int nbase,int mbase) {
		return Converter.decimalToNBase(Converter.nbaseToDecimal(num, nbase), mbase);
	}
	
	
}
