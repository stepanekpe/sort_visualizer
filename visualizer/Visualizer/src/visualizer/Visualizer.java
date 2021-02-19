package visualizer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import visualizer.algortihms.*;


public class Visualizer {
	public JFrame window;

	public Visualizer() throws Exception {
		window = new JFrame("Sort Visualizer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1280, 720);
		window.setBackground(Color.DARK_GRAY);


		JLabel title = new JLabel("Sort Visualizer");
		title.setForeground(Color.white);
		title.setFont(new Font("Verdana Bold", Font.PLAIN, 30));
		title.setBounds(550, 0, 300, 75);
		window.add(title);

		JLabel author = new JLabel("By Petr Stepanek");
		author.setForeground(Color.white);
		author.setFont(new Font("Verdana Bold", Font.PLAIN, 11));
		author.setBounds(620, 40, 300, 50);
		window.add(author);

		String[] algorithms = {"SelectionSort", "InsertSort", "BubbleSort", "QuickSort", "MergeSort", "HeapSort"};
		JComboBox<String> algos = new JComboBox<String>(algorithms);
		algos.setFont(new Font("Verdana Bold", Font.PLAIN, 11));
		algos.setBounds(425, 95, 150, 50);
		algos.setBackground(Color.WHITE);
		window.add(algos);

		JButton start = new JButton("Start Visualisation");
		start.setFont(new Font("Verdana Bold", Font.PLAIN, 11));
		start.setBounds(600, 95, 150, 50);
		start.setBackground(Color.WHITE);
		window.add(start);
		
		start.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        start.setBackground(new Color(147, 201, 252));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        start.setBackground(Color.WHITE);
		    }
		});

		JButton shuffle = new JButton("Shuffle");
		shuffle.setFont(new Font("Verdana Bold", Font.PLAIN, 11));
		shuffle.setBounds(775, 95, 150, 50);
		shuffle.setBackground(Color.WHITE);
		window.add(shuffle);
		
		shuffle.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        shuffle.setBackground(new Color(147, 201, 252));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        shuffle.setBackground(Color.WHITE);
		    }
		});

		Array arr = new Array(window);

		ISortAlgorithm selSort = new SelectionSort();
		ISortAlgorithm insSort = new InsertSort();
		ISortAlgorithm bubSort = new BubbleSort();
		ISortAlgorithm quiSort = new QuickSort();
		ISortAlgorithm merSort = new MergeSort();
		ISortAlgorithm heaSort = new HeapSort();

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(arr.sorted) return;
				switch(algos.getSelectedIndex()) {
				case 0:
					try {
						selSort.sort(arr);
						arr.sorted = true;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 1:
					try {
						insSort.sort(arr);
						arr.sorted = true;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 2:
					try {
						bubSort.sort(arr);
						arr.sorted = true;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				
				case 3:
					try {
						quiSort.sort(arr);
						arr.sorted = true;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
					
				case 4:
					try {
						merSort.sort(arr);
						arr.sorted = true;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
					
				case 5:
					try {
						heaSort.sort(arr);
						arr.sorted = true;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;	
				}	
			}
		});

		shuffle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				arr.shuffle();
				//arr.repaint();
				window.repaint();

			}
		});


		window.add(arr);

		window.setVisible(true);


	}
}
