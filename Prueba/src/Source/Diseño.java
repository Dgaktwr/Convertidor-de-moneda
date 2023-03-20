package Source;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Diseño<JSONObject> extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	@Override
	// boton convertir
	public void actionPerformed(ActionEvent e) {
		if (btnConvertir.equals(e.getSource())) {
			double cantidad = Double.parseDouble(areaImporte.getText());
			String De = boxDe.getSelectedItem().toString();
			String A = boxA.getSelectedItem().toString();
			double conversion = convertirDivisas(cantidad, De, A);
			areaConversion.setText(String.format("%.2f", conversion));
			
		}

		// boton intercambiar
		btnIntercambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String De = boxDe.getSelectedItem().toString();
				String A = boxA.getSelectedItem().toString();
				boxDe.setSelectedItem(A);
				boxA.setSelectedItem(De);
			}
		});
	}

	// informacion de valor de divisas
	private double convertirDivisas(double cantidad, String De, String A) {
		double tipoDeCambio = 0;
		if (De.equals("USD") && A.equals("EUR")) {
			tipoDeCambio = 0.93;
		} else if (De.equals("USD") && A.equals("GBP")) {
			tipoDeCambio = 0.82;
		} else if (De.equals("USD") && A.equals("JPY")) {
			tipoDeCambio = 131.84;
		} else if (De.equals("USD") && A.equals("KRW")) {
			tipoDeCambio = 1308.75;
		} else if (De.equals("USD") && A.equals("COP")) {
			tipoDeCambio = 4764.71;
		} else if (De.equals("EUR") && A.equals("USD")) {
			tipoDeCambio = 1.08;
		} else if (De.equals("EUR") && A.equals("GBP")) {
			tipoDeCambio = 0.88;
		} else if (De.equals("EUR") && A.equals("JPY")) {
			tipoDeCambio = 142.10;
		} else if (De.equals("EUR") && A.equals("KRW")) {
			tipoDeCambio = 1410.24;
		} else if (De.equals("EUR") && A.equals("COP")) {
			tipoDeCambio = 5134.22;
		} else if (De.equals("GBP") && A.equals("USD")) {
			tipoDeCambio = 1.22;
		} else if (De.equals("GBP") && A.equals("EUR")) {
			tipoDeCambio = 1.13;
		} else if (De.equals("GBP") && A.equals("JPY")) {
			tipoDeCambio = 160.55;
		} else if (De.equals("GBP") && A.equals("KRW")) {
			tipoDeCambio = 1593.73;
		} else if (De.equals("GBP") && A.equals("COP")) {
			tipoDeCambio = 5802.23;
		} else if (De.equals("JPY") && A.equals("USD")) {
			tipoDeCambio = 0.0076;
		} else if (De.equals("JPY") && A.equals("EUR")) {
			tipoDeCambio = 0.0070;
		} else if (De.equals("JPY") && A.equals("GBP")) {
			tipoDeCambio = 0.0062;
		} else if (De.equals("JPY") && A.equals("KRW")) {
			tipoDeCambio = 9.93;
		} else if (De.equals("JPY") && A.equals("COP")) {
			tipoDeCambio = 36.15;
		} else if (De.equals("KRW") && A.equals("USD")) {
			tipoDeCambio = 0.0076;
		} else if (De.equals("KRW") && A.equals("EUR")) {
			tipoDeCambio = 0.0071;
		} else if (De.equals("KRW") && A.equals("GBP")) {
			tipoDeCambio = 0.00063;
		} else if (De.equals("KRW") && A.equals("JPY")) {
			tipoDeCambio = 0.10;
		} else if (De.equals("KRW") && A.equals("COP")) {
			tipoDeCambio = 3.64;
		} else if (De.equals("COP") && A.equals("USD")) {
			tipoDeCambio = 0.00021;
		} else if (De.equals("COP") && A.equals("EUR")) {
			tipoDeCambio = 0.00020;
		} else if (De.equals("COP") && A.equals("GBP")) {
			tipoDeCambio = 0.00017;
		} else if (De.equals("COP") && A.equals("KRW")) {
			tipoDeCambio = 0.27;
		} else if (De.equals("COP") && A.equals("JPY")) {
			tipoDeCambio = 0.028;
		}
		return cantidad * tipoDeCambio;
	}

	private JPanel contentPane;
	JComboBox<String> boxA, boxDe;
	JTextPane areaImporte, areaConversion;
	JButton btnIntercambiar, btnConvertir;
	JLabel lblDe, lblA;

	/**
	 * Creacion del frame.
	 */
	public Diseño() {
		setResizable(false);
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(51, 51, 51));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Conversor de divisas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 217);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(58, 105, 94));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		boxDe = new JComboBox<String>();
		boxDe.addItem("USD");
		boxDe.addItem("EUR");
		boxDe.addItem("GBP");
		boxDe.addItem("JPY");
		boxDe.addItem("KRW");
		boxDe.addItem("COP");
		boxDe.setBounds(137, 39, 96, 22);
		contentPane.add(boxDe);

		boxA = new JComboBox<String>();
		boxA.addItem("COP");
		boxA.addItem("USD");
		boxA.addItem("EUR");
		boxA.addItem("GBP");
		boxA.addItem("JPY");
		boxA.addItem("KRW");
		boxA.setBounds(294, 39, 91, 22);
		contentPane.add(boxA);

		areaConversion = new JTextPane();
		areaConversion.setEditable(false);
		areaConversion.setFont(new Font("Tahoma", Font.BOLD, 15));
		areaConversion.setBackground(new Color(107, 163, 139));
		areaConversion.setForeground(new Color(255, 255, 255));
		areaConversion.setBounds(137, 134, 206, 22);
		contentPane.add(areaConversion);

		btnIntercambiar = new JButton("");
		btnIntercambiar.addActionListener(this);
		btnIntercambiar
				.setIcon(new ImageIcon("C:\\Users\\Lupe\\eclipse-workspace\\Prueba\\Imagenes\\flechas (2).png"));
		btnIntercambiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIntercambiar.setBounds(253, 39, 25, 22);
		contentPane.add(btnIntercambiar);

		JLabel lblConversion = new JLabel("Conversión =");
		lblConversion.setForeground(new Color(255, 255, 255));
		lblConversion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConversion.setBounds(38, 140, 96, 14);
		contentPane.add(lblConversion);

		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setForeground(new Color(255, 255, 255));
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblImporte.setBounds(25, 13, 61, 18);
		contentPane.add(lblImporte);

		areaImporte = new JTextPane();
		areaImporte.setToolTipText("");
		areaImporte.setFont(new Font("Monospaced", Font.BOLD, 14));
		areaImporte.setBackground(new Color(107, 163, 139));
		areaImporte.setForeground(new Color(255, 255, 255));
		areaImporte.setBounds(25, 38, 91, 22);
		contentPane.add(areaImporte);

		lblDe = new JLabel("De");
		lblDe.setForeground(new Color(255, 255, 255));
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDe.setBounds(137, 14, 46, 14);
		contentPane.add(lblDe);

		lblA = new JLabel("A");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblA.setBounds(294, 14, 46, 14);
		contentPane.add(lblA);

		btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(this);
		btnConvertir.setForeground(new Color(255, 255, 255));
		btnConvertir.setBackground(new Color(61, 131, 104));
		btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConvertir.setBounds(137, 84, 96, 23);
		contentPane.add(btnConvertir);
	}
}
