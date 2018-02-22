import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kerem.denemelist.Model.Kisi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private Button button;
    private ArrayList<Kisi> kisiArrayList;
    private String sonuc;
    private Context context;
    private ArrayAdapter<Kisi> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        editText = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.listView);
        button = (Button)findViewById(R.id.button);
        //

        kisiArrayList = new ArrayList<>();




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!editText.getText().toString().matches("")){
                    sonuc = editText.getText().toString();


                    kisiArrayList.add(new Kisi(sonuc));

                    items = new ArrayAdapter<>(
                            MainActivity.this,
                            android.R.layout.simple_dropdown_item_1line,
                            kisiArrayList
                    );

                    listView.setAdapter(items);
                    editText.setText("");


                }
            }
        });



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, View view, final int id, long l) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure to delete?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, ""+kisiArrayList.get(id).getAd()+" removed!", Toast.LENGTH_SHORT).show();
                                kisiArrayList.remove(id);
                                dialogInterface.cancel();
                                listView.setAdapter(items);
                            }
                        });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                builder.show();

                return false;
            }
        });

    }

}
