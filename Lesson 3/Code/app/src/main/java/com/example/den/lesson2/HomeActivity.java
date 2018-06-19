package com.example.den.lesson2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.den.lesson2.Holders.ViewHolderArticle;
import com.example.den.lesson2.Holders.ViewHolderGallery;
import com.example.den.lesson2.Items.ItemArticle;
import com.example.den.lesson2.Items.ItemBase;
import com.example.den.lesson2.Items.ItemGallery;


public class HomeActivity extends AppCompatActivity {

    public static String EMAIL_EXTRA_KEY = "EMAIL_EXTRA_KEY";
    public static String PASSWORD_EXTRA_KEY = "PASSWORD_EXTRA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        setupListView();
        setupListViewAdvanced();
    }

    private void setupListView() {

        ListView listView = findViewById(R.id.listView);

        Resources res = getResources();
        final String[] streets = res.getStringArray(R.array.streets_array);

        ArrayAdapter<String> cheeseAdapter =
                new ArrayAdapter<String>(this,
                        R.layout.item_article,
                        R.id.textViewTitle,
                        streets
                );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {

                String message = "You clicked on " + streets[position];

                Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        listView.setAdapter(cheeseAdapter);
    }


    private boolean isArticle(ItemBase item) {
        return item.getClass().equals(ItemArticle.class);
    }

    private boolean isGallery(ItemBase item) {
        return item.getClass().equals(ItemGallery.class);
    }

    private void setupListViewAdvanced() {

        ListView listView = findViewById(R.id.listView);

        final ItemBase[] itemsArray = {
                new ItemArticle("Почему мы ещё читаем бумажные книги?", "По логике, бумажная история должна быть почти полностью мертва уже. Как пластинки, компакт-диски и видеокассеты. Некоторые книжные сейчас больше напоминают магазины посуды, сувениров и канцтоваров с нашими играми — и отдельной полкой в углу для книг. \n" +
                        "\n" +
                        "Но при этом издательства до сих пор пляшут от бумажных копий, наш опыт с киосками прессы в Москве показал, что продать 20 килограммов газет в день с одной точки — вообще не вопрос в принципе. А ещё я недавно видел здравствующую бумажную библиотеку в городе на 700 человек, видел культуру чтения газет в Германии и кучу других странных вещей. \n" +
                        "\n" +
                        "И ещё я продолжаю покупать бумажные книги, хотя читаю всё чаще с экранов. Возможно, я ретроград, конечно. Но мне пару лет назад было очень интересно, что можно сделать с этим рынком, и ниже немного выкладок «пальцем к носу» по тому, почему его никак не получается добить."),
                new ItemArticle("Тест памяти, убивающий ноутбуки — почти детектив", "Недавно у нас произошла душераздирающая история — за одно утро умерли два ноутбука Lenovo T500. Умер бы один — никто и разбираться не стал. Но два за одно утро — это уже слишком! Тем более, что по крайней мере один из них (и это подтверждают три пользователя!) нормально работал до последней минуты, был выключен кнопкой питания, перенесен за 100 метров в переговорку и… не включился.\n" +
                        "\n" +
                        "Естественно, в первую очередь были опробованы все кустарные способы реанимации: заменить батарею, заменить адаптер питания… Вытащить батарею и обесточить, сбросить CMOS и так далее… Результат? Ровно ноль — ноутбуки продолжали находиться в состоянии кирпичей.\n" +
                        "\n" +
                        "Стали восстанавливать картину событий, чтобы найти хоть какую-то зацепку. Выяснилось следующее:"),
                new ItemArticle("Про рынок ИТ в России по-честному", "В последние несколько лет мои переживания по поводу российского рынка ИТ только усиливались. Все началось с кризиса рубля 2014 года (а может, и раньше), и с тех пор меня не покидает ощущение, что многие российские компании, особенно провинциальные, завязали себе глаза, заткнули ватой уши и все еще пытаются сделать вид, что ничего не происходит. Я много общался с разными компаниями, с HR, с разработчиками, и составил список неутешительных тезисов о том, что представляет собой как программистский рынок, так и культура разработки в целом, ведь это вещи взаимосвязанные. По моим субъективным оценкам, эти тезисы справедливы для ~60% российских компаний, хотя, казалось бы, те другие 40% компаний, которые мы знаем и любим, должны были заставить задуматься. Но я очень подозреваю, что это эти 60% просто надеются на русский “авось”, и подвергаются так называемой willful blindness, а иногда и намеренно мутят воду. Итак, по-честному, что же происходит?"),
                new ItemArticle("Путеводитель по Швейцарии", "В этой статье я постараюсь описать свой опыт переезда в замечательную альпийскую страну Швейцарию, а конкретно — в город Цюрих, и рассказать о наиболее важных аспектах жизни здесь.\n" +
                        "\n" +
                        "Пост будет очень объемный, потому что я хотел сделать эдакий мини-гайд по жизни в Швейцарии, по которому потенциальный тракторист сможет оценить страну. А тем, кто уже тут или собирается в ближайшее время, статья может помочь разобраться с местными особенностями — не всегда можно легко найти ответы на вопросы, особенно не зная язык.\n" +
                        "\n" +
                        "Я решил не делить его на отдельные куски — так информацию искать будет проще. Надеюсь что не сильно нарушу тематику ресурса, пусть НЛО нас рассудит."),
                new ItemArticle("Нечестная игра, или как нас обманывают организаторы розыгрышей", "Однажды, солнечным весенним утром, почитывая городской форум, я наткнулся на ссылку с простенькой игрой от известной торговой сети. Игра (акция), посвящённая чемпионату мира по футболу, представляла собой незамысловатое поле три на три, заполненное футбольными мячами. Кликая по мячу, мы открывали картинку с тем или иным товаром. При открытии трёх одинаковых картинок участнику гарантировалось бесплатное получение данного товара в одном из магазинов сети. Также под одним из мячей имелось изображение красной карточки, открытие которой означало конец игры."),
                new ItemGallery(R.drawable.sedan),
                new ItemGallery(R.drawable.convertible),
                new ItemGallery(R.drawable.coupe)
        };

        final ArrayAdapter<ItemBase> itemsArrayAdapter =
                new ArrayAdapter<ItemBase>(this, 0, itemsArray) {
                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {

                        if(isArticle(itemsArray[position])) {
                            ItemArticle currentArticle =  (ItemArticle)itemsArray[position];
                            convertView = setupArticleView(convertView, currentArticle);

                        } else if (isGallery(itemsArray[position])) {
                            ItemGallery currentGallery = (ItemGallery) itemsArray[position];
                            convertView = setupGalleryView(convertView, currentGallery);
                        }
                        return convertView;
                    }
                };

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long rowId) {

                // Generate a message based on the position
                if(isArticle(itemsArray[position])) {
                    ItemArticle article =  (ItemArticle)itemsArray[position];
//                    String message = "You clicked on " + article.getTitle();
//                    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
//                    toast.show();

                    Intent articleActivity = new Intent(getApplicationContext(), ArticleActivity.class);
                    articleActivity.putExtra(ArticleActivity.TITLE_EXTRA_KEY, article.getTitle());
                    articleActivity.putExtra(ArticleActivity.DESCRIPTION_EXTRA_KEY, article.getDescription());
                    startActivity(articleActivity);
                } else if (isGallery(itemsArray[position])) {
                    Intent galleryActivity = new Intent(getApplicationContext(), GalleryActivity.class);
                    startActivity(galleryActivity);
                }
            }
        });

        listView.setAdapter(itemsArrayAdapter);
    }

    private View setupArticleView(View convertView, ItemArticle currentArticle) {
        // Inflate only once
        if (convertView == null || convertView.getTag().getClass().equals(ViewHolderGallery.class)) {
            convertView = getLayoutInflater()
                    .inflate(R.layout.item_article, null, false);
        }

        if(convertView.getTag() == null) {
            ViewHolderArticle viewHolder = new ViewHolderArticle();
            viewHolder.textViewTitle = convertView.findViewById(R.id.textViewTitle);
            viewHolder.textViewDescription = convertView.findViewById(R.id.textViewDescription);
            convertView.setTag(viewHolder);
        }

        TextView textViewTitle =
                ((ViewHolderArticle) convertView.getTag()).textViewTitle;
        TextView textViewDescription =
                ((ViewHolderArticle) convertView.getTag()).textViewDescription;

        textViewTitle.setText(currentArticle.getTitle());
        textViewDescription.setText(currentArticle.getDescription());

        return convertView;
    }

    private View setupGalleryView(View convertView, ItemGallery currentGallery) {
        // Inflate only once
        if (convertView == null || convertView.getTag().getClass().equals(ViewHolderArticle.class)) {
            convertView = getLayoutInflater()
                    .inflate(R.layout.item_gallery, null, false);
        }

        if(convertView.getTag() == null) {
            ViewHolderGallery viewHolder = new ViewHolderGallery();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }

        ImageView imageView =
                ((ViewHolderGallery) convertView.getTag()).imageView;

        imageView.setImageDrawable(ContextCompat.getDrawable(this, currentGallery.imgResoureID()));
        return convertView;
    }
}
