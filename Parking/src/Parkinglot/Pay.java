package Parkinglot;


import java.awt.BorderLayout;
import java.awt.Color;
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
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Pay extends JFrame implements ActionListener{

	
	



	private JPanel MainPan;
	private JLabel lblInfo;
	private JButton btnSubMit;
	private JTextField tfCarNum;
	private JButton btnCal;
	private JButton btnExit;
	private JLabel Carname;
	private JLabel Timeset;
	private JLabel lblCar;
	private JLabel lblPrice;
	
	private int Price1;
	private String CarNameCheck;
	private String Price;
	private JLabel lblOutTime;
	private JLabel lblInTime;
	private String InputTime;
	private String OutputTime;
	private long Outputtimesec;
	private long Inputtimesec;
	ParkingCar pc;
	private String Area;
	private Statement stmt;
	private String Area2;
	private JLabel lblCost;
	private long Inserttime;
	private String ABC;
	private String inTime;
	private String space;
	private int cost2;
	private String GetDay;
	private Point ptFirst;
	private JComponent panUp;
	private JButton btnexit;
	private JButton xbtn;
	
	public Pay(String title, ParkingCar parkingCar) {
			pc = parkingCar;
			setTitle(title);
			setResizable(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(300, 315);
			setLocationRelativeTo(null);
			setUndecorated(true);
			
	        panUp = new JPanel();
			panUp.setPreferredSize(new Dimension(300,20));
			panUp.setBackground(Color.lightGray);
		     xbtn = new JButton("X");
		     xbtn.setForeground(new Color(59,59,59));
		     xbtn.setBounds(265, -15, 50, 50);
		     xbtn.setBorderPainted(false);
		     xbtn.setFocusPainted(false);
		     xbtn.setContentAreaFilled(false);
		     xbtn.setOpaque(false);
		     add(xbtn);
		     xbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
					
				}
			});
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
	        
			ImageIcon img = new ImageIcon("img/Pay/PayMain.png");
			
			ImageIcon img1 = new ImageIcon("img/Pay/payok.png");
			ImageIcon img1rol = new ImageIcon("img/Pay/payokrol.png");
			ImageIcon img1pre = new ImageIcon("img/Pay/payokpre.png");
			
			
			ImageIcon img2 = new ImageIcon("img/Pay/paybtn.png");
			ImageIcon img2rol = new ImageIcon("img/Pay/paybtnrol.png");
			ImageIcon img2pre = new ImageIcon("img/Pay/paybtnpre.png");
			
			
			ImageIcon img3 = new ImageIcon("img/Pay/exitbtn.png");
			ImageIcon img3rol = new ImageIcon("img/Pay/exitbtnrol.png");
			ImageIcon img3pre = new ImageIcon("img/Pay/exitbtnpre.png");
			
			
			ImageIcon img4 = new ImageIcon("img/Pay/paymain2.png");
			
			
			
			MainPan = new JPanel()
			{
		       	 public void paintComponent(Graphics g) {
		             g.drawImage(img.getImage(), 0, 0, null); //이미지 원래사이즈로 넣기
		             
		             Dimension d = getSize();
		             g.drawImage(img.getImage(), 0, 0, d.width, d.height, null); // 컴포넌트 사이즈에 맞게
		             
		     }};
		     
		    MainPan.setLayout(null);
		    
			lblInfo = new JLabel("Please enter your car number");
			lblInfo.setForeground(Color.white);
			lblInfo.setBounds(20, 25, 1000, 20);
			
			tfCarNum = new JTextField(20);
			tfCarNum.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //텍스트바 테두리 없애기
			tfCarNum.setForeground(Color.white);
			tfCarNum.setOpaque(false);
			tfCarNum.setBounds(20, 55, 180, 35);
			
			btnSubMit = new JButton(img1);
			btnSubMit.setBounds(200, 55, 60, 35);
	        btnSubMit.setRolloverIcon(img1rol);
	        btnSubMit.setPressedIcon(img1pre);
	        btnSubMit.setBorderPainted(false);
	        btnSubMit.setFocusPainted(false);
	        btnSubMit.setContentAreaFilled(false);
	        btnSubMit.setOpaque(false);
			
			btnCal = new JButton(img2);
			btnCal.setBounds(20, 222, 120, 35);
	        btnCal.setRolloverIcon(img2rol);
	        btnCal.setPressedIcon(img2pre);
			btnCal.setBorderPainted(false);
			btnCal.setFocusPainted(false);
			btnCal.setContentAreaFilled(false);
			btnCal.setOpaque(false);
			
			
			btnExit = new JButton(img3);
			btnExit.setBounds(145, 222, 120, 35);
			btnExit.setRolloverIcon(img3rol);
			btnExit.setPressedIcon(img3pre);
			btnExit.setBorderPainted(false);
			btnExit.setFocusPainted(false);
			btnExit.setContentAreaFilled(false);
			btnExit.setOpaque(false);

		
			JPanel lblpane = new JPanel(){
		       	 public void paintComponent(Graphics g) {
		             g.drawImage(img4.getImage(), 0, 0, null); //이미지 원래사이즈로 넣기
		             
		             Dimension d = getSize();
		             g.drawImage(img4.getImage(), 0, 0, d.width, d.height, null); // 컴포넌트 사이즈에 맞게
		             
		     }};
		     
		     JLabel payok = new JLabel("Price");
		     payok.setForeground(Color.white);
		     payok.setBounds(20, 62, 245, 80);
		     
			lblpane.setBackground(Color.green);
			lblpane.setBounds(20, 115, 245, 100);
			
			lblCar =new JLabel();
			lblCost = new JLabel();
			lblOutTime = new JLabel();
			lblInTime = new JLabel();
			
			lblPrice =new JLabel();

			
			
			lblpane.add(lblCar);
			lblpane.add(lblInTime);
			lblpane.add(lblOutTime);
			lblpane.add(lblPrice);
			lblpane.add(lblCost);
			btnExit.addActionListener(this);
			btnSubMit.addActionListener(this);
			btnCal.addActionListener(this);
			
			
			MainPan.add(lblInfo);
			MainPan.add(tfCarNum);
			MainPan.add(btnSubMit);
			MainPan.add(btnCal);
			MainPan.add(btnExit);
			MainPan.add(payok);
			MainPan.add(lblpane);
			//MainPan.add(lblCar);
			//MainPan.add(lblOutTime);
			//MainPan.add(lblPrice);
			
			add(panUp, BorderLayout.NORTH);
			add(MainPan);
			
			setResizable(false);
			setVisible(true);
		}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		DB_Conn dc = new DB_Conn();	


		
		
		if(obj ==btnSubMit) {//확인버튼 구현(차량번호 / 출차시간 / 요금 출력)
			
			 String sql = "select * from car where carnumber = '" + tfCarNum.getText() +"'";
			
	            System.out.println(sql);
	            ResultSet rs = dc.excuteQuery(sql);
	            //rs에 내용이 있는지 본다. 
	            try {
	                if(rs.next()) {
	                     ABC = rs.getString("carnumber"); //아이디를 가저온다.
	                     inTime = rs.getString("intime");
	                     space = rs.getString("space"); //승환
	                    
	                    if(tfCarNum.getText().equals(ABC)) {
	//아이디를 가저온다.
	        	        				///////////////////////////////////////////////////////////////////
	        	        				///////////////////////////////////////////////////////////////////
	        	        	          
	        	        	            lblCar.setText("차량 번호는 : "+ tfCarNum.getText()); //텍스트필드에 입력된 차량번호를 출력
	        	        	            ///////////////////////////////////////////////////////////////////
	        	        	            //버튼 누른지금 시간을 출력해주는 소스////////////////////////////////////////
	        	        	            ///////////////////////////////////////////////////////////////////
	        	        	            Outputtimesec = System.currentTimeMillis(); 
	        	        	            SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
	        	        	            OutputTime = dayTime.format(new Date(Outputtimesec));
	        	        	            
	        	        	            
	        	        	            SimpleDateFormat Day = new SimpleDateFormat("yyyy-MM-dd");
	        	        	            GetDay = Day.format(new Date(Outputtimesec)); ///영진수정 년 월 일 
	        	        	            
	        	        	           // lblInTime.setText("입차시각은 : "+inTime);
	        	        	            lblInTime.setText("입차시각은 : "+inTime);
	        	        	            lblOutTime.setText("출차시각은 : "+OutputTime);
	        	        	           
	        	        	            ///////////////////////////////////////////////////////////////////
	        	        	            
//	        	        	            RealTimePay.thread.setDaemon(true);
//	        	        	            Price1 = RealTimePay.Price;
//	        	        	            Price = Integer.toString(Price1);
//	        	        				lblPrice.setText(Price);
//	        	        				long a=Outputtimesec/1000-Inputtimesec/1000; 
	        	        			
//	        	        				System.out.println(a);JOptionPane.showMessageDialog(null, "확인");
	        	        	            
	        	        	      
	        	        	            
	        	        	            System.out.println(OutputTime);
	        	        	            System.out.println(inTime);
	        	        	            
	        	        	            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss",Locale.KOREA);
	        	        	            try {
											Date d1 = f.parse(OutputTime);
											Date d2 = f.parse(inTime);
											long diff = d1.getTime()-d2.getTime();
											long sec = diff/1000;
											long min = sec/60;
											
											
											
										
											int cost = (int) (min * 500);
											cost2 = cost; //기록 테이블에 저장될 정산값
											String to = Integer.toString(cost);
											lblCost.setText("주차요금 : "+to);
										} catch (ParseException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
	        	        	            
	        	        	            
	        	        	            
	                    }


	                }else {
	                    JOptionPane.showMessageDialog(null, "없는번호입니다","알림", JOptionPane.WARNING_MESSAGE);
	                    setVisible(false);
	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	            
	        }
		

		
		if(obj == btnCal)
		{
			  String sql = "select space from car where carnumber = '" + tfCarNum.getText() +"'";
	          ResultSet rs = dc.excuteQuery(sql);
	          

	                    try {
	                    	if(rs.next()) {
	            			Area = rs.getNString("space");
	        				System.out.println("Area:" + Area);

	        				Area2 = Area; 						//기록 테이블에 저장될 주차장칸 
	        				System.out.println("AREA2: " + Area2);
	        				
	        				System.out.println("TEST");
	        				if(Area2.equals("A1")) {
		        				System.out.println("ffff");
		        				pc.getLblCarA1().setText("차량번호");
		        		        pc.getBtnA1().setBackground(Color.GREEN);
		        		        pc.getLblCarTA1().setText("");
		        		        pc.getBtnA1().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A2")) {
		        				pc.getLblCarA2().setText("차량번호");
		        		        pc.getBtnA2().setBackground(Color.GREEN);
		        		        pc.getLblCarTA2().setText("");
		        		        pc.getBtnA2().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A3")) {
		        				pc.getLblCarA3().setText("차량번호");
		        		        pc.getBtnA3().setBackground(Color.GREEN);
		        		        pc.getLblCarTA3().setText("");
		        		        pc.getBtnA3().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A4")) {
		        				pc.getLblCarA4().setText("차량번호");
		        		        pc.getBtnA4().setBackground(Color.GREEN);
		        		        pc.getLblCarTA4().setText("");
		        		        pc.getBtnA4().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A5")) {
		        				pc.getLblCarA5().setText("차량번호");
		        		        pc.getBtnA5().setBackground(Color.GREEN);
		        		        pc.getLblCarTA5().setText("");
		        		        pc.getBtnA5().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A6")) {
		        				pc.getLblCarA6().setText("차량번호");
		        		        pc.getBtnA6().setBackground(Color.GREEN);
		        		        pc.getLblCarTA6().setText("");
		        		        pc.getBtnA6().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A7")) {
		        				pc.getLblCarA7().setText("차량번호");
		        		        pc.getBtnA7().setBackground(Color.GREEN);
		        		        pc.getLblCarTA7().setText("");
		        		        pc.getBtnA7().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A8")) {
		        				pc.getLblCarA8().setText("차량번호");
		        		        pc.getBtnA8().setBackground(Color.GREEN);
		        		        pc.getLblCarTA8().setText("");
		        		        pc.getBtnA8().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A9")) {
		        				pc.getLblCarA9().setText("차량번호");
		        		        pc.getBtnA9().setBackground(Color.GREEN);
		        		        pc.getLblCarTA9().setText("");
		        		        pc.getBtnA9().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("A10")) {
		        				pc.getLblCarA10().setText("차량번호");
		        		        pc.getBtnA10().setBackground(Color.GREEN);
		        		        pc.getLblCarTA10().setText("");
		        		        pc.getBtnA10().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B1")) {
		        				pc.getLblCarB1().setText("차량번호");
		        		        pc.getBtnB1().setBackground(Color.GREEN);
		        		        pc.getLblCarTB1().setText("");
		        		        pc.getBtnB1().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B2")) {
		        				pc.getLblCarB2().setText("차량번호");
		        		        pc.getBtnB2().setBackground(Color.GREEN);
		        		        pc.getLblCarTB2().setText("");
		        		        pc.getBtnB2().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B3")) {
		        				pc.getLblCarB3().setText("차량번호");
		        		        pc.getBtnB3().setBackground(Color.GREEN);
		        		        pc.getLblCarTB3().setText("");
		        		        pc.getBtnB3().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B4")) {
		        				pc.getLblCarB4().setText("차량번호");
		        		        pc.getBtnB4().setBackground(Color.GREEN);
		        		        pc.getLblCarTB4().setText("");
		        		        pc.getBtnB4().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B5")) {
		        				pc.getLblCarB5().setText("차량번호");
		        		        pc.getBtnB5().setBackground(Color.GREEN);
		        		        pc.getLblCarTB5().setText("");
		        		        pc.getBtnB5().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B6")) {
		        				pc.getLblCarB6().setText("차량번호");
		        		        pc.getBtnB6().setBackground(Color.GREEN);
		        		        pc.getLblCarTB6().setText("");
		        		        pc.getBtnB6().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B7")) {
		        				pc.getLblCarB7().setText("차량번호");
		        		        pc.getBtnB7().setBackground(Color.GREEN);
		        		        pc.getLblCarTB7().setText("");
		        		        pc.getBtnB7().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B8")) {
		        				pc.getLblCarB8().setText("차량번호");
		        		        pc.getBtnB8().setBackground(Color.GREEN);
		        		        pc.getLblCarTB8().setText("");
		        		        pc.getBtnB8().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B9")) {
		        				pc.getLblCarB9().setText("차량번호");
		        		        pc.getBtnB9().setBackground(Color.GREEN);
		        		        pc.getLblCarTB9().setText("");
		        		        pc.getBtnB9().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("B10")) {
		        				pc.getLblCarB10().setText("차량번호");
		        		        pc.getBtnB10().setBackground(Color.GREEN);
		        		        pc.getLblCarTB10().setText("");
		        		        pc.getBtnB10().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			
		        			if(Area2.equals("C1")) {
		        				pc.getLblCarC1().setText("차량번호");
		        		        pc.getBtnC1().setBackground(Color.GREEN);
		        		        pc.getLblCarTC1().setText("");
		        		        pc.getBtnC1().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C2")) {
		        				pc.getLblCarC2().setText("차량번호");
		        		        pc.getBtnC2().setBackground(Color.GREEN);
		        		        pc.getLblCarTC2().setText("");
		        		        pc.getBtnC2().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C3")) {
		        				pc.getLblCarC3().setText("차량번호");
		        		        pc.getBtnC3().setBackground(Color.GREEN);
		        		        pc.getLblCarTC3().setText("");
		        		        pc.getBtnC3().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C4")) {
		        				pc.getLblCarC4().setText("차량번호");
		        		        pc.getBtnC4().setBackground(Color.GREEN);
		        		        pc.getLblCarTC4().setText("");
		        		        pc.getBtnC4().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C5")) {
		        				pc.getLblCarC5().setText("차량번호");
		        		        pc.getBtnC5().setBackground(Color.GREEN);
		        		        pc.getLblCarTC5().setText("");
		        		        pc.getBtnC5().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C6")) {
		        				pc.getLblCarC6().setText("차량번호");
		        		        pc.getBtnC6().setBackground(Color.GREEN);
		        		        pc.getLblCarTC6().setText("");
		        		        pc.getBtnC6().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C7")) {
		        				pc.getLblCarC7().setText("차량번호");
		        		        pc.getBtnC7().setBackground(Color.GREEN);
		        		        pc.getLblCarTC7().setText("");
		        		        pc.getBtnC7().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C8")) {
		        				pc.getLblCarC8().setText("차량번호");
		        		        pc.getBtnC8().setBackground(Color.GREEN);
		        		        pc.getLblCarTC8().setText("");
		        		        pc.getBtnC8().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C9")) {
		        				pc.getLblCarC9().setText("차량번호");
		        		        pc.getBtnC9().setBackground(Color.GREEN);
		        		        pc.getLblCarTC9().setText("");
		        		        pc.getBtnC9().setEnabled(true);
		        		        setVisible(false);
		        			}
		        			if(Area2.equals("C10")) {
		        				pc.getLblCarC10().setText("차량번호");
		        		        pc.getBtnC10().setBackground(Color.GREEN);
		        		        pc.getLblCarTC10().setText("");
		        		        pc.getBtnC10().setEnabled(true);
		        		        setVisible(false);
		        			}
		        		  String sql21 = "insert into log(space, carnumber, day, intime ,outtime ,price)" + " values('"+ Area + "', '"+ ABC + "','"+ GetDay+"','"+ inTime +"','"+ OutputTime +"','"+ cost2 +"')";

		      	          rs = dc.excuteQuery(sql21);
		    	          rs =dc.excuteQuery("commit");
		    	          
		        		
		        		
		      	          String deleteSql = "delete from car where carnumber = '" + tfCarNum.getText()+ "'";
		      	          rs = dc.excuteQuery(deleteSql);
		    	          rs =dc.excuteQuery("commit");
		    	          
		    	          
	        				
	                    	}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
	        	
			
			
		}
			else if(obj == btnExit) {
			setVisible(false);
		}
	}
}
