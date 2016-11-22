import javax.swing.*;

public class MyWindow extends JFrame {
  JText inputField;
  JLabel outputText;
  JButton copybutton, clearButton;

  public MyWindow() {
    this.setSize(300, 200);
    this.setTitle("My First Window");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(copyButton);
  }

}
