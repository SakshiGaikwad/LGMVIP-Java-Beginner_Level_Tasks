/* The Tic Tac Toe Game */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;

public class GameApp implements ItemListener
{   
    static JFrame frame = new JFrame(); //Window

    JPanel up = new JPanel();   //Upper Panel
    JLabel nameofgame = new JLabel();
    JPanel right = new JPanel(); 
    JLabel turn2 = new JLabel();    //label for panel 2
    JPanel middle = new JPanel();   //Middle Panel
    JPanel left = new JPanel(); 
    JLabel turn1 = new JLabel();    //label for panel 1
    JPanel down = new JPanel(new FlowLayout()); //Lower Panel
    
    //Buttons in Lower Panel
    JButton exitbtn = new JButton();
    JButton newgamebtn = new JButton();
    
    //below button is for new feature
    //JButton playwithbotbtn = new JButton();
    
    //Board of Game
    JPanel GameBoard = new JPanel();

    //Blocks
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();

    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();

    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton();

    //Status of play
    JLabel status = new JLabel();

    //Label for players
    JLabel Player2 = new JLabel();
    JLabel Player1 = new JLabel();

    //Label for welcome message display
    JLabel greet = new JLabel();

    //A Variable for choosing X or O
    private JToggleButton OorX;

    //Label to indicate the option to perform
    JLabel notify = new JLabel("    Ready ?     Click on - >         ");

    //Custom colors used in GUI
    Color lightred = new Color(255,102,102);
    Color lightyellow = new Color(253,255,179);
    Color f = new Color(255,255,167);
    Color b = new Color(62,12,36);
    Color Bnew = new Color(193,30,100);
    Color Fnew = new Color(255,255,255);
    Color Bn = new Color(40,72,100);
    Color Y = new Color(95,196,255);
    Color boardBack = new Color(227, 244, 255);

    //String that stores the content of all buttons and toggle button to process and check win
    String con1,con2,con3,con4,con5,con6,con7,con8,con9,selection;

    //Labels
    JLabel o = new JLabel("O");
    JLabel x = new JLabel("X");
    
