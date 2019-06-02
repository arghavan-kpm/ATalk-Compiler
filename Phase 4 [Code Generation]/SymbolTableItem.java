public abstract class SymbolTableItem {

	private static int definitionsCount = 0;

	public SymbolTableItem() {
		this.definitionNumber = definitionsCount;
		if(useMustBeComesAfterDef())
			++definitionsCount;
	}

	public int getDefinitionNumber() {
		return definitionNumber;
	}

	public void setDifinitionNumber(int defNum) {
		definitionNumber = defNum;
	}

	public boolean useMustBeComesAfterDef() {
		return false;
	}

	public abstract String getKey();

	int definitionNumber;

}