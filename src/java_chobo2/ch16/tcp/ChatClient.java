package java_chobo2.ch16.tcp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatClient extends JFrame implements ActionListener {
private JPanel contentPane;
	
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private Socket socket = null;
	private Receiver receiver = null; 
	private JTextField sender = null; 
	
	public ChatClient() {
		
		initComponents();
		
		try {
			setupConnection();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		Thread th = new Thread(receiver); 
		th.start();
	}
	
	private void initComponents() {
		setTitle("클라이언트 채팅 창"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		receiver = new Receiver(); 
		receiver.setEditable(false);
		
		sender = new JTextField();
		sender.addActionListener(this);

		contentPane.add(new JScrollPane(receiver),BorderLayout.CENTER); 
		contentPane.add(sender,BorderLayout.SOUTH);
		
		setSize(400, 200); 
		setVisible(true); 
	}
	
	private void setupConnection() throws IOException {
		socket = new Socket("localhost", 9999); 
		receiver.append("서버에 연결 완료");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg = in.readLine(); 
				} catch (IOException e) {
					System.out.println(e.getMessage());
					System.exit(1);
				} 
				this.append("\n  서버 : " + msg); 
				int pos = this.getText().length();
				this.setCaretPosition(pos); 
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == sender) {
			String msg = sender.getText();
			try {
				out.write(msg+"\n"); 
				out.flush();
				
				receiver.append("\n클라이언트 : " + msg); 
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos);
				sender.setText(null);
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
				System.exit(1);
			} 
		}
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}
}
