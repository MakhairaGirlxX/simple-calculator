package Rework;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorRework {

	public static void main(String[] args) {
		
	CalculatorBuilder frame = new CalculatorBuilder();
	frame.buildDisplayPanel();
	frame.buildButtonPanel();
	frame.buildAppFrame();
	
	}

}

class CalculatorBuilder implements FrameBuilder
{
	JPanel buttonPnl, dispPnl;
	JTextField dispText = new JTextField();
	Font font = new Font("TimesRoman", Font.PLAIN, 30);
	double temp;
	double result, result2, store;
	String n1, n2;
	int counter = 0;	

	@Override
	public JPanel buildButtonPanel() {	

		buttonPnl = new JPanel();
		
		dispText.setFont(font);
		dispText.setHorizontalAlignment(JTextField.RIGHT);
		
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		String[] buttonTxt = {"C", "/", "X", "<--", "7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "=", "%", "0", "."};
		
		buttonPnl.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(2, 2, 2, 2);

		for(int i = 0; i < 19; i++)
		{
			buttons.add(new JButton(buttonTxt[i]));
			buttons.get(i).setFont(new Font("TimesRoman", Font.PLAIN, 20));
		}		
		
		buttons.get(12).addActionListener(new ButtonOne());
		buttons.get(13).addActionListener(new ButtonTwo());
		buttons.get(14).addActionListener(new ButtonThree());
		buttons.get(8).addActionListener(new ButtonFour());
		buttons.get(9).addActionListener(new ButtonFive());
		buttons.get(10).addActionListener(new ButtonSix());
		buttons.get(4).addActionListener(new ButtonSeven());
		buttons.get(5).addActionListener(new ButtonEight());
		buttons.get(6).addActionListener(new ButtonNine());
		buttons.get(17).addActionListener(new ButtonZero());
		
		buttons.get(11).addActionListener(new Addition());
		buttons.get(7).addActionListener(new Subtraction());
		buttons.get(2).addActionListener(new Multiplication());
		buttons.get(1).addActionListener(new Division());
		
		buttons.get(0).addActionListener(new Clear());
		buttons.get(18).addActionListener(new Decimal());
		buttons.get(16).addActionListener(new Percent());
		buttons.get(3).addActionListener(new Retreive());
		
		buttons.get(15).addActionListener(new Equals());
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				gbc.gridx = j;
				gbc.gridy = i;
		
				buttonPnl.add(buttons.get(counter++), gbc);
			}
		}		
	
		gbc.gridx = 0;
		gbc.gridy = 3;
		buttonPnl.add(buttons.get(counter++), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		buttonPnl.add(buttons.get(counter++), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		buttonPnl.add(buttons.get(counter++), gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		buttonPnl.add(buttons.get(counter++), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		buttonPnl.add(buttons.get(counter++), gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		buttonPnl.add(buttons.get(counter++), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		buttonPnl.add(buttons.get(counter++), gbc);		
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		buttonPnl.add(buttons.get(15), gbc);
		
		return buttonPnl;
	}	
	
	@Override
	public JPanel buildDisplayPanel() {
		
		dispPnl = new JPanel(new GridLayout());
		dispPnl.setBackground(Color.lightGray);
		dispPnl.setBorder(BorderFactory.createTitledBorder("Display"));
		dispPnl.add(dispText);
		return dispPnl;
	}

	@Override
	public JFrame buildAppFrame() 
	{		
		JFrame frame = new JFrame("Calculator");
		frame.setLayout(new GridLayout(2, 1));
		
		frame.add(dispPnl);
		frame.add(buttonPnl);
		
		frame.setSize(800, 600);
		frame.setLocation(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
		
		return frame;
	}
	
	class Decimal implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + ".");			
		}		
	}
	
	class Percent implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "%");			
		}		
	}
	
	class Addition implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "+");			
		}		
	}
	
	class Subtraction implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "-");			
		}		
	}
	
	class Multiplication implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "x");			
		}		
	}
	
	class Division implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "/");			
		}		
	}

	class ButtonOne implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "1");	
			
			if(n1 == null)
			{
				n1 = "1";
			}
			
			else 
			{
				n2 = "1";
			}
		}		
	}

	class ButtonTwo implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "2");
			if(n1 == null)
			{
				n1 = "2";
			}
			
			else
			{
				n2 = "2";
			}
			
		}
		
	}
	
	class ButtonThree implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "3");
			if(n1 == null)
			{
				n1 = "3";
			}
			
			else
			{
				n2 = "3";
			}
			
		}
		
	}
	
	class ButtonFour implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "4");
			if(n1 == null)
			{
				n1 = "4";
			}
			
			else
			{
				n2 = "4";
			}
			
		}
		
	}
	
	class ButtonFive implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "5");
			if(n1 == null)
			{
				n1 = "5";
			}
			
			else
			{
				n2 = "5";
			}
			
		}
		
	}
	
	class ButtonSix implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "6");
			if(n1 == null)
			{
				n1 = "6";
			}
			
			else
			{
				n2 = "6";
			}
			
		}
		
	}
	
	class ButtonSeven implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "7");
			if(n1 == null)
			{
				n1 = "7";
			}
			
			else
			{
				n2 = "7";
			}
			
		}
		
	}
	
	class ButtonEight implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "8");
			if(n1 == null)
			{
				n1 = "8";
			}
			
			else
			{
				n2 = "8";
			}
			
		}
		
	}
	
	class ButtonNine implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "9");
			if(n1 == null)
			{
				n1 = "9";
			}
			
			else
			{
				n2 = "9";
			}
			
		}
		
	}
	
	class ButtonZero implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			dispText.setText(dispText.getText() + "0");
			if(n1 == null)
			{
				n1 = "0";
			}
			
			else
			{
				n2 = "0";
			}
			
		}
		
	}
	
	class Equals implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			result = Double.parseDouble(n1);
			result2 = Double.parseDouble(n2);
			
			if(dispText.getText().contains("+"))
			{
				double add = result + result2;
				dispText.setText(String.valueOf(add));
				store = add;
				
			}			
			
			else if(dispText.getText().contains("-"))
			{
				double subtract = result - result2;
				dispText.setText(String.valueOf(subtract));
				store = subtract;
			}
			
			else if(dispText.getText().contains("x"))
			{
				double multi = result * result2;
				dispText.setText(String.valueOf(multi));
				store = multi;
			}
			
			
			else if(dispText.getText().contains("/"))
			{
				double div = result / result2;
				dispText.setText(String.valueOf(div));
				store = div;
			}
			
			else if(dispText.getText().contains("%"))
			{
				double per = (result / 100);
				double s = per * result2;
				
				dispText.setText(String.valueOf(s));
				store = per;
			}	
			
		}
		
	}
	
	class Clear implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispText.setText("");
			
		}		
	}
	
	class Retreive implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispText.setText(String.valueOf(store));
			
		}
		
	}
}
	
interface FrameBuilder
{
	JPanel buildButtonPanel();
	JPanel buildDisplayPanel();
	JFrame buildAppFrame();
}

