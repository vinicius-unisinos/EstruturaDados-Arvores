package ArvoreBST;



public class BST {
    protected BSTNode root = null;
    private int count = 0;
    private int qtdNode = 0;

    public BST() {
        root = null;
    }

    /**
     * Elimina todos os nodos da arvore
     *
     */
    public void clear() {
        root = null;
    }

    public int height() { //vers√£o p√∫blica
        if (root == null) {
            return 0;
        } else {
            return height(root); //passa a raiz da √°rvore para a vers√£o protegida
        }
    }

    protected int height(BSTNode p) {
        if (p != null) { //se existir raiz
            int hleft = height(p.left); //pega a altura da sub√°rvore esquerda
            int hright = height(p.right); //retorna altura da sub√°rvore direita
            if (hleft < hright) {
                return hright + 1; //retorna a maior altura, somando 1 da raiz.
            } else {
                return hleft + 1;
            }
        } else {
            return 0;
        }
    }
    
    
    private void itSon(BSTNode p){
        if(p.left == null && p.right == null){
            count = count + 1;
        }
    }

    public int countLeafNodes(){
        return countLeafNodes(root); 
    }
    private int countLeafNodes(BSTNode p){
        if (p != null) {
            itSon(p);
            countLeafNodes(p.left);
            countLeafNodes(p.right);
        }
        return count;
    }

    public boolean isFull() {
    	int tn = (int) ((Math.pow(2, height())) - 1);
    	if (tn == countNodes()) {
			return true;
		}else {
			return false;
		}
    }
    
    
    private int contNodes(BSTNode p) {
    	if (p != null) {
			contNodes(p.left);
			contNodes(p.right);
			qtdNode++;
		}
    	
    	return qtdNode;
    }
    
    public int countNodes() {
    	qtdNode = 0;
    	return contNodes(root);
    	
    }
    
    public boolean isEmpty() {
        return root == null;
    }

    
    public BSTNode getRootNode() {
        return root;
    }

    
    public boolean insert(int el) {
        BSTNode p = root, prev = null;
        // caso o valor ja exista na arvore, nao inserir e retornar false
        if (search(el) != null) {
            return false;
        }
        // procurando um lugar para colocar o novo nodo
        while (p != null) {
            prev = p;
            if (el < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }

        }
        // se arvore vazia, nodo sendo inserido vira raiz da arvore
        if (root == null) {
            root = new BSTNode(el);
        } else if (prev.key < el) {
            prev.right = new BSTNode(el);
        } else {
            prev.left = new BSTNode(el);
        }
        return true;
    }

   
    public BSTNode search(int el) {
        return search(root, el);
    }

   
    protected BSTNode search(BSTNode p, int el) {
        while (p != null) {
            /* se valor procurado == chave do nodo retorna referencia ao nodo */
            if (el == p.key) {
                return p;
            } /* se valor procurado < chave do nodo, procurar na sub-arvore esquerda deste nodo */ else if (el < p.key) {
                p = p.left;
            } /* se valor procurado > chave do nodo, procurar na sub-arvore direita deste nodo */ else {
                p = p.right;
            }
        }
        // caso chave nao foi encontrada, retorna null
        return null;
    }

    /**
     * Retorna uma referencia ao pai do nodo que contem a chave especificada
     * pelo parametro el.
     *
     */
    protected BSTNode searchFather(int el) {
        BSTNode p = root;
        BSTNode prev = null;
        while (p != null && !(p.key == el)) {  // acha o nodo com a chave el
            prev = p;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p != null && p.key == el) {
            return prev;
        }
        return null;
    }

    /**
     * Caminhamento em ordem. Visita a sub-arvore esquerda Visista o nodo Visita
     * a sub-arvore direita
     *
     */
    public void inorder() {
    	System.out.println("INICIO CAMINHAMENTO EM ORDEM");
        inorder(root);
        System.out.println("\r\nFIM CAMINHAMENTO EM ORDEM");
    }

    /**
     * Versao protegida do metodo. Utilizada pela versao publica que sempre
     * inicia a busca pelo nodo raiz
     *
     */
    protected void inorder(BSTNode p) {
        if (p != null) {
            inorder(p.left);
            System.out.println(p.key + " ");
            inorder(p.right);
        }
    }

    /**
     * Caminhamento em pre-ordem. Visita o nodo Visista a sub-arvore esquerda
     * Visita a sub-arvore direita
     *
     */
    public void preorder() {
    	System.out.println("INICIO CAMINHAMENTO PR…-ORDEM");
        preorder(root);
        System.out.println("\r\nFIM CAMINHAMENTO PR…-ORDEM");
    }

    /**
     * Versao protegida do metodo. Utilizada pela versao publica que sempre
     * inicia a busca pelo nodo raiz
     *
     * @param p
     * @return
     *
     */
    protected void preorder(BSTNode p) {

        if (p != null) {
            System.out.println(p.key);
            preorder(p.left);
            preorder(p.right);
        }
    }


    /**
     * Caminhamento em pÔøΩs-ordem. Visita a sub-arvore esquerda Visita a
     * sub-arvore direita Visista o nodo
     *
     */
    public void postorder() {
    	System.out.println("INICIO CAMINHAMENTO P”S-ORDEM");
        postorder(root);
        System.out.println("\r\nFIM CAMINHAMENTO P”S-ORDEM");
    }

    /**
     * Versao protegida do metodo. Utilizada pela versao publica que sempre
     * inicia a busca pelo nodo raiz
     *
     */
    protected void postorder(BSTNode p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.key + " ");
        }
    }
 

    /**
     * Remove o nodo que contem a chave especificada por el
     *
     */
    public void delete(int el) {
        BSTNode node, father = null;
        node = search(el); // procura nodo a ser deletado
        if (node != null && node.key == el) {
            if (node != root) {
                father = searchFather(el);  // procura pai do nodo a ser deletado
            }
            if (node.right == null) {                     // nodo nao tem filho direito
                if (node == root) {
                    root = node.left;
                } else if (father.left == node) {
                    father.left = node.left;
                } else {
                    father.right = node.left;
                }
            } else if (node.left == null) {         // nodo nao tem o filho esquerdo
                if (node == root) {
                    root = node.right;
                } else if (father.left == node) {
                    father.left = node.right;
                } else {
                    father.right = node.right;
                }
            } else {     // nodo possui ambos os filhos
                BSTNode tmp = node.left;       // 1. Obtem a raiz da sub-arvore esquerda do nodo a ser removido
                while (tmp.right != null) {    // 2. Encontra o maior valor da sub-arvore esquerda do nodo a ser removido 
                    tmp = tmp.right;
                }
                delete(tmp.key);     	// 3. Remove da arvore o maior valor da sub-arvore esquerda do nodo a ser removido 
                //    Esta chamada recursiva deleta o nodo com maior valor (chave), que sempre sera um caso simples
                //    nodo com um ou nenhum filho.
                node.key = tmp.key;   // 4.Copia o valor (chave) do nodo removido para o nodo a ser removido 

            }
        } else if (root != null) {
            System.out.println("A chave " + el + " nao esta na arvore");
        } else {
            System.out.println("A arvore esta vazia");
        }
    }

}
