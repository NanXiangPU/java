import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Form used to order a custom computer.
 *
 * <p>Homework 11 -- GUIs</p>
 */
public class ComputerOrderForm {
    /**
     * Text fields used for input.
     */
    private JTextField brandJTextField;
    private JTextField cpuCoresJTextField;
    private JTextField gpuCoresJTextField;
    private JTextField ramAmountJTextField;
    private JTextField powerSupplyJTextField;
    private JTextField hdCapacityJTextField;

    /**
     * Buttons used to handle user interaction.
     */
    private JButton calcPriceJButton;
    private JButton clearJButton;

    /**
     * Starting prices for each computer brand
     */
    private static final double APPLE_PRICE = 999.0;
    private static final double DELL_PRICE = 899.0;
    private static final double MICROSOFT_PRICE = 849.0;
    private static final double ASUS_PRICE = 799.0;
    private static final double HP_PRICE = 749.0;

    /**
     * Price multipliers for each component.
     */
    private static final double PER_CPU_CORE_PRICE = 100.0;
    private static final double PER_GPU_CORE_PRICE = 150.0;
    private static final double PER_RAM_GB_PRICE = 25.0;
    private static final double PER_HD_GB_PRICE = 1.0;
    private static final double PER_SUPPLY_WATT_PRICE = 0.25;

    private Map<String, Double> brands;

    /**
     * Constructs a newly allocated {@code ComputerOrderForm} object.
     */
    public ComputerOrderForm() {
        this.setUpGUI();
        this.brands = new HashMap<>();
        brands.put("APPLE", APPLE_PRICE);
        brands.put("DELL", DELL_PRICE);
        brands.put("MICROSOFT", MICROSOFT_PRICE);
        brands.put("ASUS", ASUS_PRICE);
        brands.put("HP", HP_PRICE);

        //TODO enter your code for calcPriceJButton's action listener here
        this.calcPriceJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String brand = brandJTextField.getText();
                if (!brands.containsKey(brand)) {
                    JOptionPane.showMessageDialog(new Frame(), "Error: Invalid brand! Please enter another!");
                    return;    
                }

                String cpu_core = cpuCoresJTextField.getText();
                int cpu = 0;
                try {
                    cpu = (int)Integer.parseInt(cpu_core);
                    if (cpu <= 0) {
                        JOptionPane.showMessageDialog(new Frame(), "Error: Invalid amount of CPU cores! Please enter a positive number!");
                        return;
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(new Frame(), "Error: Invalid amount of CPU cores! Please enter a positive number!");
                    return;
                }

                String gpu_core = gpuCoresJTextField.getText();
                int gpu = 0;
                try {
                    gpu = (int)Integer.parseInt(gpu_core);
                    if (cpu <= 0) {
                        JOptionPane.showMessageDialog(new Frame(), "Error: Invalid amount of GPU cores! Please enter a positive number!");
                        return;
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(new Frame(), "Error: Invalid amount of GPU cores! Please enter a positive number!");
                    return;
                }

                String ramStr = ramAmountJTextField.getText();
                int ram = 0;
                try {
                    ram = (int)Integer.parseInt(ramStr);
                    if (ram <= 0) {
                        JOptionPane.showMessageDialog(new Frame(), "Error: Invalid amount of RAM! Please enter a positive number!");
                        return;
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(new Frame(), "Error: Invalid amount of RAM! Please enter a positive number!");
                    return;
                }

                String powerStr = powerSupplyJTextField.getText();
                int power = 0;
                try {
                    power = (int)Integer.parseInt(powerStr);
                    if (power <= 0) {
                        JOptionPane.showMessageDialog(new Frame(), "Error: Invalid power supply wattage! Please enter a positive number!");
                        return;
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(new Frame(), "Error: Invalid power supply wattage! Please enter a positive number!");
                    return;
                }

                String hdStr = hdCapacityJTextField.getText();
                int hd = 0;
                try {
                    hd = (int)Integer.parseInt(hdStr);
                    if (hd <= 0) {
                        JOptionPane.showMessageDialog(new Frame(), "Error: Invalid HD capacity! Please enter a positive number!");
                        return;
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(new Frame(), "Error: Invalid HD capacity! Please enter a positive number!");
                    return;
                }
                
                double totolCost = (double)(brands.get(brand) + PER_CPU_CORE_PRICE * cpu + PER_GPU_CORE_PRICE * gpu + PER_RAM_GB_PRICE * ram + PER_SUPPLY_WATT_PRICE * power +  PER_HD_GB_PRICE * hd);
                JOptionPane.showMessageDialog(new Frame(), "Totol cost is: " + totolCost);
                
            }
        });
        //TODO enter your code for clearJButton's action listener here
        this.clearJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                brandJTextField.setText("");
                cpuCoresJTextField.setText("");
                gpuCoresJTextField.setText("");   
                ramAmountJTextField.setText("");
                powerSupplyJTextField.setText("");
                hdCapacityJTextField.setText("");
            }
        });
    } //ComputerOrderForm

    /**
     * Sets up the GUI for the user.
     */
    private void setUpGUI() {
        //initialize the components
        this.brandJTextField = new JTextField();
        this.cpuCoresJTextField = new JTextField();
        this.gpuCoresJTextField = new JTextField();
        this.ramAmountJTextField = new JTextField();
        this.powerSupplyJTextField = new JTextField();
        this.hdCapacityJTextField = new JTextField();
        this.calcPriceJButton = new JButton("Calculate Price");
        this.clearJButton = new JButton("Clear Form");

        JFrame mainJFrame = new JFrame("Computer Order Form");
        JPanel mainJPanel = new JPanel();

        //format mainJPanel
        mainJPanel.setLayout(new GridLayout(14, 1));
        mainJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        //add the components to mainJPanel
        mainJPanel.add(new JLabel("Brand:"));
        mainJPanel.add(this.brandJTextField);
        mainJPanel.add(new JLabel("CPU cores:"));
        mainJPanel.add(this.cpuCoresJTextField);
        mainJPanel.add(new JLabel("GPU cores:"));
        mainJPanel.add(this.gpuCoresJTextField);
        mainJPanel.add(new JLabel("RAM amount:"));
        mainJPanel.add(this.ramAmountJTextField);
        mainJPanel.add(new JLabel("Power supply wattage:"));
        mainJPanel.add(this.powerSupplyJTextField);
        mainJPanel.add(new JLabel("HD capacity:"));
        mainJPanel.add(this.hdCapacityJTextField);
        mainJPanel.add(this.calcPriceJButton);
        mainJPanel.add(this.clearJButton);

        //format mainJFrame
        mainJFrame.setMinimumSize(new Dimension(500, 450));
        mainJFrame.setContentPane(mainJPanel);
        mainJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainJFrame.setLocationRelativeTo(null);
        mainJFrame.pack();

        //make mainJFrame visible
        mainJFrame.setVisible(true);
    } //setUpGUI

    public static void main(String[] args) {
        new ComputerOrderForm();
    } //main
}
