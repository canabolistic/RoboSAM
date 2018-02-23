package Yobit;

import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class App {

	private JFrame frmSlaveBot;
	private JTextField txtPrice;
	private JLabel lblExchange;
	private JComboBox cbExchange;
	private JLabel lblMarket;
	private JComboBox cbMarket;
	private JComboBox cbTradingPair;
	private JButton btnAdd;
	private JButton btnDelete;
	private JLabel lblTradingPair;
	private JLabel lblAmount;
	private JTextField txtAmount;
	private JLabel lblPrice;
	private JLabel lblHigh;
	private JLabel lblLow;
	private JLabel lblAvg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmSlaveBot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
		createEvents();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSlaveBot = new JFrame();
		frmSlaveBot.setTitle("Slave Bot");
		frmSlaveBot.setBounds(100, 100, 442, 296);
		frmSlaveBot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		///////////////////////////////////////////
		// J Combo Box
		///////////////////////////////////////////
		
		
		// EXCHANGE LIST
		String[] exchangeList = {"Select Exchange","Bittrex","Yobit","Binance","Coinspot"};
		Arrays.sort(exchangeList);
		
		
	
		cbExchange = new JComboBox();
		
		cbExchange.setModel(new DefaultComboBoxModel(exchangeList));
		cbExchange.setSelectedItem("Select Exchange");
		
		// MARKET LIST
		String[] marketList = {"Select Market", "BTC", "ETH", "LTC", "USD"};
		Arrays.sort(marketList);
		
		cbMarket = new JComboBox();
		cbMarket.setEnabled(false);
		cbMarket.setModel(new DefaultComboBoxModel(marketList));
		cbMarket.setSelectedItem("Select Market");
		
		// TRADING PAIR
		String[] tradingPairList = {"Select Coin", "ETH", "LTC", "BTC"};
		Arrays.sort(tradingPairList);
		
		cbTradingPair = new JComboBox();
		cbTradingPair.setEnabled(false);
		cbTradingPair.setModel(new DefaultComboBoxModel(tradingPairList));
		cbTradingPair.setSelectedItem("Select Coin");
		cbTradingPair.setEditable(true);
		
		///////////////////////////////////////////
		// J Buttons
		///////////////////////////////////////////
		
		// ADD
		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbTradingPair.addItem(cbTradingPair.getSelectedItem());
			}
		});
		
		// DELETE
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbTradingPair.removeItem(cbTradingPair.getSelectedItem());
			}
		});
		
		// BUY
		JButton btnBuy = new JButton("Buy");
		btnBuy.setEnabled(false);
		
		// SELL
		JButton btnSell = new JButton("Sell");
		btnSell.setEnabled(false);
		
		///////////////////////////////////////////
		// J Labels
		///////////////////////////////////////////
		
		// EXCHANGE
		lblExchange = new JLabel("Exchange: ");
		
		// MARKET
		lblMarket = new JLabel("Market:");
		lblMarket.setEnabled(false);

		// TRADING PAIR
		lblTradingPair = new JLabel("Coin Code: ");
		lblTradingPair.setEnabled(false);
		
		// AMOUNT
		lblAmount = new JLabel("Amount:");
		lblAmount.setEnabled(false);
		
		// PRICE
		lblPrice = new JLabel("Price:");
		lblPrice.setEnabled(false);
		
		// HIGH
		lblHigh = new JLabel("High:");
		lblHigh.setEnabled(false);
		
		// LOW
		lblLow = new JLabel("Low:");
		lblLow.setEnabled(false);
		
		// AVG
		lblAvg = new JLabel("Avg:");
		lblAvg.setEnabled(false);
		
		///////////////////////////////////////////
		// Text Fields
		///////////////////////////////////////////
		
		// AMOUNT
		txtAmount = new JTextField();
		txtAmount.setEnabled(false);
		txtAmount.setText("0");
		txtAmount.setColumns(10);
		
		// PRICE
		txtPrice = new JTextField();
		txtPrice.setEnabled(false);
		txtPrice.setText("0");
		txtPrice.setColumns(10);
		
		///////////////////////////////////////////
		// Display Content
		///////////////////////////////////////////
		
		GroupLayout groupLayout = new GroupLayout(frmSlaveBot.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMarket)
									.addPreferredGap(ComponentPlacement.RELATED, 296, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblExchange, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTradingPair))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cbMarket, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbExchange, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbTradingPair, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(12)
									.addComponent(btnAdd)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnDelete)
									.addGap(12))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAmount)
										.addComponent(lblPrice))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHigh)
										.addComponent(lblLow)
										.addComponent(lblAvg))))
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(109)
							.addComponent(btnBuy)
							.addGap(18)
							.addComponent(btnSell)))
					.addGap(77))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExchange)
						.addComponent(cbExchange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarket)
						.addComponent(cbMarket, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTradingPair)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(cbTradingPair, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnAdd)
							.addComponent(btnDelete)))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAmount)
							.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblHigh))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrice)
								.addComponent(lblLow))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAvg))
						.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBuy)
						.addComponent(btnSell))
					.addContainerGap())
		);
		frmSlaveBot.getContentPane().setLayout(groupLayout);
		
		exchange();
		market();
	}
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
	
	public void exchange() {
		cbExchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// IF EXCHANGE SELECTED, ENABLE MARKET. ELSE, DISABLE
				if (cbExchange.getSelectedItem()!="Select Exchange") {
					cbMarket.setEnabled(true);
					lblMarket.setEnabled(true);
				} else {
					cbMarket.setEnabled(false);
					lblMarket.setEnabled(false);
					cbMarket.setSelectedItem("Select Market");
				}
			}
		});
	}
	
	public void market() {
		cbMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// IF MARKET SELECTED, ENABLE TRADING PAIR. ELSE, DISABLE
				if (cbMarket.getSelectedItem()!="Select Market") {
					cbTradingPair.setEnabled(true);
					lblTradingPair.setEnabled(true);
					btnAdd.setEnabled(true);
					btnDelete.setEnabled(true);
				} else {
					cbTradingPair.setEnabled(false);
					lblTradingPair.setEnabled(false);
					btnAdd.setEnabled(false);
					btnDelete.setEnabled(false);
					cbTradingPair.setSelectedItem("Select Coin");
				}
			}
		});
	}
	public void tradingPair() {
		cbTradingPair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// IF TRADING PAIR SELECTED, ENABLE ORDERS. ELSE, DISABLE
				if (cbTradingPair.getSelectedItem()!="Select Coin") {
					lblAmount.setEnabled(true);
					lblPrice.setEnabled(true);
				} else {
					lblAmount.setEnabled(false);
					lblPrice.setEnabled(false);
					cbTradingPair.setSelectedItem("Select Coin");
				}
			}
		});
	}
}
