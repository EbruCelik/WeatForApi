package com.example.deneme

import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.widget.TextView
import androidx.cardview.widget.CardView
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {


    lateinit var manager: NotificationManager
    lateinit var channel: NotificationChannel
    lateinit var notificationBuilder: Notification.Builder

    private val channelId: String = "com.tutorials.localnotification"
    private val description: String = "Notification Sample Description"
    private val notoficationId = 1001
    private val requestCode = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //bir uyarı mesajı yaratma

        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        tvuyari.setOnClickListener {



            val notificationTitle = "Uyarı Bildirimi"
            val notificationContent = "Hava durumu bilgisi"

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//auto generated by idea
                channel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                channel.enableLights(true)
                channel.lightColor = Color.BLUE
                channel.enableVibration(true)

                manager.createNotificationChannel(channel)

                notificationBuilder = Notification.Builder(this, channelId)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationContent)
                    .setSmallIcon(R.drawable.notify)
                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.notify))

            } else {
                notificationBuilder = Notification.Builder(this)
                    .setContentTitle(notificationTitle)
                    .setContentText(notificationContent)
                    .setSmallIcon(R.drawable.notify)
                    .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.notify))

            }

            manager.notify(notoficationId, notificationBuilder.build())
        }



        //bir favoriler arraylisti yaratıp içerisinde eleman olup olmadığını kontrol etme




    val favArrayList = ArrayList<String>()

// Butonun tıklama olayını belirle
        imgfavbtn.setOnClickListener {
            // TextView'dan veriyi al
            val veri = tvsehir.text.toString()

            if (favArrayList.size < 3) {
                // Veriyi ArrayList'e ekle
                favArrayList.add(veri)
                Toast.makeText(this, "Veri eklendi: $veri", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Maksimum veri sayısına ulaşıldı. Veri eklenemiyor.", Toast.LENGTH_SHORT).show()
            }
        }

// Sil butonunun tıklama olayını belirle
        imgnotfavbtn.setOnClickListener {
            val silinecekVeri = tvsehir.text.toString()

            if (favArrayList.contains(silinecekVeri)) {
                // Veriyi ArrayList'ten sil
                favArrayList.remove(silinecekVeri)
                Toast.makeText(this, "Veri silindi: $silinecekVeri", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "ArrayList'te böyle bir veri bulunamadı.", Toast.LENGTH_SHORT).show()
            }
        }


        cvfavoriler1.setOnClickListener{
            val intent = Intent(this, FavActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Favoriler 1 cardview'a tıklandı $tv2fav1", Toast.LENGTH_SHORT).show()

        }

        cvfavoriler2.setOnClickListener{

            val intent = Intent(this, FavActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Favoriler 2 cardview'a tıklandı $tv2fav2", Toast.LENGTH_SHORT).show()

        }

        cvfavoriler3.setOnClickListener{
            val intent = Intent(this, FavActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Favoriler 3 cardview'a tıklandı $tv2fav3", Toast.LENGTH_SHORT).show()

        }


        btnmenu.setOnClickListener{
            val intent = Intent(this, FavActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Menu butonuna tıklandı $btnmenu", Toast.LENGTH_SHORT).show()

        }


    }


}