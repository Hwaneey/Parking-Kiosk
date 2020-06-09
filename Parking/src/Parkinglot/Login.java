package Parkinglot;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{

	private JLabel lbl1;
	private JLabel lbl2;
	private JTextField tf1;
	private JPasswordField tf2;
	private JButton btnLogin;
	private Point ptFirst;

	
	private JButton btnSignUp;
	private JPanel mainPan;
	private JButton btnexit;
	ImageIcon img = new ImageIcon("img/Login/loginback.png");
	ImageIcon img5 = new ImageIcon("img/val.png");
	
	ImageIcon img2 = new ImageIcon("img/Login/loginbtn.png");
	ImageIcon img2rol = new ImageIcon("img/Login/loginbtnrol.png");
	ImageIcon img2pre = new ImageIcon("img/Login/loginbtnpre.png");
	
	ImageIcon img3 = new ImageIcon("img/Login/signbtn.png");
	ImageIcon img3rol = new ImageIcon("img/Login/signbtnrol.png");
	ImageIcon img3pre = new ImageIcon("img/Login/signbtnpre.png");
	
	ImageIcon img4 = new ImageIcon("img/Login/exitbtn.png");
	ImageIcon img4rol = new ImageIcon("img/Login/xbtnrol.png");
	ImageIcon img4pre = new ImageIcon("img/Login/xbtnpre.png");
	ParkingCar pc;
	private JPanel panUp;

	
	
	
	
	
	public Login(String title) {
	//	pc = parkingCar;
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 530);
		setUndecorated(true);
		//setResizable(false);
		setLocationRelativeTo(null); 
		setBackground(Color.LIGHT_GRAY);
		mainPan = new JPanel()
		{
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        panUp = new JPanel();
		panUp.setPreferredSize(new Dimension(800,30));
		panUp.setBackground(Color.lightGray);
        panUp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				ptFirst = e.getPoint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        panUp.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				Point loc = e.getLocationOnScreen();
		        loc.x -= ptFirst.x;
		        loc.y -= ptFirst.y;
		        
		        setLocation(loc);//프레임창 움직이기
			}
		});
		mainPan.setBackground(Color.WHITE);
		mainPan.setLayout(null);
		
		lbl1 = new JLabel("사 원 번 호");
		lbl1.setBounds(430, 70, 100, 20);
		
		tf1 = new JTextField("1234",10);
		tf1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //텍스트바 테두리 없애기
		tf1.setForeground(Color.white);
		tf1.setOpaque(false);
		tf1 .setBounds(455, 200, 285, 35);
		
		lbl2 = new JLabel("PW");
		lbl2.setBounds(430, 235, 100, 20);
		
		tf2 = new JPasswordField("1234",10);
		tf2.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //텍스트바 테두리 없애기
		tf2.setOpaque(false);
		tf2.setForeground(Color.white);
		tf2.setBounds(455, 270, 285, 35);
		
		btnLogin = new JButton(img2);
		btnLogin.setRolloverIcon(img2rol);
		btnLogin.setPressedIcon(img2pre);
		btnLogin.setBounds(590, 315, 140, 35);
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setOpaque(false);
		btnLogin.addActionListener(this);
		
		btnSignUp = new JButton(img3);
		btnSignUp.setRolloverIcon(img3rol);
		btnSignUp.setPressedIcon(img3pre);
		btnSignUp.setBounds(430, 315, 140, 35);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setFocusPainted(false);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setOpaque(false);
		btnSignUp.addActionListener(this);
		
		
        btnexit = new JButton("X");
        btnexit.setForeground(new Color(59,59,59));
       // btnexit.setRolloverIcon(img4rol);
        //btnexit.setPressedIcon(img4pre);
        btnexit.setBounds(760, -10, 50, 50);
        btnexit.setBorderPainted(false);
        btnexit.setFocusPainted(false);
        btnexit.setContentAreaFilled(false);
        btnexit.setOpaque(false);
        btnexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		//mainPan.add(lbl1);
		mainPan.add(tf1);
		
		//mainPan.add(lbl2);
		mainPan.add(tf2);
		mainPan.add(btnSignUp);
		mainPan.add(btnLogin);
		add(btnexit);
		
		
		add(panUp, BorderLayout.NORTH);
		add(mainPan);
		//add(panUp);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		DB_Conn dc = new DB_Conn();
		
		if(obj == btnLogin)
		{
			String sql = "select * from nodongja where id = '" + tf1.getText() +"' and pw = '" + tf2.getText() + "'";
			System.out.println(sql);
			ResultSet rs = dc.excuteQuery(sql);

			
			//rs에 내용이 있는지 본다. 
			try {
				if(rs.next()) {
					String id = rs.getString("id"); //아이디를 가저온다.
					String pw = rs.getString("pw"); //디비 순서는 1 과 2로 선택가능하고 글로 고를려면 ""
					
					if(tf1.getText().equals(id) && tf2.getText().equals(pw)) {
						new ParkingCar("주차관리");
						this.setVisible(false);//창 끄기 완전하게 꺼지는건 아니고 화면에서 없어집니다.
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패!!", "알림", JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		else if(obj == btnSignUp)
		{
			new SignUp("관리자 회원가입");
		}
	}
	
	public static void main(String[] args) {
		new Login("관리자 로그인");
	}

}
