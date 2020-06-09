package Parkinglot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SignUp extends JFrame implements ActionListener{
	
	
	
	
	private JPanel SignUpPan;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblNumber;
	private JTextField tfNumber;
	private JButton btnNumber;
	private JLabel lblPw;
	private JTextField tfPw;
	private JButton btnOk;
	private JPasswordField retfPw;
	private JLabel relblPw;
	private JButton btnexit;
	private Component panUp;
	private Point ptFirst;
	public SignUp(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLocation(500, 300);
		setSize(800, 530);
		setUndecorated(true);
		ImageIcon img = new ImageIcon("img/SingUp/signupback.png"); 
		
		ImageIcon img2 = new ImageIcon("img/SingUp/signbtn.png"); 
		ImageIcon img2rol = new ImageIcon("img/SingUp/signbtnrol.png"); 
		ImageIcon img2pre = new ImageIcon("img/SingUp/signbtnpre.png"); 
		
		ImageIcon img3 = new ImageIcon("img/SingUp/repass.png"); 
		ImageIcon img3rol = new ImageIcon("img/SingUp/repassrol.png"); 
		ImageIcon img3pre = new ImageIcon("img/SingUp/repasspre.png"); 
		
		
		ImageIcon img4 = new ImageIcon("img/SingUp/xbtn.png"); 
		ImageIcon img4rol = new ImageIcon("img/SingUp/xbtnrol.png"); 
		ImageIcon img4pre = new ImageIcon("img/SingUp/xbtnpre.png"); 
		
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
		SignUpPan = new JPanel()
		{
            public void paintComponent(Graphics g) {
                g.drawImage(img.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        
        
		SignUpPan.setLayout(null);
		SignUpPan.setBackground(Color.white);
		
		
        lblName = new JLabel("이 름 ");
        lblName.setBounds(30, 80, 100, 20);
        
        tfName = new JTextField(20);
        tfName.setBounds(120, 135, 370, 35);
		tfName.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //텍스트바 테두리 없애기
		tfName.setForeground(Color.white);
		tfName.setOpaque(false);
		
        lblNumber = new JLabel("사 원 번 호 ");
        lblNumber.setBounds(30, 145, 100, 20);
        
        tfNumber = new JTextField(20);
        tfNumber.setBounds(120, 205, 270, 35);
		tfNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //텍스트바 테두리 없애기
		tfNumber.setForeground(Color.white);
		tfNumber.setOpaque(false);
		
        btnNumber = new JButton("Check");
        btnNumber.setForeground(Color.white);
        btnNumber.setRolloverIcon(img3rol);
        btnNumber.setPressedIcon(img3pre);
        btnNumber.setBorderPainted(false);
        btnNumber.setFocusPainted(false);
        btnNumber.setContentAreaFilled(false);
        btnNumber.setOpaque(false);
        btnNumber.addActionListener(this);
        btnNumber.setBounds(280, 195, 270, 35);
        
        lblPw = new JLabel("비 밀 번 호 ");
        lblPw.setBounds(33, 220, 100, 20);
        
        tfPw = new JPasswordField(10);
        tfPw.setBounds(120, 270, 370, 35);
		tfPw.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //텍스트바 테두리 없애기
		tfPw.setForeground(Color.white);
		tfPw.setOpaque(false);
        
        relblPw = new JLabel("비 밀 번 호 확인 ");
        relblPw.setBounds(30, 290, 100, 20);
        
        retfPw  = new JPasswordField(10);
        retfPw.setBounds(120, 335, 370, 35);
		retfPw.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //텍스트바 테두리 없애기
		retfPw.setForeground(Color.white);
		retfPw.setOpaque(false);
   
        btnOk = new JButton(img2);
        btnOk.setRolloverIcon(img2rol);
        btnOk.setPressedIcon(img2pre);
        btnOk.setBackground(Color.LIGHT_GRAY);
        btnOk.addActionListener(this);
        btnOk.setBounds(65, 360, 370, 70);
        btnOk.setBorderPainted(false);
        btnOk.setFocusPainted(false);
        btnOk.setContentAreaFilled(false);
        btnOk.setOpaque(false);
        
        
        btnexit = new JButton("X");
        btnexit.setForeground(new Color(59,59,59));

        btnexit.setBounds(760, -10, 50, 50);
        btnexit.setBorderPainted(false);
        btnexit.setFocusPainted(false);
        btnexit.setContentAreaFilled(false);
        btnexit.setOpaque(false);
        btnexit.addActionListener(this);
			
        
	
		SignUpPan.add(tfName);
	
		SignUpPan.add(tfNumber);
		SignUpPan.add(btnNumber);
	
		SignUpPan.add(tfPw);
		SignUpPan.add(retfPw);

		SignUpPan.add(btnOk);
		add(btnexit);
		
		
		
		add(panUp, BorderLayout.NORTH);
		add(SignUpPan);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		DB_Conn dc = new DB_Conn();
		
		
		
		
		
		if(obj == btnOk) {
			if(tfName.getText().isEmpty() == false) {
				if(tfNumber.getText().isEmpty() == false) {
					if(((JPasswordField) tfPw).getText().isEmpty() == false) {
						if(((JPasswordField) tfPw).getText().equals(retfPw.getText())) {
						String sql = "insert into nodongja (name, id, pw)" + "values('"+tfName.getText() + "', '"+ tfNumber.getText() + "','"+ ((JPasswordField) tfPw).getText() +"')";
						JOptionPane.showMessageDialog(null, "회원가입 완료!");
						System.out.println(sql);
						dc.executeUpdate(sql);
						setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요","알림", JOptionPane.WARNING_MESSAGE);
						
						}
					}else {
						JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요!","알림", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "사원번호를 입력해주세요!","알림", JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요!","알림", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(obj == btnNumber)
        {

            String sql = "select * from nodongja where id = '" + tfNumber.getText() +"'";
            System.out.println(sql);
            ResultSet rs = dc.excuteQuery(sql);
            //rs에 내용이 있는지 본다. 
            try {
                if(rs.next()) {
                    String id = rs.getString("id"); //아이디를 가저온다.

                    if(tfNumber.getText().equals(id)) {
                        JOptionPane.showMessageDialog(null, "중복입니다.","알림", JOptionPane.WARNING_MESSAGE);
                        setVisible(false);
                    }


                }else {
                    JOptionPane.showMessageDialog(null, "사용가능합니다.","알림", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
		else if(obj == btnexit)
		{
			setVisible(false);
		}
	}

}
