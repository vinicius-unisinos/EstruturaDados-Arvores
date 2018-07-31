package GeneralTree;

public class GeneralTree {
    private Object key;
    private int degree;
    private List list; 

    public Object getKey ()
	{ return key; }
	
	public GeneralTree (Object key) {
		this.key = key; 
		degree = 0;
		list = new List ();
    }

    public GeneralTree getSubtree (int i) {
		if (i < 0 || i >= degree)
		    throw new IndexOutOfBoundsException ();
		Node ptr = list.getFirst ();
		for (int j = 0; j < i; ++j)
		    ptr = ptr.getNext();
		return (GeneralTree) ptr.getData ();
    }

    public void attachSubtree (GeneralTree t) {
		list.insertAtBack (t);
		++degree;
    }

    public GeneralTree detachSubtree (GeneralTree t) throws UnderflowException {
		list.remove (t);
		--degree;
		return t;
    }
    
    public List getList() {
    	return list;
    }
}
