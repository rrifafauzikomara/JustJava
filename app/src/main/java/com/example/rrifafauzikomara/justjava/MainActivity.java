package com.example.rrifafauzikomara.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int jumlah = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tambah (View view) {
        if(jumlah == 20){
            Toast.makeText(this, "Kamu tidak bisa memilih lebih dari 20 Coffie", Toast.LENGTH_SHORT).show();
            return;
        }
        jumlah = jumlah +1;
        display(jumlah);
    }

    public void kurang (View view) {
        if(jumlah == 1){
            Toast.makeText(this, "Kamu tidak bisa memilih kurang dari 1 Coffie", Toast.LENGTH_SHORT).show();
            return;
        }
        jumlah = jumlah -1;
        display(jumlah);
    }

    /**
     * Menampilkan jumlah quantity atau coffie yang akan di pesan pada layar
     */
    private void display(int number) {
        TextView jumlahPesanan = (TextView) findViewById (R.id.Qty);
        jumlahPesanan.setText("" + number);
    }

    private String membuatPesanan (int price, boolean addtopping, boolean addchocolate, String addnama) {
        String priceMessage = "Pesanan Atas Nama : " + addnama;
        priceMessage += "\nTambah Wipped Cream ? " + addtopping;
        priceMessage += "\nTambah Chocolate ? " + addchocolate;
        priceMessage += "\nJumlah Pesanan : " + jumlah;
        priceMessage += "\nTotal Harga: Rp. " + price;
        priceMessage += "\nThank You!";
        return priceMessage;

    }

    /**
     * Menghitung harga coffie beserta tambahan topping atau coklat
     */
    private int calculatePrice(boolean addtopping, boolean addchocolate) {
        int hargaCoffie = 5000;
        if (addtopping) {
            hargaCoffie = hargaCoffie + 1000;
        }
        if (addchocolate){
            hargaCoffie = hargaCoffie + 2000;
        }
        return jumlah * hargaCoffie;
    }


    private void tampil (String message) {
        TextView totalHarga = (TextView) findViewById(R.id.price);
        totalHarga.setText(message);
    }


    /**
     * Melakukan eksekusi ketika button Order di tekan
     */
    public void pesan (View view) {

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox1);
        EditText Etnama = (EditText) findViewById(R.id.nama);
        boolean hascb1 = cb1.isChecked();
        boolean hascb2 = cb2.isChecked();
        String nama = Etnama.getText().toString();
        int price = calculatePrice(hascb1, hascb2);
        String priceMessage = membuatPesanan(price, hascb1, hascb2, nama);
        /**
         * Jika ditampilkan pada TextView
         */
        //tampil(priceMessage);

        /**
         * Jika ditampilkan pada Toast
         */
        Toast.makeText(this, priceMessage, Toast.LENGTH_SHORT).show();

    }

}
