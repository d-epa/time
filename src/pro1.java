import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pro1 {


    public static class ToDoListGUI extends JFrame {

        private DefaultListModel<String> tasksListModel;
        private JList<String> tasksList;

        private JTextField taskInput;

        public ToDoListGUI() {
            super("To-Do List");

            tasksListModel = new DefaultListModel<>();
            tasksList = new JList<>(tasksListModel);
            taskInput = new JTextField(20);
            JButton addButton = new JButton("Add Task");
            JButton doneButton = new JButton("Mark as Done");
            JButton removeButton = new JButton("Remove Completed");

            // Set layout
            setLayout(new BorderLayout());

            // Add components to the frame
            add(new JScrollPane(tasksList), BorderLayout.CENTER);

            JPanel inputPanel = new JPanel();
            inputPanel.add(taskInput);
            inputPanel.add(addButton);
            inputPanel.add(doneButton);
            inputPanel.add(removeButton);

            add(inputPanel, BorderLayout.SOUTH);

            // Add ActionListener to buttons
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addTask();
                }
            });

            doneButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    markAsDone();
                }
            });

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeCompletedTasks();
                }
            });

            // Set frame properties
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(null); // Center the frame
            setVisible(true);
        }

        private void addTask() {
            String task = taskInput.getText().trim();
            if (!task.isEmpty() && !tasksListModel.contains(task)) {
                tasksListModel.addElement(task);
                taskInput.setText("");
            }
        }

        private void markAsDone() {
            int selectedIndex = tasksList.getSelectedIndex();
            if (selectedIndex != -1) {
                tasksListModel.remove(selectedIndex);
            }
        }

        private void removeCompletedTasks() {
            for (int i = tasksListModel.size() - 1; i >= 0; i--) {
                if (tasksList.isSelectedIndex(i)) {
                    tasksListModel.remove(i);
                }
            }
        }

        public void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ToDoListGUI();
                }
            });
        }
    }
}