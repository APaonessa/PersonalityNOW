package com.mycompany.myapp;

import java.io.IOException;
import java.io.OutputStream;
 


import com.codename1.components.ShareButton;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import java.util.Random;

public class QuestionPage {
    
    //Class fields. 
    //int questionNumber;
    private Form page; 
    private int questionTotal = 9;
    //private Button next; 
    SpanButton button1; 
    SpanButton button2;
    SpanButton button3;
    SpanButton button4;
    ButtonListener B = new ButtonListener();
    int countA;
    int countB;
    int countC;
    int countD;

    
    //Class constructor
   

   
    public void RandomInteger() {
          
        Random randomGenerator = new Random();
        for (int idx = 1; idx <= 10; ++idx){
          int randomInt = randomGenerator.nextInt(100);
          countA = randomGenerator.nextInt(100);
          countB = randomGenerator.nextInt(100);
          countC = randomGenerator.nextInt(100);
          countD = randomGenerator.nextInt(100); 
        }
      
    
    }
    
    
    public QuestionPage(String Q){
        page = new Form("PersonalityNOW");
        page.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setQuestion(Q);
              
    }
    
    //Class methods
    public void setQuestion(String Q){
        page.addComponent(new SpanLabel(Q));          
    }
    
    public void printPicture(Resources theme, String png ){
    	final Label picture = new Label(theme.getImage(png));
    	page.add(picture); 
    }
    
    public void imageDescription(String a){
    	Button b = new Button("Description");
    	b.getAllStyles().setBorder(Border.createEmpty());
    	b.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
    	page.add(b);
    	b.addActionListener((e) -> {
    		 Display.getInstance().execute(a);
    	});
    	
    }
    
    public void setOptions(int qNum, String O1, String O2, String O3, String O4){
    	
    	button1 = new SpanButton(O1); 
       	page.addComponent(button1); 
       	button1.addActionListener(B);
    	
    	
    	button2 = new SpanButton(O2); 
    	page.addComponent(button2);
    	button2.addActionListener(B);
    	
    	button3 = new SpanButton(O3); 
    	page.addComponent(button3); 
    	button3.addActionListener(B);
    	
    	button4 = new SpanButton(O4);
    	page.addComponent(button4);
    	button4.addActionListener(B);
        
        //show progress.
        showProgress(qNum);
    }

    public void showProgress(int questionNumber){   	
    	Label questionCounter = new Label("Question " + questionNumber + "/" + questionTotal);
    	page.addComponent(questionCounter);
    }

    public void goToNextQuestion(QuestionPage nextPage){
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
              	nextPage.show();
            }
        });
    	
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            	nextPage.show();
            }
        });
        
        
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            	nextPage.show();
            }
        });
        
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            	nextPage.show();
            }
        });

    }

   
    
    public void show(){
        page.show();
    }
    
    public void displayResults(Form home){
    	Form resultsPage = new Form("Results");
    	resultsPage.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
    	resultsPage.addComponent(B.getPersonality());
    	
    	button1.addActionListener(new ActionListener(){
    		
    		@Override
    		public void actionPerformed(ActionEvent evt){
    			resultsPage.show(); 
    		}
    	
    	}); 
    	 button2.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent evt) {
                resultsPage.show();
             }
         });
         
         
         button3.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent evt) {
                resultsPage.show();
             }
         });
         
         button4.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent evt) {
                resultsPage.show();
             }
         });
       
         //Share Button
         ShareButton sb = new ShareButton();
         sb.setText("Share Screenshot");
         resultsPage.add(sb);

         Image screenshot = Image.createImage(resultsPage.getWidth(), resultsPage.getHeight());
         resultsPage.revalidate();
         resultsPage.setVisible(true);
         resultsPage.paintComponent(screenshot.getGraphics(), true);

         String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
         try(OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
             ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
         } catch(IOException err) {
             Log.e(err);
         }
         sb.setImageToShare(imageFile, "image/png");
         
         //Start Over Button
         Button startOver = new Button("Start Over!"); 
         resultsPage.add(startOver); 
         startOver.addActionListener(new ActionListener(){
     		
     		@Override
     		public void actionPerformed(ActionEvent evt){
     			home.show();
     			countA = 0; 
     			countB = 0; 
     			countC = 0; 
     			countD = 0; 
     			
     		}
     	
     	}); 
    }
    
      private class  ButtonListener implements ActionListener
    {


		public void actionPerformed(ActionEvent e){
			if(e.getSource() == button1){
				countA++; //This is Sporty!
			}
			if(e.getSource() == button2)
			{
				countB++; //This is lazy but stylish
			}
			if(e.getSource() == button3)
			{
				countC++; //This is Nerd
			}
			if(e.getSource() == button4)
			{
				countD++; //Rebel for life
			}
		}
		
	    public SpanLabel getPersonality(){
	    	SpanLabel finalScore;
	    	RandomInteger(); 
	    	int x = countB + countC + countD; 
	    	int y = countA + countC + countD; 
	    	int z = countA + countB + countD; 
	    	
	    	if(countA > countB &&countA > countC && countA > countD) 
	    	{
	    		finalScore = new SpanLabel("You are Sporty! You are up for a challenge and finding something new. You are healthy"
	                    + " and probably exhausting  to most people between your food, exercise and daily lifestyle choices. Friends"
	                    + " may shun you because they do not want that salad or gym visit, use that energy to rock on !");
	    	}
	    	else if(countB > countA && countB > countC && countB > countD)
	    	{
	    		finalScore = new SpanLabel("You are lazy but stylish! No one loves their couch or bed more than you. Yes, "
	                    + " you are lazy, but you do it with such a sense of purpose you radiant endless style. Some people"
	                    + " may judge your choices (or lack of choices) but really they are just jealous so go you ! ");
	    	}
	    	else if(countC > countA && countC > countB && countC > countD)
	    	{
	    		 finalScore = new SpanLabel("You are Nerd! You love the familiar and the comfortable, probably a little too much."
	                     + " However, you own that lifestyle and get lost in your own passions. People probably do not understand"
	                     + " why you like to do the things you do so in a way that is pretty cool ! ");
	    	}
	    	else{
	    		 finalScore = new SpanLabel("You are Rebel for life! You do what you want when you want to do it."
	                     + " You do not let labels define you or people influence you in different ways. Congrats on being"
	                     + " totally and utterly unique and maybe a kind of a little reckless ! ");
	
	    	}
	    	return finalScore;
	    }

    
	
    }

	
}