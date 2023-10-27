import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCalc extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextField pantalla;
    private JButton[] botones;
    private String[] etiquetas = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"
    };
    private double numero1, numero2, resultado;
    private String operador;

    public InterfazCalc() {
        panel = new JPanel();
        pantalla = new JTextField(10);
        botones = new JButton[etiquetas.length];
        operador = "";

        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);

        panel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < etiquetas.length; i++) {
            botones[i] = new JButton(etiquetas[i]);
            botones[i].addActionListener(this);
            panel.add(botones[i]);
        }

        add(pantalla, BorderLayout.NORTH);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setSize(300, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("[0-9]+|\\.")) {
            pantalla.setText(pantalla.getText() + comando);
        } else if (comando.matches("[-+*/=]")) {
            if (!operador.isEmpty()) {
                // Si ya se ingresó un operador, realiza el cálculo actual
                numero2 = Double.parseDouble(pantalla.getText());
                switch (operador) {
                    case "+":
                        resultado = numero1 + numero2;
                        break;
                    case "-":
                        resultado = numero1 - numero2;
                        break;
                    case "*":
                        resultado = numero1 * numero2;
                        break;
                    case "/":
                        resultado = numero1 / numero2;
                        break;
                }
                pantalla.setText(String.valueOf(resultado));
            } else {
                // Si no hay un operador previo, simplemente almacena el número
                numero1 = Double.parseDouble(pantalla.getText());
            }

            // Actualiza el operador actual
            operador = comando;
        } else if (comando.equals("C")) {
            // Limpiar la pantalla y reiniciar las variables
            pantalla.setText("");
            operador = "";
            numero1 = 0;
            numero2 = 0;
            resultado = 0;
        }
    }

    public static void main(String[] args) {
    	InterfazCalc ventana = new InterfazCalc();
    }
}







