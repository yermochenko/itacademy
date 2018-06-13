package by.vsu.fmiit.aspd.proit.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import by.vsu.fmiit.aspd.proit.bot.RandomRobot;
import by.vsu.fmiit.aspd.proit.bot.Robot;
import by.vsu.fmiit.aspd.proit.control.Game;
import by.vsu.fmiit.aspd.proit.control.MoveObserver;
import by.vsu.fmiit.aspd.proit.core.Coordinates;

public class GameFrame extends JFrame implements MoveObserver {
	private Class<? extends Robot> player;
	private Class<? extends Robot> enemy;
	private Mark marks[][] = new Mark[3][3];
	private JButton next;
	private Semaphore semaphone = new Semaphore(1);

	private GameFrame() {
		super("Крестики-нолики для роботов");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 50, 400, 500);
		JPanel buttons = new JPanel(new FlowLayout());
		JButton buttonX = new JButton("Играть за X");
		buttonX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						play(player, enemy);
					}
				}).start();
			}
		});
		buttonX.setPreferredSize(new Dimension(150, 30));
		buttonX.setBackground(new Color(63, 72, 204));
		buttons.add(buttonX, BorderLayout.WEST);
		JButton buttonO = new JButton("Играть за O");
		buttonO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						play(enemy, player);
					}
				}).start();
			}
		});
		buttonO.setPreferredSize(new Dimension(150, 30));
		buttonO.setBackground(new Color(237, 28, 36));
		buttons.add(buttonO, BorderLayout.EAST);
		add(buttons, BorderLayout.NORTH);
		JPanel grid = new JPanel(new GridLayout(3, 3, 10, 10));
		grid.setBackground(new Color(0, 0, 0));
		for(int i = 0; i < marks.length; i++) {
			for(int j = 0; j < marks[i].length; j++) {
				marks[i][j] = new Mark();
				grid.add(marks[i][j]);
			}
		}
		add(grid, BorderLayout.CENTER);
		JPanel process = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		next = new JButton("Далее");
		next.setEnabled(false);
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				semaphone.release();
			}
		});
		process.add(next);
		add(process, BorderLayout.SOUTH);
		setVisible(true);
		validate();
	}

	private GameFrame(Class<? extends Robot> player, Class<? extends Robot> enemy) {
		this();
		this.player = player;
		this.enemy = enemy;
	}

	public GameFrame(Class<? extends Robot> player) {
		this(player, RandomRobot.class);
	}

	@Override
	public void nonify(by.vsu.fmiit.aspd.proit.core.Mark mark, Coordinates coordinates) {
		Mark current = marks[coordinates.getRow() - 1][coordinates.getColumn() - 1];
		current.setMark(mark);
		current.repaint();
		try {
			semaphone.acquire();
			next.setEnabled(true);
			semaphone.acquire();
			next.setEnabled(false);
			semaphone.release();
		} catch (InterruptedException e) {}
	}

	private void play(Class<? extends Robot> a, Class<? extends Robot> b) {
		for(int i = 0; i < marks.length; i++) {
			for(int j = 0; j < marks[i].length; j++) {
				marks[i][j].setMark(null);
				marks[i][j].repaint();
			}
		}
		Game game = new Game();
		game.setMoveObserver(this);
		Map<Class<? extends Robot>, Integer> result = game.play(a, b);
		next.setEnabled(false);
		int playerResult = result.get(player);
		int enemyResult = result.get(enemy);
		if(playerResult == 0 && enemyResult == 0) {
			JOptionPane.showMessageDialog(null, "Игра окончена. Техническая ничья");
		} else if(playerResult == 0 && enemyResult == 1) {
			JOptionPane.showMessageDialog(null, "Игра окончена. Технический проигрыш");
		} else if(playerResult == 1 && enemyResult == 0) {
			JOptionPane.showMessageDialog(null, "Игра окончена. Технический выигрыш");
		} else if(playerResult == 1 && enemyResult == 1) {
			JOptionPane.showMessageDialog(null, "Игра окончена. Ничья");
		} else if(playerResult == 2 && enemyResult == 0) {
			JOptionPane.showMessageDialog(null, "Игра окончена. Выигрыш");
		} else if(playerResult == 0 && enemyResult == 2) {
			JOptionPane.showMessageDialog(null, "Игра окончена. Проигрыш");
		} else {
			JOptionPane.showMessageDialog(null, "Игра окончена. Результат неопределён");
		}
	}

	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
	}
}
