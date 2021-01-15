import algorithm.Dijkstra;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LAB04 extends JFrame{
    private JPanel mainPanel;
    public JTextArea textArea1;

    public LAB04(String title) throws HeadlessException, InterruptedException {
        super(title);

        long startTime = System.currentTimeMillis();

        Monitor monitor = new Monitor();

        Thread thread1 = new Dijkstra();
        thread1.setName("Dijkstra1");

        Thread thread2 = new Dijkstra();
        thread2.setName("Dijkstra2");

        monitor.addThread(thread1);
        monitor.addThread(thread2);

        thread1.start();
        thread2.join();
        thread2.start();

        monitor.run(textArea1);
/*
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.run();

        Dijkstra dijkstra1 = new Dijkstra();
        dijkstra1.run();
*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setContentPane(mainPanel);
        this.pack();

        long timeSpend = System.currentTimeMillis() - startTime;
        System.out.println(timeSpend);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new LAB04("LAB04_window");
        frame.setVisible(true);
    }
}

class Monitor{
    private List<Thread> threadList = new ArrayList<>();

    private List<String> statesList = new ArrayList<>();

    public void addThread(Thread thread){
        threadList.add(thread);
    }

    public void run(JTextArea textArea) {
        while (threadList.stream().anyMatch(t -> t.getState() != Thread.State.TERMINATED)){
            for (Thread thread : threadList){
                //System.out.println(thread.getName() + ": " + thread.getState());
                if (thread.getState() != Thread.State.TERMINATED){
                    statesList.add(thread.getName() + ": " + thread.getState() + "\n");
                }
            }
        }

        for (Thread thread : threadList){
            statesList.add(thread.getName() + ": " + thread.getState() + "\n");
        }

        for (String s : statesList){
            textArea.append(s);
        }
    }
}
