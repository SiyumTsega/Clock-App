import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.UIManager;

public class MyFrame extends JFrame{

	JFrame frame;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	String day;
	String time;
	String date;
	Font customFont;
	ImageIcon icon;
	
	MyFrame(){
	
		icon = new ImageIcon("clock.png");
		frame = new JFrame("CLOCK APP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(0x4841EE));
		frame.setLayout(new FlowLayout());
		frame.setSize(350, 200);
		frame.setIconImage(icon.getImage());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("MMMMM dd yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 50));
		timeLabel.setForeground(new Color(0xF7EBFF));
		timeLabel.setBackground(new Color(0x68BAA6));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Bodoni MT Condensed ", Font.PLAIN, 35));
		dayLabel.setForeground(new Color(0xF7EBFF));
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 35));
		dateLabel.setForeground(new Color(0xF7EBFF));
		
		frame.add(timeLabel);
		frame.add(dayLabel);
		frame.add(dateLabel);
		frame.setVisible(true);
		
		setTime();
	}

	private void setTime() {
		while(true) {
		time = timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);
		
		day = dayFormat.format(Calendar.getInstance().getTime());
		dayLabel.setText(day.toUpperCase());
		
		date = dateFormat.format(Calendar.getInstance().getTime());
		dateLabel.setText(date.toUpperCase());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	
}
