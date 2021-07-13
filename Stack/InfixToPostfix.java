import java.util.ArrayDeque;

/**
 * InfixToPostfix
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(str));
    }

    static int Prec(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

	public static String infixToPostfix(String exp) 
	{
		String res = "";
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for(char ch: exp.toCharArray()){
		    if(Character.isLetterOrDigit(ch)){
		        res += ch;
		    }
		    else if(ch=='('){
		        stack.push(ch);
		    }
		    else if(ch==')'){
		        while(!stack.isEmpty() && stack.peek()!='('){
		            res += stack.pop();
		        }
		        stack.pop();
		    }
		    else{
		        while(!stack.isEmpty() && Prec(ch)<=Prec(stack.peek())){
		            res += stack.pop();
		        }
		        stack.push(ch);
		    }
		}
		while(!stack.isEmpty()){
            if(stack.peek()=='('){
                return "Invalid string";
            }
		    res += stack.pop();
		}
		return res;
	}
}