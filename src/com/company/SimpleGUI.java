package com.company;
import java.awt.*;
import java.awt.event.*;
//event  - отслеживать нажатие на кнопки, что при нажатии делаем такое-то действие
import javax.swing.*;
//это для формоссек - надпись, лейбл и тп




public class SimpleGUI extends JFrame {
    // JFrame - класс который помогает создавать формочки
//ниже поля которые будут в нащей формочке, но саму форму потом
    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input: ");
    private JRadioButton radio1 = new JRadioButton("Select this");
    //круглшка в которой сможем выбирать одно из двух значений
    private JRadioButton radio2 = new JRadioButton("Select that");
    private JCheckBox check = new JCheckBox("Check", false);
    //квадратик в которм появляется галочка

    public SimpleGUI () {
        //создаем конструктор который будет вызываться при создании объекта данного класса
        super("Simple Example"); //- название формочки
        // super- обращаемся к конструктору в основном классе JFrame и в этот конструткор передаем текст\
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //значит что когда закрываем форму - то приложение выполнено

        Container container = this.getContentPane();
        //container - по сути наша формочка в которую можем помещать что угодно (кнопки поля и тп)
        container.setLayout(new GridLayout(3, 2, 2,2));
        //задали размеры и отступы
        container.add(label);
        container.add(input);
        //поместили в контейнер лейбл и инпут

//  в радиобаттонах нужно чтобы была возможность выбирать только один из вариантов, поэтому вот что
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        //эта кнопка будет изначально выбрана

        container.add(radio2);
        container.add(check);

        //дальше работаем с кнопкой
        button.addActionListener(new ButtonEventListener());
        // после создаем уже этот класс
        container.add(button);

    }

    class ButtonEventListener implements ActionListener {
        //обработчик всех событий- стандартная фича если надо кнопка которая чет делает

        @Override
        public void actionPerformed(ActionEvent e) {
// метод который ничего не возвращает, событие которое передается в качестве параметра. при нажатии на кнопку
            String message = "";
            message += "Button was pressed\n";
            // \n = с новой строки
            message += "Text is " + input.getText() + "\n";
            message += (radio1.isSelected()  ? "Radio #1" : "Radio #2") + " is Selected!\n";
            //если выбрали радио 1 - тогда (?), иначе (:)
            message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked\n");

            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        //благодаря этому мы выводим новым окном новое сообщение

        }
    }
}



