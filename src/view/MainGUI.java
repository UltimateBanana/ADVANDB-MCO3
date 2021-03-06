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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;

import controller.Controller;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class MainGUI extends JFrame implements ActionListener {

	private Controller controller;
	private DefaultTableModel defaultTableModel;
	
	private JPanel contentPane;
	private JTextArea textAreaQuery;
	private JButton buttonClearQuery, buttonExecute, buttonReadUncommitted, buttonReadCommitted, buttonReadRepeatable, buttonSerializable;
	private JScrollPane scrollPaneTextArea, scrollPaneTable;
	private JTable table;
	private JLabel labelRowsReturned, labelQueryRuntime;
	private JCheckBox chckbxMarinduque, chckbxPalawan;
	private JTabbedPane tabbedPaneTextArea;
//	private
//	private

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		controller = new Controller();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 550);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPaneTextArea = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneTextArea.setBounds(10, 6, 372, 335);
		contentPane.add(tabbedPaneTextArea);
		
		textAreaQuery =  new JTextArea();
		textAreaQuery.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		textAreaQuery.setBounds(6, 6, 380, 335);
		textAreaQuery.setEditable(true);
		contentPane.add(textAreaQuery);
		
		scrollPaneTextArea = new JScrollPane(textAreaQuery, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tabbedPaneTextArea.addTab("Transaction", null, scrollPaneTextArea, null);
		
		buttonClearQuery = new JButton("Clear Query");
		buttonClearQuery.setBounds(6, 493, 117, 29);
		buttonClearQuery.addActionListener(this);
		contentPane.add(buttonClearQuery);
		
		buttonExecute = new JButton("Execute");
		buttonExecute.setBounds(6, 465, 117, 29);
		buttonExecute.addActionListener(this);
		contentPane.add(buttonExecute);
		
		buttonReadUncommitted = new JButton("Read Uncommitted");
		buttonReadUncommitted.setBounds(6, 403, 163, 29);
		buttonReadUncommitted.addActionListener(this);
		contentPane.add(buttonReadUncommitted);
		
		buttonReadCommitted = new JButton("Read Committed");
		buttonReadCommitted.setBounds(6, 433, 163, 29);
		buttonReadCommitted.addActionListener(this);
		contentPane.add(buttonReadCommitted);
		
		buttonReadRepeatable = new JButton("Read Repeatable");
		buttonReadRepeatable.setBounds(181, 403, 163, 29);
		buttonReadRepeatable.addActionListener(this);
		contentPane.add(buttonReadRepeatable);
		
		buttonSerializable = new JButton("Serializable");
		buttonSerializable.setBounds(181, 433, 163, 29);
		buttonSerializable.addActionListener(this);
		contentPane.add(buttonSerializable);
		
		defaultTableModel = new DefaultTableModel();
		table = new JTable(defaultTableModel);
		table.setBounds(392, 6, 802, 466);
		contentPane.add(table);
		
		scrollPaneTable = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneTable.setBounds(392, 6, 802, 516);
		contentPane.add(scrollPaneTable);
		
		labelRowsReturned = new JLabel("");
		labelRowsReturned.setBounds(134, 420, 210, 16);
		contentPane.add(labelRowsReturned);
		
		labelQueryRuntime = new JLabel("");
		labelQueryRuntime.setBounds(135, 448, 210, 16);
		contentPane.add(labelQueryRuntime);
		
		chckbxMarinduque = new JCheckBox("Marinduque");
		chckbxMarinduque.setBounds(62, 373, 107, 23);
		chckbxMarinduque.addActionListener(this);
		contentPane.add(chckbxMarinduque);
		
		chckbxPalawan = new JCheckBox("Palawan");
		chckbxPalawan.setBounds(234, 373, 82, 23);
		chckbxPalawan.addActionListener(this);
		contentPane.add(chckbxPalawan);
		
		JButton buttonGlobal = new JButton("Global");
		buttonGlobal.setBounds(52, 343, 117, 29);
		contentPane.add(buttonGlobal);
		
		JButton buttonLocal = new JButton("Local");
		buttonLocal.setBounds(214, 343, 117, 29);
		contentPane.add(buttonLocal);
	}

// ACTION LISTENERS
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//BUTTONS
		if(e.getSource() == buttonClearQuery)
		{
			textAreaQuery.setText("");
			System.out.println("TextArea CLEARED!");
		}
		else if(e.getSource() == buttonExecute)
		{
			try
			{
				// Passing the query from text area to controller.getData()
				String sql = textAreaQuery.getText().toString();
				populateTable(controller.getData(sql));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				// For Null Pointer Exception
				System.out.println("EMPTY QUERY! Executed nothing.");
			}
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
		
		//CHECKBOXES
		if(chckbxMarinduque.isSelected())
		{
			System.out.println("chckbxMarinduque is clicked");
			controller.changeConnection("marinduque");
		}
		else if(chckbxPalawan.isSelected())
		{
			System.out.println("chckbxPalawan is clicked");
			controller.changeConnection("palawan");
		}
		else if(chckbxPalawan.isSelected() && chckbxPalawan.isSelected())
		{
			System.out.println("chckbxMarinduque & chckbxPalawan is clicked");
			controller.changeConnection("central");
		}
	}
	
	
	
	// Populates the JTable using the ResultSet parameter
	private void populateTable(ResultSet rs)
	{
		ResultSetMetaData rsdm = null;
		int colCount = 0;
		
		// get ResultMetaData to get column header
		// get column count
		try
		{
			rsdm = rs.getMetaData();
			colCount = rsdm.getColumnCount();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// get column headers
		String[] columns = new String[colCount];
		for( int i = 0; i < colCount; i++ )
		{
			try
			{
				columns[i] = rsdm.getColumnLabel(i+1);
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// get table data
		ArrayList<Object[]> rows = new ArrayList<Object[]>(0);
		
		try
		{
			while(rs.next())
			{
				Object[] rowData = new Object[colCount];
				for( int i = 0; i < colCount; i++ )
				{
					rowData[i] = rs.getObject(i+1);
				}
				rows.add(rowData);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		defaultTableModel = new DefaultTableModel(arraylistToObjectArray(rows), columns);
		table.setModel(defaultTableModel);
		
		if( colCount <= 5 )
		{
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}
		else
		{
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		
		labelRowsReturned.setText("Rows returned: " + rows.size() + " rows");
		labelQueryRuntime.setText("Query Runtime: " + controller.getQueryTime() / 1000 + " seconds");
	}
	
	// convert ArrayList<Object[]> to Object[][]
	private Object[][] arraylistToObjectArray( ArrayList<Object[]> list )
	{
		Object[][] newList = new Object[list.size()][];
		for( int i = 0; i < list.size(); i++ )
		{
			newList[i] = list.get(i);
		}
		
		return newList;
	}
}
