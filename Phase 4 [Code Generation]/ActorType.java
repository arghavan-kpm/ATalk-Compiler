import java.util.*;

public class ActorType extends SymbolTableItem {
	String actorName;
	public ArrayList Recv;
	public int MaxMesg;
	public int BufSize;
	public ActorType(String name, ArrayList arg, int Maxmesg,int bufSize){
		this.actorName = name;
		this.Recv = new ArrayList(arg);
		this.MaxMesg = Maxmesg;
		this.BufSize = bufSize;
	}
	
	public String getKey(){
		return actorName;
	}
}