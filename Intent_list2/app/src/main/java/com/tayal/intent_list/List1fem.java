package com.tayal.intent_list;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * Created by lirisha on 07-01-2017.
 */
public class List1fem extends MainActivity {

    CustomListFem customListFem;
    private ListView listView1;

    private String Angelina_Jolie[] = {"I like someone who is a little crazy but coming from a good place. I think scars are sexy because it means you made a mistake that led to a mess",
            "","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Scarlett_Johansson[] = {"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Natalie_Portman[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Jennifer_Aniston[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Charlize_Theron[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Jennifer_Lawrence[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Mila_Kunis[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Emma_Stone[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Jessica_Alba[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Julia_Roberts[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Cameron_Diaz[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Sandra_Bullock[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Kristen_Stewart[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Megan_Fox[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Meryl_Streep[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Kate_Winslet[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Marion_Cotillard[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Keira_Knightley[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Anne_Hathaway[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Amy_Adams[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Nicole_Kidman[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Emma_Watson[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Audrey_Hepburn[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Marilyn_Monroe[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Penélope_Cruz[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Cate_Blanchett[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Olivia_Wilde[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Reese_Witherspoon[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Halle_Berry[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Margot_Robbie[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Gwyneth_Paltrow[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Melissa_McCarthy[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Grace_Kelly[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Katharine_Hepburn[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Joan_Crawford[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Elizabeth_Taylor[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Amanda_Seyfried[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Bette_Davis[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Drew_Barrymore[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Monica_Bellucci[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Vanessa_Johansson[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Kirsten_Dunst[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Ingrid_Bergman[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Rachel_McAdams[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Salma_Hayek[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Blake_Lively[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Rita_Hayworth[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Michelle_Pfeiffer[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Julianne_Moore[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Ava_Gardner[]={"","","","","","","","","","","","","","","","","","","","","","","","",};
    private String Jessica_Biel[]={"","","","","","","","","","","","","","","","","","","","","","","","",};





    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fem_list);


        Bundle bun = getIntent().getExtras();
        int x = bun.getInt("k");
        if (x == 0) {
            customListFem = new CustomListFem(this, Angelina_Jolie);}
        else if(x==1)
        {

            customListFem   = new CustomListFem(this, Scarlett_Johansson);
        }
        else if (x==2)
        {
            customListFem   = new CustomListFem(this, Natalie_Portman);

        }

        else if (x==3)
        {
            customListFem   = new CustomListFem(this, Jennifer_Aniston);

        }

        else if (x==4)
        {
            customListFem   = new CustomListFem(this, Mila_Kunis);

        }


        else if (x==5)
        {
            customListFem   = new CustomListFem(this, Emma_Stone);

        }

        else if (x==6)
        {
            customListFem   = new CustomListFem(this, Jessica_Alba);

        }


        else if (x==7)
        {
            customListFem   = new CustomListFem(this,Julia_Roberts);


        }
        else if (x==8)
        {
            customListFem   = new CustomListFem(this, Cameron_Diaz);


        }
        else if (x==9)
        {
            customListFem   = new CustomListFem(this, Sandra_Bullock);


        }
        else if (x==10)
        {
            customListFem   = new CustomListFem(this, Kristen_Stewart);


        }
        else if (x==11)
        {
            customListFem   = new CustomListFem(this, Megan_Fox);


        }
        else if (x==12)
        {
            customListFem   = new CustomListFem(this, Meryl_Streep);


        }
        else if (x==13)
        {
            customListFem   = new CustomListFem(this, Kate_Winslet);


        }
        else if (x==14)
        {
            customListFem   = new CustomListFem(this, Marion_Cotillard);


        }
        else if (x==15)
        {
            customListFem   = new CustomListFem(this, Keira_Knightley);


        }
        else if (x==16)
        {
            customListFem   = new CustomListFem(this, Anne_Hathaway);


        }
        else if (x==17)
        {
            customListFem   = new CustomListFem(this, Amy_Adams);


        }
        else if (x==18)
        {
            customListFem   = new CustomListFem(this, Nicole_Kidman);


        } else if (x==19)
        {
            customListFem   = new CustomListFem(this, Emma_Watson);


        }
        else if (x==20)
        {
            customListFem   = new CustomListFem(this, Audrey_Hepburn);


        }
        else if (x==21)
        {
            customListFem   = new CustomListFem(this, Marilyn_Monroe);


        }


        else if (x==22)
        {
            customListFem   = new CustomListFem(this, Penélope_Cruz);


        }
        else if (x==23)
        {
            customListFem   = new CustomListFem(this,Cate_Blanchett);


        }
        else if (x==24)
        {
            customListFem   = new CustomListFem(this, Olivia_Wilde);


        }
        else if (x==25)
        {
            customListFem   = new CustomListFem(this, Reese_Witherspoon);


        }
        else if (x==26)
        {
            customListFem   = new CustomListFem(this, Halle_Berry);


        } else if (x==27)
        {
            customListFem   = new CustomListFem(this, Margot_Robbie);


        }
        else if (x==28)
        {
            customListFem   = new CustomListFem(this, Gwyneth_Paltrow);


        }
        else if (x==29)
        {
            customListFem   = new CustomListFem(this, Melissa_McCarthy);


        }
        else if (x==30)
        {
            customListFem   = new CustomListFem(this, Grace_Kelly);


        }
        else if (x==31)
        {
            customListFem   = new CustomListFem(this, Katharine_Hepburn);


        }
        else if (x==32)
        {
            customListFem   = new CustomListFem(this, Joan_Crawford);


        }
        else if (x==33)
        {
            customListFem   = new CustomListFem(this, Elizabeth_Taylor);


        }
        else if (x==34)
        {
            customListFem   = new CustomListFem(this, Amanda_Seyfried);


        } else if (x==35)
        {
            customListFem   = new CustomListFem(this, Bette_Davis);


        }
        else if (x==36)
        {
            customListFem   = new CustomListFem(this, Drew_Barrymore);


        }
        else if (x==37)
        {
            customListFem   = new CustomListFem(this, Monica_Bellucci);


        }

        else if (x==38)
        {
            customListFem   = new CustomListFem(this, Vanessa_Johansson);


        }
        else if (x==39)
        {
            customListFem   = new CustomListFem(this, Kirsten_Dunst);


        }
        else if (x==40)
        {
            customListFem   = new CustomListFem(this, Ingrid_Bergman);


        }
        else if (x==41)
        {
            customListFem   = new CustomListFem(this, Rachel_McAdams);


        }
        else if (x==42)
        {
            customListFem   = new CustomListFem(this, Salma_Hayek);


        } else if (x==43)
        {
            customListFem   = new CustomListFem(this, Blake_Lively);


        }
        else if (x==44)
        {
            customListFem   = new CustomListFem(this, Rita_Hayworth);


        }
        else if (x==45)
        {
            customListFem   = new CustomListFem(this,Michelle_Pfeiffer);


        }
        else if (x==46)
        {
            customListFem   = new CustomListFem(this,Julianne_Moore);


        }
        else if (x==47)
        {
            customListFem   = new CustomListFem(this,Ava_Gardner);


        }
        else if (x==48)
        {
            customListFem   = new CustomListFem(this,Jessica_Biel);


        }





        listView1 = (ListView) findViewById(R.id.listView1);
            listView1.setAdapter(customListFem);


            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    /*Toast.makeText(getApplicationContext(), "You Clicked " + [i], Toast.LENGTH_SHORT).show();
*/              /*  Toast.makeText(getApplicationContext(),"You Clicked "+Johnny_Depp[i], Toast.LENGTH_SHORT).show();*/
                }

            });
        }
    }


        /*@Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will

            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.textView) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
}
*/