package FrmGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import DAO.AdminDAO;

public class GiaoDienThongKe extends JFrame{

    private JFrame frame;
    private AdminDAO aDAO;
    private DefaultPieDataset dataset = new DefaultPieDataset();
    // Create a set of charts
    private JFreeChart jfreeChart;
    // Create a set of panels that can show charts
    private ChartPanel chartPanel;
    // Create a panel container
    private JPanel panel;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GiaoDienThongKe window = new GiaoDienThongKe();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GiaoDienThongKe() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 513, 362); //set size frame
        aDAO = new AdminDAO();
        int diemVongTD = aDAO.RotVongThamDinh("TD");
        int diemVongPB = aDAO.RotVongPhanBien("PB");
        int slRot = diemVongPB+diemVongTD;
        int slDau = aDAO.DauVongPhanBien("PB");
        //Set gia tr cho PieChart
        dataset.setValue("Đậu", slDau);
        dataset.setValue("Rớt", slRot);

        jfreeChart = ChartFactory.createPieChart3D("Thống Kê Luận Văn", dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) jfreeChart.getPlot();
        //plot.setForegroundAlpha(0.6 f);
        plot.setSectionPaint("Không đạt ", new Color(255, 0, 0)); //Set color cho PieChart
        plot.setSectionPaint("Đạt", new Color(0, 255, 0)); //Set color cho PieChart
        plot.setBackgroundPaint(new Color(255, 255, 255)); //Set background cho PieChart

        //panel Container chartPanel
        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        // add chartPanel PieChart vao panel
        chartPanel = new ChartPanel(jfreeChart);
        chartPanel.setBounds(29, 36, 442, 232); //set size PieChart
        panel.add(chartPanel);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setZoomAroundAnchor(true);
        chartPanel.setBackground(SystemColor.menu);
        setSize(1000,800); 
		setLocationRelativeTo(null);
		//setResizable(false);
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(500,500));
        jp.add(chartPanel,BorderLayout.CENTER);
        add(jp);
       
        
    }

}