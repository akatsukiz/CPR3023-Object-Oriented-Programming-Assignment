package BasicVersion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

//import for GUI

public class BasicKidMathematicsApplication extends JFrame implements ActionListener 
{

	//create object for JButton, JTextField, JFrame
    private JButton addButton, minusButton, multiplicationButton; 
    private JTextField welcomeMessage, instructionMessage, questionText, questionNumber, exerciseName;
    private JFrame questionFrame, summaryFrame;
    private static int mode=0; //store game mode 1=Addition 2=Subtraction 3=Multiplication
    private static int[][] questions = new int[5][3]; //store questions and correct answers
    private static int[] userAns = new int[5]; //store user's answers
    private static boolean[] correct = new boolean[5]; //store user correct or incorrect
    private static int correctCount; //store number of correct answers
    private static int quesCounter=0; //count number of question
	private static int count; //use to make sure only one summary frame is open at one time
    
    public BasicKidMathematicsApplication() 
    {
        // Set up the frame
        setTitle("Kid's Mathematics Application"); //set frame title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set close operation
        setSize(900, 900); //set frame size
        setLocationRelativeTo(null); // Center the frame
        URL imageUrl = BasicKidMathematicsApplication.class.getResource("mainMenu.png"); //set background
        
        // Create an ImageIcon object with the image URL
        ImageIcon backgroundImage = new ImageIcon(imageUrl);

        // Create a panel with the image as the background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        panel.setLayout(null); //to customize layout by oneself
        // Initialize the GUI components
        welcomeMessage = new JTextField("Welcome"); //set what inside the textfield
        welcomeMessage.setBounds(280, 90, 420, 130); //set size and location
        welcomeMessage.setOpaque(false); //make the text field transparent
        welcomeMessage.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and font style
        welcomeMessage.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //clear text field border
        welcomeMessage.setEditable(false); //set text field cannot be edit
        
        instructionMessage = new JTextField("Please select the game. "); //set what inside the text field
        instructionMessage.setBounds(178, 150, 420, 130); //set size and location
        instructionMessage.setOpaque(false); //make the text field transparent
        instructionMessage.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
        instructionMessage.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //clear text field border
        instructionMessage.setEditable(false); //set text field cannot be edit
        
        addButton = new JButton("Addition"); //Set button name
        addButton.addActionListener(this); //add action listener
        addButton.setBounds(270, 260, 280, 130); //set location and size
        addButton.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
        addButton.setFocusPainted(false); //clear focus painted
        addButton.setBackground(new Color(198, 224, 249)); //set colour for button by using RGB colour
        

        minusButton = new JButton("Subtraction"); //set button name
        minusButton.addActionListener(this); //add action listener
        minusButton.setBounds(270, 420, 280, 130); //set location and size
        minusButton.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
        minusButton.setFocusPainted(false); //clear focus painted
        minusButton.setBackground(new Color(142, 221, 190)); //set colour for button by using RGB colour

        multiplicationButton = new JButton("Multiplication"); //set button name
        multiplicationButton.addActionListener(this); //add action listener
        multiplicationButton.setBounds(270, 580, 280, 130); //set size and location 
        multiplicationButton.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
        multiplicationButton.setFocusPainted(false); //clear focus painted
        multiplicationButton.setBackground(new Color(80, 202, 211)); //set colour for button by using RGB colour

        // Add the components to the panel
        panel.add(instructionMessage);
        panel.add(welcomeMessage);
        panel.add(addButton);
        panel.add(minusButton);
        panel.add(multiplicationButton);

        // Add the panel to the frame
        add(panel);

        // Show the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == addButton) //if addition game is clicked
		{
			mode=1; //set game mode to 1
		    for(int i=0;i<5;i++) { //loop 5 times to generate 5 questions
		        // Generate 2 random numbers for addition
		        int num1 = (int) (Math.random() * 20) + 1; //generate random number from 1-20
		        int num2 = (int) (Math.random() * 20) + 1; //generate random number from 1-20
		        int answer = num1+num2; //calculate correct answers
		        //Store questions and correct answers into array
		        questions[i][0] = num1;
		        questions[i][1] = num2;
		        questions[i][2] = answer;
		    }
		    	//Create a new JFrame to display the questions
		    	displayQuestions();
		}
		else if (e.getSource() == minusButton)  //if subtraction game is clicked
		{
			mode=2; //set game mode to 2
		    for(int i=0;i<5;i++) { //loop 5 times to generates 5 questions
		        // Generate 2 random numbers for addition
		    	int num1 = (int) (Math.random() * 10) + 11; //generate random number from 11-20
	            int num2 = (int) (Math.random() * 10) + 1; //generate random number from 1-10
		        int answer = num1-num2; //calculate correct answers
		        //Store questions and correct answers into array
		        questions[i][0] = num1;
		        questions[i][1] = num2;
		        questions[i][2] = answer;
		    }
		  //Create a new JFrame to display the questions
	    	displayQuestions();
	}
		else if (e.getSource() == multiplicationButton)  //if multiplication game is clicked
		{
			mode=3; //set game mode to 3
		    for(int i=0;i<5;i++) { //loop 5 times to generate 5 questions
		        // Generate 2 random numbers for addition
		    	int num1 = (int) (Math.random() * 10) + 1; //generate random number from 1-10
	            int num2 = (int) (Math.random() * 10) + 1; //generate random number from 1-10
		        int answer = num1*num2; //calculate correct answers
		        //Store questions and correct answers into array
		        questions[i][0] = num1;
		        questions[i][1] = num2;
		        questions[i][2] = answer;
		    }
		  //Create a new JFrame to display the questions
	    	displayQuestions();
	}
	}
    public void displayQuestions() { //display question for user to answer
    	dispose(); //close game mode menu
        quesCounter = 0; //count number of question
        switch(mode) //set frame name according to game mode
        {
        case 1:
        	questionFrame = new JFrame("Addition Questions");
        	break;
        case 2:
        	questionFrame = new JFrame("Subtraction Questions");
        	break;
        case 3:
        	questionFrame = new JFrame("Multiplication Questions");
        	break;
        }
        questionFrame.setSize(900, 900); //set frame size
        questionFrame.setLocationRelativeTo(null); //center the frame
        questionFrame.addWindowListener(new WindowAdapter() { //add window listener
            @Override
            public void windowClosing(WindowEvent e) {
                // Create a new instance of BasicKidMathematicsApplication when the questionFrame is closed
            	BasicKidMathematicsApplication menu = new BasicKidMathematicsApplication();
                // Dispose the questionFrame
                questionFrame.dispose();
            }
        });

        URL imageUrl = BasicKidMathematicsApplication.class.getResource("question.png"); //set background
        ImageIcon backgroundImage = new ImageIcon(imageUrl);
        JPanel questionPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        questionPanel.setLayout(null); //to customize layout
        questionNumber = new JTextField("Question 1"); //set text of text field
        switch(mode) //set question text to text field according to game mode
        {
        case 1:
        	questionText = new JTextField(questions[0][0] + " + " + questions[0][1] + " = ");
	        break;
        case 2:
        	questionText = new JTextField(questions[0][0] + " - " + questions[0][1] + " = ");
	        break;
        case 3:
        	questionText = new JTextField(questions[0][0] + " x " + questions[0][1] + " = ");
	        break;
        }
        switch(mode) //set exercise name to text field according to game mode
        {
        case 1:
        	exerciseName = new JTextField("Excercise: Addition");
        	break;
        case 2:
        	exerciseName = new JTextField("Excercise: Subtraction");
        	break;	
        case 3:
        	exerciseName = new JTextField("Excercise: Multiplication");
        	break;
        }
        exerciseName.setBounds(450, 0, 600, 150); //set size and location
        exerciseName.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
        exerciseName.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //clear border of text field
        exerciseName.setOpaque(false); //set text field to transparent
        exerciseName.setEditable(false); //set text field cannot be edit
        questionPanel.add(exerciseName); //add text field to panel
        
        questionNumber.setBounds(450, 180, 150, 150); //set text field size and location
        questionNumber.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
        questionNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //clear border of text field
        questionNumber.setOpaque(false); //set text field to transparent
        questionNumber.setEditable(false); //set text field cannot be edit
        questionPanel.add(questionNumber); //add text field onto the panel
        
        questionText.setBounds(450, 240, 150, 150); //set size and location
        questionText.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
        questionText.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //clear border of text field
        questionText.setOpaque(false); //set text field to transparent
        questionText.setEditable(false); //set text field cannot be edit
        questionPanel.add(questionText); //add text field onto panel
        
        JTextField answerField = new JTextField(3); //initialize answer field text field
        answerField.setBounds(590, 285, 100, 50); //set size and location
        answerField.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
        questionPanel.add(answerField); //add text field onto panel

        JButton submitButton = new JButton("Submit"); //initialize submit button
        submitButton.setFont(new Font("Arial", Font.BOLD, 20)); //set font size and style
        submitButton.setBounds(520, 400, 100, 50);
        submitButton.setBackground(new Color(217, 178, 163)); //set button colour by RGB
        submitButton.setFocusPainted(false); //clear focus painted
        questionPanel.add(submitButton); //add submit button onto panel
        submitButton.addActionListener(new ActionListener() { //add action listener
            public void actionPerformed(ActionEvent e) { //when submit button is clicked
                if (quesCounter <= 4) { //only run when user have not finish the question
                	try
                	{
                	String ans = answerField.getText();
                    if (ans.isEmpty()||ans.isBlank()) { //check if answer is empty
                        JOptionPane.showMessageDialog(questionFrame, "Please enter an answer.");
                        return; //if is empty, back to the question
                    }
                    userAns[quesCounter] = Integer.parseInt(ans); //parse int user answer from string
                    if(userAns[quesCounter]<0)
                    {
                    	JOptionPane.showMessageDialog(questionFrame, "Please enter a positive number.");
                    	answerField.setText("");
                        return; //if is empty, back to the question
                    }
                    if (questions[quesCounter][2] == userAns[quesCounter]) {//check if the answer is correct
                        correct[quesCounter] = true; //if correct store as true
                    } else {
                        correct[quesCounter] = false;//else wrong store as false
                    }
                
                quesCounter++; //count the question
                if (quesCounter == 5) { //after user finish 5 questions
                    displayResults(); //display the results
                    questionFrame.dispose(); //close the question frame
                }
                if (quesCounter <= 4) { //if user have not finish 5 questions, display question
                	switch(mode) //dislay question according to game mode
                	{
                	case 1:
                	questionNumber.setText("Question "+(quesCounter+1));
                    questionText.setText(questions[quesCounter][0] + " + " + questions[quesCounter][1] + " = ");
                    	break;
                	case 2:
                	questionNumber.setText("Question "+(quesCounter+1));
                	questionText.setText(questions[quesCounter][0] + " - " + questions[quesCounter][1] + " = ");
                		break;
                	case 3:
                	questionNumber.setText("Question "+(quesCounter+1));
                	questionText.setText(questions[quesCounter][0] + " x " + questions[quesCounter][1] + " = ");
                		break;
                	}
                    answerField.setText(""); //reset the text field everytime when finishing one question
                }
                	}catch(NumberFormatException exception) //catch non numeric input
                    {
                    	JOptionPane.showMessageDialog(questionFrame, "Please enter an integer.");
                    	answerField.setText(""); //reset the text field
                        return; //if is empty, back to the question
                    }
                	}
            }
        });
        
        
        questionFrame.add(questionPanel); //add question panel onto frame
        questionFrame.setVisible(true); //set frame visible
        
    }


