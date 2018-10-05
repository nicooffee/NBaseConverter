package ventana;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import clases.Converter;

public class Panel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer[] baseArray=new Integer[61];
	
	private JTextField numberField;
	private JTextArea answerField;
	
	private JComboBox<Integer> base1;
	private JComboBox<Integer> base2;
	
	private JLabel to;
	private JLabel answer;
	
	private JButton compute;
	private JButton swap;
	
	public Panel() {
		for(int i=0;i<61;i++)
			baseArray[i]=i+2;
		this.setPanel();
		this.setComponents();
	}
	
	private void setPanel() {
		this.setLayout(null);
		this.setSize(242,170);
		this.setBorder(BorderFactory.createTitledBorder("The N-M base converter"));
	}
	
	private void setComponents() {
		numberField=new JTextField();
		this.add(numberField);
		numberField.setBounds(25, 25, 75, 25);
		answerField=new JTextArea(4,22);
		this.add(answerField);
		answerField.setBounds(25, 100, 200, 50);
		answerField.setEditable(false);
		answerField.setEditable(false);
		answerField.setLineWrap(true);
		answerField.setWrapStyleWord(true);
		answerField.setBorder(BorderFactory.createLineBorder(Color.black));
		base1=new JComboBox<Integer>();
		base1.setModel(new DefaultComboBoxModel<Integer>(baseArray));
		base2=new JComboBox<Integer>();
		base2.setModel(new DefaultComboBoxModel<Integer>(baseArray));
		base1.setSelectedIndex(-1);
		base2.setSelectedIndex(-1);
		this.add(base1);
		this.add(base2);
		base1.setBounds(112, 25, 40, 25);
		base2.setBounds(180, 25, 40, 25);
		
		to=new JLabel("to");
		answer=new JLabel("Answer: ");
		this.add(to);
		this.add(answer);
		to.setBounds(160, 25, 25, 25);
		answer.setBounds(25, 80, 100, 25);
		
		compute=new JButton("Compute");
		this.add(compute);
		compute.setBounds(25, 60, 100, 20);
		compute.addActionListener(this);
		swap=new JButton("swap");
		this.add(swap);
		swap.setBounds(140, 60, 80, 20);
		swap.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(compute)) {
			if(Converter.checkNum(numberField.getText(), baseArray[base1.getSelectedIndex()]))
				answerField.setText(Converter.nBaseToMBase(numberField.getText(), baseArray[base1.getSelectedIndex()], baseArray[base2.getSelectedIndex()]));	
			else
				answerField.setText("Error: El número no es de la base indicada.");
		}
		else if(e.getSource().equals(swap)) {
			int b1=base1.getSelectedIndex();
			int b2=base2.getSelectedIndex();
			String nb1=numberField.getText();
			String nb2=answerField.getText();
			base1.setSelectedIndex(b2);
			base2.setSelectedIndex(b1);
			numberField.setText(nb2);
			answerField.setText(nb1);
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
}
