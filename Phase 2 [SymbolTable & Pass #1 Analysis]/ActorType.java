public class ActorType extends SymbolTableItem {
	String actorName;

	public ActorType(String name){
		this.actorName = name;
	}
	
	public String getKey(){
		return actorName;
	}
}