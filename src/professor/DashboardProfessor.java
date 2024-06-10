package professor;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import services.BD;

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
		setSize(1000, 853);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel sideBarPanel = new JPanel();
		sideBarPanel.setBounds(0, 0, 161, 814);
		sideBarPanel.setBackground(new Color(217, 217, 217));
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

		// Initialize the main content area with CardLayout
		cardLayout = new CardLayout();
		mainContentPanel = new JPanel(cardLayout);
		mainContentPanel.setBounds(161, 78, 823, 736); // Adjusted size to fit the rest of the frame
		contentPane.add(mainContentPanel);

		// Create and add the panels to the CardLayout panel
		JPanel homePanel = new JPanel();
		homePanel.setBackground(Color.WHITE);
		mainContentPanel.add(homePanel, "Home");
		homePanel.setLayout(null);

//		JLabel lblMessagingElement = new JLabel("");
//		lblMessagingElement
//				.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/Messages_UI_Element.png")));
//		lblMessagingElement.setBounds(39, 39, 304, 278);
//		homePanel.add(lblMessagingElement);
//
//		JLabel lblScheduleElement = new JLabel("");
//		lblScheduleElement.setIcon(
//				new ImageIcon(DashboardProfessor.class.getResource("/images/Scheduled_Classes_UI_Element.png")));
//		lblScheduleElement.setBounds(422, 39, 304, 278);
//		homePanel.add(lblScheduleElement);
//
//		JLabel lblCalendarElement = new JLabel("");
//		lblCalendarElement
//				.setIcon(new ImageIcon(DashboardProfessor.class.getResource("/images/Calendar_UI_Element.png")));
//		lblCalendarElement.setBounds(39, 345, 304, 364);
//		homePanel.add(lblCalendarElement);
//
//		JLabel lblBacklogElement = new JLabel("");
//		lblBacklogElement.setIcon(
//				new ImageIcon(DashboardProfessor.class.getResource("/images/Backlog_Scheduled_UI_Element.png")));
//		lblBacklogElement.setBounds(422, 345, 304, 338);
//		homePanel.add(lblBacklogElement);

		// Initialize each individual panel

		MainDashboardPanel mainDashboardPanel = new MainDashboardPanel();
		mainContentPanel.add(mainDashboardPanel, "MainDashboardPanel");

		StudentManagement studentManagementPanel = new StudentManagement();
		mainContentPanel.add(studentManagementPanel, "StudentManagement");

		cardLayout.show(mainContentPanel, "MainDashboardPanel"); // Show home panel by default

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(193, 193, 193));
		topPanel.setBounds(161, 0, 823, 79);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		// Logic for fetching the professor's name from the database and displaying it
		// with the welcome message in lblGreeting:
		// lblGreeting.setText("Welcome " + professorName + "!");
		// Replace <user> with the professor's name

		JLabel lblGreeting = new JLabel("Welcome <user>!");
		lblGreeting.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblGreeting.setBounds(10, 21, 190, 36);
		topPanel.add(lblGreeting);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { sideBarPanel, lblHamburger, lblHome,
				lblChat, lblRepository, lblClipboard, lblSettings, topPanel, lblGreeting }));

		// cardLayout.show(mainContentPanel, "Home"); // Show home panel by default

		// Retrieving the professor's name in the acadio database:
		String professorName = "";
		BD bd = new BD();
		if (bd.getConnection()) {
			try {
				bd.st = bd.con.prepareStatement("SELECT professor_name FROM professor_tb WHERE professor_id = ?");
				bd.st.setInt(1, 1); // Replace 1 with the professor's ID
				bd.rs = bd.st.executeQuery();
				if (bd.rs.next()) {
					professorName = bd.rs.getString("professor_name");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			bd.close();
		}
		lblGreeting.setText("Welcome " + professorName + "!");

		// Add the following code to the close() method in the BD class:
	}
}
