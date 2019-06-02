import java.util.*;

public class ActorType extends SymbolTableItem {
	String actorName;
	public ArrayList Recv;

	public ActorType(String name, ArrayList arg){
		this.actorName = name;
		this.Recv = new ArrayList(arg);
	}
	
	public String getKey(){
		return actorName;
	}
}