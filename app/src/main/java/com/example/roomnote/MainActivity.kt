package com.example.roomnote

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floatingActionButton.setOnClickListener {
            showMultipleAlert()}
         floatingActionButton2.setOnClickListener{ showSimpleAlert() }
            floatingActionButton3.setOnClickListener { showSingleChoiceAlert() }
            floatingActionButton4.setOnClickListener{ showCustomAlert() }
         }

    private fun showSimpleAlert()
    {
        val simpleAlert=AlertDialog.Builder(this)
            .setTitle("Hey ,how may i help you?")
            .setMessage("Always try to be your own boss")
            .setPositiveButton("ok") { dialog, which ->
                dialog.cancel()
                //To change body of created functions use File | Settings | File Templates.
            }
//            .setPositiveButton("hup",object :DialogInterface.OnClickListener{})
//            to implement interface we use object:....
            .setNegativeButton("close",object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    //To change body of created functions use File | Settings | File Templates.
                }
            })

            .setCancelable(true)
//by default cancelable is true , make it false if you want to imlement the alert
            .create()
            simpleAlert.show()
    }
    val itemsArray= arrayOf("Item 1", "Item 2","Item 3")
    val checkedArray= booleanArrayOf(false,false,false)

    private fun showMultipleAlert()
    {
        val multipleAlert=AlertDialog.Builder(this)

            .setMultiChoiceItems(itemsArray,checkedArray){dialog, which, isChecked ->
                Toast.makeText(this,itemsArray[which],Toast.LENGTH_SHORT).show()
            }
            .setTitle("Hi Coders!")
          //  .setMessage("Please select on option among following")
            .setPositiveButton("ok"){dialog, which ->
                dialog.cancel()
            }
            .setNegativeButton("Close"){dialog, which ->
                dialog.cancel()
            }
            .create()

        multipleAlert.show()
    }

    private fun showSingleChoiceAlert()
    {
        val singleAlert=AlertDialog.Builder(this)
            .setSingleChoiceItems(itemsArray,0) { dialog, which ->
               //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(this,itemsArray[which],Toast.LENGTH_SHORT).show()

            }
            .setTitle("Hii")
            .setPositiveButton("Ok"){dialog, which ->
                dialog.cancel()
            }
            .setNegativeButton("close"){dialog, which ->
                dialog.cancel()
            }
        singleAlert.show()
    }

    private fun showCustomAlert()
    {  val dialogueView=LayoutInflater.from(this).inflate(R.layout.alert,null,false)
        val customAlertDialog=AlertDialog.Builder(this)
        .setTitle("Hey!")
            .setView(dialogueView)
            .setPositiveButton("Ok"){dialog, which ->
                dialog.cancel()
                Toast.makeText(this
                    , "Title: ${dialogueView.title.text} Subtitle:${dialogueView.subtitle.text}"  ,Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("close"){dialog, which ->
                dialog.cancel()
            }
            .create()
        customAlertDialog.show()

    }


}