import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverterBySakshi
{
    
    public static void main(String[] args) throws Exception 
    {
        //UIDesign Starts
        JFrame frame = new JFrame();

        JLabel nameofapp = new JLabel("Currency Converter");
        nameofapp.setBounds(120,50,320,80);
        nameofapp.setFont(new Font("Serif",Font.BOLD,28));
        nameofapp.setForeground(new Color(135,206,235));
        frame.add(nameofapp);

        JLabel ConvertedAmount = new JLabel("000000.00");
        ConvertedAmount.setBounds(180,120,320,80);
        ConvertedAmount.setFont(new Font("Serif",Font.BOLD,32));
        ConvertedAmount.setForeground(new Color(224, 224, 224));
        ConvertedAmount.setToolTipText("This is converted amount");
        frame.add(ConvertedAmount);

        JLabel l = new JLabel("Amount To Convert");
        l.setBounds(50,200,140,30);
        l.setFont(new Font("Serif",Font.BOLD,15));
        l.setForeground(new Color(135,206,235));
        frame.add(l);

        JTextField Amount;
        Amount = new JTextField();
        Amount.setBounds(50,230,400,50);
        Amount.setFont(new Font("Serif",Font.BOLD,20));
        Amount.setBackground(new Color(204, 204, 255));
        Amount.setToolTipText("Only enter digits here");
        frame.add(Amount);

        JLabel l1 = new JLabel("Convert From");
        l1.setBounds(50,320,140,30);
        l1.setFont(new Font("Serif",Font.BOLD,15));
        l1.setForeground(new Color(135,206,235));
        frame.add(l1);

        String currencylist[] = {"Select Currency","INR ","USD ","KRW ","CAD ","GBP ","JPY ","EUR ","BTC "};
        JComboBox from = new JComboBox(currencylist);
        from.setBounds(50,350,180,40);
        from.setBackground(new Color(204, 204, 255));
        frame.add(from);

        JLabel l2 = new JLabel("Convert To");
        l2.setBounds(270,320,140,30);
        l2.setFont(new Font("Serif",Font.BOLD,15));
        l2.setForeground(new Color(135,206,235));
        frame.add(l2);

        JComboBox to = new JComboBox(currencylist);
        to.setBounds(270,350,180,40);
        to.setBackground(new Color(204, 204, 255));
        frame.add(to);

        JButton convertbtn = new JButton("Convert");
        convertbtn.setBounds(150,500,80,40);
        convertbtn.setBackground(new Color(229, 255, 204));
        frame.add(convertbtn);

        JButton clearbtn = new JButton("Clear");
        clearbtn.setBounds(250,500,80,40);
        clearbtn.setBackground(new Color(255, 204, 255));
        frame.add(clearbtn);

        JLabel errormsg = new JLabel();
        errormsg.setBounds(130,550,320,40);
        errormsg.setFont(new Font("Serif",Font.ITALIC,20));
        errormsg.setForeground(new Color(255, 0, 0));
        frame.add(errormsg);
        //UI Design Ends

        //Code to convert the currencies.
        convertbtn.addActionListener((ActionListener) new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {               
                //Type conversion to convert the object value into string for comparision and Calculations.
                String selectedfrom = (String) from.getSelectedItem();
                String selectedto = (String) to.getSelectedItem();
                String amt = (String) Amount.getText();
                                
                if(selectedfrom == selectedto) //Checks whether the From and To selection is same or not.
                {
                    errormsg.setText("You've selected same currency.");
                    errormsg.setVisible(true);
                }
                else if(selectedfrom != "Select Currency" && selectedto =="Select Currency") //Checks whether both currencies are selected or not.
                {
                    errormsg.setText("Please select currency.");
                    errormsg.setVisible(true);
                }
                else if(selectedfrom == "Select Currency" && selectedto !="Select Currency") //Checks whether both currencies are selected or not.
                {
                    errormsg.setText("Please select currency.");
                    errormsg.setVisible(true);
                }
                else
                {
                    errormsg.setVisible(false); //Everything is fine so now we can erase the error msg if-invoked earlier by this statement.
                    String FromOption = selectedfrom.toString();
                    String ToOption = selectedto.toString();
                    double amount = Double.parseDouble(amt);

                    if(FromOption == currencylist[1])//Convert from Indian Rupees
                    {
                        if(ToOption == currencylist[2])// To USD
                        {
                            
                            double amountconverted = (amount*0.01209); //amounttoconvert is multiplied with the currency's exchange rate.
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);//Double to String Conversion for displaying answer using JLabel.
                            ConvertedAmount.setText("$ "+temp);
                        }
                        else if(ToOption == currencylist[3])// To KRW
                        {
                             
                            double amountconverted = (amount*15.76);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20A9 "+temp);//Currency Symbol value.
                        }
                        else if(ToOption == currencylist[4])// To CAD
                        {
                             
                            double amountconverted = (amount*0.02);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("CA$ "+temp);
                        }
                        else if(ToOption == currencylist[5])// To GBP
                        {
                             
                            double amountconverted = (amount*0.01);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A3 "+temp);
                        }
                        else if(ToOption == currencylist[6])// To JPY
                        {
                             
                            double amountconverted = (amount*1.71);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A5 "+temp);
                        }
                        else if(ToOption == currencylist[7])// To EUR
                        {
                             
                            double amountconverted = (amount*0.011);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20AC "+temp);
                        }
                        else if(ToOption == currencylist[8])// To BTC
                        {
                             
                            double amountconverted = (amount*0.00000042);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20BF "+temp);
                        }
                    }
                    else if(FromOption == currencylist[2])// From United State Dollars
                    {
                        if(ToOption == currencylist[1])// To INR
                        {
                             
                            double amountconverted = (amount*82.67);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20B9 "+temp);
                        }
                        else if(ToOption == currencylist[3])// To KRW
                        {
                             
                            double amountconverted = (amount*1304.08);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20A9 "+temp);
                        }
                        else if(ToOption == currencylist[4])// To CAD
                        {
                             
                            double amountconverted = (amount*1.34);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("CA$ "+temp);
                        }
                        else if(ToOption == currencylist[5])// To GBP
                        {
                             
                            double amountconverted = (amount*0.78);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A3 "+temp);
                        }
                        else if(ToOption == currencylist[6])// To JPY
                        {
                             
                            double amountconverted = (amount*141.75);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A5 "+temp);
                        }
                        else if(ToOption == currencylist[7])// To EUR
                        {
                             
                            double amountconverted = (amount*0.91);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20AC "+temp);
                        }
                        else if(ToOption == currencylist[8])// To BTC
                        {
                            
                            double amountconverted = (amount*0.000034);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20BF "+temp);
                        }
                    }
                    else if(FromOption == currencylist[3])// From Korean Won
                    {
                        if(ToOption == currencylist[1])// To INR
                        {
                            double amountconverted = (amount*0.063);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20B9 "+temp);
                        }
                        else if(ToOption == currencylist[2])// To USD
                        {
                            double amountconverted = (amount*0.00077);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("$ "+temp);
                        }
                        else if(ToOption == currencylist[4])// To CAD
                        {
                            double amountconverted = (amount*0.0010);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("CA$ "+temp);
                        }
                        else if(ToOption == currencylist[5])// To GBP
                        {
                            double amountconverted = (amount*0.00060);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A3 "+temp);
                        }
                        else if(ToOption == currencylist[6])// To JPY
                        {
                            double amountconverted = (amount*0.11);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A5 "+temp);
                        }
                        else if(ToOption == currencylist[7])// To EUR
                        {
                            double amountconverted = (amount*0.00070);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20AC "+temp);
                        }
                        else if(ToOption == currencylist[8])// To BTC
                        {
                            double amountconverted = (amount*0.000000026);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20BF "+temp);
                        }
                    }
                    else if(FromOption == currencylist[4])// From CAD
                    {
                        if(ToOption == currencylist[1])// To INR
                        {
                            double amountconverted = (amount*61.81);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20B9 "+temp);
                        }
                        else if(ToOption == currencylist[2])// To USD
                        {
                            double amountconverted = (amount*0.75);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("$ "+temp);
                        }
                        else if(ToOption == currencylist[3])// To KRW
                        {
                            double amountconverted = (amount*975.09);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20A9 "+temp);
                        }
                        else if(ToOption == currencylist[5])// To GBP
                        {
                            double amountconverted = (amount*0.59);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A3 "+temp);
                        }
                        else if(ToOption == currencylist[6])// To JPY
                        {
                            double amountconverted = (amount*105.99);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A5 "+temp);
                        }
                        else if(ToOption == currencylist[7])// To EUR
                        {
                            double amountconverted = (amount*0.68);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20AC "+temp);
                        }
                        else if(ToOption == currencylist[8])// To BTC
                        {
                            double amountconverted = (amount*0.000026);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20BF "+temp);
                        }
                    }
                    else if(FromOption == currencylist[5])// From British pound GBP
                    {
                        if(ToOption == currencylist[1])// To INR
                        {
                            double amountconverted = (amount*105.39);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20B9 "+temp);
                        }
                        else if(ToOption == currencylist[2])// To USD
                        {
                            double amountconverted = (amount*1.27);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("$ "+temp);
                        }
                        else if(ToOption == currencylist[3])// To KRW
                        {
                            double amountconverted = (amount*1662.44);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20A9 "+temp);
                        }
                        else if(ToOption == currencylist[4])// To CAD
                        {
                            double amountconverted = (amount*1.70);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("CA$ "+temp);
                        }
                        else if(ToOption == currencylist[6])// To JPY
                        {
                            double amountconverted = (amount*180.70);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A5 "+temp);
                        }
                        else if(ToOption == currencylist[7])// To EUR
                        {
                            double amountconverted = (amount*1.16);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20AC "+temp);
                        }
                        else if(ToOption == currencylist[8])// To BTC
                        {
                            double amountconverted = (amount*0.000044);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20BF "+temp);
                        }
                    }
                    else if(FromOption == currencylist[6])//From JPY
                    {
                        if(ToOption == currencylist[1])// To INR
                        {
                            double amountconverted = (amount*0.58);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20B9 "+temp);
                        }
                        else if(ToOption == currencylist[2])// To USD
                        {
                            double amountconverted = (amount*0.01);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("$ "+temp);
                        }
                        else if(ToOption == currencylist[3])// To KRW
                        {
                            double amountconverted = (amount*9.20);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20A9 "+temp);
                        }
                        else if(ToOption == currencylist[4])// To CAD
                        {
                            double amountconverted = (amount*0.01);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("CA$ "+temp);
                        }
                        else if(ToOption == currencylist[5])// To GBP
                        {
                            double amountconverted = (amount*0.01);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A3 "+temp);
                        }
                        else if(ToOption == currencylist[7])// To EUR
                        {
                            double amountconverted = (amount*0.01);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20AC "+temp);
                        }
                        else if(ToOption == currencylist[8])// To BTC
                        {
                            double amountconverted = (amount*0.00000024);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20BF "+temp);
                        }
                    }
                    else if(FromOption == currencylist[7])// From European Currency Euro
                    {
                        if(ToOption == currencylist[1])// To INR
                        {
                            double amountconverted = (amount*91.02);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20B9 "+temp);
                        }
                        else if(ToOption == currencylist[2])// To USD
                        {
                            double amountconverted = (amount*1.10);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("$ "+temp);
                        }
                        else if(ToOption == currencylist[3])// To KRW
                        {
                            double amountconverted = (amount*1435.79);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20A9 "+temp);
                        }
                        else if(ToOption == currencylist[4])// To CAD
                        {
                            double amountconverted = (amount*1.47);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("CA$ "+temp);
                        }
                        else if(ToOption == currencylist[5])// To GBP
                        {
                            double amountconverted = (amount*0.86);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A3 "+temp);
                        }
                        else if(ToOption == currencylist[6])// To JPY
                        {
                            double amountconverted = (amount*156.07);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A5 "+temp);
                        }
                        else if(ToOption == currencylist[8])// To BTC
                        {
                            double amountconverted = (amount*0.000038);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20BF "+temp);
                        }
                    }
                    else if(FromOption == currencylist[8])// From Bitcon
                    {
                        if(ToOption == currencylist[1])// To INR
                        {
                            double amountconverted = (amount*2397537);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20B9 "+temp);
                        }
                        else if(ToOption == currencylist[2])// To USD
                        {
                            double amountconverted = (amount*29006);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("$ "+temp);
                        }
                        else if(ToOption == currencylist[3])// To KRW
                        {
                            double amountconverted = (amount*37826731);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20A9 "+temp);
                        }
                        else if(ToOption == currencylist[4])// To CAD
                        {
                            double amountconverted = (amount*38783.04);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("CA$ "+temp);
                        }
                        else if(ToOption == currencylist[5])// To GBP
                        {
                            double amountconverted = (amount*22742.31);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A3 "+temp);
                        }
                        else if(ToOption == currencylist[6])// To JPY
                        {
                            
                            double amountconverted = (amount*4111033.50);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u00A5 "+temp);
                        }
                        else if(ToOption == currencylist[7])// To EUR
                        {
                            double amountconverted = (amount*26337.63);
                            BigDecimal bd = new BigDecimal(amountconverted).setScale(2, RoundingMode.HALF_UP); 
                            double amnt = bd.doubleValue(); 
                            String temp = String.valueOf(amnt);
                            ConvertedAmount.setText("\u20AC "+temp);
                        }
                    }
                }
            }  
        });
        clearbtn.addActionListener((ActionListener) new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                //Clears the selection
                ConvertedAmount.setText("000000.00");
                Amount.setText(" ");
                from.setSelectedIndex(0);
                to.setSelectedIndex(0);
                errormsg.setVisible(false);
            }        
        });
        
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.CYAN)); //adds Border to App
        frame.setSize(500,700);
        frame.setLayout(null);
        frame.setResizable(false);//App's Height and Width will be of fixed size
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }
}