    public void displayResults() //display results
    {
    	count=0; //use to make sure only one summary frame is open at a same time
    	correctCount = countCorrectAnswers(); //count number of correct answers
    	questionFrame.dispose(); //close question frame
        JFrame resultFrame = new JFrame("Results"); //initialize result frame
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set close operation
        resultFrame.setSize(900, 900); //set size
        resultFrame.setLocationRelativeTo(null); //center the frame

        // Add the result components to the frame
        URL imageUrl = BasicKidMathematicsApplication.class.getResource("result.png"); //set background
        
        // Create an ImageIcon object with the image URL
        ImageIcon backgroundImage = new ImageIcon(imageUrl);

        // Create a panel with the image as the background
        JPanel resultPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        resultPanel.setLayout(null); //to customize the layout
        //initialize the component
        JLabel resultLabel1 = new JLabel("You got " + correctCount+" questions");
        JLabel resultLabel2 = new JLabel("out of 5 questions correct.");
        JButton playAgainButton = new JButton("Play Again");
        JButton summaryButton = new JButton("Summary");
        //set size and location
        resultLabel1.setBounds(310,250,600,50);
        resultLabel2.setBounds(280,300,600,50);
        playAgainButton.setBounds(280,400,350,60);
        summaryButton.setBounds(280,500,350,60);
        //set font size and style
        resultLabel1.setFont(new Font("Arial", Font.PLAIN, 30));
        resultLabel2.setFont(new Font("Arial", Font.PLAIN, 30));
        playAgainButton.setFont(new Font("Arial", Font.PLAIN, 30));
        summaryButton.setFont(new Font("Arial", Font.PLAIN, 30));
        //set button colour by RGB colour
        playAgainButton.setBackground(new Color(245, 132, 104));
        summaryButton.setBackground(new Color(243, 100, 151));
        //clear focus painted
        playAgainButton.setFocusPainted(false);
        summaryButton.setFocusPainted(false);
        //set layout
        resultPanel.add(resultLabel1, BorderLayout.NORTH);
        resultPanel.add(resultLabel2, BorderLayout.NORTH);
        //add button onto panel
        resultPanel.add(playAgainButton);
        resultPanel.add(summaryButton);
        resultFrame.add(resultPanel); //add panel onto frame
        resultFrame.setVisible(true); //set frame visible
        playAgainButton.addActionListener(new ActionListener() { //add action listener
            public void actionPerformed(ActionEvent e) { //if play again is clicked
            	resultFrame.dispose(); //dispose result frame
            	if(count>=1) //if summary frame is open already
            	{
            	summaryFrame.dispose(); //dispose summary frame
            	}
                new BasicKidMathematicsApplication(); //call game mode menu
            }
        });
        summaryButton.addActionListener(new ActionListener() { //add action listener
            public void actionPerformed(ActionEvent e) { //if summary is clicked
            	count++; //check if only one summary frame is open at a time
                StringBuilder summary = new StringBuilder();
                switch(mode) //append summary according to game mode
                {
                case 1:
                for (int i = 0; i < 5; i++) {
                    summary.append("Question "+(i+1)+": "+questions[i][0] + " + " + questions[i][1] + " = " + userAns[i]);
                    if (correct[i]) {
                        summary.append(" (Correct)\n");
                    } else {
                        summary.append(" (Incorrect, should be " + questions[i][2] + ")\n");
                    }
                }
                break;
                case 2:
                	for (int i = 0; i < 5; i++) {
                        summary.append("Question "+(i+1)+": "+quesCounter+": "+questions[i][0] + " - " + questions[i][1] + " = " + userAns[i]);
                        if (correct[i]) {
                            summary.append(" (Correct)\n");
                        } else {
                            summary.append(" (Incorrect, should be " + questions[i][2] + ")\n");
                        }
                    }
                break;
                case 3:
                	for (int i = 0; i < 5; i++) {
                        summary.append("Question "+(i+1)+": "+quesCounter+": "+questions[i][0] + " x " + questions[i][1] + " = " + userAns[i]);
                        if (correct[i]) {
                            summary.append(" (Correct)\n");
                        } else {
                            summary.append(" (Incorrect, should be " + questions[i][2] + ")\n");
                        }
                    }
                break;
                }
                if (count==1) //if this is the first time clicking summary button
                {
                // create a new JFrame to display the summary
                summaryFrame = new JFrame("Summary"); //initialize summary frame
                JTextArea summaryText = new JTextArea(summary.toString()); //initialize summary text
                summaryFrame.setLocationRelativeTo(null); //center the frame
                summaryText.setEditable(false); //set summary text cannot be edit

                // Add the result components to the frame
                URL imageUrl = BasicKidMathematicsApplication.class.getResource("summary.png"); //set background
                
                // Create an ImageIcon object with the image URL
                ImageIcon backgroundImage = new ImageIcon(imageUrl);

                // Create a panel with the image as the background
                JPanel summaryPanel = new JPanel() {
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
                    }
                };
                summaryText.setOpaque(false); //set text field to transparent
                summaryPanel.add(summaryText); //add textfield onto panel
                summaryPanel.setLayout(null); //to customize layout
                summaryText.setBounds(100,360,800,600); //set location and size
                summaryText.setForeground(new Color(241, 247, 231)); //set text colour by RGB
                summaryText.setFont(new Font("Arial", Font.PLAIN, 30)); //set font size and style
                summaryPanel.add(summaryText); //add text onto panel
                summaryFrame.add(summaryPanel); //add panel onto frame
                
                summaryFrame.setSize(900, 900); //set frame size
                summaryFrame.setLocationRelativeTo(null); ///center the frame
                summaryFrame.setVisible(true); //set frame visible
            }
                else //already have summary frame opened
                {
                	summaryFrame.setVisible(true); //set frame visible
                	summaryFrame.setLocationRelativeTo(null); //center the frame
                }
            }
        });
    }
    private int countCorrectAnswers() { //to count number of correct answer
        int count2 = 0;
        for (boolean c : correct) {
            if (c) {
                count2++;
            }
        }
        return count2;
    }
    
    public static void main(String[] args) //main class
    {
    	BasicKidMathematicsApplication menu = new BasicKidMathematicsApplication();//call input main menu
    }
    
}