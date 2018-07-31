package GeneralTree;

public class Test {

	public static void main(String[] args) {
		GeneralTree raiz = new GeneralTree("D");
		GeneralTree t2 = new GeneralTree("E");
		GeneralTree t3 = new GeneralTree("G");
		raiz.attachSubtree(t2);
		raiz.attachSubtree(t3);
		t2.attachSubtree(new GeneralTree("F"));
		t2.getSubtree(0).attachSubtree(new GeneralTree("A"));
		t2.getSubtree(0).attachSubtree(new GeneralTree("B"));
		t2.getSubtree(0).attachSubtree(new GeneralTree("N"));
		t2.getSubtree(0).attachSubtree(new GeneralTree("Y"));
		t3.attachSubtree(new GeneralTree("H"));
		t3.attachSubtree(new GeneralTree("J"));
		t3.attachSubtree(new GeneralTree("M"));
		t3.getSubtree(0).attachSubtree(new GeneralTree("I"));
		t3.getSubtree(1).attachSubtree(new GeneralTree("K"));
		t3.getSubtree(1).attachSubtree(new GeneralTree("L"));
		
		raiz.getList().print();
		
		}

}
 