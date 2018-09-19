# CEG4110_HW11 Canvas-Painter-and-Random-TextColor-Generator
Introduction
-------------
This app involves primarily with generating random colors for text and canvas painting utilizing color palletes, a delete button, and a 
navigation tool to switch between activities.

Requirements
------------------
No special requirements.

Random TextColor Generator Instructions
-----
![capture](https://user-images.githubusercontent.com/35312521/45727830-64c4b600-bb93-11e8-9399-cb5ef5f9f58a.PNG)

At location 1 is a editText field where you can just tap on it like any other text bar, and insert whatever keyboard characters you 
desire. 
Location 2 is the random TextColor button. Clicking it will alter the color of the inputed text.
Location 3 is a text field that
display the RGB values of the color chosen in the format
ie.
COLOR: xr, xg, xb, #FF0000
where x is the value of the color on the red, green and blue channel respectively. The app also display the HTML color code
of the color generated being the #FF0000. 
Location 4 is the button that will navigate you to part 2 of the application where you will be able to paint on the canvas.

Canvas Painter Instructions
---
![capture2](https://user-images.githubusercontent.com/35312521/45728224-157f8500-bb95-11e8-9326-ca71e75772fc.PNG)

At location 1 of part two is the color palettes where you will be able to select whatever color you wish to paint with simply by 
selecting the color via your finger.
Location 2 is the custom View which you are able to paint on by making moving contact with the touchscreen in that specified area.
Location 3 will return you to part 1 simply by clicking on the button.
Location 4 will clear the canvas if you decide to do so by pressing the button.

Software Design MainActivity class
---
In the main class we have initialized the variables int red = 0;
    int green = 0;
    int blue = 0;
    Button colorChange;
    EditText editText;
    TextView outputRGB;
    Button part2;.---
The integers blue red and green contain the values of the HTML color code that will match the text. THe button colorChange is what you 
press to change the color. The editText and the Textview are all in one method along with the previoud mentioned variables. We use a 
random number generator to collect three random numbers for the values red, blue, and green that relate to the HTML color code of the 
text and connect it with the outputRGB. We utilize the part2 button to  start a new activity.

Software Design ActivityPart2 class
---
Int this class we are able to relay all the commands by calling the DrawingBoard class. We are also able to detect which buttons were 
pressed via onClickListeners. The app is able to act accordingly depending on what is being asked. It  refers to either the paint.xml 
and the paint_pressed.xml for proper color and drawable values of the method. It also assigns all the color pallettes 

DrawingBoard Class
---
DrawingBoard is where the painting is all calculated and relayed back to ActivityPart2 in the drawingSetup method, we initialize values 
such as how large our paint stroke is the color, and we refer to which path it is taking. The onSizeChange method assigns the View a 
size, and the onDraw method is what declares what is drawable. onTouchEvent acts kinda like our path method in that we coordinate the X
and Y coordinates of the user's touch and allows us to respond accordingly. setColor is a setter which changes the color of the paint we 
are using. The delete method is what clears the Canvas.
