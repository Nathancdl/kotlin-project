package com.example.kotlin_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

/*GlobalScope.launch{
    nextscreen()
}*/


        //test
}

/*suspend fun nextscreen(){
//function async excute after launch first layout
delay(2000)
val intent = Intent(this, MyProfileActivity::class.java)
startActivity(intent);

}*/
}