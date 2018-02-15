package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class YobitBOT extends JFrame {

	
	private static final String USER_AGENT = "Mozilla/5.0";
	private static String GET_URL;
	private static String marketSel;
	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbBtc;
	private JRadioButton rbUsd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YobitBOT frame = new YobitBOT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public YobitBOT() {
		setTitle("Yobit BOT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(rbBtc.isSelected())
						
						marketSel = "btc";
					else 
						marketSel = "usd";
					GET_URL = "https://yobit.net/api/2/" + textField.getText() + "_" + marketSel.toString() + "/ticker";
					JOptionPane.showMessageDialog(null, "https://yobit.net/api/2/" + textField.getText() + "_" + marketSel.toString() + "/ticker");
					sendGET();	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblCurrency = new JLabel("Currency Code :");
		
		textField = new JTextField();
		textField.setToolTipText("e.g XRP");
		textField.setColumns(10);
		
		rbUsd = new JRadioButton("USD");
		buttonGroup.add(rbUsd);
		
		rbBtc = new JRadioButton("BTC");
		rbBtc.setSelected(true);
		buttonGroup.add(rbBtc);
		
		
		JLabel lblCompare = new JLabel("Market :");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(349, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCurrency)
						.addComponent(lblCompare))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(rbUsd)
							.addGap(18)
							.addComponent(rbBtc))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(223, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCurrency)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCompare)
						.addComponent(rbUsd)
						.addComponent(rbBtc))
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String strTicker = response.toString();
			String[] splitTicker = strTicker.split(":|\\,");
			String strHigh = splitTicker[2];
			String strLow = splitTicker[4];
			String strAverage = splitTicker[6];
			String strVolume = splitTicker[8];
			String strVol_Cur = splitTicker[10];
			String strLast = splitTicker[12];
			String strBuy = splitTicker[14];
			String strSell = splitTicker[16];
			String strUpdated = splitTicker[18];
			String strServer_Time = splitTicker[20];
			JOptionPane.showMessageDialog(null, "High: "+strHigh.toString()+", Low: "+strLow.toString()+", Average: "+strAverage.toString()+", Server Time: "+strServer_Time.toString());
			// print result
			System.out.println(GET_URL + " : " + response.toString());
			JOptionPane.showMessageDialog(null, GET_URL + " :           " + response.toString());
		} else {
			System.out.println("GET request not worked");
			JOptionPane.showMessageDialog(null, "Currency Code: Cant Be Empty!");
		}
	}
}
