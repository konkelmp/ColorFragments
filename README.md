# Color Fragments App
This simple app opens to the main activity with a top TextView for the header and two fragment container views below that. Upon start up the app inserts a FrameLayout with a
horizontal linear layout which contains two text views. This is inserted into the upper FCV. These text views are colored red and blue with respective text. These text views 
are clickable and once selected the desired choice is sent to the ColorFragment Kotlin code and a dynamic fragment is inserted into the bottom FCV with the respective choice
of color and it's corresponding UID. Upon pressing the back button the call back stack contains previous fragments and properly shows the correct one.
