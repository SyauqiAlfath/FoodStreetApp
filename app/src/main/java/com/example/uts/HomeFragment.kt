package com.example.uts

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<FoodClass>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {

        val INTENT_PARCELABLE = "OBJECT_INTENT"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv)
        recyclerView.setHasFixedSize(true)
        adapter = FoodAdapter(requireContext(), foodList) { food ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, food)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun dataInitialize() {

        foodList = listOf<FoodClass>(
            FoodClass(
                R.drawable.burger,
                foodname = "Beef Burger",
                foodprice = "Rp20.000 - Rp35.000",
                foodrate = "4,5",
                ratingbar = 4.5,
                fooddesc = "Burger adalah makanan yang terdiri dari sejumlah bahan yang digabungkan dengan sempurna untuk menciptakan rasa yang lezat dan memuaskan. Berikut ini adalah komponen dari burger:\n" +
                        "\n" +
                        "1. Roti: Burger menggunakan roti yang lezat dan empuk, baik itu roti burger tradisional atau roti brioche yang sedikit manis. Roti ini memberikan tekstur yang sempurna dan memberi kesan yang menyenangkan saat digigit.\n" +
                        "\n" +
                        "2. Daging: Burger biasanya menggunakan daging yang berkualitas tinggi, seperti daging sapi segar atau bahkan daging sapi Wagyu yang lembut dan berlemak. Daging ini dipadatkan menjadi patty yang juicy dan dipanggang dengan sempurna untuk mencapai kematangan yang tepat.\n" +
                        "\n" +
                        "3. Keju: Sebagian besar burger dilengkapi dengan keju leleh yang memberikan rasa gurih dan krimi. Keju seperti cheddar, Swiss, atau blue cheese biasanya digunakan untuk memberikan dimensi rasa yang lebih pada burger.\n" +
                        "\n" +
                        "4. Saus dan Dressing: Burger seringkali diberi tambahan saus dan dressing untuk meningkatkan rasa. Contohnya adalah mayones, saus BBQ, saus tomat, saus remoulade, atau saus spesial yang khas. Saus dan dressing ini memberikan sentuhan yang lezat dan memadukan semua elemen burger dengan harmonis.\n" +
                        "\n" +
                        "5. Sayuran dan Topping: Selain itu, burger juga dilengkapi dengan sayuran segar seperti daun selada, tomat, bawang bombay, dan acar untuk memberikan rasa dan tekstur yang berbeda. Topping tambahan seperti potongan bacon renyah atau cakram bawang yang digoreng juga bisa memberikan pengalaman rasa yang lebih kaya.\n" +
                        "\n" +
                        "6. Rasa Umami: Burger seringkali memiliki cita rasa umami yang kuat, yang berasal dari daging yang dipanggang dengan sempurna, keju yang meleleh, dan saus yang kaya rasa. Ini memberikan sensasi kenikmatan dan kepuasan yang luar biasa saat memakan burger.\n" +
                        "\n" +
                        "Deskripsi di atas hanyalah beberapa komponen umum yang dapat membuat burger, namun variasi dan preferensi dapat berbeda-beda tergantung pada selera individu dan kekhasan dari setiap tempat atau restoran yang menyajikan burger."

            ),
            FoodClass(
                R.drawable.kebab,
                foodname = "Kebab Ibliz",
                foodprice = "Rp15.000 - Rp30.000",
                foodrate = "4.5",
                ratingbar = 4.5,
                fooddesc = "Kebab adalah hidangan daging yang terkenal di berbagai negara dan budaya di seluruh dunia. Berikut adalah komponen yang biasanya ada pada kebab yang lezat:\n" +
                        "\n" +
                        "1. Daging: Kebab biasanya menggunakan daging yang dipotong menjadi potongan-potongan kecil atau diiris tipis. Daging yang sering digunakan adalah daging sapi, daging ayam, daging kambing, atau daging domba. Daging tersebut biasanya dimarinasi dengan campuran rempah-rempah dan bumbu untuk memberikan cita rasa yang kaya dan lezat.\n" +
                        "\n" +
                        "2. Rempah dan Bumbu: Kebab memiliki campuran rempah-rempah dan bumbu yang khas untuk memberikan rasa yang khas dan aromatik. Rempah-rempah yang sering digunakan termasuk bubuk paprika, jintan, kayu manis, kunyit, merica, dan bawang putih. Bumbu tambahan seperti lemon, minyak zaitun, atau yogurt juga dapat ditambahkan untuk memberikan kelembutan dan kelezatan pada daging.\n" +
                        "\n" +
                        "3. Proses Pemasakan: Kebab umumnya dipanggang, dipanggang, atau dibakar dengan cara yang khas. Misalnya, kebab dapat dipanggang di atas arang, dipanggang di oven, atau dibakar di atas grill. Proses pemasakan ini membantu daging mempertahankan kelembutan dan kelembaban, serta memberikan aroma dan rasa yang khas pada kebab.\n" +
                        "\n" +
                        "4. Roti atau Hidangan Penyajian: Kebab sering disajikan dalam beberapa cara. Salah satunya adalah dalam roti yang sering disebut sebagai \"kebab wrap\" atau \"kebab roll.\" Roti yang digunakan bisa berbeda-beda, seperti roti pita, roti naan, atau roti tortilla. Daging kebab yang dipanggang kemudian diletakkan di atas roti dan ditambahkan dengan saus, sayuran, dan sajian tambahan sesuai selera.\n" +
                        "\n" +
                        "5. Saus dan Topping: Kebab biasanya disajikan dengan berbagai saus dan topping untuk memberikan rasa yang lebih segar dan lezat. Beberapa saus yang umum digunakan termasuk saus yogurt, saus tahini, saus tomat, atau saus pedas. Sayuran seperti selada, tomat, bawang merah, timun, atau acar juga sering ditambahkan untuk memberikan rasa dan tekstur yang beragam.\n" +
                        "\n" +
                        "6. Sisi dan Pelengkap: Kebab seringkali disajikan dengan sisi dan pelengkap seperti nasi pilaf, hummus, tabouli, atau salad. Ini memberikan variasi rasa dan tekstur yang melengkapi kebab.\n" +
                        "\n" +
                        "Deskripsi di atas mencakup beberapa elemen umum dari kebab yang lezat. Perlu diingat bahwa kebab memiliki banyak variasi dan gaya yang berbeda tergantung pada negara dan budaya tempatnya berasal."

            ),
            FoodClass(
                R.drawable.taichan,
                foodname = "Sate Taichan",
                foodprice = "Rp2.000 - Rp10.000",
                foodrate = "4.0",
                ratingbar = 4.0,
                fooddesc = "Taichan adalah hidangan populer yang berasal dari Indonesia, terutama dikenal di daerah Jawa. " +
                        "Taichan terdiri dari potongan ayam yang dipanggang atau digrill dengan rempah-rempah khas, seperti bawang putih, " +
                        "cabai rawit, dan garam. Hidangan ini sering disajikan dengan tambahan jeruk nipis yang segar di atasnya. \n \n" +
                        "Taichan memiliki rasa pedas, gurih, dan segar yang membuatnya menjadi pilihan favorit bagi pecinta makanan pedas. " +
                        "Kelezatan taichan terletak pada perpaduan daging ayam yang lezat, rempah-rempah yang khas, serta sensasi segar dan pedas yang disajikan dengan sederhana namun memuaskan."

            ),
            FoodClass(
                R.drawable.ayamrica,
                foodname = "Ayam Rica Rica",
                foodprice = "Rp22.000 - Rp37.000",
                foodrate = "4.5",
                ratingbar = 4.5,
                fooddesc = "Ayam rica-rica adalah hidangan khas dari Sulawesi, Indonesia. Hidangan ini terkenal karena rasa pedasnya yang khas. " +
                        "Ayam rica-rica terdiri dari potongan ayam yang dimasak dengan bumbu rica-rica, yang terbuat dari campuran cabai rawit merah, " +
                        "bawang merah, bawang putih, tomat, serta rempah-rempah seperti kunyit, jahe, dan serai. Hidangan ini memiliki cita rasa pedas, " +
                        "gurih, dan sedikit asam. Ayam rica-rica biasanya disajikan dengan nasi putih hangat dan bisa dihidangkan dengan tambahan irisan tomat " +
                        "dan daun bawang sebagai hiasan. Rasa pedas yang khas dari ayam rica-rica membuatnya menjadi hidangan yang nikmat dan cocok bagi pecinta makanan pedas."

            ),
            FoodClass(
                R.drawable.ayambakar,
                foodname = "Ayam Bakar",
                foodprice = "Rp18.000 - Rp35.000",
                foodrate = "5.0",
                ratingbar = 5.0,
                fooddesc = "Ayam bakar adalah hidangan ayam yang populer di banyak budaya kuliner, terutama di Indonesia dan Malaysia. Ayam bakar adalah ayam yang dipanggang dengan menggunakan bumbu dan rempah-rempah khas untuk memberikan cita rasa yang lezat.\n" +
                        "\n" +
                        "Biasanya, ayam bakar dimulai dengan merendam potongan ayam dalam campuran bumbu yang terdiri dari bawang putih, bawang merah, jahe, ketumbar, kunyit, dan beberapa bahan lainnya. Ayam kemudian dipanggang di atas bara api atau dalam oven sampai matang sempurna dan kulitnya menjadi kecokelatan dan renyah.\n" +
                        "\n" +
                        "Proses pemanggangan memberikan rasa gurih yang khas pada daging ayam sambil mempertahankan kelembutan dan kelembapan. Selama pemanggangan, ayam bakar sering kali juga diolesi dengan bumbu tambahan seperti saus kecap manis, saus pedas, atau campuran bumbu khusus yang membuatnya semakin lezat.\n" +
                        "\n" +
                        "Ayam bakar dapat disajikan dengan nasi putih, nasi goreng, atau lontong, serta ditambahi dengan pelengkap seperti acar, irisan mentimun, atau sambal untuk memberikan sentuhan segar dan pedas yang lebih. Kelezatan ayam bakar terletak pada perpaduan antara rasa gurih, manis, pedas, dan rempah-rempah yang menggugah selera.\n" +
                        "\n" +
                        "Selain itu, ayam bakar juga sering menjadi hidangan populer di berbagai festival, acara keluarga, atau restoran karena rasanya yang lezat dan dapat dinikmati oleh banyak orang."

            ),
            FoodClass(
                R.drawable.nilabakar,
                foodname = "Nila Bakar",
                foodprice = "Rp20.000 - Rp45.000",
                foodrate = "4.0",
                ratingbar = 4.0,
                fooddesc = "Nila bakar adalah hidangan ikan yang populer di Indonesia, terutama di daerah pesisir. Hidangan ini menggunakan ikan nila, yang dipanggang dengan bumbu dan rempah-rempah khas untuk menciptakan cita rasa yang lezat.\n" +
                        "\n" +
                        "Proses memasak nila bakar dimulai dengan membersihkan dan membumbui ikan nila dengan campuran bumbu seperti bawang putih, bawang merah, cabai, kunyit, jahe, dan rempah-rempah lainnya. Ikan nila kemudian dipanggang di atas bara api atau dalam oven sampai matang sempurna.\n" +
                        "\n" +
                        "Pemanggangan memberikan cita rasa khas yang gurih pada ikan nila, sambil menjaga kelembutan dan kelembapan dagingnya. Kulit ikan yang dipanggang biasanya menjadi kecokelatan dan sedikit renyah, menambahkan tekstur dan aroma yang menggugah selera.\n" +
                        "\n" +
                        "Nila bakar sering disajikan dengan nasi putih hangat dan ditambahi dengan pelengkap seperti sambal, irisan jeruk nipis, atau acar. Hidangan ini menawarkan perpaduan rasa yang segar, gurih, dan sedikit pedas dari bumbu dan rempah-rempah yang digunakan.\n" +
                        "\n" +
                        "Kelezatan nila bakar membuatnya menjadi pilihan favorit di restoran, warung makan, atau acara makan bersama keluarga. Ikan nila yang dipanggang dengan bumbu khas memberikan hidangan yang lezat dan menyenangkan bagi pecinta makanan laut."

            ),

            FoodClass(
                R.drawable.nilagoreng,
                foodname = "Nila Goreng",
                foodprice = "Rp20.000 - Rp45.000",
                foodrate = "3.5",
                ratingbar = 3.5,
                fooddesc = "Nila goreng adalah hidangan ikan yang populer di Indonesia. Dalam hidangan ini, ikan nila dibersihkan dan digoreng hingga matang sempurna dengan minyak panas. \n" +
                        "\n" +
                        "Proses penggorengan memberikan tekstur kulit ikan yang renyah dan memberikan warna kecokelatan yang menarik. Daging ikan nila yang digoreng biasanya tetap lembut dan juicy di dalamnya.\n" +
                        "\n" +
                        "Nila goreng sering disajikan dengan nasi putih hangat dan ditambahi dengan pelengkap seperti sambal, irisan tomat dan mentimun, serta kerupuk sebagai pendamping. Hidangan ini menawarkan cita rasa gurih dan lezat dari ikan yang digoreng dengan sempurna.\n" +
                        "\n" +
                        "Nila goreng merupakan pilihan makanan yang populer di warung makan, restoran, dan rumah makan di seluruh Indonesia. Kelezatan dan kepraktisannya membuatnya menjadi favorit di kalangan pecinta ikan."

            )


        )
    }
}