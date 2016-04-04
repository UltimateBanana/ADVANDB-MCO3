package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTable;

public class MainGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea textAreaQuery;
	private JButton buttonClearQuery, buttonExecute, buttonReadUncommitted, buttonReadCommitted, buttonReadRepeatable, buttonSerializable;
	private JScrollPane scrollPaneTextArea;
	private JScrollPane scrollPaneTable;
	private JTable table;
	
	private DefaultTableModel defaultTableModel;
//	private
//	private
//	private
//	private
//	private

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 500);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAreaQuery =  new JTextArea();
		textAreaQuery.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textAreaQuery.setBounds(6, 6, 380, 335);
		textAreaQuery.setEditable(true);
		contentPane.add(textAreaQuery);
		
		scrollPaneTextArea = new JScrollPane(textAreaQuery, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneTextArea.setBounds(10, 6, 370, 335);
		contentPane.add(scrollPaneTextArea);
		
		buttonClearQuery = new JButton("Clear Query");
		buttonClearQuery.setBounds(6, 443, 117, 29);
		buttonClearQuery.addActionListener(this);
		contentPane.add(buttonClearQuery);
		
		buttonExecute = new JButton("Execute");
		buttonExecute.setBounds(6, 415, 117, 29);
		buttonExecute.addActionListener(this);
		contentPane.add(buttonExecute);
		
		buttonReadUncommitted = new JButton("Read Uncommitted");
		buttonReadUncommitted.setBounds(6, 353, 163, 29);
		buttonReadUncommitted.addActionListener(this);
		contentPane.add(buttonReadUncommitted);
		
		buttonReadCommitted = new JButton("Read Committed");
		buttonReadCommitted.setBounds(6, 383, 163, 29);
		buttonReadCommitted.addActionListener(this);
		contentPane.add(buttonReadCommitted);
		
		buttonReadRepeatable = new JButton("Read Repeatable");
		buttonReadRepeatable.setBounds(181, 353, 163, 29);
		buttonReadRepeatable.addActionListener(this);
		contentPane.add(buttonReadRepeatable);
		
		buttonSerializable = new JButton("Serializable");
		buttonSerializable.setBounds(181, 383, 163, 29);
		buttonSerializable.addActionListener(this);
		contentPane.add(buttonSerializable);
		
		defaultTableModel = new DefaultTableModel();
		table = new JTable(defaultTableModel);
		table.setBounds(392, 6, 802, 466);
		contentPane.add(table);
		
		scrollPaneTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneTable.setBounds(392, 6, 802, 466);
		contentPane.add(scrollPaneTable);
	}

// ACTION LISTENERS
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonClearQuery)
		{
			textAreaQuery.setText("");
		}
		else if(e.getSource() == buttonExecute)
		{
			
		}
		else if(e.getSource() == buttonReadUncommitted)
		{
			
		}
		else if(e.getSource() == buttonReadCommitted)
		{
			
		}
		else if(e.getSource() == buttonReadRepeatable)
		{
			
		}
		else if(e.getSource() == buttonSerializable)
		{
			
		}
	}
}
