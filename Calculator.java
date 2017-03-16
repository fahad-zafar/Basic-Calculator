import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	private JButton point;
	private StringBuffer num1 = new StringBuffer ();
	private StringBuffer num2 = new StringBuffer ();
	private String result = "";
	private int opt = 0;
	private String output;
	private boolean secondNum = false;
	
	public String evaluator (StringBuffer n1, StringBuffer n2, int opt) {
		Double answer = 0.0;
		if (opt == 1) {
			answer = Double.valueOf(n1.toString()) + Double.valueOf(n2.toString());
		}
		else if (opt == 2) {
			answer = Double.valueOf(n1.toString()) - Double.valueOf(n2.toString());
		}
		else if (opt == 3) {
			answer = Double.valueOf(n1.toString()) * Double.valueOf(n2.toString());
		}
		else if (opt == 4) {
			answer = Double.valueOf(n1.toString()) / Double.valueOf(n2.toString());
		}
		return String.valueOf(answer);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 282, 275);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setBounds(10, 11, 249, 46);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton back = new JButton("B");
		back.setFont(new Font("Tahoma", Font.PLAIN, 9));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				result = textField.getText();
				if (result.equals(""))
					return;
				
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					secondNum = false;
				}
				
				result = result.substring(0, result.length() - 1);
				textField.setText(result);
				
			}
		});
		back.setBounds(10, 68, 42, 23);
		frame.getContentPane().add(back);
		
		JButton ce = new JButton("CE");
		ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				result = textField.getText();
				if (result.contains("+") || result.contains("-") || result.contains("*") || result.contains("/")) {
					char temp = result.charAt(result.length() - 1);
					while (true) {
						result = result.substring(0, result.length() - 1);
						temp = result.charAt(result.length() - 1);
						if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
							result = result.substring(0, result.length() - 1);
							break;
						}
					}
					textField.setText(result);
					num1 = new StringBuffer (result);
					num2 = new StringBuffer ();
					secondNum = false;
				}
				else {
					num1 = new StringBuffer ();
					num2 = new StringBuffer ();
					opt = 0;
					result = "";
					output = "";
					secondNum = false;
					textField.setText("");
				}
			}
		});
		ce.setFont(new Font("Tahoma", Font.PLAIN, 7));
		ce.setBounds(62, 68, 42, 23);
		frame.getContentPane().add(ce);
		
		JButton c = new JButton("C");
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = new StringBuffer ();
				num2 = new StringBuffer ();
				opt = 0;
				result = "";
				output = "";
				secondNum = false;
				textField.setText("");
			}
		});
		c.setBounds(114, 68, 42, 23);
		frame.getContentPane().add(c);
		
		JButton plusminus = new JButton("\u00B1");
		plusminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				result = textField.getText();
				if (result.equals(""))
					return;
				
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					result = result.substring(0, result.length() - 1);
					textField.setText(result);
				}
				
				if (result.contains("-"))
					result = result.substring(1, result.length());
				
				else 
					result = "-" + result;
				
				num1 = new StringBuffer (result);
				textField.setText(result);
			}
		});
		plusminus.setBounds(166, 68, 42, 23);
		frame.getContentPane().add(plusminus);
		
		JButton squareroot = new JButton("\u221A");
		squareroot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = textField.getText();
				if (result.equals(""))
					return;
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					result = result.substring(0, result.length() - 1);
					textField.setText(result);
				}
				
				if (num2.length() != 0) {
					output = evaluator (num1, num2, opt);
					textField.setText(output);
				}
				
				Double answer = Double.valueOf(textField.getText());
				answer = Math.sqrt(answer);
				result = String.valueOf(answer);
				num1 = new StringBuffer (result);
				num2 = new StringBuffer ();
				textField.setText(result);
				secondNum = false;
			}
		});
		squareroot.setFont(new Font("Tahoma", Font.PLAIN, 10));
		squareroot.setBounds(218, 68, 42, 23);
		frame.getContentPane().add(squareroot);
		
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("7");
					result = textField.getText();
					textField.setText(result + "7");
				}
				else if (secondNum) {
					num2.append("7");
					result = textField.getText();
					textField.setText(result + "7");
				}
			}
		});
		seven.setBounds(10, 102, 42, 23);
		frame.getContentPane().add(seven);
		
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("8");
					result = textField.getText();
					textField.setText(result + "8");
				}
				else if (secondNum) {
					num2.append("8");
					result = textField.getText();
					textField.setText(result + "8");
				}
			}
		});
		eight.setBounds(62, 102, 42, 23);
		frame.getContentPane().add(eight);
		
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("9");
					result = textField.getText();
					textField.setText(result + "9");
				}
				else if (secondNum) {
					num2.append("9");
					result = textField.getText();
					textField.setText(result + "9");
				}
			}
		});
		nine.setBounds(114, 102, 42, 23);
		frame.getContentPane().add(nine);
		
		JButton div = new JButton("/");
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				result = textField.getText();
				if (result.equals(""))
					return;
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					result = result.substring(0, result.length() - 1);
					textField.setText(result + "/");
					opt = 4;
					secondNum = true;
					return;
				}
				
				if (!secondNum) {
					opt = 4;
					result = textField.getText();
					textField.setText(result + "/");
					secondNum = true;
				}
				else {
					output = evaluator (num1, num2, opt);
					num1 = new StringBuffer (output);
					num2 = new StringBuffer ();
					textField.setText(output + "/");
				}
			}
		});
		div.setBounds(166, 102, 42, 23);
		frame.getContentPane().add(div);
		
		JButton mod = new JButton("%");
		mod.setFont(new Font("Tahoma", Font.PLAIN, 8));
		mod.setBounds(217, 102, 42, 23);
		frame.getContentPane().add(mod);
		
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("4");
					result = textField.getText();
					textField.setText(result + "4");
				}
				else if (secondNum) {
					num2.append("4");
					result = textField.getText();
					textField.setText(result + "4");
				}
			}
		});
		four.setBounds(10, 136, 42, 23);
		frame.getContentPane().add(four);
		
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("5");
					result = textField.getText();
					textField.setText(result + "5");
				}
				else if (secondNum) {
					num2.append("5");
					result = textField.getText();
					textField.setText(result + "5");
				}
			}
		});
		five.setBounds(62, 136, 42, 23);
		frame.getContentPane().add(five);
		
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("6");
					result = textField.getText();
					textField.setText(result + "6");
				}
				else if (secondNum) {
					num2.append("6");
					result = textField.getText();
					textField.setText(result + "6");
				}
			}
		});
		six.setBounds(114, 136, 42, 23);
		frame.getContentPane().add(six);
		
		JButton multi = new JButton("*");
		multi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				result = textField.getText();
				if (result.equals(""))
					return;
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					result = result.substring(0, result.length() - 1);
					textField.setText(result + "*");
					opt = 3;
					secondNum = true;
					return;
				}
				
				if (!secondNum) {
					opt = 3;
					result = textField.getText();
					textField.setText(result + "*");
					secondNum = true;
				}
				else {
					output = evaluator (num1, num2, opt);
					num1 = new StringBuffer (output);
					num2 = new StringBuffer ();
					textField.setText(output + "*");
				}
			}
		});
		multi.setBounds(166, 136, 42, 23);
		frame.getContentPane().add(multi);
		
		JButton recep = new JButton("1/x");
		recep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				result = textField.getText();
				if (result.equals(""))
					return;
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					result = result.substring(0, result.length() - 1);
					textField.setText(result);
				}
				
				if (num2.length() != 0) {
					output = evaluator (num1, num2, opt);
					textField.setText(output);
				}
				
				Double answer = Double.valueOf(textField.getText());
				answer = 1 / answer;
				result = String.valueOf(answer);
				num1 = new StringBuffer (result);
				num2 = new StringBuffer ();
				textField.setText(result);
				secondNum = false;
			}
		});
		recep.setFont(new Font("Tahoma", Font.PLAIN, 6));
		recep.setBounds(217, 136, 42, 23);
		frame.getContentPane().add(recep);
		
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("1");
					result = textField.getText();
					textField.setText(result + "1");
				}
				else if (secondNum) {
					num2.append("1");
					result = textField.getText();
					textField.setText(result + "1");
				}
			}
		});
		one.setBounds(10, 170, 42, 23);
		frame.getContentPane().add(one);
		
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("2");
					result = textField.getText();
					textField.setText(result + "2");
				}
				else if (secondNum) {
					num2.append("2");
					result = textField.getText();
					textField.setText(result + "2");
				}
			}
		});
		two.setBounds(62, 170, 42, 23);
		frame.getContentPane().add(two);
		
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("3");
					result = textField.getText();
					textField.setText(result + "3");
				}
				else if (secondNum) {
					num2.append("3");
					result = textField.getText();
					textField.setText(result + "3");
				}
			}
		});
		three.setBounds(114, 170, 42, 23);
		frame.getContentPane().add(three);
		
		JButton minus = new JButton("-");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				result = textField.getText();
				if (result.equals(""))
					return;
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					result = result.substring(0, result.length() - 1);
					textField.setText(result + "-");
					opt = 2;
					secondNum = true;
					return;
				}
				
				if (!secondNum) {
					opt = 2;
					result = textField.getText();
					textField.setText(result + "-");
					secondNum = true;
				}
				else {
					output = evaluator (num1, num2, opt);
					num1 = new StringBuffer (output);
					num2 = new StringBuffer ();
					textField.setText(output + "-");
				}
			}
		});
		minus.setBounds(166, 170, 42, 23);
		frame.getContentPane().add(minus);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					num1.append("0");
					result = textField.getText();
					textField.setText(result + "0");
				}
				else if (secondNum) {
					num2.append("0");
					result = textField.getText();
					textField.setText(result + "0");
				}
			}
		});
		zero.setBounds(10, 206, 94, 23);
		frame.getContentPane().add(zero);
		
		point = new JButton(".");
		point.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!secondNum) {
					if (num1.toString().contains(".")) {
						return;
					}
					num1.append(".");
					result = textField.getText();
					textField.setText(result + ".");
				}
				else if (secondNum) {
					if (num2.toString().contains(".")) {
						return;
					}
					num2.append(".");
					result = textField.getText();
					textField.setText(result + ".");
				}
			}
		});
		point.setBounds(114, 204, 42, 23);
		frame.getContentPane().add(point);
		
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				result = textField.getText();
				if (result.equals(""))
					return;
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					result = result.substring(0, result.length() - 1);
					textField.setText(result + "+");
					opt = 1;
					secondNum = true;
					return;
				}
				
				if (!secondNum) {
					opt = 1;
					result = textField.getText();
					textField.setText(result + "+");
					secondNum = true;
				}
				else {
					output = evaluator (num1, num2, opt);
					num1 = new StringBuffer (output);
					num2 = new StringBuffer ();
					textField.setText(output + "+");
				}
			}
		});
		plus.setBounds(166, 206, 42, 23);
		frame.getContentPane().add(plus);
		
		JButton equal = new JButton("=");
		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				result = textField.getText();
				if (result.equals(""))
					return;
				char temp = result.charAt(result.length() - 1);
				if (temp == '-' || temp == '*' || temp == '/' || temp == '+') {
					return;
				}
				output = evaluator (num1, num2, opt);
				num1 = new StringBuffer (output);
				num2 = new StringBuffer ();
				textField.setText(output);
				secondNum = false;
			}
		});
		equal.setBounds(217, 170, 42, 59);
		frame.getContentPane().add(equal);
	}
}
