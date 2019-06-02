public class SymbolTableActorVariableItem extends SymbolTableVariableItemBase {
	
	public SymbolTableActorVariableItem(Variable variable, int offset) {
		super(variable, offset);
	}

	@Override
	public Register getBaseRegister() {
		return Register.GP;
	}
}