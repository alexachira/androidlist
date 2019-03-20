package sicily.com.androidlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
ListView mylist;
BaseAdapter adapter;
ArrayList<Account> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist =findViewById(R.id.mylist);
        adapter=new BaseAdapter() {
            @Override
            public int getCount() {
               return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v=getLayoutInflater().inflate(R.layout.list_item,null,true);
                TextView txtnames=v.findViewById(R.id.textviewnames);
                TextView txtaccnumber=v.findViewById(R.id.textviewaccnumber);
                TextView txtbalance=v.findViewById(R.id.textviewbalance);
                Account x=arrayList.get(position);
                txtnames.setText(x.getNames());
                txtaccnumber.setText(x.getAccnumber());

                Locale locale = new Locale("en", "KE");
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                String balance=currencyFormatter.format(x.getBalance());



                txtbalance.setText(balance);
                return v;
            }
        };
        mylist.setAdapter(adapter);

mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Account k=arrayList.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this, k.getNames(), Toast.LENGTH_SHORT).show();
    }
});

        Account ac1 =new Account("jim","AC001",12000);
        Account ac2 =new Account("j0an","AC002",13000);
        Account ac3 =new Account("james","AC003",14000);
        Account ac4 =new Account("john","AC004",15000);
        Account ac5 =new Account("mary","AC005",16000);
        Account ac6 =new Account("fabi","AC006",17000);
        Account ac7 =new Account("juju","AC007",18000);
        Account ac8 =new Account("shee","AC008",19000);
        Account ac9 =new Account("shon","AC009",20000);
        Account ac10 =new Account("peter","AC0010",21000);

        arrayList.add(ac1);
        arrayList.add(ac2);
        arrayList.add(ac3);
        arrayList.add(ac4);
        arrayList.add(ac5);
        arrayList.add(ac6);
        arrayList.add(ac7);
        arrayList.add(ac8);
        arrayList.add(ac9);
        arrayList.add(ac10);

        adapter.notifyDataSetChanged();
    }
}
