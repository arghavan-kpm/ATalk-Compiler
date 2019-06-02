import java.util.*;

public class ArrType extends Type {
	
	public int size() {
		int h = base.size();
		for(int i=0;i < dimension.size();i++){
			h *= Integer.parseInt( dimension.get(i).toString() );
		}	
		return h;
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof ArrType)
			return true;
		return false;
	}

	@Override
	public String toString() {
		String s = "";
		for(int i=0;i < dimension.size();i++)
			s += "arr(" + dimension.get(i).toString() + ",";
		s += base.toString();
		for(int i=0;i < dimension.size();i++)
			s += ")";
		return s;
	}

	public ArrayList dimension;
	public Type base;

	private static ArrType instance;

	public ArrType() {
		
	}

	public ArrType(Type baseType,ArrayList dim){
		dimension = dim;
		base = baseType;
	}

	public static ArrType getInstance(Type baseType,ArrayList dim) {
		if(instance == null)
			return instance = new ArrType(baseType,dim);
		return instance;
	}
}