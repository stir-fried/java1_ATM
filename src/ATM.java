//Javier Colon

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ATM {
    private JPanel myATM;
    private JButton balanceJB;
    private JButton depositJB;
    private JButton withdrawJB;
    private JButton exitJB;
    private JPanel tabs;
    private JPanel mainPage;
    private JLabel imageJL;
    private JTextArea balanceJTA;
    private JPanel balancePage;
    private JPanel withdrawPage;
    private JPanel depositPage;
    private JTextArea withdrawJTA;
    private JTextArea depositJTA;
    private JButton with10;
    private JButton with20;
    private JButton with50;
    private JButton with100;
    private JButton withSubmit;
    private JButton depo10;
    private JButton depo20;
    private JButton depo50;
    private JButton depo100;
    private JButton depoSubmit;

    private BankAccount myAccount = new BankAccount();
    private int totalWithdraw = 0;
    private int totalDeposit = 0;


    public ATM() {
        ImageIcon img = new ImageIcon("Resources/stcc_logo.png");
        imageJL.setIcon(img);
        balancePage.setVisible(false);
        withdrawPage.setVisible(false);
        depositPage.setVisible(false);
        balanceJTA.setEditable(false);
        withdrawJTA.setEditable(false);
        depositJTA.setEditable(false);


        exitJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        balanceJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPage.setVisible(false);
                balancePage.setVisible(true);
                depositPage.setVisible(false);
                withdrawPage.setVisible(false);
                balanceJTA.setText(myAccount.toString());
            }
        });
        withdrawJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPage.setVisible(false);
                balancePage.setVisible(false);
                depositPage.setVisible(false);
                withdrawPage.setVisible(true);
                withdrawJTA.setText("How much would you like to withdraw?");

            }
        });
        depositJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPage.setVisible(false);
                balancePage.setVisible(false);
                depositPage.setVisible(true);
                withdrawPage.setVisible(false);
                depositJTA.setText("How much would you like to deposit?");
            }
        });
        with10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalWithdraw += 10;
                withdrawJTA.setText("Total Withdraw: $" + totalWithdraw);

            }
        });
        with20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalWithdraw += 20;
                withdrawJTA.setText("Total Withdraw: $" + totalWithdraw);

            }
        });
        with50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalWithdraw += 50;
                withdrawJTA.setText("Total Withdraw: $" + totalWithdraw);

            }
        });
        with100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalWithdraw += 100;
                withdrawJTA.setText("Total Withdraw: $" + totalWithdraw);

            }
        });
        withSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myAccount.getBalance() >= totalWithdraw) {
                    myAccount.setBalance(myAccount.getBalance() - totalWithdraw);
                    withdrawJTA.setText("$" + totalWithdraw + " has been withdrawn.\n" +
                            "Your balance is: $" + myAccount.getBalance());
                    totalWithdraw = 0;

                } else {
                    withdrawJTA.setText("Insufficient funds. \n" +
                            "Your balance is: $" + myAccount.getBalance());
                    totalWithdraw = 0;
                }
            }
        });
        depo10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalDeposit += 10;
                depositJTA.setText("Total Deposit: $" + totalDeposit);

            }
        });

        depo20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalDeposit += 20;
                depositJTA.setText("Total Deposit: $" + totalDeposit);

            }
        });

        depo50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalDeposit += 50;
                depositJTA.setText("Total Deposit: $" + totalDeposit);

            }
        });

        depo100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalDeposit += 100;
                depositJTA.setText("Total Deposit: $" + totalDeposit);

            }
        });
        depoSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myAccount.setBalance(myAccount.getBalance() + totalDeposit);
                depositJTA.setText("You have deposited: $" + totalDeposit + "\n" +
                        "Your balance is: $" + myAccount.getBalance());
                totalDeposit = 0;
            }
        });


    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("My ATM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ATM().myATM);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(500, 500);
    }
}
