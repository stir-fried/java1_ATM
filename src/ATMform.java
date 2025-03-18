//Javier Colon

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMform extends JFrame
{

    private BankAccount myAccount = new BankAccount();
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JButton balanceButton;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton exitButton;

    public ATMform()
    {
        setTitle("ATM java");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel mainPage = new JPanel();
        mainPage.setLayout(new GridLayout(2, 2));

        balanceButton = new JButton("Balance");
        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        exitButton = new JButton("Exit");

        mainPage.add(balanceButton);
        mainPage.add(withdrawButton);
        mainPage.add(depositButton);
        mainPage.add(exitButton);

        balanceButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cardLayout.show(cardPanel, "BalancePage");
            }
        });

        withdrawButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cardLayout.show(cardPanel, "WithdrawPage");
            }
        });

        depositButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cardLayout.show(cardPanel, "DepositPage");
            }
        });

        JPanel balancePage = createBalancePage();
        JPanel withdrawPage = createWithdrawPage();
        JPanel depositPage = createDepositPage();

        cardPanel.add(mainPage, "MainPage");
        cardPanel.add(balancePage, "BalancePage");
        cardPanel.add(withdrawPage, "WithdrawPage");
        cardPanel.add(depositPage, "DepositPage");

        add(cardPanel);
        cardLayout.show(cardPanel, "MainPage");

        setVisible(true);


    }

    private JPanel createBalancePage()
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel());
        return panel;
    }

    private JPanel createWithdrawPage()
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel());
        return panel;
    }

    private JPanel createDepositPage()
    {
        JPanel panel = new JPanel();
        panel.add(new JLabel());
        return panel;
    }

    public static void main(String[] args) {
        new ATMform();
    }


}


