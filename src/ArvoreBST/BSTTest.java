package ArvoreBST;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BSTTest {

	private JFrame frmArvoreDePesquisa;
	private JTextField insertElement;
	private BST bst;
	private JTextField buscarElement;
	private JButton btnBuscarElemento;
	private JButton btnQtdNodosFolha;
	private JButton btnAlturaDaArvore;
	private JButton btnArvoreEstCheia;
	private JButton btnPreordem;
	private JButton button;
	private JButton btnEmOrdem;
	private JButton btnSair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSTTest window = new BSTTest();
					window.frmArvoreDePesquisa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BSTTest() {
		bst = new BST();
		initialize();
		frmArvoreDePesquisa.setLocationRelativeTo(null);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArvoreDePesquisa = new JFrame();
		frmArvoreDePesquisa.setResizable(false);
		frmArvoreDePesquisa.setTitle("Arvore de Pesquisa");
		frmArvoreDePesquisa.setBounds(100, 100, 356, 421);
		frmArvoreDePesquisa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArvoreDePesquisa.getContentPane().setLayout(null);

		insertElement = new JTextField();
		insertElement.setBounds(191, 46, 103, 20);
		frmArvoreDePesquisa.getContentPane().add(insertElement);
		insertElement.setColumns(10);

		JButton btnInserirElemento = new JButton("Inserir Elemento");
		btnInserirElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int el = Integer.parseInt(insertElement.getText());
					bst.insert(el);
					JOptionPane.showMessageDialog(null, "Elemento inserido!!");
					insertElement.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
				}				
			}
		});
		btnInserirElemento.setBounds(40, 45, 149, 23);
		frmArvoreDePesquisa.getContentPane().add(btnInserirElemento);

		buscarElement = new JTextField();
		buscarElement.setBounds(191, 80, 103, 20);
		frmArvoreDePesquisa.getContentPane().add(buscarElement);
		buscarElement.setColumns(10);

		btnBuscarElemento = new JButton("Buscar Elemento");
		btnBuscarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int el = Integer.parseInt(buscarElement.getText());
					if (bst.search(el) != null) {
						JOptionPane.showMessageDialog(null, "Elemento "+ bst.search(el).getKey() + " encontrado!!");
						buscarElement.setText(""); 
					}else {
						JOptionPane.showMessageDialog(null, "Elemento não encontrado");
						buscarElement.setText("");
					}
				}catch (Exception e1) {
					//System.out.println("Error: " + e1.getMessage());
					JOptionPane.showMessageDialog(null, "Erro:" + e1.getMessage());
				}
			}
		});
		btnBuscarElemento.setBounds(40, 79, 149, 23);
		frmArvoreDePesquisa.getContentPane().add(btnBuscarElemento);

		btnQtdNodosFolha = new JButton("Qtd Nodos Folha");
		btnQtdNodosFolha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "Está arvoré possui: "+ bst.countLeafNodes() + " Nodos Folha!!");
				} catch (Exception e2) {
					//System.out.println("Erro: " + e2.getMessage());
					JOptionPane.showMessageDialog(null, "Erro:" + e2.getMessage());
				}
			}
		});
		btnQtdNodosFolha.setBounds(40, 111, 254, 23);
		frmArvoreDePesquisa.getContentPane().add(btnQtdNodosFolha);

		btnAlturaDaArvore = new JButton("Altura da Arvore");
		btnAlturaDaArvore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "A Arvore possui: "+ bst.height() + " Niveis!!");
				} catch (Exception e2) {
					//System.out.println("Erro: " + e2.getMessage());
					JOptionPane.showMessageDialog(null, "Erro:" + e2.getMessage());
				}
			}
		});
		btnAlturaDaArvore.setBounds(40, 147, 254, 23);
		frmArvoreDePesquisa.getContentPane().add(btnAlturaDaArvore);

		JButton btnQtdTotalDe = new JButton("Qtd Total de Nodos");
		btnQtdTotalDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane.showMessageDialog(null, "A Arvore possui: "+ bst.countNodes() + " Nodos!!");
				} catch (Exception e2) {
					//System.out.println("Erro: " + e2.getMessage());
					JOptionPane.showMessageDialog(null, "Erro:" + e2.getMessage());
				}
			}
		});
		btnQtdTotalDe.setBounds(40, 181, 254, 23);
		frmArvoreDePesquisa.getContentPane().add(btnQtdTotalDe);

		btnArvoreEstCheia = new JButton("Arvore est\u00E1 CHEIA?");
		btnArvoreEstCheia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean x = bst.isFull();

					System.out.println(bst.isFull());
					if (!bst.isEmpty()) {
						if (x == true) {
							JOptionPane.showMessageDialog(null, "ARVORE É CHEIA");
						}else{
							JOptionPane.showMessageDialog(null, "ARVORE NÃO É CHEIA");
						}
					}else {
						JOptionPane.showMessageDialog(null, "ARVORE VAZIA");
					}
				} catch (Exception e2) {
					//System.out.println("Erro: " + e2.getMessage());
					JOptionPane.showMessageDialog(null, "Erro:" + e2.getMessage());
				}
			}
		});
		btnArvoreEstCheia.setBounds(40, 215, 254, 23);
		frmArvoreDePesquisa.getContentPane().add(btnArvoreEstCheia);

		btnPreordem = new JButton("Pre-ordem");
		btnPreordem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					bst.preorder();
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error: "+ e2.getMessage());
				}
			}
		});
		btnPreordem.setBounds(40, 249, 254, 23);
		frmArvoreDePesquisa.getContentPane().add(btnPreordem);

		button = new JButton("Pós-ordem");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bst.postorder();
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, "Error: "+ e3.getMessage());;
				}
			}
		});
		button.setBounds(40, 283, 254, 23);
		frmArvoreDePesquisa.getContentPane().add(button);

		btnEmOrdem = new JButton("Em ordem");
		btnEmOrdem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bst.inorder();
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, "Error: "+ e3.getMessage());;
				}

			}
		});
		btnEmOrdem.setBounds(40, 317, 254, 23);
		frmArvoreDePesquisa.getContentPane().add(btnEmOrdem);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.exit(0);
				}catch(Exception e3) {
					JOptionPane.showMessageDialog(null, "Error: "+ e3.getMessage());;
				}
			}
		});
		btnSair.setBounds(121, 348, 89, 23);
		frmArvoreDePesquisa.getContentPane().add(btnSair);
	}
}
