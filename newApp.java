package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.NavigationCommand;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

public class newApp {

    private Form current;
    private Resources theme;

    private Form home;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

    }
    public void start() {
        if (current != null) {
            current.show();
            return;
        }

        //create and build the home Form
       
        home = new Form("Home");
        home.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        home.addComponent(new Label("Welcome to the personality quiz!"));
    	

        Button b1 = new Button("Click to begin!");
        Button b2 = new Button("about this quiz");
        home.addComponent(b1);
        home.addComponent(b2); 
        //home.addComponent(picture);
        
        
        //Question Page 1
        QuestionPage page1 = new QuestionPage("You go to a fancy restaurant, do you choose to buy:"); 
        String a1 = "burger.png"; 
        String wN1 = "https://www.outback.com/menu/"; 
        page1.printPicture(theme, a1 );
        page1.imageDescription(wN1);
         
        page1.setOptions(1,"Fancy Salad. So many green options!","Most expensive thing on "
                + "the menu,"," Something with chicken. Its familiar.","Read through the "
                        + "descriptions and try something you have never had before.");
        
        
        
        
        
        QuestionPage page2 =  new QuestionPage("At the restaurant you came across this description:"
                + " Roasted Garlic Filet Medallions served with homestyle mashed potatoes and fresh "
                + "steamed broccoli. How much would you be willing to pay for his meal?"); 
        String a2 = "Steak.png"; 
        String wN2 = "https://www.outback.com/menu/steaks"; 
        page2.printPicture(theme, a2);
        page2.imageDescription(wN2);
        page2.setOptions(2,"$0-$15", "$16-$30", "$31-$45", "$46-$60");
        
        
        
        QuestionPage page3 = new QuestionPage("You have some extra spare money and decide to go shopping. "
                + "You see a shirt you love would love to buy. You look at the price and think: “WOW, what "
                + "a steal its only…"); 
        String a3 = "nike1.png";
        String wN3 = "http://store.nike.com/us/en_us/pd/signal-womens-t-shirt/pid-10865549/pgid-11088122"; 
        page3.printPicture(theme, a3);
        page3.imageDescription(wN3);
        page3.setOptions(3,"$0-$15","$16-$30","$31-$45","$46-$60"); 
        
        
        
        QuestionPage page4 = new QuestionPage("You finally just purchase the item. You are most likely "
                + "going to wear these clothes"); 
        String a4 = "nike1.png"; 
        String wN4 = "http://store.nike.com/us/en_us/pd/signal-womens-t-shirt/pid-10865549/pgid-11088122"; 
        page4.printPicture(theme, a4);
        page4.imageDescription(wN4);
        page4.setOptions(4,"Working out duh! That is why I bought it","Lounging around. Might as well look good "
                + "on the couch","Probably just for a light walk or daily activities like errands", "To the party"
                        + " tonight because I can do what I want and wear what I want"); 
        
        
        QuestionPage page5 = new QuestionPage("You got set up on a date and their picking you up at 8 pm "
                + "tonight. Your looking out the window and wondering what car they will show up in. "
                + "Rate how happy you would be if they showed up in this rocking vehicle"); 
       String a5 = "Audi2016.png"; 
       String wN5 = "https://www.cars.com/research/audi-a6-2016/"; 
       page5.printPicture(theme, a5);
       page5.imageDescription(wN5);
       page5.setOptions(5,"So excited!","I think its cool","Not the biggest fan","Absolutely not. Date cancelled."); 
        
        
       QuestionPage page6 = new QuestionPage("Your date finally arrives. For the sake of honesty you decide to tell him exactly"
               + "how you feel about the car. Comment away!"); 
       
       //TODO: INSERT TEXT BOX
      
       String a6 = "Audi2016.png"; 
       String wN6 = "https://www.cars.com/research/audi-a6-2016/"; 
       page6.printPicture(theme, a6);
       page6.imageDescription(wN6);
       page6.setOptions(6, "hell yes", "maybe", "eh", "no way!");
       
       
       QuestionPage page7 = new QuestionPage("You cannot get your mind off the shiny white 2016 Audi (and your cute date ;))."
               + "You wonder how much your date makes and decide to base his affluence off of how much you think the car is. "
               + "What do you think your price of the car would be..."); 
       String a7 = "Audi2016.png"; 
       String wN7 = "https://www.cars.com/research/audi-a6-2016/"; 
       page7.printPicture(theme, a7);
       page7.imageDescription(wN7);
       page7.setOptions(7,"$2,000 - $10,000","$10,000 - $50,000","$50,000 - $100,000","$100,000- %150,000");
       
       
       
       
       QuestionPage page8 = new QuestionPage("You dropped your phone for the seventeeth-hundred time. This time is not repairable."
               + " Time to go get a new phone! You walk in and there is the newest, hippest, phone on display. You..."); 
       String a8 = "iphone.png"; 
       String wN8 = "http://www.macrumors.com/roundup/iphone-8/"; 
       page8.printPicture(theme, a8);
       page8.imageDescription(wN8);
       page8.setOptions(8,"must have it. Plus it comes with a case that will strap to your arm when you go running","Probably"
               + "will just buy that one. It is on display for a reason so it is probably the best. Plus it will save you time and effort"
               + "walking around the store","Immediately start googling everything about the phone. You want to know the price, how much memory,"
                       + " it contains, and all of its gadgets. EVERYTHING.","Continue to look around the store. You want the best phone for you and do"
                               + "not like the store trying to persuade you to only one brand.");
     
       
       
       
       
       QuestionPage page9 = new QuestionPage("It has been a long day of endlessly working hard. You have been dreaming of this moment all day long. You see your bed."
               + "Based on the SFERRA linens alone, how excited are you to flop down on your bed?");
       String a9 = "bed.png"; 
       String wN9 = "https://www.sferra.com/bedding/duvet-covers/ambra-duvet-cover-white-sable"; 
       page9.printPicture(theme, a9);
       page9.imageDescription(wN9);
       page9.setOptions(9,"Not a chance. Would strictly be because you want to sleep. ","Ehh. I guess i is alright. I am sleepy anyway","Looks pretty good to me!","AWESOME. BEAUTIFUL");
       

        
        //Begin Game
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
               page1.show();
            }
        });
        
        //Move to next questions. for loop??
          
        page1.goToNextQuestion(page2);
        page2.goToNextQuestion(page3);
        page3.goToNextQuestion(page4);
        page4.goToNextQuestion(page5);
        page5.goToNextQuestion(page6);
        page6.goToNextQuestion(page7);
        page7.goToNextQuestion(page8);
        page8.goToNextQuestion(page9);
        page9.displayResults(home); 
        
    
        home.show();
    }


    public void stop() {
        current = Display.getInstance().getCurrent();
    }

    public void destroy() {
    }

}


