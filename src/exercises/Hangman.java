package exercises;

import java.util.*; 

import java.util.List;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import examples.FileHelper;

public class Hangman extends KeyAdapter {
	
	boolean invalidWord = false;
	String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
	char currentCharacter;
	boolean numberPresent = false;
    boolean specialCharacterPresent = false;
	int puzzleCount = 0;
	int input = 0;
	boolean win = false;
	int listSize = 0;
	String word = "";
	int randomIndex = 0;
	Random randomGenerator = new Random();
	Stack<String> puzzles = new Stack<String>();
	ArrayList<JLabel> boxes = new ArrayList<JLabel>();
	int lives = 9;
	JLabel livesLabel = new JLabel("" + lives);
	
	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.addPuzzles();
		hangman.createUI();
	}
	
	public List<String> loadWords() {
		List<String> wordList = FileHelper.loadFileContentsIntoArrayList("resource/words.txt");
		return wordList;
	}
	
	public void addPuzzles() { 
		List<String> listWord = loadWords();
		for (int i = 0; i < 10; i++) {
			try {
				int index = new Random().nextInt(listWord.size());
				word = "@b2"; //listWord.get(index);
		    	for (int j = 0; j < word.length(); j++) {
		    		currentCharacter = word.charAt(j);
		    		if (Character.isDigit(currentCharacter)) {
		    			numberPresent = true;
		    		}
		    		if (specialChars.contains(String.valueOf(currentCharacter))) {
		    			specialCharacterPresent = true;
		    		}
		    		
		    	}
		    }
			finally {
			}	
			if (numberPresent || specialCharacterPresent == true) {
				int index = new Random().nextInt(listWord.size());
    			System.out.println("Word " + word + " contains a number or Special characters now going to next word.");
    			word = listWord.get(index);
    			invalidWord = false;
    		}
		    
		    if (invalidWord == false) {
		    		puzzles.push(word.toLowerCase().trim());
		    }
		}
	}

	JPanel panel = new JPanel();
	private String puzzle;

	private void createUI() {
		playDeathKnell();
		JFrame frame = new JFrame("June's Hangman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(livesLabel);
		loadNextPuzzle();
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.addKeyListener(this);
	}
	private void resetUI() {
		panel.removeAll();
		panel.add(livesLabel);
		panel.updateUI();
		
			
		if(puzzleCount < 3) {
			loadNextPuzzle();
		}
		else {
			System.out.println("Congrats you beat them all!");
			System.exit(5);
		}
	}

	public void loadNextPuzzle() {
		removeBoxes();
		lives = 9;
		livesLabel.setText("" + lives);
		puzzle = puzzles.pop();
		System.out.println("puzzle is now " + puzzle);
		createBoxes();	
	}

	public void keyTyped(KeyEvent arg0) {
		System.out.println(arg0.getKeyChar());
		updateBoxesWithUserInput(arg0.getKeyChar());
		if (lives == 0) {
			playDeathKnell();
			loadNextPuzzle();
		}
	}

	public void updateBoxesWithUserInput(char keyChar) {
		boolean gotOne = false;
		for (int i = 0; i < puzzle.length(); i++) {
			if (puzzle.charAt(i) == keyChar) {
				boxes.get(i).setText("" + keyChar);
				gotOne = true;
				input++;
				if(gotOne = true) {
					if(boxes.size() == input) {
						input = 0;
						puzzleCount++;
						resetUI();
					}
				}	
			}
		}
		
		if (!gotOne) {
			livesLabel.setText("" + --lives);
		}
	}

	void createBoxes() {
		for (int i = 0; i < puzzle.length(); i++) {
			JLabel textField = new JLabel("_");
			boxes.add(textField);
			panel.add(textField);
		}
	}

	void removeBoxes() {
		for (JLabel box : boxes) {
			panel.remove(box);
		}
		boxes.clear();
	}
	
	public void playDeathKnell() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("resource/funeral-march.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			Thread.sleep(8400);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}




