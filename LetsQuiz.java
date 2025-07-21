import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Q2 extends JDialog{
    private int score;
    public Q2(Q1 frame, int prevScore)
    {
        super(frame,"Questions",true);
        this.score=prevScore;
        Container contain=getContentPane();
        contain.setLayout(null);
        JLabel begin=new JLabel("Question: 2");
        begin.setBounds(30,20,100,30);
        contain.add(begin);

        JLabel question=new JLabel("2. Who invented JAVA?");
        question.setBounds(30,50,400,30);
        contain.add(question);

        JRadioButton name1=new JRadioButton("Dennis Ritchie");
        name1.setBounds(30,80,200,30);

        JRadioButton name2=new JRadioButton("Guido van Rossum");
        name2.setBounds(30,110,200,30);

        JRadioButton name3=new JRadioButton("James Gosling");
        name3.setBounds(30,140,200,30);

        JRadioButton name4=new JRadioButton("Bjarne Stroustrup");
        name4.setBounds(30,170,200,30);

        ButtonGroup bg=new ButtonGroup();
        bg.add(name1);
        bg.add(name2);
        bg.add(name3);
        bg.add(name4);

        contain.add(name1);
        contain.add(name2);
        contain.add(name3);
        contain.add(name4);

        JButton next=new JButton("Submit");
        next.setBounds(60,230,100,30);
        contain.add(next);
        next.addActionListener(e->{
            if(name3.isSelected())
            {
                score++;
            }
            dispose();
        });

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(200,230,100,30);
        contain.add(cancel);
        cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
          setSize(450,450);
    }
    public int getScore()
    {
        return score;
    }
}

class Q1 extends JDialog{
    private int score=0;
    public Q1(LetsQuiz frame)
    {
        super(frame,"Questions",true);
        Container contain=getContentPane();
        contain.setLayout(null);
        JLabel begin=new JLabel("Question: 1");
        begin.setBounds(30,20,100,30);
        contain.add(begin);

        JLabel question=new JLabel("1. What is the capital city of France?");
        question.setBounds(30,50,400,30);
        contain.add(question);

        JRadioButton milan=new JRadioButton("Milan");
        milan.setBounds(30,80,200,30);

        JRadioButton paris=new JRadioButton("Paris");
        paris.setBounds(30,110,200,30);

        JRadioButton dc=new JRadioButton("Washington D.C");
        dc.setBounds(30,140,200,30);

        JRadioButton berlin=new JRadioButton("Berlin");
        berlin.setBounds(30,170,200,30);

        ButtonGroup bg=new ButtonGroup();
        bg.add(paris);
        bg.add(milan);
        bg.add(berlin);
        bg.add(dc);

        contain.add(paris);
        contain.add(berlin);
        contain.add(dc);
        contain.add(milan);
       
        JButton next=new JButton("Next");
        next.setBounds(60,230,100,30);
        contain.add(next);
           next.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
        if(!paris.isSelected() && !berlin.isSelected() && !dc.isSelected() && !milan.isSelected())
        {
          JOptionPane.showMessageDialog(Q1.this,"Please choose the answer to proceed further",
                                                "Message",JOptionPane.ERROR_MESSAGE);
                 }
            if(paris.isSelected())
                {
                    score++;
                }
                Q2 q2=new Q2(Q1.this,score);
                q2.setVisible(true);

                int finalScore=q2.getScore();
                JOptionPane.showMessageDialog(Q1.this,"You Scored: "+finalScore+" /2",
                                                "Result",JOptionPane.INFORMATION_MESSAGE);
                dispose();
               
            }
        });
        

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(200,230,100,30);
        contain.add(cancel);
        cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        setSize(450,450);
    }
}

public class LetsQuiz extends JFrame{
    public LetsQuiz()
    {
        Container contain=getContentPane();
        contain.setLayout(new GridBagLayout());
        
        // JPanel p1=new JPanel(new BorderLayout());
        // p1.add(new JButton("Start Quiz"),BorderLayout.CENTER);
        // contain.add(p1);

        JButton startB=new JButton("Start Quiz");
        contain.add(startB,new GridBagConstraints());
        startB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Q1 q=new Q1(LetsQuiz.this);
                q.setVisible(true);
            }
        });

        setSize(400,400);
        setTitle("Let's Quiz");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LetsQuiz();
    }
}
