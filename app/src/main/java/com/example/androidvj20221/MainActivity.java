package com.example.androidvj20221;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.service.controls.Control;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import com.example.androidvj20221.adapters.ContactAdapter;
import com.example.androidvj20221.adapters.StringAdapter;
import com.example.androidvj20221.entities.Contact;
import com.example.androidvj20221.factories.RetrofitFactory;
import com.example.androidvj20221.services.ContactService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("APP_VJ20202", "onCreate");
        setContentView(R.layout.activity_main);


        Retrofit retrofit = RetrofitFactory.build();
        ContactService service = retrofit.create(ContactService.class);

        Call<List<Contact>> call = service.getContacts();

        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                if(!response.isSuccessful()) {
                    Log.e("APP_VJ20202", "Error de aplicación");
                } else {
                    Log.i("APP_VJ20202", "Respuesta Correcta");
                    contacts = response.body();

                    ContactAdapter adapter = new ContactAdapter(contacts);

                    RecyclerView rv = findViewById(R.id.rvContacts);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Log.e("APP_VJ20202", "No hubo conectividad con el servicio web");
            }
        });





    }

    private List<String> getStringContacts() {
        List<String> contacts = new ArrayList<>();
        contacts.add("Luis Mendoza");
        contacts.add("Lionel Messi");
        contacts.add("Cristiano Ronaldo");
        contacts.add("Mavra Guirardin");
        contacts.add("Robin Fawcett");
        contacts.add("Dane Wallworke");
        contacts.add("Hodge Gradwell");
        contacts.add("Johnna Burghall");
        contacts.add("Saidee Brockington");
        contacts.add("Hermann Troutbeck");
        contacts.add("Donella Isgar");
        contacts.add("My Biggadike");
        contacts.add("Arv Payne");
        contacts.add("Samaria Kemmish");
        contacts.add("Debera Cure");
        contacts.add("Hussein Danzelman");
        contacts.add("Danna Linebarger");
        contacts.add("Lester Gagie");
        contacts.add("Kordula Wolfenden");
        contacts.add("Kellia Oloshkin");
        contacts.add("Charita Hasnney");
        contacts.add("Wyn Slyvester");
        contacts.add("Blondell Jahan");
        contacts.add("Rob Asson");
        contacts.add("Pascale Faircliffe");
        contacts.add("Rene Bowmer");
        contacts.add("Brooks Rylstone");
        contacts.add("Amelina Paxton");
        contacts.add("Ninnette Crimes");
        contacts.add("Tally Springford");
        contacts.add("Ferdinand Fardy");
        contacts.add("Ricoriki Dowzell");
        contacts.add("Suzi Gridley");
        contacts.add("Hadria Kinney");
        contacts.add("Georgena Pratchett");
        contacts.add("Melita Cuddehy");
        contacts.add("Sanderson Bescoby");
        contacts.add("Artair Stapylton");
        contacts.add("Maisey Olyff");
        contacts.add("Farley Whellams");
        contacts.add("Georgianna Ridgedell");
        contacts.add("Brock Boulds");
        contacts.add("Drusy Elham");
        contacts.add("Alexi Canavan");
        contacts.add("Willy Dun");
        contacts.add("Devlin Dackombe");
        contacts.add("Auberta Connikie");
        contacts.add("Tudor Peegrem");
        contacts.add("Stanley Lindroos");
        contacts.add("Asia Dowdam");
        contacts.add("Cristobal Tallon");
        contacts.add("Darren Risso");
        contacts.add("Kane Crosetto");
        contacts.add("Barbra Benini");
        contacts.add("Fulton Angelini");
        contacts.add("Ambrosi Sherebrook");
        contacts.add("Benedetto Suller");
        contacts.add("Cordy Orrum");
        contacts.add("Tiphany Cove");
        contacts.add("Bonny Hadrill");
        contacts.add("Shani Sargison");
        contacts.add("Clemmy Nono");
        contacts.add("Norri Folini");
        contacts.add("Owen Rubenczyk");
        contacts.add("Guillema Dennes");
        contacts.add("Denise Sharphurst");
        contacts.add("Merci Ing");
        contacts.add("Breena Gaitung");
        contacts.add("Vinita Katte");
        contacts.add("Gnni Cadore");
        contacts.add("Kahlil Prestige");
        contacts.add("Caren Wheatcroft");
        contacts.add("Beverlee Ledster");
        contacts.add("Tersina Thulborn");
        contacts.add("Rosemarie Keenlayside");
        contacts.add("Peirce Pennetti");
        contacts.add("Kara-lynn Tukely");
        contacts.add("Kendricks Gounel");
        contacts.add("Shaylah Truelove");
        contacts.add("Huntley Hofner");
        contacts.add("Melloney Haston");
        contacts.add("Sheri Hibling");
        contacts.add("Nance Cristofalo");
        contacts.add("Georgia Petyt");
        contacts.add("Gideon Heustace");
        contacts.add("Magdalena Hallatt");
        contacts.add("Rafferty Zorzoni");
        contacts.add("Cheston Rosenhaus");
        contacts.add("Dru Ballingal");
        contacts.add("Emelia Stuke");
        contacts.add("Asa Dregan");
        contacts.add("Niall Ladell");
        contacts.add("Saul McAvaddy");
        contacts.add("Maye Whysall");
        contacts.add("Basile Ducarne");
        contacts.add("Timothee Kahan");
        contacts.add("Fara Jarrelt");
        contacts.add("Shelton Taffee");
        contacts.add("Tish Witard");
        contacts.add("Marwin Limpricht");
        contacts.add("Dedie Blaxton");
        contacts.add("Whitman Ruzic");
        contacts.add("Eziechiele Sloy");

        return contacts;
    }

    private List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1,"Quintina Straughan","542-590-6572"));
        contacts.add(new Contact(2,"Yoshi Smillie","103-593-1880"));
        contacts.add(new Contact(3,"Alan Houndson","435-440-2851"));
        contacts.add(new Contact(4,"Udell Tole","572-705-6101"));
        contacts.add(new Contact(5,"Amelita Diggell","543-296-9061"));
        contacts.add(new Contact(6,"Clint Tranckle","267-342-8794"));
        contacts.add(new Contact(7,"Cherie Henken","778-359-4226"));
        contacts.add(new Contact(8,"Fan Langrick","597-338-7011"));
        contacts.add(new Contact(9,"Suzette Ivanaev","932-661-1183"));
        contacts.add(new Contact(10,"Aloise Janoch","563-845-9088"));
        contacts.add(new Contact(11,"Keriann O'Lenechan","646-515-2182"));
        contacts.add(new Contact(12,"Odette Perel","920-692-3791"));
        contacts.add(new Contact(13,"Clemente Guile","885-564-3244"));
        contacts.add(new Contact(14,"Eva Caren","862-128-0186"));
        contacts.add(new Contact(15,"Tommie Rosina","754-519-3703"));
        contacts.add(new Contact(16,"Coretta Alred","801-591-8160"));
        contacts.add(new Contact(17,"Brook Fredi","528-506-8502"));
        contacts.add(new Contact(18,"Jobey Sabathier","581-676-9164"));
        contacts.add(new Contact(19,"Vida Du Barry","644-390-1122"));
        contacts.add(new Contact(20,"Zollie Whisker","890-154-6707"));
        contacts.add(new Contact(21,"Clarance Escofier","260-718-8584"));
        contacts.add(new Contact(22,"Leda Powis","751-251-1010"));
        contacts.add(new Contact(23,"Odette Dunbar","928-507-9852"));
        contacts.add(new Contact(24,"Immanuel Mac Geaney","502-344-2285"));
        contacts.add(new Contact(25,"Kitty Creddon","347-700-7007"));
        contacts.add(new Contact(26,"Humbert Harrod","391-130-1598"));
        contacts.add(new Contact(27,"Harcourt Verbeke","987-703-9375"));
        contacts.add(new Contact(28,"Enid Langelay","107-732-0712"));
        contacts.add(new Contact(29,"Michele Croston","738-171-8646"));
        contacts.add(new Contact(30,"Aloysius Ruselin","338-918-1391"));
        contacts.add(new Contact(31,"Doralynn Lashley","749-859-5770"));
        contacts.add(new Contact(32,"Ivar Dennis","929-825-2347"));
        contacts.add(new Contact(33,"Codie Shirley","659-726-1838"));
        contacts.add(new Contact(34,"Larry Tring","549-839-9353"));
        contacts.add(new Contact(35,"Colette Foye","505-468-7240"));
        contacts.add(new Contact(36,"Aldous Zincke","534-380-4354"));
        contacts.add(new Contact(37,"Ollie Braden","638-138-3127"));
        contacts.add(new Contact(38,"Marv Chipchase","668-399-7485"));
        contacts.add(new Contact(39,"Robers Bathow","329-883-8223"));
        contacts.add(new Contact(40,"Jodie Menier","673-388-7669"));
        contacts.add(new Contact(41,"Tracee Bohan","563-720-3919"));
        contacts.add(new Contact(42,"Matti Morrell","688-398-4953"));
        contacts.add(new Contact(43,"Cloe Durrans","838-456-7624"));
        contacts.add(new Contact(44,"Vernen Tomkins","152-460-7405"));
        contacts.add(new Contact(45,"Mario Causley","229-261-3049"));
        contacts.add(new Contact(46,"Jacklin Canto","893-553-8403"));
        contacts.add(new Contact(47,"Jackie Horstead","493-456-6105"));
        contacts.add(new Contact(48,"Dmitri Cornu","536-175-5921"));
        contacts.add(new Contact(49,"Peri Stolli","128-935-4820"));
        contacts.add(new Contact(50,"Crin Andree","181-783-6158"));
        contacts.add(new Contact(51,"Marsiella Neely","679-431-8947"));
        contacts.add(new Contact(52,"Wilmar Dady","437-764-0710"));
        contacts.add(new Contact(53,"Jervis Wych","294-284-4149"));
        contacts.add(new Contact(54,"Gaylor Ellul","929-326-3980"));
        contacts.add(new Contact(55,"Fanni Lowings","879-733-7803"));
        contacts.add(new Contact(56,"Ryon Nursey","471-717-4564"));
        contacts.add(new Contact(57,"Helga Jurasz","233-334-9799"));
        contacts.add(new Contact(58,"Dulcy MacKaile","332-990-8567"));
        contacts.add(new Contact(59,"Heriberto Pountain","336-356-9820"));
        contacts.add(new Contact(60,"Krispin Velti","251-838-2987"));
        contacts.add(new Contact(61,"Jerry Obell","475-112-5460"));
        contacts.add(new Contact(62,"Adams Kydd","618-702-9842"));
        contacts.add(new Contact(63,"Melany Tilson","603-824-7226"));
        contacts.add(new Contact(64,"Mallorie Effaunt","249-981-8233"));
        contacts.add(new Contact(65,"Fanny Sandwick","998-924-6495"));
        contacts.add(new Contact(66,"Kristofor Gilluley","448-474-3212"));
        contacts.add(new Contact(67,"Xenos Tresise","857-247-6975"));
        contacts.add(new Contact(68,"Veronique Devil","410-648-3451"));
        contacts.add(new Contact(69,"Rolfe McSkeagan","928-474-7878"));
        contacts.add(new Contact(70,"Joaquin Thorley","797-312-3260"));
        contacts.add(new Contact(71,"Ossie Bernon","587-954-2538"));
        contacts.add(new Contact(72,"Row Mattke","504-538-4208"));
        contacts.add(new Contact(73,"Lucretia Blackston","880-318-6845"));
        contacts.add(new Contact(74,"Deena Pruce","599-638-6274"));
        contacts.add(new Contact(75,"Loraine Bispo","941-334-7556"));
        contacts.add(new Contact(76,"Roda Vasyushkhin","516-774-8354"));
        contacts.add(new Contact(77,"Jolie Roset","656-182-3250"));
        contacts.add(new Contact(78,"Rudiger Tresise","935-758-3364"));
        contacts.add(new Contact(79,"Merwyn Klaussen","340-449-5886"));
        contacts.add(new Contact(80,"Gloria Hackey","250-222-2199"));
        contacts.add(new Contact(81,"Julietta Fenge","755-654-0083"));
        contacts.add(new Contact(82,"Darby Castledine","388-326-5231"));
        contacts.add(new Contact(83,"Natalie Wyness","735-706-5887"));
        contacts.add(new Contact(84,"Carolee Josefs","160-989-0120"));
        contacts.add(new Contact(85,"Davidson Rebillard","471-573-2408"));
        contacts.add(new Contact(86,"Jessie Lackmann","374-829-0094"));
        contacts.add(new Contact(87,"Novelia Allmen","587-378-0567"));
        contacts.add(new Contact(88,"Laurent Gooddie","897-328-8853"));
        contacts.add(new Contact(89,"Ruthanne Tice","778-115-5038"));
        contacts.add(new Contact(90,"Taylor Cecil","322-360-1466"));
        contacts.add(new Contact(91,"Gauthier Heggs","217-227-2669"));
        contacts.add(new Contact(92,"Simmonds Membry","683-757-3265"));
        contacts.add(new Contact(93,"Thibaut Dingivan","327-346-2532"));
        contacts.add(new Contact(94,"Broddie Reuben","513-482-4073"));
        contacts.add(new Contact(95,"Dukie Stables","229-173-1509"));
        contacts.add(new Contact(96,"Elnar McKerrow","619-120-7480"));
        contacts.add(new Contact(97,"Kiele Rubenfeld","817-295-9095"));
        contacts.add(new Contact(98,"Adolf Pigram","591-548-2334"));
        contacts.add(new Contact(99,"Bobbee Tussaine","460-643-2796"));
        contacts.add(new Contact(100,"Angele Dessant","746-3564190"));
        return contacts;
    }
}