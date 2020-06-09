package Parkinglot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.sql.*;
import java.util.Vector;

public class Log extends JFrame implements ActionListener{
	private JButton btnDPT;
	private DayPayTable dpt;
	private JPanel panUp;
	private Point ptFirst;
	private Vector column;
	private int c;
	private Vector data;
	private Vector row;
	public Log(String title) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String s;

		
//connect your app to mysql database 
/**
 *  	    원본
 *  		s = "select space 주차칸, day 입차일, carnumber 차량번호, intime 입차시간, outtime 출차시간, price 원 from log ORDER BY INTIME ASC"; 
 * */
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "parkingtest", "tigertest");
			st = con.createStatement();
			s = "select space 주차칸, carnumber 차량번호, intime 입차시간, outtime 출차시간, price 원 from log ORDER BY INTIME ASC";
			rs = st.executeQuery(s);
			ResultSetMetaData rsmt = rs.getMetaData();
			
			c = rsmt.getColumnCount();
			column = new Vector(c);

			
			
			
			
			
			for (int i = 1; i <= c; i++) {
				column.add(rsmt.getColumnName(i));
			}

			data = new Vector();
		row = new Vector();

			while (rs.next()) {
				row = new Vector(c);

				for (int i = 1; i <= c; i++) {
					row.add(rs.getString(i));
				}

				data.add(row);
			}
			setTitle(title);
			
			
			setSize(1000, 700);
			
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		    dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		     
		    //TableColumnModel tcm = t.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴
	
			
			ImageIcon img0 = new ImageIcon("img/Log/log.png"); 
			ImageIcon img0rol = new ImageIcon("img/Log/logr.png"); 
			ImageIcon img0pre = new ImageIcon("img/Log/logp.png"); 
			
			JPanel panA = new JPanel(new BorderLayout());
			btnDPT = new JButton(img0); //기간별 출차 금액
			btnDPT.setRolloverIcon(img0rol);
			btnDPT.setPressedIcon(img0pre);
			btnDPT.setBorderPainted(false);
			btnDPT.setFocusPainted(false);
			btnDPT.setContentAreaFilled(false);
			btnDPT.setOpaque(false);
			btnDPT.addActionListener(this);
			panA.add(btnDPT,BorderLayout.EAST);
			JPanel panel = new JPanel();
			JTable table = new JTable(data, column);
			JScrollPane jsp = new JScrollPane(table);
			panel.setLayout(new BorderLayout());
			panel.add(jsp, BorderLayout.CENTER);
			
			panUp = new JPanel();
			panUp.setPreferredSize(new Dimension(300,20));
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
			        
			        setLocation(loc);
				}
			});
		     JButton xbtn = new JButton("X");
		     xbtn.setForeground(new Color(59,59,59));
		     xbtn.setBounds(959, -15, 50, 50);
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
			add(panUp,BorderLayout.NORTH);
			add(panel);
			add(panA,BorderLayout.SOUTH);
			
			setUndecorated(true);
			setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
			e.printStackTrace();
		} finally {
			try {
				st.close();
				rs.close();
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btnDPT) {
			if(dpt==null) {
				dpt = new DayPayTable("기간별 출차 금액");
			}
			else {
				dpt.dispose();
				dpt = new DayPayTable("기간별 출차 금액");
			}
		}
	}
}