package proyectoJTable.sistema;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import proyectoJTable.formulario.FormularioJTable;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	public static String administrador = "administrador";
	public static String admClave = "adm123456";

	public static String invitado = "invitado";
	public static String invClave = "inv123456";

	public static int bloquedora;

	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreUsuario.setBounds(37, 92, 171, 41);
		contentPane.add(lblNombreUsuario);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(37, 141, 117, 29);
		contentPane.add(lblPassword);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(203, 104, 186, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{

				loguear();
			}
		});
		btnEntrar.setBounds(204, 220, 89, 23);
		contentPane.add(btnEntrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(301, 220, 89, 23);
		contentPane.add(btnCancelar);

		JLabel lblMundojbeTradeMark = new JLabel("MundoJBE Trade Mark 2018.");
		lblMundojbeTradeMark.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblMundojbeTradeMark.setBounds(243, 247, 147, 14);
		contentPane.add(lblMundojbeTradeMark);

		JLabel lblBienvenidos = new JLabel();
		lblBienvenidos.setText("Bienvenidos");
		lblBienvenidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenidos.setBounds(149, 7, 171, 50);
		contentPane.add(lblBienvenidos);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(203, 147, 187, 20);
		contentPane.add(txtPassword);

	} // fin del constructor
	
	private void loguear()
	{
		char[] ch = txtPassword.getPassword();
		String claveTemp = "";
		for (int i = 0; i < ch.length; i++) {
			claveTemp += ch[i];
		}

		if ((txtUsuario.getText().trim()
				.equalsIgnoreCase(administrador))
				&& (claveTemp.equalsIgnoreCase(admClave))) {
			Login.this.dispose();
			Login.bloquedora = 0;
			FormularioJTable form = new FormularioJTable();
			form.setVisible(true);
			
		} else if ((txtUsuario.getText().trim()
				.equalsIgnoreCase(invitado))
				&& (claveTemp.equalsIgnoreCase(invClave))) {
			Login.this.dispose();
			Login.bloquedora = 1;
			FormularioJTable form = new FormularioJTable();
			form.setVisible(true);
			
		} else {
			JOptionPane.showMessageDialog(null,
					"Error Nombre o Contrasena Incorrecto");
		}
	
	} // fin de loguear
} // fin de Login