    public GameApp()
    {
       //Buidling the Game GUI
        frame.setTitle("Tic - Tac - Toe Game by Sakshi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setLayout((LayoutManager) new BorderLayout(5,5));

        //Name of Game displayed in upper panel
        nameofgame.setText("Tic - Tac - Toe Game");
        nameofgame.setForeground(Fnew);
        nameofgame.setBounds(100, 100, 200, 50);
        nameofgame.setFont(new Font("Broadway" ,Font.BOLD,35));
        up.add(nameofgame);

        //Player 2 Window
        Player2.setText("PLAYER 2");
        Player2.setForeground(Color.WHITE);
        Player2.setFont(new Font("Times New Roman",Font.BOLD,25));
        right.add(Player2);

        //Name of player
        turn2.setText("Name : XYZ");
        turn2.setFont(new Font("Times New Roman",Font.BOLD,24));
        turn2.setForeground(Y);
        x.setFont(new Font("Times New Roman",Font.BOLD,45));
        x.setVisible(true);
        x.setForeground(Y);
        right.add(turn2);
        right.add(x);

        //Middle window greeting message
        greet.setText("W E L C O M E");
        greet.setFont(new Font("Helvatica",Font.BOLD,15));
        greet.setForeground(Bn);
        middle.add(greet);

        //Player 1 Window 
        Player1.setText("PLAYER 1");
        Player1.setForeground(Color.WHITE);
        Player1.setFont(new Font("Times New Roman",Font.BOLD,25));
        left.add(Player1);

        //Name of player
        turn1.setText("Name : ABC");
        turn1.setFont(new Font("Times New Roman",Font.BOLD,24));
        turn1.setForeground(Y);
        o.setFont(new Font("Times New Roman",Font.BOLD,45));
        o.setVisible(true);
        o.setForeground(Y);
        left.add(turn1);
        left.add(o);

        //Buttons
        exitbtn.setText(" Exit ");
        exitbtn.setForeground(Color.WHITE);
        exitbtn.setBackground(Color.BLUE);
        
        newgamebtn.setText(" New Game ");
        newgamebtn.setForeground(Color.BLACK);
        newgamebtn.setBackground(Color.GREEN);

        //playwithbotbtn.setText(" Play with Computer ");
        //playwithbotbtn.setBackground(Color.YELLOW);

        //adding the buttons to lower panel
        down.add(newgamebtn);
        down.add(exitbtn);
        //down.add(playwithbotbtn);
        
        //Background of every panel
        up.setBackground(Bnew);
        left.setBackground(Bn);
        middle.setBackground(Color.WHITE);
        right.setBackground(Bn);
        down.setBackground(Bnew);

        //setting the custom size of each panel
        up.setPreferredSize(new Dimension(100, 100));
        left.setPreferredSize(new Dimension(150, 100));
        middle.setPreferredSize(new Dimension(100, 100));
        right.setPreferredSize(new Dimension(150, 100));
        down.setPreferredSize(new Dimension(100, 100));

        //Creating a Board inside middle panel
        GameBoard.setLayout(new GridLayout(3, 3));
        GameBoard.setVisible(true);

        //Buttons inside board 
        b1 = new JButton(" ");
        b1.setBackground(boardBack);
        b1.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));//setting border to each block
        b2 = new JButton(" ");
        b2.setBackground(boardBack);
        b2.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));
        b3 = new JButton(" ");
        b3.setBackground(boardBack);
        b3.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));

        b4 = new JButton(" ");
        b4.setBackground(boardBack);
        b4.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));
        b5 = new JButton(" ");
        b5.setBackground(boardBack);
        b5.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));
        b6 = new JButton(" ");
        b6.setBackground(boardBack);
        b6.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));

        b7 = new JButton(" ");
        b7.setBackground(boardBack);
        b7.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));
        b8 = new JButton(" ");
        b8.setBackground(boardBack);
        b8.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));
        b9 = new JButton(" ");
        b9.setBackground(boardBack);
        b9.setBorder(BorderFactory.createMatteBorder(1,1,1,1,b));
        
        GameBoard.add(b1);
        GameBoard.add(b2);
        GameBoard.add(b3);

        GameBoard.add(b4);
        GameBoard.add(b5);
        GameBoard.add(b6);

        GameBoard.add(b7);
        GameBoard.add(b8);
        GameBoard.add(b9);

        GameBoard.setPreferredSize(new Dimension(290, 300));
        middle.add(GameBoard);

        status.setText("           Status : Game Started !                 ");
        status.setFont(new Font("Times New Roman",Font.BOLD,15));
        status.setForeground(Bn);
        middle.add(status);
        
        notify.setForeground(Bn);
        middle.add(notify);

        //Making a call to toggle button method
        setJToggleButton();  
        setAction();

        frame.add(up,BorderLayout.NORTH);
        frame.add(right,BorderLayout.EAST);
        frame.add(middle,BorderLayout.CENTER);
        frame.add(left,BorderLayout.WEST);
        frame.add(down,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(5,2,10,2,Color.WHITE));

        newgamebtn.addActionListener((ActionListener) new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clearBoard();
                status.setText("           Status : New Game Started !                 ");
                turn2.setText(" Name : XYZ ");
                OorX.setText("Go");

                b1.setBackground(boardBack);
                b2.setBackground(boardBack);
                b3.setBackground(boardBack);

                b4.setBackground(boardBack);
                b5.setBackground(boardBack);
                b6.setBackground(boardBack);

                b7.setBackground(boardBack);
                b8.setBackground(boardBack);
                b9.setBackground(boardBack);

                //every button's previous content is cleared in new game
                b1.setText(" ");
                b2.setText(" ");
                b3.setText(" ");
                
                b4.setText(" ");
                b5.setText(" ");
                b6.setText(" ");

                b7.setText(" ");
                b8.setText(" ");
                b9.setText(" ");

                //clearing the button's content previously stored during the previous game 
                con1 = " ";
                con2 = " ";
                con3 = " ";

                con4 = " ";
                con5 = " ";
                con6 = " ";

                con7 = " ";
                con8 = " ";
                con9 = " ";

                //checking the Tie or Win
                checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
            }
        });

        exitbtn.addActionListener((ActionListener) new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
            }
        });
        /*
        playwithbotbtn.addActionListener((ActionListener) new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                clearBoard();
                status.setText("Status : Playing with Computer !");
                turn2.setText(" Computer ");
            }
        });
        */
    }

    //Methods coding
    private void setJToggleButton() {  
        OorX = new JToggleButton("Go");  
        OorX.setFont(new Font("Times New Roman", Font.BOLD, 45));
        OorX.setSize(200, 200);
        OorX.setBackground(b);
        OorX.setForeground(f);
        middle.add(OorX);  
    }  
    private void setAction() {  
        OorX.addItemListener(this);
    }  
    public void itemStateChanged(ItemEvent e) {  
        if(OorX.isSelected())
        {  
            OorX.setText("X"); 
            OorX.setBackground(b);
            OorX.setForeground(f);
            checkBoard();
        }
        else  
        {
            OorX.setText("O"); 
            OorX.setBackground(b);
            OorX.setForeground(f);
            checkBoard();
        }
        
        String temp = OorX.getText();

        if(temp == "X")
        {
            status.setForeground(Bn);
            status.setText("            It's Player 2's Turn Now            ");
            checkTie(con1, con2, con3, con4, con5, con6, con7, con8, con9); 
        }
        else if(temp == "O")
        {
            status.setForeground(Bn);
            status.setText("            It's Player 1's Turn Now            ");
            checkTie(con1, con2, con3, con4, con5, con6, con7, con8, con9); 
        }
    
    }   
    public void checkBoard()
    {
        con1 = b1.getText();
        con2 = b2.getText();
        con3 = b3.getText();
        con4 = b4.getText();
        con5 = b5.getText();
        con6 = b6.getText();
        con7 = b7.getText();
        con8 = b8.getText();
        con9 = b9.getText();
        selection = OorX.getText();

        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    method1(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
            
        }});

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    method2(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
                
            }
            
        });

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    method3(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
            }
            
        });

        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    method4(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);

            }
            
        });

        b5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    method5(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
            }
            
        });

        b6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    method6(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
            }
            
        });

        b7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    method7(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
            }
            
        });

        b8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    method8(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
            }
            
        });

        b9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    method9(con1,con2,con3,con4,con5,con6,con7,con8,con9,selection);
                    checkWin(con1,con2,con3,con4,con5,con6,con7,con8,con9);
            }
            
        });
        
    }
    public void ColorBoardwithRedColor()
    {
        b1.setBackground(lightred);
        b2.setBackground(lightred);
        b3.setBackground(lightred);

        b4.setBackground(lightred);
        b5.setBackground(lightred);
        b6.setBackground(lightred);

        b7.setBackground(lightred);
        b8.setBackground(lightred);
        b9.setBackground(lightred);
    }
    public void checkTie(String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9)
    {
        checkWin(c1,c2,c3,c4,c5,c6,c7,c8,c9);     //check win    
    }
    public void checkWin(String t1, String t2,String t3,String t4,String t5,String t6,String t7,String t8,String t9)
    {
        checkRowWin(t1,t2,t3,t4,t5,t6,t7,t8,t9);
        checkColumnWin(t1,t2,t3,t4,t5,t6,t7,t8,t9);
        checkDiagonal(t1,t2,t3,t4,t5,t6,t7,t8,t9);
        
    }
    public void checkRowWin(String ct1, String ct2,String ct3,String ct4,String ct5,String ct6,String ct7,String ct8,String ct9)
    {
        if( (ct1 == "X" && ct2 == "X" && ct3 == "X") )
        {
            status.setText("             Status : X Wins the Game            ");
            b1.setBackground(Color.GREEN);
            b2.setBackground(Color.GREEN);
            b3.setBackground(Color.GREEN);
        
        }
        else if(ct4 == "X" && ct5 == "X" && ct6 == "X")
        {
            status.setText("            Status : X Wins the Game            ");
            b4.setBackground(Color.GREEN);
            b5.setBackground(Color.GREEN);
            b6.setBackground(Color.GREEN);
        }
        else if(ct7 == "X" && ct8 == "X" && ct9 == "X")
        {
            status.setText("            Status : X Wins the Game            ");
            b7.setBackground(Color.GREEN);
            b8.setBackground(Color.GREEN);
            b9.setBackground(Color.GREEN);
        }
        else if((ct1 == "O" && ct2 == "O" && ct3 == "O"))
        {
            status.setText("            Status : O Wins the Game            ");
            b1.setBackground(Color.GREEN);
            b2.setBackground(Color.GREEN);
            b3.setBackground(Color.GREEN);

        }
        else if(ct4 == "O" && ct5 == "O" && ct6 == "O")
        {
            status.setText("            Status : O Wins the Game            ");
            b4.setBackground(Color.GREEN);
            b5.setBackground(Color.GREEN);
            b6.setBackground(Color.GREEN);
        }
        else if(ct7 == "O" && ct8 == "O" && ct9 == "O")
        {
            status.setText("            Status : O Wins the Game            ");
            b7.setBackground(Color.GREEN);
            b8.setBackground(Color.GREEN);
            b9.setBackground(Color.GREEN);
        }
        else if(ct1 != " " && ct2 != " " && ct3 != " " && ct4 != " " && ct5 != " " && ct6 != " " && ct7 != " " && ct8 != " " && ct9 != " ")
        {
            status.setText("            Status : It's a Tie Game Over            ");
            ColorBoardwithRedColor();
        }        
    }
    public void checkColumnWin(String ct1, String ct2,String ct3,String ct4,String ct5,String ct6,String ct7,String ct8,String ct9)
    {
        if( (ct1 == "X" && ct4 == "X" && ct7 == "X") )
        {
            status.setText("            Status : X Wins the Game            ");    
            b1.setBackground(Color.GREEN);
            b4.setBackground(Color.GREEN);
            b7.setBackground(Color.GREEN);           

        }
        else if(ct2 == "X" && ct5 == "X" && ct8 == "X")
        {
            status.setText("            Status : X Wins the Game            ");    
            b2.setBackground(Color.GREEN);
            b5.setBackground(Color.GREEN);
            b8.setBackground(Color.GREEN);  
        }
        else if(ct3 == "X" && ct6 == "X" && ct9 == "X")
        {
            status.setText("            Status : X Wins the Game            ");    
            b3.setBackground(Color.GREEN);
            b6.setBackground(Color.GREEN);
            b9.setBackground(Color.GREEN);  
        }
        else if(ct1 == "O" && ct4 == "O" && ct7 == "O")
        {
            status.setText("            Status : O Wins the Game            ");
            b1.setBackground(Color.GREEN);
            b4.setBackground(Color.GREEN);
            b7.setBackground(Color.GREEN);

        }
        else if(ct2 == "O" && ct5 == "O" && ct8 == "O")
        {
            status.setText("            Status : O Wins the Game            ");
            b2.setBackground(Color.GREEN);
            b5.setBackground(Color.GREEN);
            b8.setBackground(Color.GREEN);
        }
        else if(ct3 == "O" && ct6 == "O" && ct9 == "O")
        {
            status.setText("            Status : O Wins the Game            ");
            b3.setBackground(Color.GREEN);
            b6.setBackground(Color.GREEN);
            b9.setBackground(Color.GREEN);
        }
        else if(ct1 != " " && ct2 != " " && ct3 != " " && ct4 != " " && ct5 != " " && ct6 != " " && ct7 != " " && ct8 != " " && ct9 != " ")
        {
            status.setText("            Status : It's a Tie Game Over            ");       
            ColorBoardwithRedColor();       

        }
    }
    public void checkDiagonal(String ct1, String ct2,String ct3,String ct4,String ct5,String ct6,String ct7,String ct8,String ct9)
    {
        if(ct1 == "X" && ct5 == "X" && ct9 == "X") 
        {
            status.setText("            Status : X Wins the Game            ");    
            b1.setBackground(Color.GREEN);
            b5.setBackground(Color.GREEN);
            b9.setBackground(Color.GREEN);                 

        }
        else if(ct3 == "X" && ct5 == "X" && ct7 == "X")
        {
            status.setText("            Status : X Wins the Game            ");    
            b3.setBackground(Color.GREEN);
            b5.setBackground(Color.GREEN);
            b7.setBackground(Color.GREEN);
        }
        else if((ct1 == "O" && ct5 == "O" && ct9 == "O") )
        {
            status.setText("            Status : O Wins the Game            ");
            b1.setBackground(Color.GREEN);
            b5.setBackground(Color.GREEN);
            b9.setBackground(Color.GREEN);               

        }
        else if(ct3 == "O" && ct5 == "O" && ct7 == "O")
        {
            status.setText("            Status : O Wins the Game            ");
            b3.setBackground(Color.GREEN);
            b5.setBackground(Color.GREEN);
            b7.setBackground(Color.GREEN); 
        }
        else if(ct1 != " " && ct2 != " " && ct3 != " " && ct4 != " " && ct5 != " " && ct6 != " " && ct7 != " " && ct8 != " " && ct9 != " ")
        {
            status.setText("            Status : It's a Tie Game Over            ");
            ColorBoardwithRedColor();
        }

    }
    public void method1(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9,String selection)
    {
        //checks button 1 activities
        if(content1.equals(" ") && selection.equals("O") )
        {
            b1.setText("O");
            b1.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b1.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content1.equals(" ") && selection.equals("X"))
        {
            b1.setText("X");
            b1.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b1.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content1.equals("O") || content1.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content1 = " ";
    } 
    public void method2(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9, String selection)
    {
        //check button 2's activities
        if(content2.equals(" ") && selection.equals("O") )
        {
            b2.setText("O");
            b2.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b2.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content2.equals(" ") && selection.equals("X"))
        {
            b2.setText("X");
            b2.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b2.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content2.equals("O") || content2.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content2 = " ";
    }
    public void method3(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9, String selection)
    {
        //check button 3's activites
        if(content3.equals(" ") && selection.equals("O") )
        {
            b3.setText("O");
            b3.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b3.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content3.equals(" ") && selection.equals("X"))
        {
            b3.setText("X");
            b3.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b3.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content3.equals("O") || content3.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content3 = " ";
    }
    public void method4(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9, String selection)
    {
        //check button 4's activites
        if(content4.equals(" ") && selection.equals("O") )
        {
            b4.setText("O");
            b4.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b4.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content4.equals(" ") && selection.equals("X"))
        {
            b4.setText("X");
            b4.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b4.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content4.equals("O") || content4.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content4 = " ";
    }
    public void method5(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9, String selection)
    {
        //check button 5's activites
        if(content5.equals(" ") && selection.equals("O") )
        {
            b5.setText("O");
            b5.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b5.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content5.equals(" ") && selection.equals("X"))
        {
            b5.setText("X");
            b5.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b5.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content5.equals("O") || content5.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content5 = " ";
    }
    public void method6(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9, String selection)
    {
        //check button 6's activites
        if(content6.equals(" ") && selection.equals("O") )
        {
            b6.setText("O");
            b6.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b6.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content6.equals(" ") && selection.equals("X"))
        {
            b6.setText("X");
            b6.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b6.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);    
        }
        else if(content6.equals("O") || content6.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content6 = " ";
    }
    public void method7(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9, String selection)
    {
        //check button 7's activites
        if(content7.equals(" ") && selection.equals("O") )
        {
            b7.setText("O");
            b7.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b7.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content7.equals(" ") && selection.equals("X"))
        {
            b7.setText("X");
            b7.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b7.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content7.equals("O") || content7.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content7 = " ";
    }
    public void method8(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9, String selection)
    {
        //check button 8's activites
        if(content8.equals(" ") && selection.equals("O") )
        {
            b8.setText("O");
            b8.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b8.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content8.equals(" ") && selection.equals("X"))
        {
            b8.setText("X");
            b8.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b8.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content8.equals("O") || content8.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content8 = " "; 
    }
    public void method9(String content1,String content2,String content3, String content4, String content5, String content6, String content7, String content8, String content9, String selection)
    {
        //check button 9's activites
        if(content9.equals(" ") && selection.equals("O") )
        {
            b9.setText("O");
            b9.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b9.setForeground(Color.RED);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content9.equals(" ") && selection.equals("X"))
        {
            b9.setText("X");
            b9.setFont(new Font("Times New Roman", Font.BOLD, 35));
            b9.setForeground(Color.BLUE);
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        else if(content9.equals("O") || content9.equals("X"))
        {
            checkTie(content1,content2,content3,content4,content5,content6,content7,content8,content9);
        }
        checkTie(content1, content2, content3, content4, content5, content6, content7, content8, content9);
        content9 = " ";
    }
    public void clearBoard()
    {
        //clears every buttons display content 
        b1.setText(" ");
        b2.setText(" ");
        b3.setText(" ");
        b4.setText(" ");
        b5.setText(" ");
        b6.setText(" ");
        b7.setText(" ");
        b8.setText(" ");
        b9.setText(" ");
    }
    
    public static void main(String []args)
    {
        //initialize the game gui and start to play
        new GameApp();
    }
}
