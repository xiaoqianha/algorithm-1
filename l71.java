package L71;

import java.util.Scanner;
import java.util.Stack;

public class l71 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr=new Scanner(System.in);
		String s;
		s=sr.nextLine();
		System.out.println(simplifyPath(s));
		sr.close();
	}
        public static String simplifyPath(String path) {
	    	String[] s=path.split("/");
	        Stack<String> stack=new Stack<>();
	        for(int i=0;i<s.length;i++) {
	        	if(!stack.empty()&&s[i].equals("..")) {//如果有上级，就把不合题意的从栈中去出来
	        		stack.pop();
	        	}
	        	else if(!s[i].equals("")&&!s[i].equals(".")&&!s[i].equals("..")) {//不然就看是不是绝对路径
	        		stack.push(s[i]);
	        	}
	        }
			if(stack.isEmpty())return "/";
			String result="";//用字符串来接
			for(int i=0;i<stack.size();i++) 
				result+="/"+stack.get(i);//因为栈里也有像数组一样的结构
			return result;
}
}
