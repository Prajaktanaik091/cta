package JavaApplication;
import java.awt.*; 
import java.awt.event.*;

import javax.swing.*;


//exception handling
class IAException extends Throwable{

}

class cieException extends Throwable{

}

class SEMException extends Throwable{

}


class StudentCie extends JFrame implements ActionListener{
	Container ContentPane;
	JButton b;
	JPanel p,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t,t1,t2,t3,t4;

	public StudentCie(String title) {
		super(title);
		b=new JButton("calculate");


		p = new JPanel();  //panel for grading system
		l6=new JLabel();
		l7=new JLabel();
		p9=new JPanel();
		p.setBounds(150, 10, 250, 50);
		l=new JLabel("grading system");
		p.add(l);
		p9.add(p);


		p1=new JPanel();   //panel for ia1
		p1.setBounds(75,100,300,50);
		l1=new JLabel("enter ia1 marks");
		p1.add(l1);
		t=new JTextField(5);
		p1.add(t);


		p2=new JPanel();   //panel for ia2
		p2.setBounds(75,150,300,50);
		l2=new JLabel("enter ia2 marks");
		p2.add(l2);
		t1=new JTextField(5);
		p2.add(t1);


		p3=new JPanel();  //panel for ia3
		p3.setBounds(75,200,300,50);
		l3=new JLabel("enter ia3 marks");
		p3.add(l3);
		t2=new JTextField(5);
		p3.add(t2);


		p4=new JPanel();   //panel for cta
		p4.setBounds(75,250,300,50);
		l4=new JLabel("enter cta marks");
		p4.add(l4);
		t3=new JTextField(5);
		p4.add(t3);


		p5=new JPanel();   //panel for see
		p5.setBounds(75,300,300,50);
		l5=new JLabel("enter see marks");
		p5.add(l5);
		t4=new JTextField(5);
		p5.add(t4);

        
		p6=new JPanel();   //panel for button
		p6.setBounds(100,350,300,50);
		b.setPreferredSize(new Dimension(150,25));
		p6.add(b);


		p7=new JPanel();   //panel for total marks
		p7.setBounds(75,400,100,50);
		l6=new JLabel("total marks:");
		p7.add(l6);


		p8=new JPanel();  //panel for grade
		p8.setBounds(75,450,100,50);
		l7=new JLabel("grade:");
		p8.add(l7);


		p10=new JPanel();   //panel for note
		p10.setBounds(150,50,250,50);
		l8=new JLabel("note: incase of absentees please enter zero");
		p10.add(l8);

		//adding all panels to frame
		this.add(p);
		this.add(p10);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(p7);
		this.add(p8);
		this.add(p9);

		b.addActionListener(this);


	}

	//method to calculate total marks
	double  ciecalculator(){
		double cie,small;
		
		double ia1 = Double.parseDouble(t.getText());
		double ia2 = Double.parseDouble(t1.getText());
		double ia3 = Double.parseDouble(t2.getText());
		double cta = Double.parseDouble(t3.getText());
		small=ia1;
		if(ia2<small) {
			small=ia2;
		}
		if(ia3<small) {
			small=ia3;
		}
		cie=ia1+ia2+ia3+cta-small;
		try {
			if(cie<20) {
				throw new cieException();
			}
		}catch (cieException ciee) {
			JOptionPane.showMessageDialog(this," student is detained for see");
			return -1;
		}
		double see = Double.parseDouble(t4.getText());
		if(see==38 || see==39)
			see=40;
		see = see/2;
		see=Math.ceil(see);
		double total =see+cie;
		return total;
		}
		
		
	

	//method to compute grade
	String grade() {
		double totalm = ciecalculator();
		String grade;

		if(totalm<=100 && totalm >=90)
			grade="S";
		else if(totalm<90 && totalm>=80)
			grade="A";
		else if(totalm<80 && totalm>=70)
			grade="B";
		else if(totalm<70 && totalm>=60)
			grade="C";
		else if(totalm<60 && totalm>=50)
			grade="D";
		else if(totalm<50 && totalm >= 40)
			grade="E";
		else
			grade="F";

		return grade;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		double cie = ciecalculator();

		// TODO Auto-generated method stub

		
		
		double ia1 = Double.parseDouble(t.getText());
		double ia2 = Double.parseDouble(t1.getText());
		double ia3 = Double.parseDouble(t2.getText());
		double cta = Double.parseDouble(t3.getText());
		double see = Double.parseDouble(t4.getText());
		
		
		

	
	
			if((ia1<0 || ia1 >20)|| (ia2<0 || ia2>20) || (ia3<0 || ia3>20) || (cta<0 ||cta>10)|| (see<0 || see>100)) {
				throw new IAException();	
			}
			try {
				if(see<38) {
					throw new SEMException();
				}
				if(cie!=-1 && cie!=-2) {
					l6.setText("total marks :" + ciecalculator());
					l7.setText("grade :" + grade());
				}
			}catch(SEMException seme) {
				JOptionPane.showMessageDialog(this, "your grade is f : failed");
			}
		}catch(IAException iae) {
			JOptionPane.showMessageDialog(this,"invalid marks entered");
		}catch(NumberFormatException nfe) {
		     JOptionPane.showMessageDialog(this, "please enter input");
		     System.out.println("");
		}
	



	}
}


public class DemoGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new StudentCie("students grading system");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setBounds(0,0,600,600);
		f.setVisible(true);
	}

}
