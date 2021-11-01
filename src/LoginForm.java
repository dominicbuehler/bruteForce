import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginForm extends JFrame implements ActionListener {
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel, errorWarning;
    final JTextField userField, passwordField;
    private int maxlengthPassword, minLengthPassword;

    LoginForm() {
        userLabel = new JLabel();
        userLabel.setText("Username");

        userField = new JTextField(15);
        userField.setText("bruteForceTester");


        passLabel = new JLabel();
        passLabel.setText("Password");


        passwordField = new JPasswordField(15);

        errorWarning = new JLabel("errorWarning");
        errorWarning.setForeground(Color.RED);

        maxlengthPassword = 8;
        minLengthPassword = 6;

        b1 = new JButton("SUBMIT");

        newPanel = new JPanel(new GridLayout(3, 2));
        newPanel.add(userLabel);
        newPanel.add(userField);
        newPanel.add(passLabel);
        newPanel.add(passwordField);
        newPanel.add(b1);
        newPanel.add(errorWarning);

        add(newPanel, BorderLayout.CENTER);

        b1.addActionListener(this);
        setTitle("PASSWORD CREATOR");
    }

    public void actionPerformed(ActionEvent ae) {
        String userValue = userField.getText();
        String passValue = passwordField.getText();

        //TODO better authentification
        if (passValue.length() >= minLengthPassword && passValue.length() <= maxlengthPassword) {

            errorWarning.setText("Login successful");
            errorWarning.setForeground(Color.BLACK);
            NewPage page = new NewPage();

            page.setVisible(true);

            JLabel wel_label = new JLabel("Welcome: " + userValue);
            page.getContentPane().add(wel_label);
        } else {
            errorWarning.setText("Please enter password in between " + minLengthPassword + " and " + maxlengthPassword + " symbols.");
        }
    }
}

class LoginFormDemo {
    public static void main(String arg[]) {
        try {
            LoginForm form = new LoginForm();
            form.setSize(800, 500);
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
