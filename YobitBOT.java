package api.roboSAM;

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
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class YobitBOT extends JFrame {

	
	private static final String USER_AGENT = "Mozilla/5.0";
	private static String GET_URL;
	private static String marketSel;
	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbBtc;
	private JRadioButton rbUsd;
	private static JTextField trf;
	private JLabel lblHigh;
	private JLabel lblLow;
	private static JTextField lowtxt;

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
					//JOptionPane.showMessageDialog(null, "https://yobit.net/api/2/" + textField.getText() + "_" + marketSel.toString() + "/ticker");
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
		
		trf = new JTextField();
		trf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		trf.setBackground(SystemColor.menu);
		trf.setForeground(SystemColor.menuText);
		trf.setColumns(10);

		
		lblHigh = new JLabel("High");
		
		lblLow = new JLabel("Low");
		
		lowtxt = new JTextField();
		lowtxt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		lowtxt.setBackground(SystemColor.menu);
		lowtxt.setForeground(SystemColor.menuText);
		lowtxt.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(btnSubmit, Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblCurrency)
									.addComponent(lblCompare))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(76)
										.addComponent(rbUsd)
										.addGap(18)
										.addComponent(rbBtc)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblHigh)
							.addGap(14)
							.addComponent(trf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLow)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lowtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(147, Short.MAX_VALUE))
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
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(trf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHigh))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLow)
						.addComponent(lowtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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
			//JOptionPane.showMessageDialog(null, "High: "+strHigh.toString()+", Low: "+strLow.toString()+", Average: "+strAverage.toString()+", Server Time: "+strServer_Time.toString());
			// print result
			//System.out.println(GET_URL + " : " + response.toString());
			//JOptionPane.showMessageDialog(null, GET_URL + " :           " + response.toString());
			trf.setText(strHigh);
			lowtxt.setText(strLow);
		} else {
			System.out.println("GET request not worked");
			JOptionPane.showMessageDialog(null, "Currency Code: Cant Be Empty!");
		}
	}
}
