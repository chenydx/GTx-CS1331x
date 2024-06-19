public class HW01_2 {
	public static void main(String[] args){
		String MyName = "Diming Chen";
		System.out.println("My name: "+MyName);
		System.out.println("1st Letter: "+ MyName);
		String MyNewName = "A"+MyName.substring(1,MyName.length()-1)+"Z";
		System.out.println("My new name after replacement: "+ MyNewName);
		System.out.println();
		
		String aURL = "www.baidu.com";
		System.out.println("My URL: "+ aURL);
		String aNewURL = aURL.substring(aURL.indexOf('.')+1,aURL.indexOf('.',aURL.indexOf('.')+1))+"1331";
		
		System.out.println("My new URL: "+aNewURL);
		System.out.println("Done..");
	}
}