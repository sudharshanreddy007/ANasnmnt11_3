package com.sudharshan.user.anasnmnt11_3;


import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DBhelper DbHelper;
    //create class DBHelper
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
// call the super class onCreate to complete the creation of activity like the view hierarchy
        setContentView(R.layout.activity_main);

        DbHelper = new DBhelper(this);
        //performing insert operation and closing database
        Employee employee_One = new Employee(BitmapFactory.decodeResource(
                getResources(), R.drawable.lollipop),"Lollipop", 22);
        //Creates Bitmap objects from various sources, including files, streams, and byte-arrays.
        //decodeResource:Parameters
        // res	Resources: The resources object containing the image data
        //id	int: The resource id of the image data
        //  Returns
        // Bitmap	The decoded bitmap, or null if the image could not be decoded.
        DbHelper.open();//opens the database
        DbHelper.insertEmpDetails(employee_One);//insert the employee details
        DbHelper.close();//closes the database
        employee_One = null;//opens we close the database we will clear the database and opens the db empty next time
        DbHelper.open();//again opens the db
        employee_One = DbHelper.retriveEmpDetails();//retriving the emp details into object
        DbHelper.close();//closes the db
        //Finding texviews and imageview in java and using set method
        TextView empname = (TextView) findViewById(R.id.name);
        //A user interface element that displays text to the user.
        //findViewById:A user interface element that displays text to the user.
        empname.setText(employee_One.getName());
        //Sets the text to be displayed using a string resource identifier.
        //get the value of emp name from object
        ImageView empphoto = (ImageView) findViewById(R.id.photo);
        //Displays image resources, for example Bitmap or Drawable resources. ImageView is also commonly used to apply tints to an image and handle image scaling.
        //a bitmap is a mapping from some domain to bits. It is also called a bit array or bitmap index
        empphoto.setImageBitmap(employee_One.getBitmap());
        TextView empage = (TextView) findViewById(R.id.age);
        empage.setText("" + employee_One.getAge());//get the age from the object

    }
}