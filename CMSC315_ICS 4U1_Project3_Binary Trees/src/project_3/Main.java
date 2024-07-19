package project_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kelvin Njenga
 * Date: September 25, 2023
 * This is the Main class that is responsible for displaying the items and options on the GUI that it has created.
 */

public class Main {
	private JFrame frame;
	private JTextField inputTextField;
	private JButton makeTreeButton, isBalancedButton, isFullButton, isProperButton, heightButton, nodesButton, inorderButton;
	private JTextArea outputTextArea;
	private BinaryTree binaryTree;

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        project_3.Main app = new Main();
	        app.createAndShowGUI();
	    });
	}

	private void createAndShowGUI() {
	    frame = new JFrame("Binary Tree Analyzer");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(400, 300));

	    JPanel panel = new JPanel(new BorderLayout());

	    inputTextField = new JTextField();
	    panel.add(inputTextField, BorderLayout.NORTH);

	    makeTreeButton = new JButton("Make Tree");
	    makeTreeButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            makeTreeButtonClicked();
	            }
	        });

	    JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
	    buttonPanel.add(makeTreeButton);

	    isBalancedButton = new JButton("Is Balanced?");
	    isBalancedButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            isBalancedButtonClicked();
	            }
	        });
	    buttonPanel.add(isBalancedButton);

	    isFullButton = new JButton("Is Full?");
	    isFullButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            isFullButtonClicked();
	            }
	        });
	    buttonPanel.add(isFullButton);

	    isProperButton = new JButton("Is Proper?");
	    isProperButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            isProperButtonClicked();
	            }
	        });
	    buttonPanel.add(isProperButton);

	    heightButton = new JButton("Height");
	    heightButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            heightButtonClicked();
	            }
	        });
	    buttonPanel.add(heightButton);

	    nodesButton = new JButton("Nodes");
	    nodesButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            nodesButtonClicked();
	            }
	        });
	    buttonPanel.add(nodesButton);

	    inorderButton = new JButton("Inorder");
	    inorderButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            inorderButtonClicked();
	            }
	        });
	    buttonPanel.add(inorderButton);

	    panel.add(buttonPanel, BorderLayout.WEST);

	    outputTextArea = new JTextArea();
	    panel.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

	    frame.getContentPane().add(panel);
	    frame.pack();
	    frame.setVisible(true);
	    }

	private void makeTreeButtonClicked() {
	    try {
	        String input = inputTextField.getText();
	        binaryTree = new BinaryTree(input);
	        outputTextArea.setText("Tree constructed successfully.");
	    } catch (InvalidTreeSyntax e) {
	        JOptionPane.showMessageDialog(frame, e.getMessage(), "Invalid Tree Syntax", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	private void isBalancedButtonClicked() {
	    if (binaryTree != null && binaryTree.isBalanced()) {
	        outputTextArea.setText("The tree is balanced.");
	    } else {
	        outputTextArea.setText("The tree is not balanced.");
	        }
	    }

	private void isFullButtonClicked() {
	    if (binaryTree != null && binaryTree.isFull()) {
	        outputTextArea.setText("The tree is full.");
	    } else {
	        outputTextArea.setText("The tree is not full.");
	        }
	    }

	private void isProperButtonClicked() {
	    if (binaryTree != null && binaryTree.isProper()) {
	        outputTextArea.setText("The tree is proper.");
	    } else {
	        outputTextArea.setText("The tree is not proper.");
	        }
	    }

	private void heightButtonClicked() {
	    if (binaryTree != null) {
	        int height = binaryTree.getHeight();
	        outputTextArea.setText("The height of the tree is: " + height);
	    } else {
	        outputTextArea.setText("Tree has not been constructed yet.");
	        }
	    }

	private void nodesButtonClicked() {
	    if (binaryTree != null) {
	        int nodeCount = binaryTree.getNodeCount();
	        outputTextArea.setText("The number of nodes in the tree is: " + nodeCount);
	    } else {
	        outputTextArea.setText("Tree has not been constructed yet.");
	        }
	    }

	private void inorderButtonClicked() {
	    if (binaryTree != null) {
	        String inorderTraversal = binaryTree.getInorderTraversal();
	        outputTextArea.setText("Inorder Traversal: " + inorderTraversal);
	    } else {
	        outputTextArea.setText("Tree has not been constructed yet.");
	        }
	    }
	}

