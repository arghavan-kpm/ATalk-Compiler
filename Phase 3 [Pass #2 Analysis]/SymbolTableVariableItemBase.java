public abstract class SymbolTableVariableItemBase extends SymbolTableItem {
	
	public SymbolTableVariableItemBase(Variable variable, int offset) {
		this.variable = variable;
		this.offset = offset;
	}

	public int getSize() {
		return variable.size();
	}

	public int getOffset() {
		return offset;
	}

	public Variable getVariable() {
		return variable;
	}

	@Override
	public String getKey() {
		return variable.getName();
	}

	public abstract Register getBaseRegister();

	int offset;
	Variable variable;
}