package professor;

import java.awt.CardLayout;
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
import javax.swing.WindowConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class DashboardProfessor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel mainContentPanel;
	private CardLayout cardLayout;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					DashboardProfessor frame = new DashboardProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DashboardProfessor() {
		setResizable(true);
		setTitle("Dashboard Professor");
		setSize(953, 853);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel sideBarPanel = new JPanel();
		sideBarPanel.setBounds(0, 0, 161, 814);
		sideBarPanel.setBackground(new Color(128, 128, 128));
		contentPane.add(sideBarPanel);
		sideBarPanel.setLayout(null);

		JLabel lblHamburger = new JLabel("");
		lblHamburger.setBounds(33, 11, 94, 94);
		sideBarPanel.add(lblHamburger);
		lblHamburger.setToolTipText("Hide sidebar.");
		lblHamburger.setHorizontalAlignment(SwingConstants.CENTER);
		lblHamburger.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/hamburger_fluency.png")));
		lblHamburger.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		JLabel lblHome = new JLabel("");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainContentPanel, "MainDashboardPanel");

			}
		});
		lblHome.setBounds(33, 116, 94, 94);
		sideBarPanel.add(lblHome);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/home_fluency.png")));

		JLabel lblStudent = new JLabel("");
		lblStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(mainContentPanel, "StudentManagement");

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

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { sideBarPanel, lblHamburger, lblHome,
				lblChat, lblRepository, lblClipboard, lblSettings }));

		// Initialize the main content area with CardLayout
		cardLayout = new CardLayout();
		mainContentPanel = new JPanel(cardLayout);
		mainContentPanel.setBounds(161, 0, 776, 814); // Adjusted size to fit the rest of the frame
		contentPane.add(mainContentPanel);

		// Create and add the panels to the CardLayout panel
		JPanel homePanel = new JPanel();
		homePanel.setBackground(Color.WHITE);
		mainContentPanel.add(homePanel, "Home");

		// Initialize each individual panel

		MainDashboardPanel mainDashboardPanel = new MainDashboardPanel();
		mainContentPanel.add(mainDashboardPanel, "MainDashboardPanel");

		StudentManagement studentManagementPanel = new StudentManagement();
		mainContentPanel.add(studentManagementPanel, "StudentManagement");

		cardLayout.show(mainContentPanel, "MainDashboardPanel"); // Show home panel by default

		// cardLayout.show(mainContentPanel, "Home"); // Show home panel by default
	}
}
