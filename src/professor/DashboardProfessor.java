package professor;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class DashboardProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static DashboardProfessor frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DashboardProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DashboardProfessor() {

		setResizable(true);
		getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		setTitle("Dashboard Professor");
		setSize(953, 853);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel sideBarPanel = new JPanel();
		sideBarPanel.setBounds(0, 0, 161, 814);
		sideBarPanel.setBackground(new Color(128, 128, 128));
		getContentPane().add(sideBarPanel);
		sideBarPanel.setLayout(null);

		JLabel lblHamburger = new JLabel("");
		lblHamburger.setBounds(33, 11, 94, 94);
		sideBarPanel.add(lblHamburger);
		lblHamburger.setToolTipText("Hide sidebar.");
		lblHamburger.setHorizontalAlignment(SwingConstants.CENTER);
		lblHamburger.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/hamburger_fluency.png")));
		lblHamburger.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		JLabel lblHome = new JLabel("");
		lblHome.setBounds(33, 116, 94, 94);
		sideBarPanel.add(lblHome);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/home_fluency.png")));

		JLabel lblStudent = new JLabel("");
		lblStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				StudentManagement sm = new StudentManagement();
				frame.setContentPane(sm);
				frame.revalidate();
				frame.repaint();
			}
		});
		lblStudent.setBounds(33, 363, 94, 94);
		sideBarPanel.add(lblStudent);
		lblStudent.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblStudent.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/graduation_cap_fluency.png")));

		JLabel lblChat = new JLabel("");
		lblChat.setBounds(33, 239, 94, 94);
		sideBarPanel.add(lblChat);
		lblChat.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/chat_fluency.png")));

		JLabel lblRepository = new JLabel("");
		lblRepository.setBounds(33, 468, 94, 94);
		sideBarPanel.add(lblRepository);
		lblRepository.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/database_fluency.png")));

		JLabel lblClipboard = new JLabel("");
		lblClipboard.setBounds(33, 573, 94, 94);
		sideBarPanel.add(lblClipboard);
		lblClipboard.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/clipboard_task_fluency.png")));

		JLabel lblSettings = new JLabel("");
		lblSettings.setBounds(33, 693, 94, 94);
		sideBarPanel.add(lblSettings);
		lblSettings.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/gear_fluency.png")));
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { sideBarPanel, lblHamburger,
				lblHome, lblChat, lblRepository, lblClipboard, lblSettings }));
		setVisible(true);

		setContentPane(contentPane);
	}

}
