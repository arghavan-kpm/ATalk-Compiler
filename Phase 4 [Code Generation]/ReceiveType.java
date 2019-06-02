import java.util.*;

public class ReceiveType extends SymbolTableItem {
	String receiverName;
	ArrayList argument;
	public ReceiveType(String name,ArrayList args){
		this.receiverName = name;
		this.argument = args;
	}
	
	public String getKey(){
		String s = receiverName + "(";
		for(int i=0; i < argument.size();i++){
			if(i != 0)
				s += ",";
			s += argument.get(i).toString();
		}
		s += ")";
		return s;
	}
}